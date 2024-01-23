package org.estoque.Test;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Logradouro;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Present.ListUsuarios.ListUsuarios;
import org.estoque.Present.LogradouroServices.LogradouroServices.LogradouroServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuariosTesteSelect {
    public static void main(String[] args) throws SQLException {
        try {
            Conexao conexao = new connection();
            ListUsuarios listUsuarios = new ListUsuarios(conexao);

            List<UsuarioDados> usuarios = listUsuarios.listAllUsuarios();

            for (UsuarioDados usuarioDados : usuarios) {
                System.out.println("ID: " + usuarioDados.getId());
                System.out.println("Username: " + usuarioDados.getUsername());
                System.out.println("Senha: " + usuarioDados.getSenha());
                System.out.println("Nome: " + usuarioDados.getNome());
                System.out.println("Email: " + usuarioDados.getEmail());
                System.out.println("Telefone: " + usuarioDados.getTelefone());
                System.out.println("Status: " + usuarioDados.getStatus());
                System.out.println("Data e hora do registro: " + usuarioDados.getDataRegistro());
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
