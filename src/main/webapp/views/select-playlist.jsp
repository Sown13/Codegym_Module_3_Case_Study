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
                        <!-- Image cover display here-->
                        <div class=" mx-0 my-5">
                            <div class="row">
                                <div class="col-6">
                                    <img src="images/img_2_horizontal.jpg" alt="Image placeholder" class="rounded img-fluid">
                                </div>
                                <div class="col-6">
                                    <p class="text-white">Personal playlist</p>
                                    <h3 class="text-white">My Playlist #n</h3>
                                    <p class="text-white">#author</p>
                                </div>
                            </div>
                        </div>
                        <hr style="color: white">
                        <!-- Playlist play button display here-->
                        <div class="mx-0 my-3">
                            <div class="row align-items-center">
                                <div class="col-1">
                                    <i class="fa-solid fa-circle-play fa-3x ms-4" style="color: limegreen"></i>
                                </div>
                                <div class="col-1">
                                    <i class="fa-solid fa-heart fa-2xl ms-3" style="color: limegreen"></i>
                                </div>
                            </div>
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
                            <tr class="table-dark" role="button">
                                <td >1</td>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>2</td>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                                <td>@fat</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>
                            <tr class="table-dark" role="button">
                                <td>3</td>
                                <td>Larry the Bird</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                                <td>@twitter</td>
                            </tr>

                            </tbody>
                        </table>
                    </section>
                </div>
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
