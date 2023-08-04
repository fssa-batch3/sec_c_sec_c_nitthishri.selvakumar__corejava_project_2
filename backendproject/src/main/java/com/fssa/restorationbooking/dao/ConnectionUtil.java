package com.fssa.restorationbooking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionUtil {
	 
    public static Connection getConnection() throws RuntimeException{
 
        Connection con = null;
        String url = "jdbc:mysql://localhost/blackwoodalley";
        String userName = "root";
        String passWord = "root";
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("connected");
        } catch (Exception e) {
            e.printStackTrace();        
            throw new RuntimeException("Unable to connect to the database");
        }       
        return con;
        
    }

    
    public static void main(String[] args) {
		Connection con=getConnection();
	}
}




