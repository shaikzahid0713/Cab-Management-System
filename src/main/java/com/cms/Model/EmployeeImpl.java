package com.cms.Model;

import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeImpl extends Employee {

    Scanner scanner = new Scanner(System.in);

    public EmployeeImpl(Integer Id, String Password, String Name, String Email, String Department) {
            super(Id,Password,Name,Email,Department);
    }

    public void operations() throws SQLException {
        Connection connect = databaseConnect.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        System.out.println("Enter your Choice....");
        System.out.println("1.Request a Cab");
        System.out.println("2.Booking Status");

        int choice = scanner.nextInt();
        if(choice == 1) {
            ps = connect.prepareStatement("insert into requests (EMPLOYEE_ID,BOOKSTATUS_ID) values(?,?)");
            ps.setInt(1, this.getEmployeeId());
            ps.setInt(2,1);
            ps.execute();
            System.out.println("Cab Request placed....");
        }
        else {
            ps = connect.prepareStatement("select BOOKSTATUS_ID,BOOKING_ID from requests where EMPLOYEE_ID = ? order by REQUESTS_ID desc limit 1");
            ps.setInt(1, this.getEmployeeId());
            rs = ps.executeQuery();
            if (rs.next()) {
                int verdict = rs.getInt(1);
                switch (verdict) {
                    case 1:
                        System.out.println("Cab Requested....");
                        break;
                    case 2:
                        System.out.println("Request Approved....");
                        break;
                    case 3:
                        System.out.println("Request Rejected. Try Again....");
                        break;
                    case 4:
                        System.out.println("Request Pending....");
                }
            }
        }
    }

}
