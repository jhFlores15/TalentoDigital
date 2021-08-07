<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 07-08-2021
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="row w-80">
            <form:form action="/songs" method="post" modelAttribute="song">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="title">Title</form:label>
                    <form:errors path="title"/>
                    <form:input cssClass="form-control" path="title"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="artist">Artist</form:label>
                    <form:errors path="artist"/>
                    <form:input cssClass="form-control" path="artist"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="rating">Rating</form:label>
                    <form:errors path="rating"/>
                    <form:input type="number" cssClass="form-control" path="rating"/>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>

</body>
</html>
