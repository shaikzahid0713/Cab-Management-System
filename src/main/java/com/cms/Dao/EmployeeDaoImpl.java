package com.cms.Dao;

import com.cms.Model.Employee;
import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao {

    Employee employee = new Employee();

    Scanner scanner = new Scanner(System.in);
    private static final Logger log = Logger.getLogger("EmployeeImplDao.class");

    @Override
    public void operations () throws Exception {

        Connection connect = databaseConnect.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        System.out.println(" Enter your choice....");
        System.out.println("1. Request a cab");
        System.out.println("2. Booking status");

        int choice = scanner.nextInt();
        if (choice == 1) {
            log.info("cab request process");
            ps = connect.prepareStatement("insert into requests (employee_id,bookstatus_id) values(?,?)");
            ps.setInt(1, employee.getEmployeeId());
            ps.setInt(2, 1);
            ps.execute();
            System.out.println("cab request placed....");
        }
        else {
            log.info("cab status check");
            ps = connect.prepareStatement("select bookstatus_id,booking_id from requests where employee_id = ? order by requests_id desc limit 1");
            ps.setInt(1, employee.getEmployeeId());
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
