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
                    <section class="album-slider w-auto">
                        <div id="myCarousel" class="carousel slide mb-0" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"
                                        aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1"
                                        aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2"
                                        aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <svg class="bd-placeholder-img" width="100%" height="100%"
                                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true"
                                         preserveAspectRatio="xMidYMid slice" focusable="false">
                                        <rect width="100%" height="100%" fill="#777"/>
                                    </svg>

                                    <div class="container">
                                        <div class="carousel-caption text-start">
                                            <h1>Example headline.</h1>
                                            <p>Some representative placeholder content for the first slide of the
                                                carousel.</p>
                                            <p><a class="btn btn-lg btn-primary" href="#">Sign up today</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <svg class="bd-placeholder-img" width="100%" height="100%"
                                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true"
                                         preserveAspectRatio="xMidYMid slice" focusable="false">
                                        <rect width="100%" height="100%" fill="#777"/>
                                    </svg>

                                    <div class="container">
                                        <div class="carousel-caption">
                                            <h1>Another example headline.</h1>
                                            <p>Some representative placeholder content for the second slide of the
                                                carousel.</p>
                                            <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <svg class="bd-placeholder-img" width="100%" height="100%"
                                         xmlns="http://www.w3.org/2000/svg" aria-hidden="true"
                                         preserveAspectRatio="xMidYMid slice" focusable="false">
                                        <rect width="100%" height="100%" fill="#777"/>
                                    </svg>

                                    <div class="container">
                                        <div class="carousel-caption text-end">
                                            <h1>One more for good measure.</h1>
                                            <p>Some representative placeholder content for the third slide of this
                                                carousel.</p>
                                            <p><a class="btn btn-lg btn-primary" href="#">Browse gallery</a></p>
                                        </div>
                                    </div>
                                </div>
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

                        <div class="container list1">
                            <h5 class="text-white">Nhac Tre</h5>
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
                            <h5 class="text-white">Rock</h5>
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
                            <h5 class="text-white">Nhac Vang</h5>
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
                            <h5 class="text-white">Nhac Cu Chuoi</h5>
                            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                                <c:forEach var="playLists4" items="${requestScope['playLists4']}">
                                    <div class="col">
                                        <div class="card shadow-sm">
                                            <img src="views/images/img_2_horizontal.jpg" class="w-100 h-100">
                                            <div class="card-body">
                                                <p class="card-text"><b><c:out
                                                        value="${playLists4.getPlayListName()}"/></b></p>
                                                <p class="card-text"><c:out value="${playLists4.getLabel()}"/></p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                            <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất
                                cả</p>
                        </div>

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
                    </section>
                </div>
            </div>

        </div>
    </div>
</main>
<jsp:include page="play-bar.jsp"/>
</body>
</html>
