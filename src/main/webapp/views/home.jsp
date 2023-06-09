<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/24/2023
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="views/css/bootstrap_css/bootstrap.css">
    <!-- Option 1: Include in HTML -->
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
                    <section class="album-slider w-auto">
                        <div id="myCarousel" class="carousel slide mb-0" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"
                                        aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1"
                                        aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2"
                                        aria-label="Slide 3"></button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="3"
                                        aria-label="Slide 4"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="views/images/img_4_horizontal.jpg" class="w-100 h-100">
                                    <div class="container">
                                        <div class="carousel-caption">
                                            <h1>Another example headline.</h1>
                                            <p>Some representative placeholder content for the second slide of the
                                                carousel.</p>
                                            <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
                                        </div>
                                    </div>
                                </div>
                                <c:forEach var="trendPlaylist" items="${requestScope.trendList}">
                                <div class="carousel-item">
                                    <img src="views/images/img_3_horizontal.jpg" class="w-100 h-100">
                                    <div class="container">
                                        <div class="carousel-caption text-start">
                                            <h1>${trendPlaylist.getPlayListName()}</h1>
                                            <p>Thể loại: ${trendPlaylist.getLabel()}</p>
                                            <p><a class="btn btn-lg btn-primary" href="playlists?choice=edit&playlistID=${trendPlaylist.getP_id()}">Listen now</a></p>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel"
                                    data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#myCarousel"
                                    data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </section>
                    <section class="main-display w-auto bg-dark p-3">

                        
                        <c:choose>
                            <c:when test="${requestScope.choice == 'searchResult'}">
                                <c:forEach var="resultPlaylist" items="${requestScope['resultPlaylist']}">
                                    <div class="col">
                                        <a href="playlists?choice=edit&playlistID=${resultPlaylist.getP_id()}"
                                           class="text-decoration-none p-3 lh-tight text-white">
                                            <div class="card shadow-sm">
                                                <img src="views/images/img_2_horizontal.jpg" class="w-100 h-100">
                                                <div class="card-body">
                                                    <p class="card-text"><b><c:out
                                                            value="${resultPlaylist.getPlayListName()}"/></b></p>
                                                    <p class="card-text"><c:out value="${resultPlaylist.getLabel()}"/></p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:when test="${requestScope.choice != 'searchResult'}">
                                <div class="container list1">
                                    <h5 class="text-white">Vpop</h5>
                                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                                        <c:forEach var="playLists1" items="${requestScope['playLists1']}">
                                            <div class="col">
                                                <a href="playlists?choice=edit&playlistID=${playLists1.getP_id()}"
                                                   class="text-decoration-none p-3 lh-tight text-white">
                                                    <div class="card shadow-sm">
                                                        <img src="views/images/img_2_horizontal.jpg" class="w-100 h-100">
                                                        <div class="card-body">
                                                            <p class="card-text"><b><c:out
                                                                    value="${playLists1.getPlayListName()}"/></b></p>
                                                            <p class="card-text"><c:out value="${playLists1.getLabel()}"/></p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất
                                        cả</p>
                                </div>


                                <div class="container list1">
                                    <h5 class="text-white">Kpop</h5>
                                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                                        <c:forEach var="playLists2" items="${requestScope['playLists2']}">
                                            <div class="col">
                                                <a href="playlists?choice=edit&playlistID=${playLists2.getP_id()}"
                                                   class="text-decoration-none p-3 lh-tight text-white">
                                                    <div class="card shadow-sm">
                                                        <img src="views/images/img_2_horizontal.jpg" class="w-100 h-100">
                                                        <div class="card-body">
                                                            <p class="card-text"><b><c:out
                                                                    value="${playLists2.getPlayListName()}"/></b></p>
                                                            <p class="card-text"><c:out value="${playLists2.getLabel()}"/></p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất
                                        cả</p>
                                </div>


                                <div class="container list1">
                                    <h5 class="text-white">NHẠC VÀNG</h5>
                                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">

                                        <c:forEach var="playLists3" items="${requestScope['playLists3']}">
                                            <div class="col">
                                                <a href="playlists?choice=edit&playlistID=${playLists3.getP_id()}"
                                                   class="text-decoration-none p-3 lh-tight text-white">
                                                    <div class="card shadow-sm">
                                                        <img src="views/images/img_2_horizontal.jpg" class="w-100 h-100">
                                                        <div class="card-body">
                                                            <p class="card-text"><b><c:out
                                                                    value="${playLists3.getPlayListName()}"/></b></p>
                                                            <p class="card-text"><c:out value="${playLists3.getLabel()}"/></p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </c:forEach>

                                    </div>
                                    <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất
                                        cả</p>
                                </div>


                                <div class="container list1">
                                    <h5 class="text-white">NHẠC EDM</h5>
                                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                                        <c:forEach var="playLists4" items="${requestScope['playLists4']}">
                                            <div class="col">
                                                <a href="playlists?choice=edit&playlistID=${playLists4.getP_id()}"
                                                   class="text-decoration-none p-3 lh-tight text-white">
                                                    <div class="card shadow-sm">
                                                        <img src="views/images/img_2_horizontal.jpg" class="w-100 h-100">
                                                        <div class="card-body">
                                                            <p class="card-text"><b><c:out
                                                                    value="${playLists4.getPlayListName()}"/></b></p>
                                                            <p class="card-text"><c:out value="${playLists4.getLabel()}"/></p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất
                                        cả</p>
                                </div>
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
</html>
