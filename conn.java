// package com.ems.electricity_management_system;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class conn {
    // we will not going to run this class we will create an object of this class and we will use that object into another file.
    Connection c;
    String url = "jdbc:mysql://localhost:3306/hms";
    String username = "root";
    String password = "admin";
    Statement s;
    // Connection is the class comes under .sql.* package use to create connection between database and java file.
    // creating object of Connection class.
   public conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // forName is static method located in class.java class
            c = DriverManager.getConnection(url, username, password);
            // DriverManager is a class contains .getConnection(connection string)
            s = c.createStatement();
        } catch (Exception e) {
           System.out.println(e);
        }
   }


    
}
 
