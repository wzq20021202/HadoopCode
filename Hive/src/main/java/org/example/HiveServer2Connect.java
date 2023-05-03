package org.example;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 * @author 30337
 */
public class HiveServer2Connect {

    public static void main(String[] args) throws SQLException {
        try {
            String driverName = "org.apache.hive.jdbc.HiveDriver";
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Connection conn = DriverManager.getConnection("jdbc:hive2://hadoop201:10000/movielens", "root", "11111");
        Statement stmt = conn.createStatement();
        String sql = "select * from u_data";
        System.out.println("Running: " + sql);
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println("userid:" + res.getString(1) + "\t"
                    + "movieid:" + res.getString(2) + "\t"
                    + "rating:" + res.getString(3) + "\t" + "unixtime" + res.getString(4));
        }

    }
}