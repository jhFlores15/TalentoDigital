<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 27-07-2021
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/5.0.1/css/bootstrap.min.css">
    <title>Dojo Survey Index</title>
</head>
<body>
    <div class="container">
        <div class="card w-50" >
            <div class="card-body">
                <h5 class="card-title">Submited info</h5>
                <div class="row">
                    <div class="col">
                        <h6>Name:</h6>
                        <h6>Dojo location:</h6>
                        <h6>Favorite Language:</h6>
                        <h6>Comment:</h6>
                    </div>
                    <div class="col">
                        <h6><c:out value="${session.getAttribute('name')}" /></h6>
                        <h6><c:out value="${session.getAttribute('location')}" /></h6>
                        <h6><c:out value="${session.getAttribute('language')}" /></h6>
                        <h6><c:out value="${session.getAttribute('comment')}" /></h6>
                    </div>
                </div>
                <a href="/" class="btn btn-primary">Go to Home</a>
            </div>
        </div>
    </div>

</body>
</html>
