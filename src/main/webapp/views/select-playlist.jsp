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
                    <section class="main-display w-auto bg-dark p-3">
                        <div class=" mx-0 my-5">
                            <div class="row">
                                <div class="col-6">
                                    <img src="views/images/img_2_horizontal.jpg" alt="Image placeholder"
                                         class="rounded img-fluid">
                                </div>
                                <c:choose>
                                    <c:when test="${sessionScope['loginUser'] != null && playlistUserID == sessionScope.loginUser.getU_id()}">
                                        <div class="col-6">
                                            <a href="playlists?choice=editPlaylistInfo&playlistID=${playlistID}" class="text-decoration-none">
                                                <p class="text-white">Personal playlist</p>
                                                <h3 class="text-white">${playlistName}</h3>
                                                <p class="text-white">label</p>
                                                <p class="text-white">Số lượt like: ${requestScope.numberOfLike}</p>
                                            </a>
                                        </div>
                                    </c:when>

                                    <c:when test="${sessionScope['loginUser'] == null || playlistUserID != sessionScope.loginUser.getU_id()}">
                                        <div class="col-6">
                                            <p class="text-white">Personal playlist</p>
                                            <h3 class="text-white">${playlistName}</h3>
                                            <p class="text-white">label</p>
                                            <p class="text-white">Số lượt like: ${requestScope.numberOfLike}</p>
                                        </div>
                                    </c:when>

                                </c:choose>
                            </div>
                        </div>
                        <hr style="color: white">
                        <div class="mx-0 my-3">
                            <div class="row align-items-center">
                                <div class="col-1">
                                    <a href="#play-playlist"><i class="fa-solid fa-circle-play fa-3x ms-4"
                                                                data-bs-toggle="tooltip" data-bs-placement="left"
                                                                title="Play/Pause" role="button"
                                                                style="color: limegreen"></i></a>
                                </div>

                                <c:choose>
                                    <c:when test="${sessionScope['loginUser']!= null && playlistUserID != sessionScope.loginUser.getU_id()}">
                                        <div class="col-1">
                                            <a href="playlists?choice=like&playlistID=${playlistID}&userID=${sessionScope.loginUser.getU_id()}">
                                                <i class="fa-solid fa-heart fa-2xl ms-3"
                                                   data-bs-toggle="tooltip"
                                                   data-bs-placement="left"
                                                   title="Like/Unlike" role="button"
                                                   style="color: limegreen"></i></a>
                                        </div>
                                    </c:when>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${sessionScope['loginUser'] != null && playlistUserID == sessionScope.loginUser.getU_id()}">
                                        <div class="col">
                                            <a href="playlists?choice=delete&playlistID=${playlistID}"><i
                                                    class="fa-solid fa-trash fa-xl float-end text-light me-3"
                                                    data-bs-toggle="tooltip" data-bs-placement="left"
                                                    title="Delete playlist"
                                                    role="button"></i></a>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                        <hr style="color: white">
                        <table class="table playing-table table-hover">
                            <thead>
                            <tr class="table-dark">
                                <th scope="col">#</th>
                                <th scope="col">TÊN BÀI HÁT</th>
                                <th scope="col">TÁC GIẢ</th>
                                <th scope="col">THỂ LOẠI</th>
                                <th scope="col">LINK</th>
                                <th scope="col" class="align-middle">
                                    <i class="fa-solid fa-trash fa-lg text-light ms-3" data-bs-toggle="tooltip"
                                       data-bs-placement="left" title="Delete"></i>
                                </th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:choose>

                                <c:when test="${sessionScope['loginUser'] != null && playlistUserID == sessionScope.loginUser.getU_id()}">
                                    <c:forEach var="song" items="${requestScope.listSong}" varStatus="loop">
                                        <tr class="table-dark">
                                            <td>${loop.index + 1}</td>
                                            <td><a href="playlists?choice=play&playlistID=${playlistID}&playingSong=${song.getS_id()}">${song.getSong_name()}</a></td>
                                            <td>${song.getAuthor()}</td>
                                            <td>${song.getLabel()}</td>
                                            <td>${song.getSong_url()}</td>
                                            <td>
                                                <form method="post" action="playlists">
                                                    <input type="hidden" name="choice" value="removeSong">
                                                    <input type="hidden" name="playlistID" value="${playlistID}">
                                                    <input type="hidden" name="addSongID" value="${song.getS_id()}">
                                                    <button type="submit" class="btn btn-outline-secondary">Xóa</button>
                                                </form>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </c:when>

                                <c:when test="${sessionScope['loginUser'] == null || playlistUserID != sessionScope.loginUser.getU_id()}">
                                    <c:forEach var="song" items="${requestScope.listSong}" varStatus="loop">
                                        <tr class="table-dark">
                                            <td>${loop.index + 1}</td>
                                            <td><a href="playlists?choice=play&playlistID=${playlistID}&playingSong=${song.getS_id()}">${song.getSong_name()}</a></td>
                                            <td>${song.getAuthor()}</td>
                                            <td>${song.getLabel()}</td>
                                            <td>${song.getSong_url()}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>

                            </c:choose>
                            </tbody>
                        </table>
                    </section>
                    <hr style="color: white">
                    <section class="recommend-songs w-auto bg-dark p-3">
                        <c:choose>
                            <c:when test="${sessionScope['loginUser'] != null && playlistUserID == sessionScope.loginUser.getU_id()}">
                                <h3 class="text-white">Gợi ý</h3>
                                <table class="table songs-table table-hover">
                                    <thead>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="song" items="${requestScope['listAllSong']}">
                                        <tr class="table-dark" role="button">
                                            <td><a href="playlists?choice=play&playlistID=${playlistID}&playingSong=${song.getS_id()}">${song.getSong_name()}</a></td>
                                            <td>${song.getAuthor()}</td>
                                            <td>${song.getLabel()}</td>
                                            <td class="text-end">
                                                <form method="post" action="playlists">
                                                    <input type="hidden" name="choice" value="addSong">
                                                    <input type="hidden" name="playlistID" value="${playlistID}">
                                                    <input type="hidden" name="addSongID" value="${song.getS_id()}">
                                                    <button type="submit" class="btn btn-outline-secondary">Thêm
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:when>
                        </c:choose>

                    </section>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="play-bar.jsp"/>
</body>
<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('.playing-table').on('click', 'tbody tr', function (event) {--%>
<%--            $(this).addClass('highlight').siblings().removeClass('highlight');--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</html>
