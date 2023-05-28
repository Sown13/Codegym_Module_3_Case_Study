package dao.user;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static others.Utils.*;

public class UserDAO implements IUserDAO {

    private static final String INSERT_USERS_SQL = "INSERT INTO users (user_name, password, full_name, address, email) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select user_name,full_name, address, email from users where u_id =?";
    private static final String SELECT_ALL_USERS = "select user_name,full_name, address, email from users";
    private static final String DELETE_USERS_SQL = "delete from users where u_id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set full_name = ?,address= ?, email =? where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullname());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getEmail());
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    @Override
    public User select(String id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String user_name = rs.getString("user_name");
                String fullname = rs.getString("fullname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                user = new User(user_name, fullname, address, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String user_name = rs.getString("user_name");
                String fullname = rs.getString("full_name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                users.add(new User(user_name, fullname, address, email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getU_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public User login(String user, String password) {
        String SELECT_USERS_BY_USER_NAME_AND_PASSWORD = "SELECT * FROM users WHERE user_name=? and password=?;";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USERS_BY_USER_NAME_AND_PASSWORD);
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new User(
                        resultSet.getString("u_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("last_play_song_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateLastPlay(String songID, String userID) {
        String sql = "UPDATE users SET last_play_song_id = ? WHERE u_id = ?;";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, songID);
            preparedStatement.setString(2, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getLastPlaySongID(String userID){
        String sql = "SELECT last_play_song_id FROM users WHERE u_id = ? ";
        String lastPlaySongID = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                lastPlaySongID = resultSet.getString("last_play_song_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastPlaySongID;
    }

}