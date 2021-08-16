<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 15-08-2021
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
    <script src="/js/scripts.js"></script>
    <title>Show Student</title>
</head>
<body>
    <div class="container">
        <%--@elvariable id="student" type="com.johfloresm.listaestudiantes.models.Student"--%>
        <h4><c:out value="${student.firstName}  ${student.lastName}"/></h4>
        <div class="row">
            <form action="/students/<c:out value="${student.id}"/>" method="post" class="w-50">
                <div class="col">
                    <select class="form-select" aria-label=".form-select-lg example" name="classId">
                        <option selected>Select the Class</option>
                        <%--@elvariable id="clas" type="com.johfloresm.listaestudiantes.models.Class"--%>
                        <c:forEach items="${classes}" var="clas">
                            <option value="${clas.id}">${clas.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col"><button type="submit" class="btn btn-primary">Add</button></div>
            </form>
        </div>
        <h4>Your Schedule</h4>
        <div class="row mb-5 w-50">
            <h4>Students</h4>
            <table id="students" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="clas" type="com.johfloresm.listaestudiantes.models.Class"--%>
                <c:forEach items="${student.classes}" var="clas">
                    <tr>
                        <td>${clas.name}</td>
                        <td>
                            <form action="/students/<c:out value="${student.id}"/>/remove" method="post">
                                <input type="number" hidden value="${clas.id}" name="classId">
                                <button class="btn btn-danger" type="submit">Drop</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</body>
</html>
