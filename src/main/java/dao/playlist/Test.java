package dao.playlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static Connection synthetic(){
         String jdbcURL = "jdbc:mysql://localhost:3306/case_study_m3?useSSL=false";
         String jdbcUsername = "root";
         String jdbcPassword = "25546912$oN";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }




}
