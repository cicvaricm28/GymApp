/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domain.Trener;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Session {
    private static Session instance;
    private Trener currentUser;
    private Socket socket;
    private boolean otvoriFormu;
    
    
    private Session() {
        
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Trener getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Trener currentUser) {
        this.currentUser = currentUser;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isOtvoriFormu() {
        return otvoriFormu;
    }

    public void setOtvoriFormu(boolean otvoriFormu) {
        this.otvoriFormu = otvoriFormu;
    }

    
    
    
}
