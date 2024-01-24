/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.estoque.View.FormularioCadastro;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.estoque.Present.CadastroControllerUI.CadastroUI;

import javax.swing.*;

/**
 *
 * @author campos
 */
@Data
@Getter
@Setter
public class CadastraFormularioView extends javax.swing.JFrame {

    private CadastroUI cadastroUI;

    public CadastraFormularioView() {
        initComponents();
        setLocationRelativeTo(null);
        jButton1.addActionListener(new CadastroUI(this));
        this.cadastroUI = new CadastroUI(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        InputEmail = new javax.swing.JTextField();
        InputNome = new javax.swing.JTextField();
        InputUsername1 = new javax.swing.JTextField();
        InputTelefone = new javax.swing.JTextField();
        InputSenha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Oliveira.dev");

        InputEmail.setText("Email");
        InputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputEmailActionPerformed(evt);
            }
        });

        InputNome.setText("Nome");
        InputNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNomeActionPerformed(evt);
            }
        });

        InputUsername1.setText("Username");
        InputUsername1.setToolTipText("Username");
        InputUsername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUsername1ActionPerformed(evt);
            }
        });

        InputTelefone.setText("Telefone");
        InputTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTelefoneActionPerformed(evt);
            }
        });

        InputSenha.setText("Senha");
        InputSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputSenhaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(16, 109, 16));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salvar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {

        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InputEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(InputUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(InputTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Message)
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InputNome, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(InputUsername1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputEmailActionPerformed

    private void InputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNomeActionPerformed

    private void InputUsername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUsername1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUsername1ActionPerformed

    private void InputTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputTelefoneActionPerformed

    private void InputSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastraFormularioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputNome;
    private javax.swing.JTextField InputSenha;
    private javax.swing.JTextField InputTelefone;
    private javax.swing.JTextField InputUsername1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


    public JTextField getInputEmail() {
        return InputEmail;
    }

    public void setInputEmail(JTextField inputEmail) {
        InputEmail = inputEmail;
    }

    public JTextField getInputNome() {
        return InputNome;
    }

    public void setInputNome(JTextField inputNome) {
        InputNome = inputNome;
    }

    public JTextField getInputSenha() {
        return InputSenha;
    }

    public void setInputSenha(JTextField inputSenha) {
        InputSenha = inputSenha;
    }

    public JTextField getInputTelefone() {
        return InputTelefone;
    }

    public void setInputTelefone(JTextField inputTelefone) {
        InputTelefone = inputTelefone;
    }

    public JTextField getInputUsername1() {
        return InputUsername1;
    }

    public void setInputUsername1(JTextField inputUsername1) {
        InputUsername1 = inputUsername1;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return Message;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.Message = jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }


}
