package com.cms.Dao;

import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Logger;

public class ManagerDaoImpl implements ManagerDao{

    private static final Logger log = Logger.getLogger("ManagerDaoImpl.class");
    Scanner scanner = new Scanner(System.in);


   @Override
   public void decide () throws Exception {

       log.info("Manager Decision On Rejecting or Approving the Employee Cab Request");
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
               log.info("Manager Approved the Employee Cab Request");
               PreparedStatement pt = connect.prepareStatement("update requests set BOOKSTATUS_ID = 2 where REQUESTS_ID = ?");
               pt.setInt(1, rs.getInt(1));
               pt.executeUpdate();
               System.out.println("Request Approved....");
           }
           else {
               log.info("Manager Rejected the Employee Cab Request");
               PreparedStatement pt = connect.prepareStatement("update requests set BOOKSTATUS_ID = 3 where REQUESTS_ID = ?");
               pt.setInt(1, rs.getInt(1));
               pt.executeUpdate();
               System.out.println("Request Rejected....");
           }
       }
   }
}
