package org.estoque.Model.Connection;

import org.sqlite.SQLiteException;

import java.sql.*;

public class connection implements Conexao{
    private final String URL = "jdbc:sqlite:C:/Users/campo/OneDrive/Documentos/Database/Estoque/estoqueDatabase.db";

    private Connection connection;

    @Override
    public Connection getConnection() throws SQLiteException {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(URL);
                System.out.println("Conexão estabelecida com sucesso");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private void createUsuarioDadosTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS logs ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "usuario_id INTEGER,"
                + "status BOOLEAN NOT NULL,"
                + "horarioLogin TIMESTAMP NOT NULL,"
                + "FOREIGN KEY (usuario_id) REFERENCES usuarioDados(id)"
                + ")";


        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Tabela usuarioDados criada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
