package controller;

import dao.playlist.PlaylistDAO;
import dao.user.UserDAO;
import model.PlayList;
import model.User;
import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/home")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;


    @Override
    public void init() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        if (choice == null) {
            choice = "";
        }
        try {
            switch (choice) {
                case "create": {
                    showNewForm(request, response);
                    break;
                }
                case "edit": {
                    showEditForm(request, response);
                    break;
                }
                case "delete": {
                    showDeleteForm(request, response);
                    break;
                }
                case "loginForm": {
                    showFormLogin(request, response);
                    break;
                }
                case "logout":
                    setHomePlaylist(request,response);
                    logout(request,response);
                    break;
                default: {
                    setHomePlaylist(request,response);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("playlists");
                    dispatcher.forward(request, response);
                    break;
                }
            }
        } catch (SQLException e) {
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
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "login":
                    login(request,response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void setHomePlaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("rock", "rock");
        request.setAttribute("nhac tre", "nhac tre");
        request.setAttribute("nhac vang", "nhac vang");
        request.setAttribute("jar", "jar");
        request.setAttribute("nhac cu chuoi", "nhac cu chuoi");
    }
    private void getListUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> listUser = userDAO.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        User existingUser = userDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editUser.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    protected void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/deleteUser.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String fullname = request.getParameter("full_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        User newUser = new User(user_name, password,fullname,email, address);
        userDAO.insert(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/createUser.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("u_id");
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        User user = new User(id, name, email, address);
        userDAO.update(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editUser.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("u_id");
        userDAO.delete(id);
        List<User> listUser = userDAO.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }
    private  void showFormLogin(HttpServletRequest request, HttpServletResponse response)
        throws SQLException,IOException,ServletException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("views/login.jsp");
        dispatcher.forward(request,response);
    }
    private void login(HttpServletRequest request,HttpServletResponse response)
    throws SQLException,IOException,ServletException{
        String user=request.getParameter("user");
        String passwords=request.getParameter("password");
        User user1=userDAO.login(user,passwords);
        setHomePlaylist(request, response);
        if(user1!=null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",user1);
//            session.setMaxInactiveInterval(10);
            request.setAttribute("choice", "");
            RequestDispatcher dispatcher=request.getRequestDispatcher("playlists");
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher=request.getRequestDispatcher("playlists");
            dispatcher.forward(request,response);

        }
    }
    private void logout(HttpServletRequest request,HttpServletResponse response)
    throws IOException,ServletException{
        HttpSession session=request.getSession();
        session.removeAttribute("loginUser");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("playlists");
        requestDispatcher.forward(request,response);

    }





}
