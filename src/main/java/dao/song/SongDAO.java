package dao.song;

import model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static others.Utils.*;

public class SongDAO implements ISongDAO {

    private static final String INSERT_song_SQL = "INSERT INTO song(song_name,author,song_url,label) VALUES(?,?,?,?)";
    private static final String SELECT_SONG_BY_ID = "SELECT s_id,song_name,author,upload_date,song_url,label,listening_frequency";
    private static final String SELECT_ALL_SONG = "SELECT*FORM song";
    private static final String DELETE_song_SQL = "DELETE FROM song WHERE id=?";
    private static final String Max_listen_song_SQL = "SELECT FROM* song WHERE listening_frequency=? ORDER BY listening_frequency DESC";
    private static final String SEARCH_SONG_BY_SONG_NAME_SQL = "SELECT * FROM song WHERE name_song like=%name_song% ";
    private static final String UPDATE_USERS_SQL = "UPDATE song s_name=?,author=?,song_url=?,label=?";

    public SongDAO() {
    }

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

    @Override
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
    public Song select(String songID) {
        Song song = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SONG_BY_ID);) {
            statement.setString(1, songID);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("song_name");
                String author = rs.getString("author");
                String song_url = rs.getString("song_url");
                String label = rs.getString("label");
                song = new Song(songID, name, author, song_url, label);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return song;
    }

    @Override
    public List<Song> selectAll() {
        List<Song> songs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SONG)) {
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String song_name = rs.getString("song_name");
                String author = rs.getString("author");
                String label = rs.getString("label");
                songs.add(new Song(song_name, author, label));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return songs;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean checkRow;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_song_SQL)) {
            statement.setString(1, id);
            checkRow = statement.executeUpdate() > 0;
        }
        return checkRow;
    }

    @Override
    public boolean update(Song song) throws SQLException {
        boolean checkSong;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, song.getSong_name());
            statement.setString(2, song.getAuthor());
            statement.setString(3, song.getSong_url());
            statement.setString(4, song.getLabel());
            checkSong = statement.executeUpdate() > 0;
        }
        return checkSong;
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

    public List<Song> searchSong(String name) throws SQLException {
        List<Song> songs = new ArrayList<>();
        Song song;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_SONG_BY_SONG_NAME_SQL)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name_song = rs.getString("song_name");
                String author = rs.getString("author");
                String song_url = rs.getString("song_url");
                String label = rs.getString("label");
                song = new Song(name_song, author, song_url, label);
                songs.add(song);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }

    //    public List<Song>ListMaxSong(int listening_frequency ) throws  SQLException{
//        List<Song>songs=new ArrayList<>();
//        Song song;
//        try (Connection connection=getConnection();
//        PreparedStatement statement=connection.prepareStatement(Max_listen_song_SQL)) {
//
//            System.out.println(statement);
//            System.out.println(statement);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String name_song = rs.getString("song_name");
//                String author = rs.getString("author");
//                String song_url = rs.getString("song_url");
//                String label = rs.getString("label");
//                song = new Song(name_song, author, song_url, label);
//                songs.add(song);
//            }
//
//        }
//        return songs;
//    }
    public List<Song> range() throws SQLException {
        List<Song> songList = new ArrayList<>();
        Song song;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(Max_listen_song_SQL)) {
            ResultSet resultSet = statement.executeQuery(Max_listen_song_SQL);
            while (resultSet.next()) {
                String name_song = resultSet.getString("name_song");
                String author = resultSet.getString("author");
                String song_url = resultSet.getString("song_url");
                String label = resultSet.getString("label");
                song = new Song(name_song, author, song_url, label);
                songList.add(song);

            }
            return songList;
        }
    }


    public void playing(String id) throws SQLException {
        String play_sql = "UPDATE songs SET playing = true WHERE s_id = ?;";
        String stop_sql = "UPDATE songs SET playing = false WHERE s_id = ?;";
        String status_sql = "SELECT status FROM songs WHERE s_id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(status_sql);
        try {
            statement.setString(1, id);
            boolean status = statement.execute();
            if (status) {
                statement = connection.prepareStatement(stop_sql);
                statement.execute();
            } else {
                statement = connection.prepareStatement(play_sql);
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            statement.close();
        }
    }

    public List<Song> findSongByName(String songName) throws SQLException{
        String sql = "SELECT*FROM songs WHERE song_name LIKE '%'?'%'";
        List<Song> songList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String songID = resultSet.getString("s_id");
                String song_name = resultSet.getString("song_name");
                String author = resultSet.getString("author");
                String song_url = resultSet.getString("song_url");
                String label = resultSet.getString("label");
                songList.add(new Song(songID,song_name, author, song_url, label));
            }
        }
        return songList;
    }

}
