package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/babyland";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hasi1304#";

    static {
        try {
            // Loading the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Note: "com.mysql.jdbc.Driver" is deprecated; use the newer version
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

   // to test connection
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectDB.getConnection();
            if (conn != null) {
                System.out.println("Successfully connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
