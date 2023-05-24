package dao.song;

import model.Song;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public class SongDAO implements ISongDAO{
    @Override
    public void insert(Song song) throws SQLException {
=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO implements ISongDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "25546912$oN";
    private static final String INSERT_song_SQL = "INSERT INTO song(song_name,author,song_url,label) VALUES(?,?,?,?)";
    private static final String SELECT_song_BY_ID = "SELECT s_id,song_name,author,upload_date,song_url,label,listening_frequency";
    private static final String SELECT_ALL_song = "SELECT FORM*song";
    private static final String DELETE_song_SQL = "DELETE FROM song WHERE id=?";
    private static final String UPDATE_USERS_SQL = "UPDATE song s_name=?,author=?,song_url=?,label=?";

    public SongDAO() {
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
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243

    }

    @Override
<<<<<<< HEAD
    public Song select(String id) {
        return null;
=======
    public void insert(Song song) throws SQLException {
        System.out.println(INSERT_song_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_song_SQL)) {
            preparedStatement.setString(1, song.getSong_name());
            preparedStatement.setString(2, song.getAuthor());
            preparedStatement.setString(3, song.getSong_url());
            preparedStatement.setString(4, song.getLabel());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);

        }


    }


    @Override
    public Song select(String id) {
        Song song = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_song_BY_ID);) {
            statement.setString(1, id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("song_name");
                String author = rs.getString("author");
                String song_url = rs.getString("song_url");
                String label = rs.getString("label");
                song = new Song(name, author, song_url, label);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return song;
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }

    @Override
    public List<Song> selectAll() {
<<<<<<< HEAD
        return null;
=======
        List<Song> songs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_song)) {
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("s_id");
                String song_name = rs.getString("song_name");
                String author = rs.getString("author");
                Timestamp upload_date = rs.getTimestamp("upload_date");
                int listening_frequency = rs.getInt("listening_frequency");
                String label = rs.getString("label");
                songs.add(new Song(id, song_name, author, upload_date, listening_frequency, listening_frequency, label));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return songs;
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }

    @Override
    public boolean delete(String id) throws SQLException {
<<<<<<< HEAD
        return false;
=======
        boolean checkRow;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_song_SQL)) {
            statement.setString(1, id);
            checkRow = statement.executeUpdate() > 0;
        }
        return checkRow;
>>>>>>> 6b362124dd44226daed17b1661ce761585d8c243
    }

    @Override
    public boolean update(Song song) throws SQLException {
<<<<<<< HEAD
        return false;
=======
      boolean checkSong;
      try(Connection connection=getConnection();
      PreparedStatement statement=connection.prepareStatement(UPDATE_USERS_SQL )) {
          statement.setString(1,song.getSong_name());
          statement.setString(2,song.getAuthor());
          statement.setString(3,song.getSong_url());
          statement.setString(4,song.getLabel());
          checkSong=statement.executeUpdate()>0;
      }return checkSong;
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
