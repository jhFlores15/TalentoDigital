<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 21-08-2021
  Time: 21:13
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
    <div class="container">
        <c:forEach begin="1" end="${totalPages}" var="index">
            <a href="/pages/${index}">${index}</a>
        </c:forEach>
        <table class="table" >
            <thead>
            <th>Dojo Name</th>
            <th>Ninja First Name</th>
            <th>Ninja Last Name</th>
            </thead>
            <tbody>
            <c:forEach var="row" items="${data.content}">
                <tr>
                    <td>${row[0].name}</td>
                    <td>${row[1].firstName}</td>
                    <td>${row[1].lastName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
