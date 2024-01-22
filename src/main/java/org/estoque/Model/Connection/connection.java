package org.estoque.Model.Connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection implements Conexao{
    private final String USUARIO = "root";
    private final String PASSWORD = "senha12345";
    private final String URL = "jdbc:mysql://localhost:3306/estoque";
    private Connection connection;


    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexão estabelecidada com sucesso");
        }
        return connection;
    }
}
