<%--
  Created by IntelliJ IDEA.
  User: namnh
  Date: 5/24/2023
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row align-items-center">
    <div class="col-6 search-box">
        <div class="form ms-5">
            <svg class="fa fa-search" width="16" height="16"><use xlink:href="#search-fill"/></svg>
            <input type="text" class="form-control form-input" placeholder="Search anything...">
        </div>
    </div>
    <div class="col-6">
        <c:choose>
        <c:when test="${sessionScope['loginUser'] == null}">
            <a href="/home?choice=loginForm">
                <i class="fa-solid fa-circle-user fa-2xl float-end text-warning" role="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Login"></i>
            </a>
        </c:when>
        <c:when test="${sessionScope['loginUser'] != null}">
<%--            <p class="text-white"> hien len neu co user</p>--%>
<%--            <i class="fa-solid fa-circle-user fa-2xl float-end text-warning" role="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Tooltip on left"></i>--%>
            <p class="text-end m-0" style="color: limegreen">Xin chào <c:out value="${sessionScope['loginUser'].fullname}"/></p>
            <a href="/home?choice=logout" class="text-end float-end">Logout</a>
        </c:when>
        </c:choose>

    </div>
</div>
</body>
</html>
