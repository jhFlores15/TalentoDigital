<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 11-08-2021
  Time: 22:57
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
    <div class="container p-3">
        <div class="row mb-5 w-50">
            <form:form action="/students" method="post" modelAttribute="student">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="firstName">firstName</form:label>
                    <form:errors path="firstName"/>
                    <form:input cssClass="form-control" path="firstName"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="lastName">lastName</form:label>
                    <form:errors path="lastName"/>
                    <form:input cssClass="form-control" path="lastName"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="age">Age</form:label>
                    <form:errors path="age"/>
                    <form:input type="number" cssClass="form-control" path="age"/>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>

</body>
</html>
