package com.cms.Client;

import com.cms.Model.Employee;
import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Login {
    static Connection connect;
    {
        try {
            connect = databaseConnect.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Employee> employee = new ArrayList<>();
    static ArrayList<Employee> manager = new ArrayList<>();

    public static boolean ManagerStatus;

    public static Boolean employeeLogin(Integer Id, String Password) throws SQLException,NullPointerException {
        PreparedStatement ps = connect.prepareStatement("select * from employee where id = ? and password = ? and manager = ?");

        boolean credentials = false;

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           if (rs.getInt(1) == Id && Objects.equals(rs.getString(2), Password)) credentials = true;

           String eName = rs.getString(3);
           String eEmail = rs.getString(4);
           String eDepartment = rs.getString(6);

           Employee emp = new Employee(Id,Password,eName,eEmail,eDepartment);

           if (credentials) {
               if(rs.getInt(5) == 1) {
                   ManagerStatus = true;
                   emp.setManager(true);
                   manager.add(emp);
               }
               if (rs.getInt(5) == 0) ManagerStatus = false;
               employee.add(emp);
               break;
           }
        }
        return credentials;
    }
}
