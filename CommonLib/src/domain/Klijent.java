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
public class Klijent implements IGeneralEntity{
    private int klijentId;
    private String ime;
    private String prezime;
    private String jmbg;
    private String kontakt;
    private VrstaTreninga vrstaTreninga;
    
    public Klijent() {
    }

    public Klijent(int klijentId, String ime, String prezime, String jmbg, String kontakt, VrstaTreninga vrstaTreninga) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.kontakt = kontakt;
        this.vrstaTreninga = vrstaTreninga;
        
    }

    
     public int getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(int klijentId) {
        this.klijentId = klijentId;
    }
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public VrstaTreninga getVrstaTreninga() {
        return vrstaTreninga;
    }

    public void setVrstaTreninga(VrstaTreninga vrstaTreninga) {
        this.vrstaTreninga = vrstaTreninga;
    }

   
    @Override
    public String getTableName() {
        return "klijent";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {    
            
            int klId = resultSet.getInt("KlijentID");
            String ime1 = resultSet.getString("Ime");
            String prezime1 = resultSet.getString("Prezime");
            String jmbg = resultSet.getString("JMBG");
            String kontakt = resultSet.getString("Kontakt");
            int vrstaId = resultSet.getInt("VrstaTreningaID");
            
            Klijent k = new Klijent(klId, ime1, prezime1, jmbg, kontakt,new VrstaTreninga(vrstaId));
            list.add(k);
        }
        return list;
    }

    @Override
    public String getValues() {
        return klijentId + ", '" + ime + "', '" + prezime + "', '"+jmbg+"', '"+kontakt+"', "+vrstaTreninga.getVrstaTreningaId();
    
    }

    @Override
    public String getAttributes() {
        return "KlijentID, Ime, Prezime, JMBG, Kontakt, VrstaTreningaID";
    }

    @Override
    public String setAttributes() {
        return "KlijentID=" + klijentId + ", Ime='" + ime + "', Prezime='" + prezime + "', JMBG='" + jmbg + "', Kontakt='" + kontakt + "', VrstaTreningaID=" + vrstaTreninga.getVrstaTreningaId() ;
    }

    @Override
    public String getDeleteCondition() {
        return "KlijentID=" + klijentId;
    }

    @Override
    public String getUpdateCondition() {
        return "KlijentID=" + klijentId;
    }

    @Override
    public String getSelectCondition() {
        if (vrstaTreninga != null && vrstaTreninga.getVrstaTreningaId()> 0) {
            return "VrstaTreningaID=" + vrstaTreninga.getVrstaTreningaId();
        }
        
        return "KlijentID=" + klijentId;
    }

   

    
    
   
}
