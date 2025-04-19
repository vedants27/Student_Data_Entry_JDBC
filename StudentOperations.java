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
        public void addStudent(Student student) {
        if (!isConnected()) return;
        String sql = "INSERT INTO students (prn, name, branch, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, student.getPRN());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getBranch());
            stmt.setString(4, student.getBatch());
            stmt.setDouble(5, student.getCGPA());
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
        public void displayStudents() {
        if (!isConnected()) return;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student s = new Student(
                        rs.getLong("prn"),
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getString("batch"),
                        rs.getDouble("cgpa"));
                s.display();
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }
        public Student searchByPRN(long prn) {
        if (!isConnected()) return null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE prn = ?")) {
            stmt.setLong(1, prn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(prn, rs.getString("name"), rs.getString("branch"), rs.getString("batch"),
                        rs.getDouble("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
        public Student searchByName(String name) {
        if (!isConnected()) return null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getLong("prn"), name, rs.getString("branch"), rs.getString("batch"),
                        rs.getDouble("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
        public Student searchByPosition(int pos) {
        if (!isConnected()) return null;
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            if (rs.absolute(pos + 1)) {
                return new Student(rs.getLong("prn"), rs.getString("name"), rs.getString("branch"),
                        rs.getString("batch"), rs.getDouble("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }







