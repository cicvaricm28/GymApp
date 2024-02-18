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
public class VrstaTreninga implements IGeneralEntity{
    private int vrstaTreningaId;
    private String nazivVrsteTreninga;

    public VrstaTreninga() {
    }

    public VrstaTreninga(int vrstaTreningaId) {
        this.vrstaTreningaId = vrstaTreningaId;
    }
    
    
    
    public VrstaTreninga(int vrstaTreningaId, String nazivVrsteTreninga) {
        this.vrstaTreningaId = vrstaTreningaId;
        this.nazivVrsteTreninga = nazivVrsteTreninga;
    }

    public String getNazivVrsteTreninga() {
        return nazivVrsteTreninga;
    }

    public void setNazivVrsteTreninga(String nazivVrsteTreninga) {
        this.nazivVrsteTreninga = nazivVrsteTreninga;
    }

    public int getVrstaTreningaId() {
        return vrstaTreningaId;
    }

    public void setVrstaTreningaId(int vrstaTreningaId) {
        this.vrstaTreningaId = vrstaTreningaId;
    }

    @Override
    public String toString() {
        return nazivVrsteTreninga;
    }

    @Override
    public String getTableName() {
        return "vrstatreninga";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {    
            
            
            int vrstaId = resultSet.getInt("VrstaTreningaID");
            String nazivVrste = resultSet.getString("NazivVrsteTreninga");
            
            VrstaTreninga v = new VrstaTreninga(vrstaId, nazivVrste);
            list.add(v);
        }
        return list;
    }

    @Override
    public String getValues() {
         return vrstaTreningaId + ", '" + nazivVrsteTreninga + "'";
    
    }

    @Override
    public String getAttributes() {
        return "VrstaTreningaID, NazivVrsteTreninga";
    }

    @Override
    public String setAttributes() {
        return "VrstaTreningaID=" + vrstaTreningaId + ", NazivVrsteTreninga='" + nazivVrsteTreninga +"'"; 
                }

    @Override
    public String getDeleteCondition() {
        return "VrstaTreningaID=" + vrstaTreningaId;
    }

    @Override
    public String getUpdateCondition() {
        return "VrstaTreningaID=" + vrstaTreningaId;
    }

    @Override
    public String getSelectCondition() {
        return "VrstaTreningaID=" + vrstaTreningaId;
    }
    
    
}
