/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domain.IGeneralEntity;
import java.util.List;

/**
 *
 * @author user
 */
public interface IBrokerBaze {
    //koristice se za: prijaviKorisnika i vratiTip
    IGeneralEntity vratiPoId(IGeneralEntity entity) throws Exception;

    //koristice se za: vratiSveLekove i vratiSveTipove
    List<IGeneralEntity> vratiSve(IGeneralEntity entity) throws Exception;

    int sacuvaj(IGeneralEntity entity) throws Exception;

    //koristice se za: obrisiTip, obrisiPrijavu
    void obrisi(IGeneralEntity entity) throws Exception;

    void izmeni(IGeneralEntity entity) throws Exception;
    
    List<IGeneralEntity> vratiPoUslovu(IGeneralEntity entity) throws Exception;

}
