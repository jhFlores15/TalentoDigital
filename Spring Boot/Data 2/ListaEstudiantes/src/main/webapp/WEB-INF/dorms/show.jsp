<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 14-08-2021
  Time: 20:41
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
    <title>Title</title>
</head>
<body>
    <div class="container p-3">
        <div class="row mb-5">
        </div>
        <div class="row mb-5 w-50">
            <h4><c:out value="${dormitory.name}"/> Dormitory</h4>
            <form action="/dorms/<c:out value="${dormitory.id}"/>" method="post">
                <select name="student" class="form-select" id="">
                    <%--@elvariable id="student" type="com.johfloresm.listaestudiantes.models.Student"--%>
                    <c:forEach items="${students}" var="student">
                        <option value="${student.id}">${student.firstName} ${student.lastName}</option>
                    </c:forEach>
                </select>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form>
            <table id="students" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="student" type="com.johfloresm.listaestudiantes.models.Student"--%>
                <%--@elvariable id="dormitory" type="com.johfloresm.listaestudiantes.models.Dormitory"--%>
                <c:forEach items="${dormitory.student}" var="student">
                    <tr>
                        <td>${student.firstName} ${student.lastName}</td>
                        <td>${student.age}</td>
                        <td>${student.contact.address}</td>
                        <td>${student.contact.city}</td>
                        <td>${student.contact.state}</td>
                        <td>
                            <form class="d-inline" action="/dorms/${dormitory.id}/remove/${student.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input class="btn btn-primary" type="submit" value="Delete">
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
