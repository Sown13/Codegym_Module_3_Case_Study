package dao.song;

import model.Song;

import java.sql.SQLException;
import java.util.List;

public class SongDAO implements ISongDAO{
    @Override
    public void insert(Song song) throws SQLException {

    }

    @Override
    public Song select(String id) {
        return null;
    }

    @Override
    public List<Song> selectAll() {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Song song) throws SQLException {
        return false;
    }
}
