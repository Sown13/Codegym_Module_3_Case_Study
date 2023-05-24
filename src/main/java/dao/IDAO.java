package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    public void insert(T t) throws SQLException;

    public T select(String id);

    public List<T> selectAll();

    public boolean delete(String id) throws SQLException;

    public boolean update(T t) throws SQLException;
}
