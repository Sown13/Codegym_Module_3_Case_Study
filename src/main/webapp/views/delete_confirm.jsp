<%--
  Created by IntelliJ IDEA.
  User: Hải Sơn
  Date: 5/27/2023
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> Bạn thực sự muốn xóa playlist này chứ?</p>
<form action="playlists" method="post">
    <input type="hidden" name="playlistID" value="${requestScope.playlistID}">
    <button type="submit" name="choice" value="delete">Yes</button>
</form>
<form action="playlists" method="post">
    <button type="submit" name="choice" value="">No</button>
</form>

</body>
</html>
