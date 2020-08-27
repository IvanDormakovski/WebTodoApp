package main.java.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/todoapp";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "10Lin20PasX7q";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
            return connection;
    }

    public static LocalDate getUtilDate(Date SQLDate) {
        return SQLDate.toLocalDate();
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable throwable : ex) {
            ex.printStackTrace(System.err);
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("Error Code: " + ex.getErrorCode());
            System.err.println("Message: " + ex.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}
