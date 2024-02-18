/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domain.Trener;

/**
 *
 * @author user
 */
public interface SkladisteTrener {
    Trener prijaviTrenera(String username, String password) throws Exception;
}
