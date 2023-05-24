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
                <section class="main-display w-auto bg-dark p-3">
                    <!-- As a heading -->
                    <!-- Nav bar display here-->
<%--                    <div class="col-md-6 search-box">--%>
<%--                        <div class="form ms-5">--%>
<%--                            <svg class="fa fa-search" width="16" height="16"><use xlink:href="#search-fill"/></svg>--%>
<%--                            <input type="text" class="form-control form-input" placeholder="Search anything...">--%>
<%--                        </div>--%>

<%--                    </div>--%>
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

                        </tbody>
                    </table>
                </section>
            </div>
        </div>
    </div>
</main>
</body>
<script>
    $(document).ready(function(){
        $('.playing-table').on('click', 'tbody tr', function(event) {
            $(this).addClass('highlight').siblings().removeClass('highlight');
        });
    });
</script>
</html>
