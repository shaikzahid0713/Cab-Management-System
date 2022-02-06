/* Admin Requirements :-
   1. Methods :
            * Add Employee
            * Add Cab
*/

package com.cms.Dao;

import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AdminImpl {

    Scanner scanner = new Scanner(System.in);
    Connection connect;
    Statement st;
    PreparedStatement ps;

    {
        try {
            connect = databaseConnect.getConnection();
            st = connect.createStatement();
            st.executeUpdate("USE CMS");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void menu() throws Exception {

        System.out.println(" === MENU ===");
        System.out.println(" 1. Add Employee ");
        System.out.println(" 2. Add Cab ");
        System.out.println("Enter Your Option: ");

        int number = scanner.nextInt(); scanner.nextLine();

        while (true) {
            switch (number) {
                case 1:
                    addEmployee(); break;
                case 2:
                    addCab(); break;
            }
        }
    }

    void addEmployee() throws Exception {

        ps = connect.prepareStatement("insert into employee values (?,?,?,?,?,?)");

        System.out.println("Enter the Employee Id: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter the Employee Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter the Employee Name:");
        String name = scanner.nextLine();
        System.out.println("Enter the Employee Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the Employee type (Manager - 1 Or Not - 0): ");
        int isManager = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter the Employee Department: ");
        String department = scanner.nextLine();

        ps.setInt(1, id);
        ps.setString(2, password);
        ps.setString(3, name);
        ps.setString(4, email);
        ps.setInt(5, isManager);
        ps.setString(6, department);
        ps.execute();
        System.out.println("Employee Added Successfully....");
    }

    void addCab() throws Exception {

        ps = connect.prepareStatement("insert into cabs values (?,?)");

        System.out.println("Enter the Cab Id: ");
        int cabId = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter the Cab Availability (Available - 1 Or Not - 0): ");
        int isAvailable = scanner.nextInt();

        ps.setInt(1, cabId);
        ps.setInt(2, isAvailable);
        System.out.println("Cab Added Successfully....");
    }
}
