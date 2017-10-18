package cn.lbw.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Bowei Liu on 2017/10/18.
 */
public class DBConnector {
    private static String dbUrl = "jdbc:mysql://localhost:3306/dblp";
    private static String user = "root";
    private static String password = "****";

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            System.out.println("数据库连接错误！"
                    + e.getMessage());
            return null;
        }
    }
}
