package com.example.webnew.db.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
    private final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/newsstand";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "rootroot";
    private static ConnectionManager instance;

    private ConnectionManager() {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Unable to find db driver: " + e.getMessage());
            }
    }
    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
