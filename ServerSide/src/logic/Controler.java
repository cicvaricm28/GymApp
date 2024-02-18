/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.IGeneralEntity;
import domain.Klijent;
import domain.RezimTreninga;
import domain.StavkaRezimaTreninga;
import domain.VrstaTreninga;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import skladiste.IBrokerBaze;
import so.AbstractGenericOperation;
import so.klijent.ObrisiKlijentaSO;
import so.klijent.UnesiKlijentaSO;
import so.klijent.VratiKlijenteSO;
import so.rezim.SacuvajRezimSO;
import so.rezim.VratiSveRezimeSO;
import so.stavka.IzmeniStavkuSO;
import so.stavka.ObrisiStavkuSO;
import so.stavka.UnesiStavkuSO;
import so.trener.PrijaviTreneraSO;
import so.vrstaTreninga.VratiVrsteSO;

/**
 *
 * @author user
 */
public class Controler {
    private static Controler instance;
    private IBrokerBaze brokerBaze;

    private Controler() {
        brokerBaze = new BrokerBaze();
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public IGeneralEntity prijaviTrenera(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new PrijaviTreneraSO();
        so.templateExecute(entity);
        return ((PrijaviTreneraSO) so).getObject();
    }

    public void sacuvajKlijenta(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new UnesiKlijentaSO();
        so.templateExecute(entity);
    }

    public List<IGeneralEntity> vratiKlijente(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new VratiKlijenteSO();
        so.templateExecute(entity);
        return ((VratiKlijenteSO) so).getList();
    }

    public void obrisiKlijenta(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new ObrisiKlijentaSO();
        so.templateExecute(entity);
    }

    public void sacuvajRezim(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new SacuvajRezimSO();
        so.templateExecute(entity);
    }

    public List<IGeneralEntity> vratiSveRezime(RezimTreninga r) throws Exception {
        AbstractGenericOperation so = new VratiSveRezimeSO();
        so.templateExecute(r);
        return ((VratiSveRezimeSO) so).getList();
    }

    public void obrisiStavku(IGeneralEntity entity) throws Exception{
        AbstractGenericOperation so = new ObrisiStavkuSO();
        so.templateExecute(entity);
    }

    public void sacuvajStavku(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new UnesiStavkuSO();
        so.templateExecute(entity);
    }

    public void izmeniStavku(IGeneralEntity entity) throws Exception{
        AbstractGenericOperation so = new IzmeniStavkuSO();
        so.templateExecute(entity);
    }

    public List<IGeneralEntity> vratiSveVrste(VrstaTreninga r) throws Exception {
        AbstractGenericOperation so = new VratiVrsteSO();
        so.templateExecute(r);
        return ((VratiVrsteSO) so).getList();
    }
    
    
    
    
    
}
