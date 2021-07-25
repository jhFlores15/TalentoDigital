<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 24-07-2021
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/5.0.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css" type="text/css">
    <script src="js/scripts.js" type="text/javascript"></script>
    <title>Date</title>
</head>
<body>
    <div class="container">
        <div class="row u-text-center u-mt200">
            <label class="u-color__dodgerblue u-font__lucida u-font-size__xxxlarge"><c:out value="${date}"/></label>
        </div>
    </div>
</body>
</html>
