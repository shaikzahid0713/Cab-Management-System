<<<<<<< HEAD
package com.cms.Client;

import com.cms.Dao.AdminImpl;
import com.cms.Dao.Login;
import com.cms.Service.EmployeeServiceImpl;
import com.cms.Service.ManagerServiceImpl;
import com.cms.Service.cabService;
import com.cms.Service.cabServiceImpl;

import java.util.Scanner;
import java.util.logging.Logger;


public class ui {

    private static final Logger log = Logger.getLogger("ui.class");

    public static void main (String[] args) throws Exception {

        log.info("Project Execution Started");
        cabService cs = new cabServiceImpl();

        System.out.println("=== MENU ===");
        System.out.println("1. Employee ");
        System.out.println("2. Admin ");
        System.out.println("3. Cab Driver ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your option: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your Id: ");
        Integer Id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your Password: ");
        String Password = scanner.nextLine();

        switch (number) {
            case 1: {
                if (Login.employeeLogin(Id, Password)) {
                    if (Login.eManagerStatus) {
                        try {
                            log.info("Logged in as Manager");
                            ManagerServiceImpl manager = new ManagerServiceImpl(Id, Password, Login.eName, Login.eEmail, Login.eDepartment);
                            manager.decide();
                            break;
                        } catch (Exception e) {
                            System.out.println("An error occurred during casting....");
                            e.printStackTrace();
                        }
                    }
                    else {
                        try {
                            log.info("Logged in as Employee");
                            EmployeeServiceImpl employee = new EmployeeServiceImpl(Id, Password, Login.eName, Login.eEmail, Login.eDepartment);
                            employee.operations();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else {
                    System.out.println("Id or Password incorrect. Try again....");
                    break;
                }
            }
            case 2: {
                if (Id.equals(1000) && Password.equals("Admin")) {
                    log.info("Logged in as Admin.");
                    AdminImpl admin = new AdminImpl();
                    admin.menu();
                }
                else {
                    System.out.println("Admin Id or Password Incorrect. Try again...");
                    break;
                }
                break;
            }
            default:
                System.out.println("Please enter a different option....");
                break;

        }
    }
}
=======
package com.cms.Client;

import com.cms.Dao.AdminImpl;
import com.cms.Dao.Login;
import com.cms.Service.EmployeeServiceImpl;
import com.cms.Service.ManagerServiceImpl;
import com.cms.Service.cabService;
import com.cms.Service.cabServiceImpl;

import java.util.Scanner;
import java.util.logging.Logger;


public class ui {

    private static final Logger log = Logger.getLogger("ui.class");

    public static void main(String[] args) throws Exception {

        log.info("Project Execution Started");
        cabService cs = new cabServiceImpl();

        System.out.println("=== MENU ===");
        System.out.println("1. Employee ");
        System.out.println("2. Admin ");
        System.out.println("3. Cab Driver ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your option: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your Id: ");
        Integer Id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your Password: ");
        String Password = scanner.nextLine();

        while (true) {
            switch (number) {
                case 1: {
                    if (Login.employeeLogin(Id, Password)) {
                        if (Login.eManagerStatus) {
                            try {
                                log.info("Logged in as Manager");
                                ManagerServiceImpl manager =  new ManagerServiceImpl(Id,Password,Login.eName,Login.eEmail,Login.eDepartment);
                                manager.decide();
                            } catch (ClassCastException e) {
                                System.out.println("An error occurred during casting....");
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                log.info("Logged in as Employee");
                                EmployeeServiceImpl employee =  new EmployeeServiceImpl(Id,Password,Login.eName,Login.eEmail,Login.eDepartment);
                                employee.operations();
                            } catch (ClassCastException e) {
                                System.out.println("An error occurred during casting....");
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else System.out.println("Id or Password incorrect. Try again....");
                    break;
                }
                case 2: {
                    if (Id.equals(1000) && Password.equals("Admin")) {
                        log.info("Logged in as Admin.");
                        AdminImpl admin = new AdminImpl();
                        admin.menu();
                    } else System.out.println("Admin Id or Password Incorrect. Try again...");
                    break;
                }
                default:
                    System.out.println("Please enter a different option....");
                    break;

            }
        }
    }
}
>>>>>>> 1accd209467e91cd737629e971c55c63bfc95081
