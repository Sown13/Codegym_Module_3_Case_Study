package controller;

import dao.playlist_detail.PlaylistDetailDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PlaylistDetailServlet", value = "/playlist_detail")
public class PlaylistDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PlaylistDetailDAO playlistDetailDAO;
    public  void init(){}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
