/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezim;

import domain.IGeneralEntity;
import domain.RezimTreninga;
import domain.StavkaRezimaTreninga;
import domain.Trener;
import domain.VrstaTreninga;
import java.util.ArrayList;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class VratiSveRezimeSO extends AbstractGenericOperation{
    private List<IGeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof RezimTreninga)) {
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        List<IGeneralEntity> lista = databaseBroker.vratiSve((IGeneralEntity) entity);
        list = new ArrayList<>();
        for (IGeneralEntity entRezim : lista) {
            RezimTreninga rezim = (RezimTreninga) entRezim;
            StavkaRezimaTreninga stavka = new StavkaRezimaTreninga();
            stavka.setRezim(rezim);
            
            
            List<IGeneralEntity> stavke = databaseBroker.vratiPoUslovu(stavka);

            ArrayList<StavkaRezimaTreninga> stavkeRezima = new ArrayList<>();
            for (IGeneralEntity entStavka : stavke) {
                StavkaRezimaTreninga sp = (StavkaRezimaTreninga) entStavka;
                sp.setRezim(rezim);
                sp.setTrener((Trener) databaseBroker.vratiPoId(sp.getTrener()));
                sp.setVrstaTreninga((VrstaTreninga) databaseBroker.vratiPoId(sp.getVrstaTreninga()));
                
                stavkeRezima.add(sp);
            }
            rezim.setStavke(stavkeRezima);
            list.add(rezim);
        }
    }

    public List<IGeneralEntity> getList() {
        return list;
    }
}
