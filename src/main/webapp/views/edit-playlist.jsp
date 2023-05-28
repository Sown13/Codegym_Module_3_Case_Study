<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/24/2023
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select-playlist</title>
    <link rel="stylesheet" href="views/css/bootstrap_css/bootstrap.css">
    <!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="views/css/style.css">
    <script src="views/css/bootstrap_js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/bbbce8c886.js" crossorigin="anonymous"></script>
</head>
<body class="overflow-hidden">
<main>
    <div class="container mt-3">
        <div class="row">
            <jsp:include page="side-bar.jsp"/>
            <div class="col-9 bg-dark">
                <div class="pt-3 mb-3">
                    <jsp:include page="search-bar.jsp"/>
                </div>
                <div class="overflow-auto" style="height: 80vh">
                    <h1>Trang thay đổi thông tin Playlist</h1>
                    <form action="playlists" method="post">
                        <table class="table table-dark able-striped table-hover">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Thông tin</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">Tên</th>
                                <td><input class="w-100" name="newPlaylistName" value="${requestScope.playlitsEdit.getPlayListName()}"></td>
                            </tr>
                            <tr>
                                <th scope="row">Label</th>
                                <td><input class="w-100" name="newPlaylistLabel" value="${requestScope.playlitsEdit.getLabel()}"></td>
                            </tr>
                            </tbody>
                        </table>
                        <input type="hidden" name="playlistID" value="${playlistID}">
                        <input type="hidden" name="choice" value="editPlaylistInfo">
                        <button type="submit" class="btn btn-outline-secondary text-white">Save</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="play-bar.jsp"/>
</body>
</html>
