/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezim;

import domain.RezimTreninga;
import domain.StavkaRezimaTreninga;
import so.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class SacuvajRezimSO extends AbstractGenericOperation{
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof RezimTreninga)) {
            throw new Exception("Objekat nije validan!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        RezimTreninga p = (RezimTreninga) entity;
        int id = databaseBroker.sacuvaj(p);
        System.out.println(p.getStavke());
        for (StavkaRezimaTreninga s : p.getStavke()) {
            databaseBroker.sacuvaj(s);
        }
    }
}
