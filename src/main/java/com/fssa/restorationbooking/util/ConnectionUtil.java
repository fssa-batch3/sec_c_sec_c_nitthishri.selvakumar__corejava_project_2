package com.fssa.restorationbooking.util;

import java.sql.Connection;

import java.sql.DriverManager;



public class ConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;

		String url, userName, passWord;
                          
	
			url = System.getenv("DATABASE_HOST");
			userName = System.getenv("DATABASE_USERNAME");
			passWord = System.getenv("DATABASE_PASSWORD");
	

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}

	public static void main(String[] args) {
		// Test the database connection
		getConnection();
	}
}
