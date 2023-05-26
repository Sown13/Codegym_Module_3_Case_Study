package controller;

import dao.playlist.PlaylistDAO;
import model.PlayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String choice = request.getParameter("choice");
        if (choice == null) {
            choice = "";
        }
        try {
            switch (choice) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditFrom(request, response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
                case "find":
                    findPlaylistByName(request, response);
                    break;
                case "sort":
                    sortPlayListByDate(request, response);
                    break;
                default:
                    getPlaylistByLabel(request,response);
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
        String label=request.getParameter("label");
        PlayList newPlayList = new PlayList(p_id, p_name, u_id,label);
        playlistDAO.insert(newPlayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String p_id = request.getParameter("p_id");
        String p_name = request.getParameter("P_name");
        String u_id = request.getParameter("u_id");
        String label=request.getParameter("label");
        PlayList book = new PlayList(p_id, p_name, u_id,label);
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


    private void getPlaylistByLabel(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,IOException,ServletException{
        List<PlayList> playLists1 = new ArrayList<>();
        List<PlayList> playLists2 = new ArrayList<>();
        List<PlayList> playLists3 = new ArrayList<>();
        List<PlayList> playLists4 = new ArrayList<>();
        List<PlayList> playLists5 = new ArrayList<>();
        String nhacTre=request.getParameter("nhac tre");
        String rock=request.getParameter("rock");
        String nhacVang=request.getParameter("nhac vang");
        String nhacCuChuoi=request.getParameter("nhac cu chuoi");
        String jar=request.getParameter("jar");
        playLists1 = playlistDAO.playListLabel(nhacTre);
        playLists2 = playlistDAO.playListLabel(rock);
        playLists3 = playlistDAO.playListLabel(nhacVang);
        playLists4 = playlistDAO.playListLabel(nhacCuChuoi);
        playLists5 = playlistDAO.playListLabel(jar);
        request.setAttribute("playLists1", playLists1);
        request.setAttribute("playLists2", playLists2);
        request.setAttribute("playLists3", playLists3);
        request.setAttribute("playLists4", playLists4);
        request.setAttribute("playLists5", playLists5);
        RequestDispatcher dispatcher=request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request,response);
    }




    private void findPlaylistByName (HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException{
        String name = request.getParameter("p_name");
        playlistDAO.findPlayListByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }
    private void sortPlayListByDate(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException{
        List<PlayList> playLists = playlistDAO.sortPlaylistByDate();
        request.setAttribute("playlist", playLists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }
}
