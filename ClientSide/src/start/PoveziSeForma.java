/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;


import forms.frmLogin;
import java.net.Socket;
import javax.swing.JOptionPane;
import session.Session;


/**
 *
 * @author user
 */
public class PoveziSeForma extends javax.swing.JFrame {

    /**
     * Creates new form PoveziSeForma
     */
    public PoveziSeForma() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPoveziSe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        btnPoveziSe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Adresa:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Port:");

        txtAdresa.setText("127.0.0.1");

        txtPort.setText("9000");

        btnPoveziSe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPoveziSe.setText("Povezi se");
        btnPoveziSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoveziSeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPoveziSeLayout = new javax.swing.GroupLayout(pnlPoveziSe);
        pnlPoveziSe.setLayout(pnlPoveziSeLayout);
        pnlPoveziSeLayout.setHorizontalGroup(
            pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPoveziSeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPoveziSeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPoveziSe, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPoveziSeLayout.createSequentialGroup()
                        .addGroup(pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        pnlPoveziSeLayout.setVerticalGroup(
            pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPoveziSeLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPoveziSeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPoveziSe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pnlPoveziSe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlPoveziSe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPoveziSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoveziSeActionPerformed
        try {
            Socket socket = new Socket(txtAdresa.getText(), Integer.parseInt(txtPort.getText()));
            Session.getInstance().setSocket(socket);
            frmLogin prijaviSeForma = new frmLogin();
            this.dispose();
            JOptionPane.showMessageDialog(null, "Uspesno ste se povezali!");
            prijaviSeForma.setVisible(true);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Server ne radi!");
        }
    }//GEN-LAST:event_btnPoveziSeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPoveziSe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlPoveziSe;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}
