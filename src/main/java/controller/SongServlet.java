package controller;

import dao.song.SongDAO;
import model.Song;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SongServlet", value = "/songs")
public class SongServlet extends HttpServlet {
    private SongDAO songDAO;
    public void init(){
        songDAO=new SongDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choice=request.getParameter("choice");
        if(choice ==null){
            choice="";
        }
        try {
            switch (choice){
                case "creatFrom":
                    showCreatSong(request,response);
                    break;
                case "FromEdit":
                    editFrom(request,response);
                    break;
                case "delete":
                    deleteSong(request,response);
                    break;
                case "search":
                    fromSearchName(request,response);
                    break;
                default:
                    listSong(request,response);
            }

        }catch (SQLException e){
            throw new ServletException();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String choice=request.getParameter("choice");
      if(choice==null){
          choice="";
      }
      try {
          switch (choice){
              case "createSong":
                  createSong(request,response);
                  break;
              case "editSong":
                  editSong(request,response);
                  break;
              case "search":
                  searchName(request,response);
                  break;
          }

      }catch (SQLException e){
          throw  new ServletException();
      }
    }
    private void listSong(HttpServletRequest request,HttpServletResponse response)
        throws ServletException ,SQLException,IOException{
        List<Song> getList=songDAO.selectAll();
        request.setAttribute("getList" ,getList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/listSong.jsp");
        dispatcher.forward(request,response);
    }
    private void editFrom(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,SQLException,IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/fromEdit.jsp");
        dispatcher.forward(request,response);
    }
    private void editSong(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,SQLException,IOException{
        String id=(request.getParameter("id"));
        String name=request.getParameter("song_name");
        String author=request.getParameter("author");
        String label=request.getParameter("label");
        Song song=new Song(id,name,author,label);
        songDAO.update(song);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/listSong.jsp");
        dispatcher.forward(request,response);
    }
    private void showCreatSong(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException,SQLException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/creat.jsp");
        dispatcher.forward(request,response);
    }
    private void createSong(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException,SQLException{
        String song_name=request.getParameter("song_name");
        String author=request.getParameter("author");
        String song_url=request.getParameter("song_url");
        String label=request.getParameter("label");
        Song newSong=new Song(song_name,author,song_url,label);
        songDAO.update(newSong);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/ListSong.jsp");
        dispatcher.forward(request,response);

    }
    private void deleteSong(HttpServletRequest request,HttpServletResponse response)
        throws SQLException,IOException,ServletException{
        String id=request.getParameter("id");
        songDAO.delete(id);
        List<Song>songs=songDAO.selectAll();
        request.setAttribute("songs",songs);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/listSong.jsp");
        dispatcher.forward(request,response);
    }
    private void fromSearchName(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,SQLException,IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/fromSearch.jsp");
        dispatcher.forward(request,response);
    }
    private void searchName(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,SQLException,IOException{
        String name_song=request.getParameter("song_name");
        songDAO.searchSong(name_song);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/listSong.jsp");
        dispatcher.forward(request,response);
    }
}
