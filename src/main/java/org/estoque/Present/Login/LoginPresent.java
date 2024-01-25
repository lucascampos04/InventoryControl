/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.estoque.Present.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Logradouro;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Model.Enum.Status;

/**
 *
 * @author campos
 */
public class LoginPresent {
    private final Conexao conexao;
    
    public LoginPresent() {
        this.conexao = new connection();
    }
    
    private UsuarioDados getDadosUser(ResultSet resultSet) throws SQLException {
        UsuarioDados usuarioDados = new UsuarioDados();

        usuarioDados.setId(resultSet.getLong("id"));
        usuarioDados.setUsername(resultSet.getString("username"));
        usuarioDados.setSenha(resultSet.getString("senha"));
        usuarioDados.setNome(resultSet.getString("nome"));
        usuarioDados.setEmail(resultSet.getString("email"));
        usuarioDados.setTelefone(resultSet.getString("telefone"));
        usuarioDados.setStatus(Status.valueOf(resultSet.getString("status")));

        int logradouroId = resultSet.getInt("logradouro_id");
        if (!resultSet.wasNull()) {
            Logradouro logradouro = new Logradouro();
            logradouro.setId((long) logradouroId);
            usuarioDados.setLogradouro(logradouro);
        }

        return usuarioDados;
    }
    
    public UsuarioDados BuscarPeloID(Long id) {
        String sql = "SELECT * FROM usuarioDados WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getDadosUser(resultSet);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    // Buscando pelo usuario
    public UsuarioDados BuscarPeloUsername(String usuario){
        String sql = String.format("SELECT * FROM usuarioDados WHERE username = '%s'", usuario);
        try {
                PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return getDadosUser(resultSet);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
