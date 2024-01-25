/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Present.LoginControllerUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.View.Login.LoginView;

/**
 *
 * @author campos
 */
public class LoginUI implements ActionListener{
    private final LoginView loginView;
    private final Authentication authentication;

    public LoginUI(LoginView loginView) {
        this.loginView = loginView;
        this.authentication = new Authentication();
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "Login":
                login();
                break;
            default:
               System.out.println("Erro desconhecido");
        }
    }
    
    public void login(){
        String username = this.loginView.getIInputLogin().getText();
        String password = this.loginView.getInputPassword().getText();
        
        if (username.equals("") || password.equals("")){
            System.out.println("Login incorreto");
            return;
        }
        
        UsuarioDados usuario = new UsuarioDados(username, password);
        UsuarioDados usuarioTem = authentication.login(usuario);
        
        if (usuarioTem != null){
            JOptionPane.showConfirmDialog(null, usuarioTem.getNome());
            System.out.println("Login realizado com sucesso");
        } else {
            System.out.println("Usuario ou senha incorreto");
        }
        
              
    }
}
