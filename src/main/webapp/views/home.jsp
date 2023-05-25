<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/24/2023
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="css/bootstrap_css/bootstrap.css">
    <!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="css/bootstrap_js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<main>
    <div class="container mt-3">
        <div class="row">
            <jsp:include page="side-bar.jsp"/>
            <div class="col-9">
                <section class="album-slider w-auto bg-dark p-3">
                    <jsp:include page="search-bar.jsp"/>
                    <div id="myCarousel" class="carousel slide mt-5 mb-0" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>

                                <div class="container">
                                    <div class="carousel-caption text-start">
                                        <h1>Example headline.</h1>
                                        <p>Some representative placeholder content for the first slide of the carousel.</p>
                                        <p><a class="btn btn-lg btn-primary" href="#">Sign up today</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>

                                <div class="container">
                                    <div class="carousel-caption">
                                        <h1>Another example headline.</h1>
                                        <p>Some representative placeholder content for the second slide of the carousel.</p>
                                        <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>

                                <div class="container">
                                    <div class="carousel-caption text-end">
                                        <h1>One more for good measure.</h1>
                                        <p>Some representative placeholder content for the third slide of this carousel.</p>
                                        <p><a class="btn btn-lg btn-primary" href="#">Browse gallery</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </section>
                <section class="main-display w-auto bg-dark p-3">
                    <div class="container list1">
                        <h5 class="text-white">Danh sách dành cho {user_name}</h5>
                        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_2_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 1</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_3_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 2</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_4_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 3</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_5_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 4</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất cả</p>
                    </div>
                    <div class="container list1">
                        <h5 class="text-white">Mới phát gần đây</h5>
                        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_2_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 1</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_3_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 2</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_4_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 3</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_5_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 4</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất cả</p>
                    </div>
                    <div class="container list1">
                        <h5 class="text-white">Pop</h5>
                        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_2_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 1</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_3_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 2</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_4_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 3</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_5_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 4</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất cả</p>
                    </div>
                    <div class="container list1">
                        <h5 class="text-white">Cho mọi tâm trạng</h5>
                        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_2_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 1</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_3_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 2</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_4_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 3</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_5_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 4</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất cả</p>
                    </div>
                    <div class="container list1">
                        <h5 class="text-white">Rock</h5>
                        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_2_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 1</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_3_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 2</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_4_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 3</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <img src="images/img_5_horizontal.jpg" class="w-100 h-100">
                                    <div class="card-body">
                                        <p class="card-text"><b>Daily Mix 4</b></p>
                                        <p class="card-text">Ngọt,Chilies,Đen và nhiều hơn nữa</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p class="text-white-50 text-decoration-underline text-end mt-2" role="button">Hiện tất cả</p>
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
</main>
</body>
</html>
