/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rosal
 */
class DataSource {
    private static DataSource instance;
    private Connection connection;

    /**
     * Connection info
     */
    private static final String serverUrl = "jdbc:mysql://localhost:3306/fwrp";
    private static final String userString = "root";
    private static final String passwordString = "0505";
    private static final String driverString = "com.mysql.cj.jdbc.Driver";

    /**
     * Private constructor to initialize the connection
     */
    private DataSource() {
        try {
            Class.forName(driverString);
            this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    /**
     * Method to get the current connection.
     * 
     * @return the current database connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Method to get the singleton instance of the DataSource.
     * 
     * @return the singleton instance of DataSource.
     */
    public static DataSource getInstance() {
        if (instance == null) {
            synchronized (DataSource.class) {
                if (instance == null) {
                    instance = new DataSource();
                }
            }
        }
        return instance;
    }
}