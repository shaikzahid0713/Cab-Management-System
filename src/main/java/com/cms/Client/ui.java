package com.cms.Client;

import com.cms.Dao.AdminImpl;
import com.cms.Model.Employee;
import com.cms.Model.EmployeeImpl;
import com.cms.Model.ManagerImpl;
import com.cms.Service.cabService;
import com.cms.Service.cabServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

public class ui {
    public static void main(String[] args) throws SQLException {
        cabService cs = new cabServiceImpl();

        System.out.println("=== MENU ===");
        System.out.println("1. Employee ");
        System.out.println("2. Admin ");
        System.out.println("3. Cab Driver ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your option: ");
        int number = scanner.nextInt(); scanner.nextLine();

        System.out.println("Enter your Id: ");
        Integer Id = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter your Password: ");
        String Password = scanner.nextLine();

        while(true) {
            switch(number) {
                case 1: {
                    Employee emp = new Employee();

                    if (Login.employeeLogin(Id, Password)) {
                        if (Login.ManagerStatus) {
                            try {
                                ManagerImpl manager = (ManagerImpl) new Employee();
                                manager.decide();
                            } catch (ClassCastException e) {
                                System.out.println("An error occurred during casting....");
                                printStackTrace();
                            }
                        }
                        else {
                            try {
                                EmployeeImpl employee = (EmployeeImpl) new Employee();
                                employee.operations();
                            } catch (ClassCastException e) {
                                System.out.println("An error occurred during casting....");
                                printStackTrace();
                            }
                        }
                    }
                    else System.out.println("Id or Password incorrect. Try again....");
                    break;
                }
                case 2: {
                    if (Id.equals(1000) && Password.equals("Admin")) {
                        AdminImpl admin = new AdminImpl();
                        admin.menu();
                    }
                    else System.out.println("Admin Id or Password Incorrect. Try again...");
                    break;
                }
                default:
                    System.out.println("Please enter a different option....");

            }
        }
    }
}
