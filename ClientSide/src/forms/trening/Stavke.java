/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.trening;

import domain.Klijent;
import domain.RezimTreninga;
import domain.StavkaRezimaTreninga;
import domain.VrstaTreninga;
import forms.klijent.UnosKlijenta;
import forms.models.TableModelKlijent;
import forms.models.TableModelStavke;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logics.Controler;
import session.Session;

/**
 *
 * @author user
 */
public class Stavke extends javax.swing.JDialog {

    /**
     * Creates new form Stavke
     */
    public Stavke(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Session.getInstance().setOtvoriFormu(true);
        initComponents();
        
        setUpCb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbRezim = new javax.swing.JComboBox<>();
        btnIzaberiRezim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnUnesi = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        cbVrsteTreninga = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Rezim");

        cbRezim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIzaberiRezim.setText("Izaberi");
        btnIzaberiRezim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiRezimActionPerformed(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        btnUnesi.setText("Unesi Stavku");
        btnUnesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("Izbrisi Stavku");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni Stavku");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        jLabel2.setText("Vrsta Treninga");

        jLabel3.setText("Naziv Stavke");

        cbVrsteTreninga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnIzaberiRezim))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addComponent(cbRezim, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(169, 169, 169)
                                    .addComponent(btnIzbrisi))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnUnesi)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnIzmeni))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cbVrsteTreninga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(15, 15, 15)
                                                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRezim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnIzaberiRezim)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnIzbrisi)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbVrsteTreninga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnUnesi))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzaberiRezimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiRezimActionPerformed
        RezimTreninga r = (RezimTreninga) cbRezim.getSelectedItem();
        btnIzbrisi.setEnabled(true);
        btnIzmeni.setEnabled(true);
        btnUnesi.setEnabled(true);
        populateTable(r);
        
    }//GEN-LAST:event_btnIzaberiRezimActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        int r = tblStavke.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe stavku po zadatoj vrednosti! Morate selektovati stavku!");
            return;
        }
        TableModelStavke tmp = (TableModelStavke) tblStavke.getModel();
        StavkaRezimaTreninga v = tmp.getStavke().get(r);
        try {
            Controler.getInstance().obrisiStavku(v.getStavkaId());
            JOptionPane.showMessageDialog(null, "Sistem je obrisao stavku!");
            tmp.obrisiStavku(r);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da obriše stavku!");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da obriše stavku!");
        }
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnUnesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiActionPerformed
        if(!setujStavku()){
            return;
        }
        
        RezimTreninga r = (RezimTreninga) cbRezim.getSelectedItem();
        
        StavkaRezimaTreninga s = new  StavkaRezimaTreninga(1, r, txtNaziv.getText(), Session.getInstance().getCurrentUser(), (VrstaTreninga) cbVrsteTreninga.getSelectedItem());
        try {
            Controler.getInstance().sacuvajStavku(s);
            TableModelStavke tmp = (TableModelStavke) tblStavke.getModel();
            tmp.dodajStavku(s);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti rezim.");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da zapamti rezim.");
        }
        
        
    }//GEN-LAST:event_btnUnesiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int r = tblStavke.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe stavku po zadatoj vrednosti! Morate selektovati stavku!");
            return;
        }
        TableModelStavke tmp = (TableModelStavke) tblStavke.getModel();
        StavkaRezimaTreninga v = tmp.getStavke().get(r);
        v.setNazivStavke(txtNaziv.getText());
        v.setVrstaTreninga((VrstaTreninga) cbVrsteTreninga.getSelectedItem());
        v.setTrener(Session.getInstance().getCurrentUser());
        try {
            Controler.getInstance().izmeniStavku(v);
            JOptionPane.showMessageDialog(null, "Sistem je izmenio stavku!");
            tmp.obrisiStavku(r);
            tmp.dodajStavku(v);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni stavku!");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Sistem ne može da izmeni stavku!");
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Stavke dialog = new Stavke(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberiRezim;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnUnesi;
    private javax.swing.JComboBox<Object> cbRezim;
    private javax.swing.JComboBox<Object> cbVrsteTreninga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void setUpCb() {
        try {
            btnIzbrisi.setEnabled(false);
            btnIzmeni.setEnabled(false);
            btnUnesi.setEnabled(false);
            cbVrsteTreninga.removeAllItems();
        try {
            ArrayList<VrstaTreninga> vrste = Controler.getInstance().vratiVrste();
            for (VrstaTreninga vrstaTreninga : vrste) {
                cbVrsteTreninga.addItem(vrstaTreninga);
            }
        } catch (Exception ex) {
            Logger.getLogger(UnosKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            
            cbRezim.removeAllItems();
            ArrayList<RezimTreninga> stavke = Controler.getInstance().vratiRezime();
            for (RezimTreninga rezimTreninga : stavke) {
                cbRezim.addItem(rezimTreninga);
                
            }
            
        } catch (Exception ex) {
            Session.getInstance().setOtvoriFormu(false);
            JOptionPane.showMessageDialog(null, "Sistem ne može da vrati rezime!");
            this.dispose();
        }
    }

    private void populateTable(RezimTreninga r) {
        TableModelStavke m = new TableModelStavke(r.getStavke());
        tblStavke.setModel(m);
        
    }
    
    
    private boolean setujStavku() {
        if (
                txtNaziv.getText().isEmpty() 
                
                
        ){ 
            JOptionPane.showMessageDialog(null, "Popunite sva polja!");
            return false;
        }
             
                
        return true;
        }
        
        
        
}
