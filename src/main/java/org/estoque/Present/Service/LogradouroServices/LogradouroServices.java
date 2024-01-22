package org.estoque.Present.Service.LogradouroServices;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Entity.Logradouro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogradouroServices {
    private final Conexao conexao;
    public LogradouroServices(Conexao conexao) {
        this.conexao = conexao;
    }

    // Listando logradouros
    public List<Logradouro> listallLogradouros() throws SQLException {
        String sql = "SELECT * FROM logradouro";
        List<Logradouro> logradouros = new ArrayList<>();
        try {
            Statement statement = conexao.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                logradouros.add(getLogradouro(resultSet));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return logradouros;
    }

    public Logradouro getLogradouro(ResultSet resultSet) throws  SQLException {
        Logradouro logradouro = new Logradouro();
        logradouro.setId(resultSet.getLong("id"));
        logradouro.setEndereco(resultSet.getString("endereco"));
        logradouro.setRua(resultSet.getString("rua"));
        logradouro.setEstado(resultSet.getString("estado"));
        logradouro.setCidade(resultSet.getString("cidade"));
        logradouro.setCep(resultSet.getString("cep"));

        return logradouro;
    }
}
