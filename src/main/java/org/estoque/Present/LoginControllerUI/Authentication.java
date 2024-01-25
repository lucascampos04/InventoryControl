/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Present.LoginControllerUI;

import javax.swing.JOptionPane;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Model.Enum.Status;
import org.estoque.Present.Login.LoginPresent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author campos
 */
public class Authentication {
    private final LoginPresent loginPresent;

    public Authentication() {
        this.loginPresent = new LoginPresent();
    }
    
    public boolean thenPermision(UsuarioDados usuario){
        try {
            permissao(usuario);
            return true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuário não tem permissão", 0);
        }
        return false;
    }
    
    private void permissao(UsuarioDados usuario){
        if (!Status.ADMIN.equals(usuario.getStatus())){
            throw new RuntimeException("Sem permissão para realzar essa ação");
        }
    }
    
    public UsuarioDados login(UsuarioDados dadosLogin){
        UsuarioDados usuario = loginPresent.BuscarPeloUsername(dadosLogin.getUsername());
        
        if (usuario == null){
            System.out.println("usuario não encontrado");
            return null;
        }
        
        if (validarPassword(usuario.getSenha(), dadosLogin.getSenha())){
            return usuario;
        }
        return null;
    }
    
    public boolean validarPassword(String passwordusuario, String passwordLogin){
        BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder1.matches(passwordLogin, passwordusuario);
    }
}
