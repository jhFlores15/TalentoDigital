<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 07-08-2021
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-end">
            <a href="/dashboard">Dashboard</a>
        </div>
        <div class="row">
            <div class="col">
                <p>Title: </p>
                <p>Artist: </p>
                <p>Ranting (1-10): </p>
            </div>
            <div class="col">
                <p><c:out value="${song.title}" /></p>
                <p><c:out value="${song.artist}" /></p>
                <p><c:out value="${song.rating}" /></p>
            </div>
        </div>
        <div class="row">
            <form class="d-inline" action="/songs/${song.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input class="btn btn-primary" type="submit" value="Delete">
            </form>
        </div>

    </div>

</body>
</html>
