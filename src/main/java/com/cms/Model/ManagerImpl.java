package com.cms.Model;

import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagerImpl extends Employee{

    Employee manager = new Employee();
    Scanner scanner = new Scanner(System.in);

    public ManagerImpl(Integer employeeId, String empPassword, String employeeName, String employeeEmail, String employeeDepartment) {
        super(employeeId, empPassword, employeeName, employeeEmail, employeeDepartment);
        manager.setManager(true);
    }
    public void decide() throws SQLException {
        Connection connect = databaseConnect.getConnection();

        System.out.println("The List of Pending Requests.... ");
        System.out.println("Approve or Reject....");

        PreparedStatement ps = connect.prepareStatement("select * from requests where BOOKSTATUS_ID = 1");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Employee" + rs.getInt(2) + " requested a cab with Request Id " + rs.getInt(1));
            System.out.println("Make Decision....");
            boolean approve = scanner.nextBoolean();
            if (approve) {
                PreparedStatement pt = connect.prepareStatement("update requests set BOOKSTATUS_ID = 2 where REQUESTS_ID = ?");
                pt.setInt(1,rs.getInt(1));
                pt.executeUpdate();
                System.out.println("Request Approved....");
            }
            else {
                PreparedStatement pt = connect.prepareStatement("update requests set BOOKSTATUS_ID = 3 where REQUESTS_ID = ?");
                pt.setInt(1,rs.getInt(1));
                pt.executeUpdate();
                System.out.println("Request Rejected....");
            }
        }
    }
}
