/*
 * Copyright (C) 2019 Matthew Cumbo & Hunter Jasinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mrencryptor;

import java.awt.Color;
import java.awt.Font;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

/**
 *
 * @author Matthew Cumbo & Hunter Jasinski
 */
public class MainFrame extends javax.swing.JFrame {
    
    private boolean invalueEmpty = true; // Used for checking if INVALUE is empty.
    private final String KEY = "MChaffee@HTPD162"; // Key used for AES256
    private final String SALT = "f0i1neFE@!caCfD!";
    
    /**
     * Encrypts a string to AES256 encryption.
     * @param str String to encrypt.
     * @return Encrypted text.
     */
    protected String encrypt(String str){
        try{
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
        } 
        catch(Exception e){
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    /**
     * Decrypts a string in AES256 to regular
     * text.
     * @param str String to decipher.
     * @return Deciphered text.
     */
    protected String decrypt(String str){
        try{   
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
         
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
         
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(str)));
        }catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    // Creates new form MainFrame
    public MainFrame() {
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

        lblINOP = new javax.swing.JLabel();
        lblOUTPUT = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        INOP = new javax.swing.JComboBox<>();
        outputScroller = new javax.swing.JScrollPane();
        OUTPUT = new javax.swing.JTextArea();
        invalueScroller = new javax.swing.JScrollPane();
        INVALUE = new javax.swing.JTextArea();
        lblINVALUE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mr. Encryptor");
        setResizable(false);

        lblINOP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblINOP.setText("INOP:");

        lblOUTPUT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblOUTPUT.setText("OUTPUT:");

        btnEnter.setText("Enter");
        btnEnter.setEnabled(false);
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        INOP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encrypt", "Decrypt" }));
        INOP.setNextFocusableComponent(btnEnter);

        OUTPUT.setEditable(false);
        OUTPUT.setColumns(20);
        OUTPUT.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        OUTPUT.setRows(5);
        outputScroller.setViewportView(OUTPUT);

        INVALUE.setColumns(20);
        INVALUE.setFont(new java.awt.Font("Courier New", 2, 14)); // NOI18N
        INVALUE.setForeground(java.awt.Color.gray);
        INVALUE.setRows(5);
        INVALUE.setText("Enter text here");
        INVALUE.setNextFocusableComponent(INOP);
        INVALUE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                INVALUEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                INVALUEFocusLost(evt);
            }
        });
        INVALUE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INVALUEKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                INVALUEKeyReleased(evt);
            }
        });
        invalueScroller.setViewportView(INVALUE);

        lblINVALUE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblINVALUE.setText("INVALUE:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblINVALUE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(invalueScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(lblINOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(INOP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnEnter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblOUTPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(outputScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblINVALUE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalueScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblINOP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(INOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEnter)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOUTPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INVALUEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_INVALUEFocusGained
        if(invalueEmpty){
            INVALUE.setText("");
            INVALUE.setFont(new Font("Courier New", Font.PLAIN, 14));
            INVALUE.setForeground(Color.black);
        }
        else{
            INVALUE.selectAll();
        }  
    }//GEN-LAST:event_INVALUEFocusGained

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        if(INOP.getSelectedItem().toString().equals("Encrypt")){
            OUTPUT.setText(encrypt(INVALUE.getText()));
        }
        else{
            OUTPUT.setText(decrypt(INVALUE.getText()));
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void INVALUEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INVALUEKeyReleased
        OUTPUT.setText("");
        if(INVALUE.getText().equals("")){
            btnEnter.setEnabled(false);
            invalueEmpty = true;
        }
        else{
            btnEnter.setEnabled(true);
            invalueEmpty = false;
        }
    }//GEN-LAST:event_INVALUEKeyReleased

    private void INVALUEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_INVALUEFocusLost
        if(invalueEmpty){
            INVALUE.setText("Enter text here");
            INVALUE.setFont(new Font("Courier New", Font.ITALIC, 14));
            INVALUE.setForeground(Color.gray);
        }
    }//GEN-LAST:event_INVALUEFocusLost

    private void INVALUEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INVALUEKeyPressed
        OUTPUT.setText("");
        if(INVALUE.getText().equals("")){
            btnEnter.setEnabled(false);
            invalueEmpty = true;
        }
        else{
            btnEnter.setEnabled(true);
            invalueEmpty = false;
        }
    }//GEN-LAST:event_INVALUEKeyPressed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> INOP;
    private javax.swing.JTextArea INVALUE;
    private javax.swing.JTextArea OUTPUT;
    private javax.swing.JButton btnEnter;
    private javax.swing.JScrollPane invalueScroller;
    private javax.swing.JLabel lblINOP;
    private javax.swing.JLabel lblINVALUE;
    private javax.swing.JLabel lblOUTPUT;
    private javax.swing.JScrollPane outputScroller;
    // End of variables declaration//GEN-END:variables
}
