/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.models;

import domain.Klijent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableModelKlijent extends AbstractTableModel {
    ArrayList<Klijent> korisnici;
    String[] header = new String[]{"Id", "Ime", "Prezime", "Kontakt", "JMBG" ,"Vrsta Treninga ID"};

    public TableModelKlijent() {
        korisnici = new ArrayList<>();
    }

    public TableModelKlijent(ArrayList<Klijent> korisnici) {
        this.korisnici = new ArrayList<>();
        this.korisnici = korisnici;
    }

    @Override
    public String getColumnName(int col) {
        return header[col];
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Klijent korisnik = korisnici.get(row);
        switch (col) {
            case 0:
                return korisnik.getKlijentId();
            case 1:
                return korisnik.getIme();
            case 2:
                return korisnik.getPrezime();
            case 3:
                return korisnik.getKontakt();
            case 4:
                return korisnik.getJmbg();
            case 5:
                return korisnik.getVrstaTreninga().getVrstaTreningaId();
               
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

    public void setKorisnici(ArrayList<Klijent> korisnici) {
        this.korisnici = korisnici;
    }

    public ArrayList<Klijent> getKorisnici() {
        return korisnici;
    }
}
