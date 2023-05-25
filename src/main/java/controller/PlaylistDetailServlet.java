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
    public  void init(){
        this.playlistDetailDAO= new PlaylistDetailDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String choice=request.getParameter("choice");
     if(choice==null){
         choice="";
     }
     try {
         switch (choice){
             case "case":
                 break;

             default:
                 getListDetail(request,response);

         }

     }catch (SQLException ex){
         throw new ServletException(ex);
     }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void getListDetail(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, SQLException,IOException{
        List<PlaylistDetail>playlistDetails=playlistDetailDAO.selectAll();
        RequestDispatcher dispatcher=request.getRequestDispatcher("");
        dispatcher.forward(request,response);
    }
}
