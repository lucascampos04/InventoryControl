package org.estoque;

import org.estoque.Model.Connection.Conexao;
import org.estoque.Model.Connection.connection;
import org.estoque.Model.Entity.Logradouro;
import org.estoque.Present.Service.UsuarioServices.UsuarioServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        try {
            Conexao conexao = new connection();
            UsuarioServices usuarioServices = new UsuarioServices(conexao);

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
