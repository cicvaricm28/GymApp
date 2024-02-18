/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.models;

import domain.Klijent;
import domain.StavkaRezimaTreninga;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableModelStavke extends AbstractTableModel{
    ArrayList<StavkaRezimaTreninga> stavke;
    String[] header = new String[]{"StavkaID", "NazivStavke", "VrstaTreninga"};

    public TableModelStavke() {
        stavke = new ArrayList<>();
    }

    public TableModelStavke(ArrayList<StavkaRezimaTreninga> stavke) {
        
        this.stavke = stavke;
    }

    @Override
    public String getColumnName(int col) {
        return header[col];
    }

    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        StavkaRezimaTreninga stavka = stavke.get(row);
        switch (col) {
            case 0:
                return stavka.getStavkaId();
            case 1:
                return stavka.getNazivStavke();
            case 2:
                return stavka.getVrstaTreninga().getNazivVrsteTreninga();
           
               
            default:
                return "N/A";
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        switch (col) {
            default:
                return false;
        }
    }

    public void setStavke(ArrayList<StavkaRezimaTreninga> stavke) {
        this.stavke = stavke;
    }

    public ArrayList<StavkaRezimaTreninga> getStavke() {
        return stavke;
    }
    
    public void dodajStavku(StavkaRezimaTreninga stavkaPrijave) {
        
        stavke.add(stavkaPrijave);
        
        fireTableDataChanged();
    }
    
    
     public void obrisiStavku(int selectedRow) {
        
        StavkaRezimaTreninga sp = stavke.get(selectedRow);
            
        stavke.remove(selectedRow);
        
        fireTableDataChanged();
    }
    
}
