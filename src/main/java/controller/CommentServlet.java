package controller;

import dao.comment.CommentDAO;
import model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/Comment")
public class CommentServlet extends HttpServlet {
    private CommentDAO commentDAO;

    public void init() {
        commentDAO = new CommentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        if (choice == null) {
            choice = "";
        }
        try {
            switch (choice) {
            case "createFrom":
                createFrom(request, response);
                break;
                case "edit":
                    editFrom(request,response);
                break;
                case "delete":
                    deleteComment(request,response);
                    break;
                default:
                    showComment(request,response);
        }

        }catch (SQLException e){
            throw new ServletException(e);
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
                    createComment(request,response);
                    break;
                case "edit":
                    editComment(request,response);

            }
        }catch (SQLException e){
            throw new ServletException(e);
        }

    }
    private void createFrom(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
    RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/create.jsp");
    dispatcher.forward(request,response);
    }
    private void createComment(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException,  SQLException {
        String content=request.getParameter("content");
        String s_id=request.getParameter("s_id");
        String u_id=request.getParameter("u_id");
        Comment comment=new Comment(content,s_id,u_id);
        commentDAO.update(comment);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/List.jsp");
        dispatcher.forward(request,response);
    }
    private void showComment(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException,SQLException{
        List<Comment>commentList=commentDAO.selectAll();
        request.setAttribute("ListComment",commentList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
        dispatcher.forward(request,response);
    }
    private void editFrom(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException,SQLException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/edit.jsp");
        dispatcher.forward(request,response);
    }
    private void editComment(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException,SQLException{
        String content=request.getParameter("content");
        String s_id=request.getParameter("s_id");
        String u_id=request.getParameter("u_id");
        Comment comment=new Comment(content,s_id,u_id);
        commentDAO.update(comment);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
        dispatcher.forward(request,response);
    }
    private void deleteComment(HttpServletRequest request,HttpServletResponse response)
    throws SQLException,IOException,ServletException{
        String id_c=request.getParameter("id");
        commentDAO.delete(id_c);
        List<Comment>commentList=commentDAO.selectAll();
        request.setAttribute("commentList",commentList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list");
        dispatcher.forward(request,response);

    }
}
