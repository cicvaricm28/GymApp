/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import server.Server;
import skladiste.baza.konekcija.Konekcija;
import util.Constants;
import util.SettingsLoader;


/**
 *
 * @author user
 */
public class frmServer extends javax.swing.JFrame {

    private Server server;

    /**
     * Creates new form frmServer
     */
    public frmServer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new javax.swing.JLabel();
        btnPokreni = new javax.swing.JButton();
        btnIzgasi = new javax.swing.JButton();
        lblUrl = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStatus.setText("Server nije aktivan");

        btnPokreni.setText("Pokreni");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnIzgasi.setText("Izgasi");
        btnIzgasi.setEnabled(false);
        btnIzgasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzgasiActionPerformed(evt);
            }
        });

        lblUrl.setText("URL baze:");

        lblUsername.setText("Username baze:");

        lblPassword.setText("Password baze:");

        txtUsername.setText("root");

        txtUrl.setText("jdbc:mysql://localhost:3306/mojabaza");
        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });

        txtPort.setText("9000");

        lblPort.setText("Broj porta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnPokreni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzgasi)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(lblUsername)
                    .addComponent(lblUrl)
                    .addComponent(lblPort))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPort)
                    .addComponent(txtUrl)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblStatus)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreni)
                    .addComponent(btnIzgasi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPort)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUrl)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblUsername))
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        String url = this.txtUrl.getText().trim();
        String username = this.txtUsername.getText().trim();
        String password = this.txtPassword.getText().trim();
        String port = this.txtPort.getText().trim();

        try {
            Integer.parseInt(port);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Port mora biti broj! Pokusajte ponovo!");
            return;
        }

        SettingsLoader.getInstance().setProperty(Constants.URL, url);
        SettingsLoader.getInstance().setProperty(Constants.USERNAME, username);
        SettingsLoader.getInstance().setProperty(Constants.PASSWORD, password);
        SettingsLoader.getInstance().setProperty(Constants.PORT, port);

        try {
            SettingsLoader.getInstance().saveProperties();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Property nisu sacuvani! Pokusajte ponovo!");
            return;
        }

        JOptionPane.showMessageDialog(this, "Properties sacuvani!");
        if (server == null || !server.isAlive()) {
            try {
                server = new Server(Integer.parseInt(SettingsLoader.getInstance().getProperty(Constants.PORT)));
                server.start();

                Konekcija.getInstance().getConnection();

                this.lblStatus.setText("Server radi.");
                JOptionPane.showMessageDialog(this, "Server je zapoceo rad.");
                this.btnPokreni.setEnabled(false);
                this.btnIzgasi.setEnabled(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Port " + SettingsLoader.getInstance().getProperty(Constants.PORT) + " je zauzet.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Neispravni podaci o bazi!");
                try {
                    server.stopServer();
                    server = null;
                } catch (IOException ex1) {
                    JOptionPane.showMessageDialog(this, "Neuspesno zatvaranje servera!");
                    System.exit(0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Server vec radi.");
        }
    }//GEN-LAST:event_btnPokreniActionPerformed

    private void btnIzgasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzgasiActionPerformed
        try {
            server.stopServer();
            server = null;
            Konekcija.getInstance().closeConnection();
            JOptionPane.showMessageDialog(this, "Server je zaustavljen.");
            this.lblStatus.setText("Server ne radi.");
            this.btnPokreni.setEnabled(true);
            this.btnIzgasi.setEnabled(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Neuspesno zaustavljanje servera.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Neuspesno zatvaranje baze za rad.");
        }
    }//GEN-LAST:event_btnIzgasiActionPerformed

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrlActionPerformed

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
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzgasi;
    private javax.swing.JButton btnPokreni;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public void pokrenutJeServer() {
        btnPokreni.setEnabled(false);
        btnIzgasi.setEnabled(true);
        lblStatus.setText("Server je pokrenut");
    }

    public void greskaUServeru() {
        JOptionPane.showMessageDialog(this, "Greska u povezivanju");
    }
}