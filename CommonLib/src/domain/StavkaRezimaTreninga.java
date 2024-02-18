/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class StavkaRezimaTreninga implements IGeneralEntity{
    private int stavkaId;
    private RezimTreninga rezim;
    private String nazivStavke;
    private Trener trener;
    private VrstaTreninga vrstaTreninga;
    
    
    public StavkaRezimaTreninga() {
    }

    public StavkaRezimaTreninga(int stavkaId, RezimTreninga rezim) {
        this.stavkaId = stavkaId;
        this.rezim = rezim;
    }

    public StavkaRezimaTreninga(int stavkaId, RezimTreninga rezim, String nazivStavke, Trener trener, VrstaTreninga vrstaTreninga) {
        this.stavkaId = stavkaId;
        this.rezim = rezim;
        this.nazivStavke = nazivStavke;
        this.trener = trener;
        this.vrstaTreninga = vrstaTreninga;
    }

    

   

    

    public int getStavkaId() {
        return stavkaId;
    }

    public void setStavkaId(int stavkaId) {
        this.stavkaId = stavkaId;
    }

    public RezimTreninga getRezim() {
        return rezim;
    }

    public void setRezim(RezimTreninga rezim) {
        this.rezim = rezim;
    }

    
    

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public VrstaTreninga getVrstaTreninga() {
        return vrstaTreninga;
    }

    public void setVrstaTreninga(VrstaTreninga vrstaTreninga) {
        this.vrstaTreninga = vrstaTreninga;
    }

    @Override
    public String getTableName() {
        return "stavkarezima";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {    
            
            
            int rezId = resultSet.getInt("RezimID");
            int trenerId = resultSet.getInt("TrenerID");
            int stavkaId = resultSet.getInt("StavkaID");
            int vrstaTreningaId = resultSet.getInt("VrstaTreningaID");
            
            StavkaRezimaTreninga s = new StavkaRezimaTreninga(stavkaId, new RezimTreninga(rezId), resultSet.getString("NazivStavke"), new Trener(trenerId), new VrstaTreninga(vrstaTreningaId));
            list.add(s);
        }
        return list;
    }

    @Override
    public String getValues() {
        return stavkaId + ", " + rezim.getRezimId() + ", '" + nazivStavke +"' , " + trener.getTrenerId() + ", "  + vrstaTreninga.getVrstaTreningaId();
    }

    @Override
    public String getAttributes() {
        return "StavkaID, RezimID, NazivStavke, TrenerID, VrstaTreningaID";
    }

    @Override
    public String setAttributes() {
    
        return "StavkaID=" + stavkaId + ", RezimID=" + rezim.getRezimId() + ", NazivStavke = '" + nazivStavke + "',TrenerID = " + trener.getTrenerId() + ", VrstaTreningaID = " +vrstaTreninga.getVrstaTreningaId();
        
    }

    @Override
    public String getDeleteCondition() {
         return "StavkaID = " + stavkaId;
    }

    @Override
    public String getUpdateCondition() {
        return "StavkaID = " + stavkaId ;
   
    }

    @Override
    public String getSelectCondition() {
        return "RezimID= " + rezim.getRezimId();
   }

    public String getNazivStavke() {
        return nazivStavke;
    }

    public void setNazivStavke(String nazivStavke) {
        this.nazivStavke = nazivStavke;
    }
    
    
    
    
    
    
    
    
}
