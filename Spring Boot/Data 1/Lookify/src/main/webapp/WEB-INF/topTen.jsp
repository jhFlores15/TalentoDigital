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
        <div class="row">
            <div class="col">
                <h3 class="">Top Ten Songs:</h3>
            </div>
            <div class="col justify-content-end">
                <a class="align-content-end  w-25 d-block" href="/dashboard">Dashboard</a>
            </div>
        </div>
        <div class="row">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <c:forEach items="${songs}" var="song">
                        <p>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p> </li>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
