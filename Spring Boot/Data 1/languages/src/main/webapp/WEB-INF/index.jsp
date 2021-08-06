<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 04-08-2021
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
</head>
<body>
    <div class="container p-3">
        <div class="row mb-5 w-50">
            <h4>Languages</h4>
            <table id="languages" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Creator</th>
                    <th>Version</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${languages}" var="language">
                    <tr>
                        <td><a href="/languages/${language.id}">${language.name}</a></td>
                        <td>${language.creator}</td>
                        <td>${language.currentVersion}</td>
                        <td>
                            <form class="d-inline" action="/languages/${language.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input class="btn btn-primary" type="submit" value="Delete">
                            </form>
                            <a href="/languages/${language.id}/edit" class="btn btn-primary">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row w-50">
            <form:form action="/languages" method="post" modelAttribute="language">
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
<script>
    $(document).ready( function () {
        $('#languages').DataTable();
    } );
</script>
