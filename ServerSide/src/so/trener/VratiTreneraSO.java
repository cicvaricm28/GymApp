/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.trener;

import domain.IGeneralEntity;
import domain.Trener;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class VratiTreneraSO extends AbstractGenericOperation{
    IGeneralEntity object;
    
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Trener)) {
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        object = databaseBroker.vratiPoId((IGeneralEntity) entity);
    }

    public IGeneralEntity getObject() {
        return object;
    }
}
