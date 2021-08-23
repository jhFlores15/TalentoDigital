<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <script src="/js/scripts.js"></script>
    <title>WaterBnB</title>
</head>
<body>
    <div class="container">
        <div class="row float-end">
            <c:if test="${user == null}">
                <a class="" href="/guest/signing">Signing/Signup</a>
            </c:if>
            <c:if test="${user != null}">
                <a class="align-content-end"  href="/logout">Logout!</a>
            </c:if>
        </div>
        <div class="row mt3">
            <h3>Find Places to swim and sleep on water bnb!</h3>
            <div class="col-auto">
                <input type="text" class="form-control" id="address">
            </div>
            <div class="col-auto">
                <button type="button" class="btn btn-primary mb-3" onclick="searchPoolByAddress()">Search</button>
            </div>
        </div>
    </div>
</body>
</html>