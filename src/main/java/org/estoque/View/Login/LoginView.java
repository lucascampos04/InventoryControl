/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.estoque.View.Login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import lombok.Getter;
import lombok.Setter;
import org.estoque.Present.LoginControllerUI.LoginUI;

/**
 *
 * @author campos
 */
public class LoginView extends javax.swing.JFrame {

    private final LoginUI loginUI;
    
    public LoginView() {
        initComponents();
        setLocationRelativeTo(this);
        this.loginUI = new LoginUI(this, null);
        ButtonLogin.addActionListener(new LoginUI(this, null));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonLogin = new javax.swing.JButton();
        InputPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        IInputLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ButtonCancelar = new javax.swing.JButton();
        LabelEsqueciSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(64, 167, 235));

        ButtonLogin.setBackground(new java.awt.Color(2, 119, 19));
        ButtonLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ButtonLogin.setText("Login");
        ButtonLogin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                ButtonLoginAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        InputPassword.setText("jPasswordField1");

        jLabel1.setText("Senha");

        jLabel2.setText("Login");

        ButtonCancelar.setBackground(new java.awt.Color(227, 15, 8));
        ButtonCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ButtonCancelar.setText("Cancelar");

        LabelEsqueciSenha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelEsqueciSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEsqueciSenha.setText("Esqueci senha");
        LabelEsqueciSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelEsqueciSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelEsqueciSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(InputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(ButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonCancelar)
                            .addGap(11, 11, 11))
                        .addComponent(IInputLogin)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IInputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(LabelEsqueciSenha)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelEsqueciSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelEsqueciSenhaMouseClicked
       System.out.println("Esqueci senha");
    }//GEN-LAST:event_LabelEsqueciSenhaMouseClicked

    private void ButtonLoginAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ButtonLoginAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonLoginAncestorMoved

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JTextField IInputLogin;
    private javax.swing.JPasswordField InputPassword;
    private javax.swing.JLabel LabelEsqueciSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonCancelar() {
        return ButtonCancelar;
    }

    public void setButtonCancelar(JButton ButtonCancelar) {
        this.ButtonCancelar = ButtonCancelar;
    }

    public JButton getButtonLogin() {
        return ButtonLogin;
    }

    public void setButtonLogin(JButton ButtonLogin) {
        this.ButtonLogin = ButtonLogin;
    }

    public JTextField getIInputLogin() {
        return IInputLogin;
    }

    public void setIInputLogin(JTextField IInputLogin) {
        this.IInputLogin = IInputLogin;
    }

    public JPasswordField getInputPassword() {
        return InputPassword;
    }

    public void setInputPassword(JPasswordField InputPassword) {
        this.InputPassword = InputPassword;
    }

    public JLabel getLabelEsqueciSenha() {
        return LabelEsqueciSenha;
    }

    public void setLabelEsqueciSenha(JLabel LabelEsqueciSenha) {
        this.LabelEsqueciSenha = LabelEsqueciSenha;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    
}
