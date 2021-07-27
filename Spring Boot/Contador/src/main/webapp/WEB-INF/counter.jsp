<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 26-07-2021
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/5.0.1/css/bootstrap.min.css">
    <title>Current visit count</title>
</head>
<body>
    <div class="row text-center">
        <h3>You have visited <a href="/">Welcome</a>  <c:out value="${counter}"/> times.</h3>
        <a href="/">Test another visit?</a>
    </div>
</body>
</html>
