package com.cms.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class databaseConnect {
    public static Connection getConnection () throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "root");

    }

}