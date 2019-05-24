package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/ksr",
                                "postgres", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
