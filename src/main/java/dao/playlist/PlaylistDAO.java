package dao.playlist;

import model.PlayList;

import java.sql.SQLException;
import java.util.List;

public class PlaylistDAO implements IPlaylistDAO{

    @Override
    public void insert(PlayList playList) throws SQLException {

    }

    @Override
    public PlayList select(String id) {
        return null;
    }

    @Override
    public List<PlayList> selectAll() {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlayList playList) throws SQLException {
        return false;
    }
}
