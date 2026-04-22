// Topic: JDBC - Database Connectivity
// Demonstrates: JDBC Drivers, DriverManager, Connection, Statement, ResultSet,
//               PreparedStatement, Stored Procedures, Stored Functions
// NOTE: Replace DB_URL, USER, PASS with your actual MySQL credentials.
//       Ensure the JDBC driver (mysql-connector-j) is on the classpath.

import java.sql.*;

public class JDBCDemo {

    static final String DB_URL = "jdbc:mysql://localhost:3306/school_db";
    static final String USER   = "root";
    static final String PASS   = "password";

    // ---------- CREATE TABLE ----------
    static void createTable(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                id     INT AUTO_INCREMENT PRIMARY KEY,
                name   VARCHAR(100) NOT NULL,
                grade  VARCHAR(5),
                score  DOUBLE
            )
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'students' created/verified.");
        }
    }

    // ---------- INSERT with PreparedStatement ----------
    static void insertStudent(Connection conn, String name, String grade, double score)
            throws SQLException {
        String sql = "INSERT INTO students (name, grade, score) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, grade);
            ps.setDouble(3, score);
            int rows = ps.executeUpdate();
            System.out.println("Inserted " + rows + " row: " + name);
        }
    }

    // ---------- RETRIEVE DATA ----------
    static void retrieveAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students ORDER BY score DESC";
        try (Statement stmt = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(sql)) {
            System.out.println("\n--- All Students ---");
            System.out.printf("%-5s %-20s %-8s %-6s%n", "ID", "Name", "Grade", "Score");
            System.out.println("-".repeat(45));
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-8s %-6.1f%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("grade"),
                    rs.getDouble("score"));
            }
        }
    }

    // ---------- PARAMETERIZED QUERY ----------
    static void retrieveByGrade(Connection conn, String grade) throws SQLException {
        String sql = "SELECT name, score FROM students WHERE grade = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, grade);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- Grade " + grade + " Students ---");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " : " + rs.getDouble("score"));
            }
        }
    }

    // ---------- UPDATE ----------
    static void updateScore(Connection conn, int id, double newScore) throws SQLException {
        String sql = "UPDATE students SET score = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newScore);
            ps.setInt(2, id);
            System.out.println("Updated " + ps.executeUpdate() + " row(s).");
        }
    }

    // ---------- STORED PROCEDURE ----------
    // Assumes: CREATE PROCEDURE get_avg_score(OUT avg_score DOUBLE)
    //          BEGIN SELECT AVG(score) INTO avg_score FROM students; END
    static void callStoredProcedure(Connection conn) throws SQLException {
        String sql = "{CALL get_avg_score(?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.DOUBLE);
            cs.execute();
            double avg = cs.getDouble(1);
            System.out.println("\nStored Procedure - Avg Score: " + avg);
        } catch (SQLException e) {
            System.out.println("Stored procedure not found (create it first): " + e.getMessage());
        }
    }

    // ---------- STORED FUNCTION ----------
    // Assumes: CREATE FUNCTION get_grade(score DOUBLE) RETURNS VARCHAR(5)
    //          DETERMINISTIC BEGIN ... RETURN grade; END
    static void callStoredFunction(Connection conn) throws SQLException {
        String sql = "{ ? = CALL get_grade(?) }";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setDouble(2, 88.5);
            cs.execute();
            System.out.println("Stored Function - Grade for 88.5: " + cs.getString(1));
        } catch (SQLException e) {
            System.out.println("Stored function not found (create it first): " + e.getMessage());
        }
    }

    // ---------- TRANSACTION ----------
    static void transactionExample(Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        try {
            insertStudent(conn, "TransactionTest", "A", 99.0);
            // Simulate error: uncomment next line to test rollback
            // if (true) throw new SQLException("Simulated error!");
            conn.commit();
            System.out.println("Transaction committed.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transaction rolled back: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) {
        System.out.println("Attempting DB connection...");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to: " + conn.getMetaData().getDatabaseProductName());

            createTable(conn);
            insertStudent(conn, "Alice",   "A", 95.5);
            insertStudent(conn, "Bob",     "B", 82.0);
            insertStudent(conn, "Charlie", "A", 91.0);
            insertStudent(conn, "Diana",   "C", 67.5);
            retrieveAll(conn);
            retrieveByGrade(conn, "A");
            updateScore(conn, 2, 85.0);
            retrieveAll(conn);
            transactionExample(conn);
            callStoredProcedure(conn);
            callStoredFunction(conn);

        } catch (SQLException e) {
            System.out.println("DB Connection failed: " + e.getMessage());
            System.out.println("(Run with a live MySQL instance to test fully)");
        }
    }
}
