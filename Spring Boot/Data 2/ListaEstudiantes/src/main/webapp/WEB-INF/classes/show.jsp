<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 15-08-2021
  Time: 21:31
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
    <title>Show Class</title>
</head>
<body>
    <div class="container">
        <h3><c:out value="${classs.name}"/></h3>
        <div class="row mt-4">
            <p class="">Students taking this class:</p>
            <table id="students" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${classs.students}" var="student">
                    <tr>
                        <td>${student.firstName}  ${student.lastName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>

</body>
</html>
