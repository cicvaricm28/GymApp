/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Trener implements IGeneralEntity{
    private int trenerId;
    private String username;
    private String password;
    private String jmbgTrenera;
    private String ime;
    private String prezime;

    public Trener() {
    }

    public Trener(int trenerId) {
        this.trenerId = trenerId;
    }
    

    public Trener(int trenerId, String username, String password, String jmbgTrenera, String ime, String prezime) {
        this.trenerId = trenerId;
        this.username = username;
        this.password = password;
        this.jmbgTrenera = jmbgTrenera;
        this.ime = ime;
        this.prezime = prezime;
    }

     public int getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(int trenerId) {
        this.trenerId = trenerId;
    }
    
    
    
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJmbgTrenera() {
        return jmbgTrenera;
    }

    public void setJmbgTrenera(String jmbgTrenera) {
        this.jmbgTrenera = jmbgTrenera;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return  ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "trener";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {    
            int treId = resultSet.getInt("TrenerID");
            String username1 = resultSet.getString("Username");
            String password1 = resultSet.getString("Password");
            String ime1 = resultSet.getString("Ime");
            String prezime1 = resultSet.getString("Prezime");
            String jmbg = resultSet.getString("JMBGT");
            Trener t = new Trener(treId, username1, password1, jmbg, ime1, prezime1);
            list.add(t);
        }
        return list;
    }

    @Override
    public String getValues() {
        return trenerId + ", '" + ime + "', '" + prezime + "', '" + username + "', '" + password + "', '" + jmbgTrenera + "'";
    }

    @Override
    public String getAttributes() {
        return "TrenerID, Ime, Prezime, Username, Password, JMBGT";
    }

    @Override
    public String setAttributes() {
        return "TrenerID=" + trenerId + ", Ime='" + ime + "', Prezime='" + prezime + "', Username='" + username + "', Password='" + password + "', JMBGT='" + jmbgTrenera+"'" ;
    }

    @Override
    public String getDeleteCondition() {
        return "TrenerID="+trenerId;
    }

    @Override
    public String getUpdateCondition() {
         return "TrenerID="+trenerId;
    }

    @Override
    public String getSelectCondition() {
        if(username == null && password == null){
            return "TrenerID="+trenerId;
        }
        return "Username='" + username + "' and Password='" + password + "'";
        
    }
}
