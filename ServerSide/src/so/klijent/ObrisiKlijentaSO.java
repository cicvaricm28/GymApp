/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domain.IGeneralEntity;
import domain.Klijent;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class ObrisiKlijentaSO extends AbstractGenericOperation{
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Klijent)) {
            throw new Exception("Objekat nije validan!");
        }
        
       
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.obrisi((IGeneralEntity) entity);
    }
}
