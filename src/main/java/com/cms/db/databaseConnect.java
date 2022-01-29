package com.cms.db;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class databaseConnect {
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","root");
        return connection;
    }
}
