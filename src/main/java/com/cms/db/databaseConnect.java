<<<<<<< HEAD
package com.cms.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class databaseConnect {
    public static Connection getConnection () throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "root");

    }

=======
package com.cms.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class databaseConnect {
    public static Connection getConnection () throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "root");

    }

>>>>>>> 1accd209467e91cd737629e971c55c63bfc95081
=======
package com.cms.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class databaseConnect {
    public static Connection getConnection () throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "root");

    }

>>>>>>> 1accd209467e91cd737629e971c55c63bfc95081
}