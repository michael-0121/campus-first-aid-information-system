package database;//package database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:sqlite:resources/first_aid.db";
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL);
//    }
//}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3344/student";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = DatabaseConnection.connect();
        DatabaseConnection.disconnect();
    }
}