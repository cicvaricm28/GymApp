/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vrstaTreninga;

import domain.IGeneralEntity;
import domain.VrstaTreninga;
import java.util.ArrayList;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class VratiVrsteSO extends AbstractGenericOperation{
    private List<IGeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof VrstaTreninga)) {
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = new ArrayList<>();
        List<IGeneralEntity> korisnika = databaseBroker.vratiSve((VrstaTreninga) entity);

        for (IGeneralEntity e : korisnika) {
            list.add((VrstaTreninga) e);
        }
    }

    public List<IGeneralEntity> getList() {
        return list;
    }
}
