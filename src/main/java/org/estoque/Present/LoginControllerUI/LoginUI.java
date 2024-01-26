/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Present.LoginControllerUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.View.Central.CentralView;
import org.estoque.View.Login.LoginView;

/**
 *
 * @author campos
 */
public class LoginUI implements ActionListener{
    private final LoginView loginView;
    private final Authentication authentication;
    private final CentralView centralView;

    public LoginUI(LoginView loginView, org.estoque.View.Central.CentralView centralView) {
        this.loginView = loginView;
        this.authentication = new Authentication();
        this.centralView = new CentralView();
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
            System.out.println("Login realizado com sucesso");
            redirectCentral();
        } else {
            System.out.println("Usuario ou senha incorreto");
        }     
    }
    private void redirectCentral(){
        loginView.dispose();
        centralView.setVisible(true);
    }

    private void clearFileds(){
        this.loginView.getInputPassword().setText("");
        this.loginView.getIInputLogin().setText("");
    }
 
}
