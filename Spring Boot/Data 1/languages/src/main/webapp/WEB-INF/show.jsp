<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 04-08-2021
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-end">
            <a class="btn btn-primary align-content-end w-25 d-block" href="/languages">Dashboard</a>
        </div>
        <div class="row">
            <div class="col-2">
                <p>Name</p>
                <p>Creator</p>
                <p>Version</p>
            </div>
            <div class="col-4">
                <p><c:out value="${language.name}"/></p>
                <p><c:out value="${language.creator}"/></p>
                <p><c:out value="${language.currentVersion}"/></p>
            </div>
        </div>
        <div class="row w-25">
            <div class="col"><a href="/languages/<c:out value="${language.id}"/>/edit" class="btn btn-primary w-auto">Edit</a></div>
            <div class="col">
                <form action="/languages/${language.id}" method="post" class="w-auto">
                    <input type="hidden" name="_method" value="delete">
                    <input class="btn btn-primary" type="submit" value="Delete">
                </form>
            </div>
        </div>
    </div>

</body>
</html>
