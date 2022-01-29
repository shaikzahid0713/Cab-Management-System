/* Admin Requirements :-
   1. Methods :
            * Add Employee
            * Add Cab
            * Requests

*/

package com.cms.Dao;

import com.cms.Service.cabServiceImpl;
import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminImpl {

    Scanner scanner = new Scanner(System.in);

    public void menu() throws SQLException {

        System.out.println(" === MENU ===");
        System.out.println(" 1. Add Employee ");
        System.out.println(" 2. Add Cab ");
        System.out.println(" 3. Check Requests ");
        System.out.println("Enter Your Option: ");

        int number = scanner.nextInt(); scanner.nextLine();

        switch (number) {
            case 1:
                addEmployee(); break;
            case 2:
                addCab(); break;
            case 3:
                checkCabRequests(); break;
        }
    }

    void addEmployee() throws SQLException {
        Connection connect = databaseConnect.getConnection();
        PreparedStatement ps = connect.prepareStatement("insert into employee values (?,?,?,?,?,?)");

        System.out.println("Enter the Employee Id: ");
        int id = scanner.nextInt();
        System.out.println("Enter the Employee Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter the Employee Name:");
        String name = scanner.nextLine();
        System.out.println("Enter the Employee Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the Employee type: ");
        boolean isManager = scanner.nextBoolean();
        System.out.println("Enter the Employee Department: ");
        String department = scanner.nextLine();

        ps.setInt(1,id);
        ps.setString(2,password);
        ps.setString(3,name);
        ps.setString(4,email);
        if (isManager) ps.setInt(5,1);
        else ps.setInt(5,0);
        ps.setString(6,department);
        ps.execute();
    }

    void addCab() throws SQLException {
        System.out.println("Enter the Cab Number: ");
        Integer cabNumber = scanner.nextInt();

        Connection connect = databaseConnect.getConnection();
        PreparedStatement ps = connect.prepareStatement("insert into cabs values (?,?)");

        System.out.println("Enter the Cab Id: ");
        int cabId = scanner.nextInt();
        System.out.println("Enter the Cab Availability: ");
        boolean isAvailable = scanner.nextBoolean();

        ps.setInt(1,cabId);
        if (isAvailable) ps.setInt(2,1);
        else ps.setInt(2,0);
    }

    void checkCabRequests() throws SQLException {
        Connection connect = databaseConnect.getConnection();
        cabServiceImpl cs = new cabServiceImpl();
        Integer cabNumber;
    }

}
