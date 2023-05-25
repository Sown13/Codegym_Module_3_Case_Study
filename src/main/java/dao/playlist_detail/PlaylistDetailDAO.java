package dao.playlist_detail;

import model.PlaylistDetail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class PlaylistDetailDAO implements IPlaylistDetailDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "25546912$oN";

    private static final String INSERT_PLAYLISTDETAIL_SQL = "INSERT INTO playlist_detail (s_id, p_id) VALUES (?, ?);";
    private static final String SELECT_PLAYLISTDETAIL_BY_ID = "select  from playlist_detail group by p_id";
    private static final String SELECT_ALL_PLAYLISTDETAIL = "select user_name,full_name, address, email from users";
    private static final String DELETE_PLAYLISTDETAIL_SQL = "delete from playlist_detail where pd_id = ?;";
    private static final String UPDATE_PLAYLISTDETAIL_SQL = "update playlist_detail set s_id = ?,p_id = ? where id = ?;";

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
    public void insert(PlaylistDetail playlistDetail) throws SQLException {

    }

    @Override
    public PlaylistDetail select(String id) {
        return null;
    }

    @Override
    public List<PlaylistDetail> selectAll() {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlaylistDetail playlistDetail) throws SQLException {
        return false;
    }
}
