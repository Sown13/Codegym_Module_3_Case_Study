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
            <div class="col-9 overflow-auto" style="height: 90vh">
                <section class="main-display w-auto bg-dark p-3">
                    <jsp:include page="search-bar.jsp"/>
                    <!-- Image cover display here-->
                    <div class=" mx-0 my-5">
                        <h1 class="text-white w-100">Image cover</h1>
                    </div>
                    <hr style="color: white">
                    <!-- Playlist play button display here-->
                    <div class="mx-0 my-3">
                        <h5 class="text-white w-100 m-0">Play button display</h5>
                    </div>
                    <hr style="color: white">
                    <table class="table playing-table">
                        <thead>
                        <tr class="table-dark">
                            <th scope="col">#</th>
                            <th scope="col">Tiêu đề</th>
                            <th scope="col">Album</th>
                            <th scope="col">Yêu thích</th>
                            <th scope="col">Trạng thái</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="song" items="${requestScope.listSong}">
                        <tr class="table-dark" role="button">
                            <td >${song.getS_id()}</td>
                            <td>${song.getSong_name()}</td>
                            <td>${song.getAuthor()}</td>
                            <td>${song.getLabel()}</td>
                            <td>${song.getSong_url()}</td>
                        </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </section>
            </div>
        </div>
    </div>
</main>
<jsp:include page="play-bar.jsp"/>
</body>
<script>
    $(document).ready(function(){
        $('.playing-table').on('click', 'tbody tr', function(event) {
            $(this).addClass('highlight').siblings().removeClass('highlight');
        });
    });
</script>
</html>
