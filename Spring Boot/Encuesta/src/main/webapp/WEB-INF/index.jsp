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
    <form action="/" method="post">
        <form>
            <div class="mb-3">
                <label class="form-label">Your Name</label>
                <input type="text" class="form-control" name="name" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Dojo Location</label>
                <select class="form-select" name="location" required>
                    <option></option>
                    <c:forEach items="${locations}" var="item">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Favorite Language</label>
                <select class="form-select" name="language" required>
                    <option></option>
                    <c:forEach items="${languages}" var="item">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Comment (optional):</label>
                <textarea class="form-control" name="comment"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </form>
</div>

</body>
</html>
