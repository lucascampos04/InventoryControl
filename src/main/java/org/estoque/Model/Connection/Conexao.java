package org.estoque.Model.Connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface Conexao{
    public Connection getConnection() throws SQLException;
}
