<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 20-08-2021
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <title>Dashboard</title>
</head>
<body>
    <div class="container">
        <form id="logoutForm" method="POST" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout!" />
        </form>

        <h3>Welcome <c:out value="${user.username}"/></h3>
        <div class="row w-50">
            <div class="col">
                <p>Username</p>
                <p>First Name</p>
                <p>Last Name</p>
                <p>Email</p>
            </div>
            <div class="col">
                <p><c:out value="${user.username}"/></p>
                <p><c:out value="${user.firstName}"/></p>
                <p><c:out value="${user.lastName}"/></p>
                <p><c:out value="${user.email}"/></p>
            </div>
        </div>

    </div>

</body>
</html>
