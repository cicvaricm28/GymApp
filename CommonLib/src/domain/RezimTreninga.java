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
public class RezimTreninga implements IGeneralEntity{
    private int rezimId;
    private String opis;
    private String mesec;
    private ArrayList<StavkaRezimaTreninga> stavke;

    public RezimTreninga() {
        stavke = new ArrayList<>();
    }

    public RezimTreninga(int rezimId) {
        this.rezimId = rezimId;
        stavke = new ArrayList<>();
    }

    public RezimTreninga(int rezimId, String opis, String mesec) {
        this.rezimId = rezimId;
        this.opis = opis;
        this.mesec = mesec;
        stavke = new ArrayList<>();
    }

    
    
    public RezimTreninga(int rezimId, String opis, String mesec, ArrayList<StavkaRezimaTreninga> stavke) {
        this.rezimId = rezimId;
        this.opis = opis;
        this.mesec = mesec;
        this.stavke = stavke;
    }
    
    
    
    
    
    
    public int getRezimId() {
        return rezimId;
    }

    public void setRezimId(int rezimId) {
        this.rezimId = rezimId;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    @Override
    public String getTableName() {
        return "rezimtreninga";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
         List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {    
            
            
            int rezId = resultSet.getInt("RezimID");
            String opis = resultSet.getString("Opis");
            String mesec = resultSet.getString("Mesec");
            
            RezimTreninga r = new RezimTreninga(rezId, opis, mesec);
            list.add(r);
        }
        return list;
    }

    @Override
    public String getValues() {
         return rezimId + ", '" + opis + "', '" + mesec +"'";
    }

    @Override
    public String getAttributes() {
        return "RezimID, Opis, Mesec";
    }

    @Override
    public String setAttributes() {
        return "RezimID=" + rezimId + ", Opis='" + opis + "', Mesec='" +mesec +"'"; 
    }
    @Override
    public String getDeleteCondition() {
        return "RezimID ="+ rezimId;
                }

    @Override
    public String getUpdateCondition() {
        return "RezimID ="+ rezimId;
                }

    @Override
    public String getSelectCondition() {
      return "RezimID ="+ rezimId;
                }

    public ArrayList<StavkaRezimaTreninga> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRezimaTreninga> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return mesec; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
