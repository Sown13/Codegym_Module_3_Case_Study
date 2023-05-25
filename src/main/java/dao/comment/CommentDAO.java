package dao.comment;

import model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements CommentI {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "25546912$oN";
    private static final String INSERT_comment_SQL = "INSET INTO comment(content,s_id,u_id)";
    private static final String SELECT_comment_BY_ID = "SELECT c_id,content,s_id,u_id From comment where c_id=?";
    private static final String SELECT_ALL_comment = "SELECT FROM * comment";
    private static final String DELETE_comment_SQL = "DELETE FROM comment WHERE c_id=?";
    private static final String UPDATE_comment_SQL = "UPDATE comment content=?,s_id=?,u_id=?";

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

    public CommentDAO() {
    }

    @Override
    public void insert(Comment comment) throws SQLException {
        System.out.println(INSERT_comment_SQL);
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_comment_SQL)) {
            statement.setString(1, comment.getContent());
            statement.setString(2, comment.getS_id());
            statement.setString(3, comment.getU_id());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);

        }

    }

    @Override
    public Comment select(String id) {
        Comment comment = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_comment_BY_ID)) {
            statement.setString(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String content = resultSet.getString("content");
                String S_id = resultSet.getString("S_id");
                String U_id = resultSet.getString("U_id");
                comment = new Comment(content, S_id, U_id);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return comment;
    }

    @Override
    public List<Comment> selectAll() {
        List<Comment> commentList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_comment)) {
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String content = rs.getString("content");
                String U_id = rs.getString("u_id");
                String s_id = rs.getString("s_id");
                commentList.add(new Comment(id, content, U_id, s_id));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return commentList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean checkComment;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_comment_SQL)) {
            statement.setString(1, id);
            checkComment = statement.executeUpdate() > 0;

        }
        return checkComment;
    }

    @Override
    public boolean update(Comment comment) throws SQLException {
        boolean checkComment;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_comment_SQL)) {
            statement.setString(1, comment.getContent());
            statement.setString(2, comment.getS_id());
            statement.setString(3, comment.getU_id());
            checkComment = statement.executeUpdate() > 0;

        }
        return checkComment;
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
