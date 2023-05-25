<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/25/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Playbar</title>
</head>
<body>
<main class="play-bar">
  <div class="container bg-black text-light" >
    <div class="row align-items-center" style="height: 55px">
      <div class="col-3">
        <div class="row align-items-center">
          <div class="col-3">
            <i class="fa-solid fa-music fa-2xl "></i>
          </div>
          <div class="col-6">
            <h6 class="p-0 m-0 small">SONG NAME HERE</h6>
            <p class="p-0 m-0 small">artist here</p>
          </div>
          <div class="col-3">
            <i class="fa-regular fa-heart text-light"></i>
          </div>
        </div>


      </div>
      <div class="col-6 text-center">
        <div class="d-flex justify-content-center">
          <i class="fa-solid fa-shuffle fa-lg mx-2"></i>
          <i class="fa-solid fa-backward-step fa-lg mx-2"></i>
          <i class="fa-solid fa-play fa-2xl mx-4"></i>
          <i class="fa-solid fa-forward-step fa-lg mx-2"></i>
          <i class="fa-solid fa-repeat fa-lg mx-2"></i>
        </div>
      </div>
      <div class="col-3 text-end">
        <i class="fa-solid fa-volume-high"></i>
        <input class="bg-" type="range" name="vol" id="vol" min="0" max="100">
      </div>
    </div>
  </div>
  <!--    </div>-->
</main>
</body>
</html>
