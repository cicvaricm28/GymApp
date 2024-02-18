/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavka;

import domain.IGeneralEntity;
import domain.Klijent;
import domain.StavkaRezimaTreninga;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class UnesiStavkuSO  extends AbstractGenericOperation{
    
    
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof StavkaRezimaTreninga)) {
            throw new Exception("Objekat nije validan!");
        }
    }

    
    protected void execute(Object entity) throws Exception {
        databaseBroker.sacuvaj((IGeneralEntity) entity);
    }
}
