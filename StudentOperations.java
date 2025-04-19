//StudentOperation.java
import java.sql.*;

public class StudentOperations {
    private Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "ved@2775";

        public StudentOperations() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Database connection established.");
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
        private boolean isConnected() {
        if (conn == null) {
            System.out.println("Database connection not available.");
            return false;
        }
        return true;
    }


