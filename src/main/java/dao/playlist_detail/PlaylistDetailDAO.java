package dao.playlist_detail;

import model.PlaylistDetail;

import java.sql.*;
import java.util.List;
import static others.Utils.*;

public class PlaylistDetailDAO implements IPlaylistDetailDAO {
    private static final String INSERT_PLAYLISTDETAIL_SQL = "INSERT INTO playlist_detail (s_id, p_id) VALUES (?, ?);";
    private static final String SELECT_PLAYLISTDETAIL_BY_ID = "select  from playlist_detail group by p_id";
    private static final String SELECT_ALL_PLAYLISTDETAIL = "select user_name,full_name, address, email from users";
    private static final String DELETE_PLAYLISTDETAIL_SQL = "delete from playlist_detail where pd_id = ?;";
    private static final String UPDATE_PLAYLISTDETAIL_SQL = "update playlist_detail set s_id = ?,p_id = ? where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
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
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLISTDETAIL_SQL)) {
            preparedStatement.setString(1, playlistDetail.getSongId());
            preparedStatement.setString(2, playlistDetail.getPd_id());
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public PlaylistDetail select(String id) {
        PlaylistDetail playlistDetail = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PLAYLISTDETAIL_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String songID = rs.getString("s_id");
                String playlistID = rs.getString("p_id");
                playlistDetail = new PlaylistDetail(songID, playlistID);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return playlistDetail;
    }

    @Override
    public List<PlaylistDetail> selectAll() {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PLAYLISTDETAIL_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(PlaylistDetail playlistDetail) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PLAYLISTDETAIL_SQL)) {
            statement.setString(1, playlistDetail.getSongId());
            statement.setString(2, playlistDetail.getPlaylistId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
