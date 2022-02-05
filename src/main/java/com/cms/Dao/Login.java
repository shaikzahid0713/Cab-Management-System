<<<<<<< HEAD
package com.cms.Dao;

import com.cms.Model.Employee;
import com.cms.db.databaseConnect;

import java.sql.*;
import java.util.HashSet;
import java.util.Objects;

public class Login {
    static Connection connect;


    static {
        try {
            connect = databaseConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static HashSet<Employee> employee = new HashSet<>();
    static HashSet<Employee> manager = new HashSet<>();

    public static Boolean eManagerStatus = false;
    public static String eName;
    public static String eEmail;
    public static String eDepartment;


    public static Boolean employeeLogin (Integer Id, String Password) throws  NullPointerException, SQLException {
        Statement st = connect.createStatement();
        st.executeUpdate("use cms");


        PreparedStatement ps = connect.prepareStatement("select * from employee where emp_id = ? and emp_password = ?");
        ps.setInt(1,Id);
        ps.setString(2,Password);

        boolean credentials = false;

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) == Id && Objects.equals(rs.getString(2), Password)) credentials = true;

            eName = rs.getString(3);
            eEmail = rs.getString(4);

            eDepartment = rs.getString(6);

            Employee emp = new Employee(Id, Password, eName, eEmail, eDepartment);

            if (credentials) {
                if (rs.getInt(5) == 1) {
                    eManagerStatus = true;
                    emp.setManager(true);
                    manager.add(emp);
                }
                if (rs.getInt(5) == 0) eManagerStatus = false;
                employee.add(emp);
                break;
            }
        }
        return credentials;
    }
}
=======
package com.cms.Dao;

import com.cms.Model.Employee;
import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;

public class Login {
    static Connection connect;

    static {
        try {
            connect = databaseConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static HashSet<Employee> employee = new HashSet<>();
    static HashSet<Employee> manager = new HashSet<>();

    public static Boolean eManagerStatus;
    public static String eName;
    public static String eEmail;
    public static String eDepartment;


    public static Boolean employeeLogin (Integer Id, String Password) throws SQLException, NullPointerException {
        PreparedStatement ps = connect.prepareStatement("select * from employee where id = ? and password = ? and manager = ?");

        boolean credentials = false;

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) == Id && Objects.equals(rs.getString(2), Password)) credentials = true;

            eName = rs.getString(3);
            eEmail = rs.getString(4);
            eDepartment = rs.getString(6);

            Employee emp = new Employee(Id, Password, eName, eEmail, eDepartment);

            if (credentials) {
                if (rs.getInt(5) == 1) {
                    eManagerStatus = true;
                    emp.setManager(true);
                    manager.add(emp);
                }
                if (rs.getInt(5) == 0) eManagerStatus = false;
                employee.add(emp);
                break;
            }
        }
        return credentials;
    }
}
>>>>>>> 1accd209467e91cd737629e971c55c63bfc95081
