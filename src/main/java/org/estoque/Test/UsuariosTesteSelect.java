package org.estoque.Test;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.UsuarioDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosTesteSelect {
    public static void main(String[] args) throws SQLException {
        Conexao conexao = new connection();

        ResultSet resultSet;
        try (Connection connection = conexao.getConnection()) {
            String sql = "SELECT * FROM usuarioDados";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    UsuarioDados usuario = criarUsuarioDados(resultSet);

                    exibirDadosUsuario(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static UsuarioDados criarUsuarioDados(ResultSet resultSet) throws SQLException {
        UsuarioDados usuario = new UsuarioDados();

        usuario.setId(resultSet.getLong("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setSenha(resultSet.getString("senha"));
        usuario.setNome(resultSet.getString("nome"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setTelefone(resultSet.getString("telefone"));

        return usuario;
    }

    private static void exibirDadosUsuario(UsuarioDados usuario) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Username: " + usuario.getUsername());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Telefone: " + usuario.getTelefone());
        System.out.println("----------------------");
    }
}
