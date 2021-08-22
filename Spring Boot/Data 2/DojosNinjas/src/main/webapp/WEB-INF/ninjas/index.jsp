<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 21-08-2021
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="ninjas">
        <h1>Ninjas</h1>

        // for loop to create all the links
        <c:forEach begin="1" end="${totalPages}" var="index">
            <a href="/ninjas/pages/${index}">${index}</a>
        </c:forEach>
        <table class="table">
            <thead>
            <th>First Name</th>
            <th>Last Name</th>
            </thead>
            <tbody>
            <c:forEach var="ninja" items="${ninjas.content}">
                <tr>
                    <td><c:out value="${ninja.firstName}"></c:out></td>
                    <td><c:out value="${ninja.lastName}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
