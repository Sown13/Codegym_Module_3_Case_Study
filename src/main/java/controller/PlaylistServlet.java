package controller;

import dao.like.LikeDAO;
import dao.playlist.PlaylistDAO;
import dao.playlist_detail.PlaylistDetailDAO;
import dao.song.SongDAO;
import dao.user.UserDAO;
import model.PlayList;
import model.Song;
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
                    checkLastSongPlay(request, response);
                    showNewForm(request, response);
                    break;
                case "edit":
                    checkLastSongPlay(request, response);
                    showEditForm(request, response);
                    break;
                case "delete":
                    checkLastSongPlay(request, response);
                    showDeleteForm(request, response);
                    break;
                case "search":
                    checkLastSongPlay(request, response);
                    searchPlaylistByName(request, response);
                    break;
                case "sort":
                    sortPlayListByDate(request, response);
                    break;
                case "listSong":
                    checkLastSongPlay(request, response);
                    findListSongByPlayListId(request, response);
                    break;
                case "like":
                    likePlaylist(request, response);
                    checkLastSongPlay(request, response);
                    showEditForm(request, response);
                    break;
                case "play":
                    play(request, response);
                    break;
                case "editPlaylistInfo":
                    showEditPlaylistInfo(request, response);
                    break;
                default:
                    checkLastSongPlay(request, response);
                    getPlaylistByLabel(request, response);
                    break;
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
                    checkLastSongPlay(request, response);
                    showNewForm(request, response);
                    break;
                case "edit":
                    checkLastSongPlay(request, response);
                    update(request, response);
                    break;
                case "addSong":
                    checkLastSongPlay(request, response);
                    addSongIntoPlaylist(request, response);
                    showEditForm(request, response);
                    break;
                case "removeSong":
                    checkLastSongPlay(request, response);
                    removeSongFromPlaylist(request, response);
                    showEditForm(request, response);
                    break;
                case "delete":
                    checkLastSongPlay(request, response);
                    delete(request, response);
                    break;
                case "cancel":
                    checkLastSongPlay(request, response);
                    showEditForm(request, response);
                    break;
                case "editPlaylistInfo":
                    checkLastSongPlay(request, response);
                    editPlaylistInfo(request, response);
                    break;
                default:
                    checkLastSongPlay(request, response);
                    getPlaylistByLabel(request, response);
                    break;
            }
        } catch (SQLException e) {
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
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        String playlistNameDefault = "New Playlist - " + loginUser.getFullname();
        playlistDAO.insert(new PlayList(playlistNameDefault, loginUser.getU_id(), "Unknow"));
        showPlaylistOrderByUser(request, response);
        PlayList playList = playlistDAO.SelectLastestAddedPlaylist();
        LikeDAO likeDAO = new LikeDAO();
        int numberOfLike = likeDAO.countLikeFromPlaylist(playList.getP_id());
        request.setAttribute("numberOfLike", numberOfLike);
        request.setAttribute("playlistName", playList.getPlayListName());
        if (playList != null) {
            String servlet_url = "/playlists?choice=edit&playlistID=" + playList.getP_id();
            response.sendRedirect(servlet_url);
        }


//        response.sendRedirect("playlists?choice=edit&playlistID=");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/select-playlist.jsp");
//        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String playListID = request.getParameter("playlistID");
        List<Song> listSong = playlistDAO.getListSongByPlayListId(playListID);
        request.setAttribute("listSong", listSong);
        List<Song> listAllSong = playlistDAO.getAllSong();
        request.setAttribute("listAllSong", listAllSong);
        showPlaylistOrderByUser(request, response);
        request.setAttribute("playlistID", playListID);
        PlayList playList = playlistDAO.select(playListID);
        request.setAttribute("playlistName", playList.getPlayListName());
        request.setAttribute("playlistUserID", playList.getU_id());
        LikeDAO likeDAO = new LikeDAO();
        int numberOfLike = likeDAO.countLikeFromPlaylist(playListID);
        request.setAttribute("numberOfLike", numberOfLike);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/select-playlist.jsp");
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String p_id = request.getParameter("p_id");
        String p_name = request.getParameter("p_name");
        String u_id = request.getParameter("u_id");
        String label = request.getParameter("label");
        PlayList newPlayList = new PlayList(p_id, p_name, u_id, label);
        playlistDAO.insert(newPlayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String p_id = request.getParameter("p_id");
        String p_name = request.getParameter("P_name");
        String u_id = request.getParameter("u_id");
        String label = request.getParameter("label");
        PlayList book = new PlayList(p_id, p_name, u_id, label);
        playlistDAO.update(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String playlistID = request.getParameter("playlistID");
        PlaylistDetailDAO playlistDetailDAO = new PlaylistDetailDAO();
        playlistDetailDAO.deleteAnEntirePlaylist(playlistID);
        LikeDAO likeDAO = new LikeDAO();
        likeDAO.deleteAnEntirePlaylist(playlistID);
        playlistDAO.delete(playlistID);
        request.removeAttribute("choice");
        response.sendRedirect("home");
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String playlistID = request.getParameter("playlistID");
        request.setAttribute("playlistID", playlistID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/delete_confirm.jsp");
        dispatcher.forward(request, response);
    }

    private void getPlaylistByLabel(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<PlayList> playLists1 = new ArrayList<>();
        List<PlayList> playLists2 = new ArrayList<>();
        List<PlayList> playLists3 = new ArrayList<>();
        List<PlayList> playLists4 = new ArrayList<>();
        List<PlayList> playLists5 = new ArrayList<>();
        String vpop = "Nhạc Vpop";
        String kpop = "Nhạc Kpop";
        String nhacVang = "Nhạc vàng";
        String edm = "Nhạc EDM";
        String noVoice = "Nhạc không lời";
        playLists1 = playlistDAO.selectPlayListByLabel(vpop);
        playLists2 = playlistDAO.selectPlayListByLabel(kpop);
        playLists3 = playlistDAO.selectPlayListByLabel(nhacVang);
        playLists4 = playlistDAO.selectPlayListByLabel(edm);
        playLists5 = playlistDAO.selectPlayListByLabel(noVoice);
        request.setAttribute("playLists1", playLists1);
        request.setAttribute("playLists2", playLists2);
        request.setAttribute("playLists3", playLists3);
        request.setAttribute("playLists4", playLists4);
        request.setAttribute("playLists5", playLists5);
        showPlaylistOrderByUser(request, response);
        setHotTrendPlaylist(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    private void setHotTrendPlaylist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<PlayList> trendList = new ArrayList<>();
        trendList = playlistDAO.getHotTrendPlaylist();
        request.setAttribute("trendList", trendList);
    }

    private void searchPlaylistByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String playlistName = request.getParameter("playlistName");
        List<PlayList> resultPlaylist = playlistDAO.findPlayListByName(playlistName);
        request.setAttribute("resultPlaylist", resultPlaylist);
        request.setAttribute("choice", "searchResult");
        showPlaylistOrderByUser(request, response);
        setHotTrendPlaylist(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    private void sortPlayListByDate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<PlayList> playLists = playlistDAO.sortPlaylistByDate();
        request.setAttribute("playlist", playLists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void findListSongByPlayListId(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String p_id = request.getParameter("p_id");
        List<Song> listSong = playlistDAO.getListSongByPlayListId(p_id);
        request.setAttribute("listSong", listSong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }


    private void showPlaylistOrderByUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<PlayList> playLists = new ArrayList<>();
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") == null) {
            playLists = playlistDAO.selectAll();
        } else {
            User loginUser = (User) session.getAttribute("loginUser");
            String userID = loginUser.getU_id();
            playLists.addAll(playlistDAO.selectPlayListByUID(userID));
            playLists.addAll(playlistDAO.selectPlayListFromOtherUser(userID));
        }
        request.setAttribute("playLists", playLists);
    }

    private List<Song> showSongInPlaylist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String playlistID = request.getParameter("playlistID");
        List<Song> listSong = playlistDAO.getListSongByPlayListId(playlistID);
        return listSong;
    }

    private void addSongIntoPlaylist(HttpServletRequest request, HttpServletResponse response) {
        String addSongID = request.getParameter("addSongID");
        String playlistID = request.getParameter("playlistID");
        playlistDAO.addSongIntoPlaylist(addSongID, playlistID);
    }

    private void removeSongFromPlaylist(HttpServletRequest request, HttpServletResponse response) {
        String addSongID = request.getParameter("addSongID");
        String playlistID = request.getParameter("playlistID");
        playlistDAO.removeSongFromPlaylist(addSongID, playlistID);
    }

    public void likePlaylist(HttpServletRequest request, HttpServletResponse response) {
        String userID = request.getParameter("userID");
        String playlistID = request.getParameter("playlistID");
        LikeDAO likeDAO = new LikeDAO();
        if (likeDAO.isExistedLike(userID, playlistID)) {
            likeDAO.unLikePlaylist(userID, playlistID);
        } else {
            likeDAO.likePlaylist(userID, playlistID);
        }
    }

    public void updateLastSongPlay(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        String lastPlaySongID = request.getParameter("playingSong");
        if (loginUser != null) {
            UserDAO userDAO = new UserDAO();
            userDAO.updateLastPlay(lastPlaySongID, loginUser.getU_id());
        }
        SongDAO songDAO = new SongDAO();
        Song playingSong = songDAO.select(lastPlaySongID);
        request.setAttribute("playingSong", playingSong);
    }

    public void checkLastSongPlay(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            SongDAO songDAO = new SongDAO();
            String lastPlaySongID = loginUser.getLastSongPlayID();
            Song playingSong = songDAO.select(lastPlaySongID);
            request.setAttribute("playingSong", playingSong);
        }
    }

    public void play(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        updateLastSongPlay(request, response);
        showEditForm(request, response);
    }

    private void showEditPlaylistInfo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String playlistID = request.getParameter("playlistID");
        request.setAttribute("playlistID",playlistID);
        PlayList playList = playlistDAO.select(playlistID);
        request.setAttribute("playlitsEdit", playList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit-playlist.jsp");
        dispatcher.forward(request, response);
    }

    private void editPlaylistInfo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String newPlaylistName = request.getParameter("newPlaylistName");
        String newPlaylistLabel = request.getParameter("newPlaylistLabel");
        String playlistID = request.getParameter("playlistID");
        playlistDAO.updatePlaylistInfoByID(newPlaylistName,newPlaylistLabel,playlistID);
        request.setAttribute("playlistID", playlistID);
        request.setCharacterEncoding("UTF-8");
        showEditForm(request, response);
    }

}
