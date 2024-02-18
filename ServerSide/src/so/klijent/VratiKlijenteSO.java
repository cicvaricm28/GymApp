/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domain.IGeneralEntity;
import domain.Klijent;
import domain.VrstaTreninga;
import java.util.ArrayList;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class VratiKlijenteSO extends AbstractGenericOperation{
    private List<IGeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (entity == null)
            return;
        
        if (!(entity instanceof Klijent)) {
            throw new Exception("Objekat nije validan!");
        }
    }
    
    
    protected void execute(Object entity) throws Exception {
        list = new ArrayList<>();
        List<IGeneralEntity> klijenti = databaseBroker.vratiSve((Klijent)entity);

        for (IGeneralEntity e : klijenti) {
            Klijent k = (Klijent) e;
            k.setVrstaTreninga((VrstaTreninga) databaseBroker.vratiPoId(k.getVrstaTreninga())); 
            
            
    
            list.add(k);
        }
    }
    
    
    public List<IGeneralEntity> getList() {
        return list;
    }
}
