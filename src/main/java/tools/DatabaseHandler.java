package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    static final String jdbcURL = "jdbc:postgresql://localhost:9898/studs";

    public DatabaseHandler() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver is not found");
            e.printStackTrace();

        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, "s311765", "thq611");
        } catch (SQLException e) {
            System.out.println("Connection Failed : " + e.getMessage());
        }
        if (connection != null) {
            System.out.println("--- Connected to DB successfully ---");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
