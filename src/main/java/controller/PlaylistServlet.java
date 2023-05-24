package controller;

import dao.playlist.PlaylistDAO;
import model.PlayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PlaylistServlet", value = "/playlists")
public class PlaylistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PlaylistDAO playlistDAO;

    public void init() {
        playlistDAO = new PlaylistDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditFrom(request, response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
                default:
                    list(request,response);
                    break;
            }
        } catch (SQLException e){
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    insert(request,response);
                    break;
                case "edit":
                    update(request, response);
                    break;
            }
        } catch (SQLException e){
            throw new ServletException(e);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<PlayList> playLists = playlistDAO.selectAll();
        request.setAttribute("playlists", playLists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        PlayList playList = playlistDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        request.setAttribute("playlist", playList);
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String p_id = request.getParameter("p_id");
        String p_name = request.getParameter("p_name");
        String u_id = request.getParameter("u_id");
        PlayList newPlayList = new PlayList(p_id, p_name, u_id);
        playlistDAO.insert(newPlayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String p_id = request.getParameter("p_id");
        String p_name = request.getParameter("P_name");
        String u_id = request.getParameter("u_id");
        PlayList book = new PlayList(p_id, p_name, u_id);
        playlistDAO.update(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        playlistDAO.delete(id);

        List<PlayList> playLists = playlistDAO.selectAll();
        request.setAttribute("playlist", playLists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }
}
