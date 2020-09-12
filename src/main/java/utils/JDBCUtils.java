package main.java.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;

public class JDBCUtils {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/web_todo_app";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "10Lin20PasX7q";

    public static Connection getConnection(){
        Connection connection = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Date getSQLDate(LocalDate date) {
        return Date.valueOf(date);
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
