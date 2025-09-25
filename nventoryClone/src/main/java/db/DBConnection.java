// src/main/java/db/DBConnection.java
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // PostgreSQL-kku JDBC URL-a maathirukkom
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/inventory_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        try {
            // PostgreSQL-oda JDBC Driver class-a maathirukkom
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            throw new SQLException("JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
}