package com.jmpjva.appllication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author jazeel
 * @since 2026-11-19
 * What this code does: 
 * Establishes a connection to the employmentdb MySQL database.
 */

public class Database {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/employmentdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "2629";
    private Database() {
    }
    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
        } 
        catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            connection = DriverManager.getConnection( DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}
