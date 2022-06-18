package com.mdt.mazedatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Database connection class from CAB302, Practical 06
 * Ref: https://github.com/qut-cab302/prac06/blob/master/solution/dataExercise/DBConnection.java
 */
public class DBConnection {
    private static Connection instance = null;

    /**
     * Initialise the database connection
     */
    private DBConnection() {
        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream("db.props");
            props.load(in);
            in.close();

            // Specify the data source, username and password
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            String schema = props.getProperty("jdbc.schema");

            // Get a connection
            instance = DriverManager.getConnection(url + "/" + schema, username, password);
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Provides global access to the singleton instance of the database connection
     * @return a handle to the singleton instance of the database connection
     */
    public static Connection getInstance() {
        if (instance == null) {
            new DBConnection();
        }
        return instance;
    }
}