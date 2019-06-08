package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

public class InsertionDB {
    private static InsertionDB instance;
    private static KeyFactory keyFactory;

    private InsertionDB() {
        keyFactory = KeyFactory.getInstance();
    }

    public static InsertionDB getInstance() {
        if (instance == null) {
            instance = new InsertionDB();
        }
        return instance;
    }

    public Boolean insertDB(Connection connection, List<List<String>> records) {
        Collections.shuffle(records);
        for (int i = 1; i < 11000; i++) {
            if (connection != null) {
                PreparedStatement ps = null;
                String sql = "INSERT INTO flights VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {
                    ps = connection.prepareStatement(sql);

                    ps.setInt(1, keyFactory.getNewKey());
                    ps.setInt(2, Integer.parseInt(records.get(i).get(0)));
                    ps.setInt(3, Integer.parseInt(records.get(i).get(1)));
                    ps.setInt(4, Integer.parseInt(records.get(i).get(2)));
                    ps.setInt(5, Integer.parseInt(records.get(i).get(3)));
                    ps.setInt(6, Integer.parseInt(records.get(i).get(4)));
                    ps.setString(7, records.get(i).get(5));
                    ps.setString(8, records.get(i).get(6));
                    ps.setString(9, records.get(i).get(7));
                    ps.setString(10, records.get(i).get(8));
                    if (!records.get(i).get(9).equals("")) ps.setInt(11, (int)Float.parseFloat(records.get(i).get(9)));
                        else ps.setNull(11, Types.INTEGER);
                    if (!records.get(i).get(10).equals("")) ps.setInt(12, (int)Float.parseFloat(records.get(i).get(10)));
                        else ps.setNull(12, Types.INTEGER);
                    if (!records.get(i).get(11).equals("")) ps.setInt(13, (int)Float.parseFloat(records.get(i).get(11)));
                        else ps.setNull(13, Types.INTEGER);
                    if (!records.get(i).get(12).equals("")) ps.setInt(14, (int)Float.parseFloat(records.get(i).get(12)));
                        else ps.setNull(14, Types.INTEGER);
                    if (!records.get(i).get(13).equals("")) ps.setInt(15, (int)Float.parseFloat(records.get(i).get(13)));
                        else ps.setNull(15, Types.INTEGER);
                    ps.setString(16, records.get(i).get(14));
                    if (!records.get(i).get(15).equals("")) ps.setInt(17, (int)Float.parseFloat(records.get(i).get(15)));
                        else ps.setNull(17, Types.INTEGER);
                    if (!records.get(i).get(16).equals("")) ps.setInt(18, (int)Float.parseFloat(records.get(i).get(16)));
                        else ps.setNull(18, Types.INTEGER);
                    if (!records.get(i).get(17).equals("")) ps.setInt(19, (int)Float.parseFloat(records.get(i).get(17)));
                        else ps.setNull(19, Types.INTEGER);
                    if (!records.get(i).get(18).equals("")) ps.setInt(20, (int)Float.parseFloat(records.get(i).get(18)));
                        else ps.setNull(20, Types.INTEGER);
                    if (!records.get(i).get(19).equals("")) ps.setInt(21, (int)Float.parseFloat(records.get(i).get(19)));
                        else ps.setNull(21, Types.INTEGER);
                    if (!records.get(i).get(20).equals("")) ps.setInt(22, (int)Float.parseFloat(records.get(i).get(20)));
                        else ps.setNull(22, Types.INTEGER);
                    if (!records.get(i).get(21).equals("")) ps.setInt(23, (int)Float.parseFloat(records.get(i).get(21)));
                        else ps.setNull(23, Types.INTEGER);

                    ps.executeUpdate();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
