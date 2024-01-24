package org.estoque.Present.ListUsuarios;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Model.Enum.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ListUsuarios {
    private final Conexao conexao;
    public ListUsuarios(Conexao conexao) {
        this.conexao = conexao;
    }

    // Listando usuarios
    public List<UsuarioDados> listAllUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuarioDados";
        List<UsuarioDados> usuarioDados = new ArrayList<>();
        try {
            Statement statement = conexao.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                usuarioDados.add(getUsuario(resultSet));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return usuarioDados;
    }


    public UsuarioDados getUsuario(ResultSet resultSet) throws SQLException {
        UsuarioDados usuario = new UsuarioDados();

        usuario.setId(resultSet.getLong("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setSenha(resultSet.getString("senha"));
        usuario.setNome(resultSet.getString("nome"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setTelefone(resultSet.getString("telefone"));

        try {
            usuario.setStatus(Status.valueOf(resultSet.getString("status").toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.err.println("Valor inválido para Status: " + resultSet.getString("status"));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataRegister = resultSet.getString("dataRegistro");

        if (dataRegister != null && !dataRegister.isEmpty()) {
            try {
                LocalDateTime dataRegistroFormatada = LocalDateTime.parse(dataRegister, formatter);
                usuario.setDataRegistro(dataRegistroFormatada);
            } catch (DateTimeParseException e) {
                System.err.println("Erro ao fazer parsing da data: " + dataRegister);
            }
        }

        return usuario;
    }




}
