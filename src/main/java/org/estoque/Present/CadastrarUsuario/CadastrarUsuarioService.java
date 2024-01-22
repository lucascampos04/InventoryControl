package org.estoque.Present.CadastrarUsuario;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Entity.Logradouro;
import org.estoque.Model.Entity.UsuarioDados;
import org.estoque.Model.Enum.Status;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CadastrarUsuarioService {
    private final Conexao conexao;
    public CadastrarUsuarioService(Conexao conexao) {
        this.conexao = conexao;
    }

    public String addUsuario(UsuarioDados usuarioDados){
        String sql = "INSERT INTO usuarioDados(username, senha, nome, email, telefone, status, logradouro_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        UsuarioDados usuario = searchUsername(usuarioDados.getUsername());

        if (usuario != null){
            return String.format("Erro : usuario já cadastrado");
        }
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            preencherValores(preparedStatement, usuarioDados);
            int result = preparedStatement.executeUpdate();
            return result == 1 ? "Usuario adicionado com sucesso" : "Não foi possivel adicionar o usuario";
        } catch (SQLException e) {
            return String.format("Erro : %s ", e.getMessage());
        }
    }

    private void preencherValores(PreparedStatement preparedStatement, UsuarioDados usuarioDados) throws SQLException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordBcrypt = bCryptPasswordEncoder.encode(usuarioDados.getSenha());

        preparedStatement.setString(1, usuarioDados.getUsername());
        preparedStatement.setString(2, passwordBcrypt);
        preparedStatement.setString(3, usuarioDados.getNome());
        preparedStatement.setString(4, usuarioDados.getEmail());
        preparedStatement.setString(5, usuarioDados.getTelefone());
        preparedStatement.setString(6, String.valueOf(usuarioDados.getStatus()));

        if (usuarioDados.getLogradouro() != null) {
            preparedStatement.setLong(7, usuarioDados.getLogradouro().getId());
        } else {
            preparedStatement.setNull(7, Types.BIGINT);
        }
    }


    public UsuarioDados searchUsername(String username){
        String sql = String.format("SELECT * FROM usuarioDados WHERE username = '%s'", username);

        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return getDadosUser(resultSet);
            }
        } catch (SQLException e) {
           e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
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
}
