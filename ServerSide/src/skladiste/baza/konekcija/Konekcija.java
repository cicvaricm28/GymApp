/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.baza.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.SettingsLoader;

/**
 *
 * @author user
 */
public class Konekcija {
    private final Connection connection;
    private static Konekcija instance;

    private Konekcija() throws SQLException{
        String url = SettingsLoader.getInstance().getProperty("URL");
        String username = SettingsLoader.getInstance().getProperty("USERNAME");
        String password = SettingsLoader.getInstance().getProperty("PASSWORD");
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
    }

    public static Konekcija getInstance() throws SQLException {
         if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        instance = null;
    }
}
