package dao.playlist;

import dao.playlist_detail.PlaylistDetailDAO;
import model.PlayList;
import model.PlaylistDetail;
import model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static others.Utils.*;

public class PlaylistDAO implements IPlayListDAO {
    private static final String INSERT_PLAYLIST_SQL = "INSERT INTO playlist (p_name, u_id, label) VALUES (?, ?, ?);";
    private static final String SELECT_PLAYLIST_BY_ID = "select p_id, p_name, create_date, u_id from playlist where p_id = ?";
    private static final String SELECT_ALL_PLAYLIST = "select * from playlist";
    private static final String DELETE_PLAYLIST_SQL = "delete from playlist where p_id = ?;";
    private static final String UPDATE_PLAYLIST_SQL = "update playlist set p_name=?;";
    private static final String FIND_PLAYLIST_BY_NAME = "select * from playlist where p_name like '%'?'%';";
    private static final String SORT_PLAYLIST_BY_DATE = "select * from playlist order by create_date desc;";
    private static final String LIST_SONG = "select*from playlist_detail inner join playlist using(p_id) inner join songs using(s_id) where p_id = ?";

    public PlaylistDAO() {

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
    public void insert(PlayList playlist) throws SQLException {
        System.out.println(INSERT_PLAYLIST_SQL);
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(INSERT_PLAYLIST_SQL)) {
            ps.setString(1, playlist.getPlayListName());
            ps.setString(2, playlist.getU_id());
            ps.setString(3, playlist.getLabel());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public PlayList select(String id) {
        PlayList playList = null;
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_PLAYLIST_BY_ID)) {
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String p_name = rs.getString("p_name");
                String u_id = rs.getString("u_id");
                String label = rs.getString("label");
                playList = new PlayList(id, p_name, u_id, label);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return playList;
    }

    @Override
    public List<PlayList> selectAll() {
        List<PlayList> playLists = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_ALL_PLAYLIST)) {
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String p_id = rs.getString("p_id");
                String p_name = rs.getString("p_name");
                String u_id = rs.getString("u_id");
                String label = rs.getString("label");
                playLists.add(new PlayList(p_id, p_name, u_id, label));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return playLists;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDelete;
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(DELETE_PLAYLIST_SQL)) {
            rowDelete = ps.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean update(PlayList playlist) throws SQLException {
        boolean rowUpdate;
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(UPDATE_PLAYLIST_SQL)) {
            ps.setString(1, playlist.getP_id());
            ps.setString(2, playlist.getPlayListName());
            ps.setString(3, playlist.getU_id());
            rowUpdate = ps.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<PlayList> selectPlayListByLabel(String label) {
        List<PlayList> playLists = new ArrayList<>();
        String SELECT_FROM_PLAYLIST = "SELECT * FROM playlist WHERE label= ? LIMIT 4;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_FROM_PLAYLIST)) {
            statement.setString(1, label);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String p_id = resultSet.getString("p_id");
                String p_name = resultSet.getString("p_name");
                String u_id = resultSet.getString("u_id");
                String target_label = resultSet.getString("label");
                PlayList playList = new PlayList(p_id, p_name, u_id, target_label);
                playLists.add(playList);
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return playLists;

    }


    public List<PlayList> findPlayListByName(String name) {
        List<PlayList> playLists = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(FIND_PLAYLIST_BY_NAME)) {
            ps.setString(1, name);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String p_id = rs.getString("p_id");
                String u_id = rs.getString("u_id");
                String label = rs.getString("label");
                playLists.add(new PlayList(p_id, name, u_id, label));

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return playLists;
    }

    public PlayList findPlaylistById(String id) {
        PlayList playList = null;
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(FIND_PLAYLIST_BY_NAME)) {
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String p_id = rs.getString("p_id");
                String u_id = rs.getString("u_id");
                String label = rs.getString("label");
                playList = new PlayList(p_id, p_id, u_id, label);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return playList;
    }


    public List<PlayList> sortPlaylistByDate() {
        List<PlayList> playLists = new ArrayList<>();
        System.out.println(SORT_PLAYLIST_BY_DATE);
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SORT_PLAYLIST_BY_DATE)) {
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String p_id = rs.getString("p_id");
                String p_name = rs.getString("p_name");
                String u_id = rs.getString("u_id");
                String label = rs.getString("label");
                playLists.add(new PlayList(p_id, p_name, u_id, label));

            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return playLists;
    }

    public List<Song> getListSongByPlayListId(String playlistID) {
        List<Song> listSong = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(LIST_SONG)) {
            ps.setString(1, playlistID);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s_id = rs.getString("s_id");
                String s_name = rs.getString("song_name");
                String author = rs.getString("author");
                String url = rs.getString("url");
                String label = rs.getString("label");
                listSong.add(new Song(s_id, s_name, author, url, label));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listSong;
    }

    public List<PlayList> selectPlayListByUID(String userID) {
        String SELECT_PLAYLIST_BY_UID = "select * from playlist where u_id = ?;";
        List<PlayList> playLists = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_PLAYLIST_BY_UID)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String playlistID = rs.getString("p_id");
                String playlistName = rs.getString("p_name");
                String label = rs.getString("label");
                Date createDate = rs.getDate("create_date");
                playLists.add(new PlayList(playlistID, playlistName, userID, label,createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        playLists.sort(Comparator.comparing(PlayList::getCreateDate).reversed());
        return playLists;
    }

    public List<PlayList> selectPlayListFromOtherUser(String userID) {
        String SELECT_PLAYLIST_FROM_ORTHER = "select * from playlist where u_id != ?;";
        List<PlayList> playLists = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_PLAYLIST_FROM_ORTHER)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String playlistID = rs.getString("p_id");
                String playlistName = rs.getString("p_name");
                String ortherUserID = rs.getString("u_id");
                String label = rs.getString("label");
                playLists.add(new PlayList(playlistID, playlistName, ortherUserID, label));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println(playLists.toString());
        return playLists;
    }

    public PlayList SelectLastestAddedPlaylist() {
        String queryString = "SELECT * FROM playlist ORDER BY create_date DESC LIMIT 1;";
        PlayList playList = null;
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(queryString)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String playlistID = rs.getString("p_id");
                String playlistName = rs.getString("p_name");
                String ortherUserID = rs.getString("u_id");
                String label = rs.getString("label");
                playList = new PlayList(playlistID, playlistName, ortherUserID, label);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return playList;
    }

    public void addSongIntoPlaylist(String songID, String playlistID) {
        PlaylistDetail playlistDetail = new PlaylistDetail(songID, playlistID);
        PlaylistDetailDAO playlistDetailDAO = new PlaylistDetailDAO();
        try {
            playlistDetailDAO.insert(playlistDetail);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void removeSongFromPlaylist(String songID, String playlistID){
        PlaylistDetail playlistDetail = new PlaylistDetail(songID, playlistID);
        PlaylistDetailDAO playlistDetailDAO = new PlaylistDetailDAO();

        try {
            playlistDetailDAO.removeSongFromPlaylist(playlistDetail);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public List<Song> getAllSong() {
        List<Song> songs = new ArrayList<>();
        String SELECT_ALL_SONG = "SELECT * FROM songs;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SONG)) {
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String songID = rs.getString("s_id");
                String song_name = rs.getString("song_name");
                String author = rs.getString("author");
                String song_url = rs.getString("url");
                String label = rs.getString("label");
                songs.add(new Song(songID, song_name, author, song_url, label));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return songs;
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
