<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 21-08-2021
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

  <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
  <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
  <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
  <meta charset="UTF-8">
  <title>Welcome</title>
</head>
<body>
<h1>Welcome, <c:out value="${user.email}" /></h1>
<a href="/logout">Logout</a>
</body>
</html>