package dao.like;

import model.Like;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeDAO implements ILikeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "25546912$oN";
    private static final String INSERT_LIKE_SQL = "INSERT INTO likes (u_id, s_id) VALUES (?,?);";
    private static final String SELECT_LIKE_BY_ID = "select u_id, s_id from likes where u_id = ?";
    private static final String SELECT_ALL_LIKE = "select * from likes";
    private static final String DELETE_LIKE_SQL = "delete from likes where u_id = ?";
    private static final String UPDATE_LIKE_SQL = "update likes set u_id=?, s_id=?";
    private Like like;

    public LikeDAO() {

    }

    protected Connection getConnection() {
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

    @Override
    public void insert(Like like) throws SQLException {
        System.out.println(INSERT_LIKE_SQL);
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(INSERT_LIKE_SQL)) {
            ps.setString(1, like.getU_id());
            ps.setString(2, like.getS_id());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Like select(String id) {
        Like like = null;
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_LIKE_BY_ID)) {
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s_id = rs.getString("s_id");
                like = new Like(id, s_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return like;
    }

    @Override
    public List<Like> selectAll() {
        List<Like> likes = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_ALL_LIKE)) {
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String u_id = rs.getString("u_id");
                String s_id = rs.getString("s_id");
                likes.add(new Like(u_id, s_id));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return likes;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDelete;
        try (Connection cn = getConnection();
        PreparedStatement ps = cn.prepareStatement(DELETE_LIKE_SQL)){
            ps.setString(1, id);
            rowDelete = ps.executeUpdate()>0;
        }
        return rowDelete;
    }

    @Override
    public boolean update(Like like) throws SQLException {
        boolean rowUpdate;
        try(Connection cn = getConnection();
        PreparedStatement ps = cn.prepareStatement(UPDATE_LIKE_SQL)){
            ps.setString(1, like.getU_id());
            ps.setString(2, like.getS_id());
            rowUpdate = ps.executeUpdate()>0;
        }
        return rowUpdate;
    }
    public boolean checkValueExists(String u_id, String s_id) {
        boolean check = false;
        if (u_id.equals(like.getS_id()) && s_id.equals(like.getS_id())){
            check = true;
        }
        return check;
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
}
