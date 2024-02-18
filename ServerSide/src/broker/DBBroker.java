/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

/**
 *
 * @author user
 */
public class DBBroker {
    private static DBBroker instance;
    
    private DBBroker(){
    
    }
    
    public static DBBroker getInstance(){
        if(instance == null){
            instance = new DBBroker();
        }
        return instance;
    }
    
    
}
