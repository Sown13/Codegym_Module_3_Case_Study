package dao.user;

import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO{
    @Override
    public void insert(User user) throws SQLException {

    }

    @Override
    public User select(String id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }
}
