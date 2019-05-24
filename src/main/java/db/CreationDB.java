package db;

import java.sql.*;

public class CreationDB {

    public static Boolean createDB(Connection connection) {
        if (connection != null) {
            PreparedStatement ps = null;
            checkAndDrop(connection);
            try {
                ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS flights(" +
                        "flight_id SERIAL NOT NULL PRIMARY KEY," +
                        "year integer," +
                        "quarter integer," +
                        "month integer," +
                        "day_of_month integer," +
                        "day_of_week integer," +
                        "origin_city_name varchar(225)," +
                        "origin_state_name varchar(225)," +
                        "dest_city_name varchar(225)," +
                        "dest_state_name varchar(225)," +
                        "dep_delay integer," +
                        "dep_delay15 integer," +
                        "arr_delay integer," +
                        "arr_delay15 integer," +
                        "cancelled integer," +
                        "cancellation_code varchar(1)," +
                        "diverted integer," +
                        "distance integer," +
                        "carrier_delay integer," +
                        "weather_delay integer," +
                        "nas_delay integer," +
                        "security_delay integer," +
                        "late_aircraft_delay integer)");
                ps.executeUpdate();
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private static void checkAndDrop(Connection connection) {
        if (connection != null) {
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement("DROP TABLE IF EXISTS flights");
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
