package com.fssa.restorationbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {

   
    public static Connection getConnection() {
        Connection con = null;

        String url, userName, passWord;

        // Check if the application is running in a CI/CD environment
        if (System.getenv("CI") != null) {
            // Use environment variables for database configuration in CI
            url = System.getenv("DATABASE_HOST");
            userName = System.getenv("DATABASE_USERNAME");
            passWord = System.getenv("DATABASE_PASSWORD");
        } else {
            // Load database configuration from local .env file
            Dotenv env = Dotenv.load();
            url = env.get("DATABASE_HOST");
            userName = env.get("DATABASE_USERNAME");
            passWord = env.get("DATABASE_PASSWORD");
        }

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

