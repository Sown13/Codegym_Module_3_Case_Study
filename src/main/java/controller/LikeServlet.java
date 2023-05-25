package controller;

import dao.like.LikeDAO;
import model.Like;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LikeServlet", value = "/like")
public class LikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LikeDAO likeDAO;

    public void init() {
        likeDAO = new LikeDAO();
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
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteLike(request, response);
                    break;
                default:
                    listLike(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertLike(request, response);
                    break;
                case "edit":
                    updateLike(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    public void listLike(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Like> listLike = likeDAO.selectAll();
        request.setAttribute("listLike", listLike);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String u_id = request.getParameter("u_id");
        Like existingLike = likeDAO.select(u_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        request.setAttribute("like", existingLike);
        dispatcher.forward(request, response);

    }

    private void insertLike(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String u_id = request.getParameter("u_id");
        String s_id = request.getParameter("s_id");
        Like newLike = new Like(u_id, s_id);
        likeDAO.insert(newLike);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void updateLike(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String u_id = request.getParameter("u_id");
        String s_id = request.getParameter("s_id");
        Like book = new Like(u_id, s_id);
        likeDAO.update(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void deleteLike(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String u_id = request.getParameter("u_id");
        String s_id = request.getParameter("s_id");
        if (!likeDAO.checkValueExists(u_id, s_id)) {
            likeDAO.delete(u_id);
        }
        List<Like> listLike = likeDAO.selectAll();
        request.setAttribute("listLike", listLike);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

}
