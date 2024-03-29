package org.estoque.Model.Connection;

import org.sqlite.SQLiteException;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connection implements Conexao{ 
    public static void main(String[] args) {
       Conexao conexao = new connection();
        try {
            conexao.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private final String URL = "jdbc:sqlite:C:/Program Files/Estoque/estoqueDatabase.db";
    private Connection connection;
    @Override
    public Connection getConnection() throws SQLiteException {
        if (connection == null) {
            try {
                File directory = new File("C:/Program Files/Estoque/");
                if (!directory.exists()){
                    directory.mkdir();
                    System.out.println("Diretorio criado");
                }
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(URL);
                createLogradouro();
                createUsuarioDados();
                createTableLogs();
                createTableEstoque();
                System.out.println("Conexão estabelecida com sucesso");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void removerUSerDateNull(){
        try (Statement statement = connection.createStatement()) {
            String deleteSQL = "DELETE FROM usuarioDados WHERE id IS NULL";
            statement.executeUpdate(deleteSQL);
            System.out.println("Usuários com dataRegistro null removidos com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean tableExist(String table) throws SQLException {
        DatabaseMetaData databaseMetaData  = connection.getMetaData();
        try (ResultSet resultSet  = databaseMetaData.getTables(null, null, table, null)){
            return resultSet.next();
        }
    }

    private void createLogradouro() throws SQLException {
        if (!tableExist("logradouro")) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS logradouro (" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    endereco TEXT NOT NULL,\n" +
                    "    rua TEXT NOT NULL,\n" +
                    "    estado TEXT NOT NULL,\n" +
                    "    cidade TEXT NOT NULL,\n" +
                    "    cep TEXT NOT NULL\n" +
                    ");";

            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Tabela logradouro criada com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void createUsuarioDados() throws SQLException{
        if (!tableExist("usuarioDados")){
            String createTableSQL = "CREATE TABLE IF NOT EXISTS usuarioDados (" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    username TEXT NOT NULL UNIQUE,\n" +
                    "    senha TEXT NOT NULL,\n" +
                    "    nome TEXT NOT NULL,\n" +
                    "    email TEXT NOT NULL,\n" +
                    "    telefone TEXT NOT NULL,\n" +
                    "    status TEXT DEFAULT 'USER',\n" +
                    "    dataRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                    "    logradouro_id INTEGER,\n" +
                    "    FOREIGN KEY (logradouro_id) REFERENCES logradouro (id)\n" +
                    ");";

            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Tabela usuarioDados criada com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createTableLogs() throws SQLException {
        if (!tableExist("logs")){
            String createTableSQL = "CREATE TABLE IF NOT EXISTS logs ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "usuario_id INTEGER,"
                    + "status BOOLEAN NOT NULL,"
                    + "horarioLogin TIMESTAMP NOT NULL,"
                    + "FOREIGN KEY (usuario_id) REFERENCES usuarioDados(id)"
                    + ")";


            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Tabela logs criada com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void createTableEstoque() throws SQLException {
        if (!tableExist("estoque")){
            String createTableSQL = "CREATE TABLE IF NOT EXISTS estoque ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "usuario_id INTEGER,"
                    + "nome TEXT,"
                    + "categoria TEXT,"
                    + "quantidade INTEGER,"
                    + "fornecedor TEXT,"
                    + "valor DOUBLE,"
                    + "status TEXT,"
                    + "FOREIGN KEY (usuario_id) REFERENCES usuarioDados(id)"
                    + ")";


            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Tabela estoque criada com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
