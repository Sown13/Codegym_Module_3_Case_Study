package dao.playlist;

import model.PlayList;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public class PlaylistDAO implements IPlayListDAO{

    @Override
    public void insert(PlayList playList) throws SQLException {

=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO implements IPlaylistDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "25546912$oN";
    private static final String INSERT_PLAYLIST_SQL = "INSERT INTO playlist (p_id, p_name, u_id) VALUES (?, ?, ?);";
    private static final String SELECT_PLAYLIST_BY_ID = "select p_id, p_name, create_date, u_id from playlist where p_id = ?";
    private static final String SELECT_ALL_PLAYLIST = "select * from playlist";
    private static final String DELETE_PLAYLIST_SQL = "delete from playlist where p_id = ?;";
    private static final String UPDATE_PLAYLIST_SQL = "update playlist set p_name=?,";
    public PlaylistDAO(){

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
    public void insert(PlayList playlist) throws SQLException {
        System.out.println(INSERT_PLAYLIST_SQL);
        try(Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(INSERT_PLAYLIST_SQL)) {
            ps.setString(1, playlist.getP_id());
            ps.setString(2, playlist.getP_name());
            ps.setString(3, playlist.getU_id());
            System.out.println(ps);
            ps.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }

    @Override
    public PlayList select(String id) {
<<<<<<< HEAD
        return null;
=======
        PlayList playList = null;
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_PLAYLIST_BY_ID)){
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String p_name = rs.getString("p_name");
                String u_id = rs.getString("u_id");
                playList = new PlayList(id, p_name, u_id);
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return playList;
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }

    @Override
    public List<PlayList> selectAll() {
<<<<<<< HEAD
        return null;
=======
        List<PlayList> playLists = new ArrayList<>();
        try (Connection cn = getConnection();
        PreparedStatement ps = cn.prepareStatement(SELECT_ALL_PLAYLIST)){
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String p_id = rs.getString("p_id");
                String p_name = rs.getString("p_name");
                String u_id = rs.getString("u_id");
                playLists.add(new PlayList(p_id,p_name,u_id));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return playLists;
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }

    @Override
    public boolean delete(String id) throws SQLException {
<<<<<<< HEAD
        return false;
    }

    @Override
    public boolean update(PlayList playList) throws SQLException {
        return false;
=======
       boolean rowDelete;
       try (Connection cn = getConnection();
       PreparedStatement ps = cn.prepareStatement(DELETE_PLAYLIST_SQL)){
           rowDelete = ps.executeUpdate() > 0;
       }
       return rowDelete;
    }

    @Override
    public boolean update(PlayList playlist) throws SQLException {
       boolean rowUpdate;
       try (Connection cn = getConnection();
       PreparedStatement ps = cn.prepareStatement(UPDATE_PLAYLIST_SQL)){
           ps.setString(1, playlist.getP_id());
           ps.setString(2, playlist.getP_name());
           ps.setString(3, playlist.getU_id());
           rowUpdate = ps.executeUpdate() > 0;
       }
       return rowUpdate;
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
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }
}
