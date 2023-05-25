package others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    public static String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_m3?useSSL=false";
    public static String JDBC_USER = "root";
    public static String JDBC_PASSWORD = "25546912$oN";
    public static  Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
