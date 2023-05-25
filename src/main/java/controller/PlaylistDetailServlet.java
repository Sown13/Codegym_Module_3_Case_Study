package controller;

import dao.playlist_detail.PlaylistDetailDAO;
import model.PlaylistDetail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PlaylistDetailServlet", value = "/playlist_detail")
public class PlaylistDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PlaylistDetailDAO playlistDetailDAO;

    public void init() {
        this.playlistDetailDAO = new PlaylistDetailDAO();
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
                    showFormIsert(request,response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
                case "edit":
                    showFormUpdate(request,response);
                    break;

                default:
                    getListDetail(request, response);

            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        if (choice == null) {
            choice = "";
        }
        try {
            switch (choice) {
                case "create":
                    inset(request,response);
                    break;
                case "edit":
                    update(request,response);

                default:


            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void getListDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        List<PlaylistDetail> playlistDetails = playlistDetailDAO.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showFormIsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
         RequestDispatcher dispatcher=request.getRequestDispatcher("");
         dispatcher.forward(request,response);

    }

    private void inset(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        String p_id = request.getParameter("pd_id");
        String songId = request.getParameter("s_id");
        String playlistId = request.getParameter("p_id");
        PlaylistDetail playlistDetail = new PlaylistDetail(p_id, songId, playlistId);
        playlistDetailDAO.insert(playlistDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,SQLException,IOException{
        String p_id=request.getParameter("p_id");
        playlistDetailDAO.delete(p_id);
        List<PlaylistDetail>playlistDetailList=playlistDetailDAO.selectAll();
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("");
        requestDispatcher.forward(request,response);
    }
    private void showFormUpdate(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException,SQLException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("");
        dispatcher.forward(request,response);
    }
    private void update(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException, ServletException, SQLException {
        String songId=request.getParameter("song_id");
        String plays=request.getParameter("plays");
       PlaylistDetail playlistDetail=new PlaylistDetail(songId,plays);
       playlistDetailDAO.update(playlistDetail);
       RequestDispatcher dispatcher=request.getRequestDispatcher("");
       dispatcher.forward(request,response);

    }
}
