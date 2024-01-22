package org.estoque.Test;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Logradouro;
import org.estoque.Present.LogradouroServices.LogradouroServices.LogradouroServices;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class TestLogradouro
{
    public static void main( String[] args ) throws SQLException {
        try {
            Conexao conexao = new connection();
            LogradouroServices usuarioServices = new LogradouroServices(conexao);

            List<Logradouro> logradouros = usuarioServices.listallLogradouros();

            // Processar os logradouros (exibir, armazenar, etc.)
            for (Logradouro logradouro : logradouros) {
                System.out.println("ID: " + logradouro.getId());
                System.out.println("Endereço: " + logradouro.getEndereco());
                System.out.println("Rua: " + logradouro.getRua());
                System.out.println("Estado: " + logradouro.getEstado());
                System.out.println("Cidade: " + logradouro.getCidade());
                System.out.println("CEP: " + logradouro.getCep());
                System.out.println("----------------------");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
