<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 04-08-2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
</head>
<body>
<%@ page isErrorPage="true" %>
    <div class="container">
        <div class="row w-50">
            <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
                <input type="hidden" name="_method" value="put">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="name">Name</form:label>
                    <form:errors path="name"/>
                    <form:input cssClass="form-control" path="name"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="creator">Creator</form:label>
                    <form:errors path="creator"/>
                    <form:input cssClass="form-control" path="creator"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="currentVersion">Version</form:label>
                    <form:errors path="currentVersion"/>
                    <form:input cssClass="form-control" path="currentVersion"/>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>
</body>
</html>
