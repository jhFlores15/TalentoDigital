<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 22-08-2021
  Time: 13:59
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
    <title>Show Event</title>
</head>
<body>
    <div class="container">
        <h2>${event.name}</h2>
        <div class="row">
            <div class="col">
                <p>Host: <c:out value="${event.host.firstName} ${event.host.lastName}"/></p>
                <p>Date: <c:out value="${event.date}"/></p>
                <p>Location: <c:out value="${event.location.name}"/></p>
                <p>People who are attending this event: ${event.users.size()}</p>
                <table id="dtTable" class="display">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.firstName} ${user.lastName}</td>
                            <td>${user.location.name}</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <h3>Message Wall</h3>
                <div class="form-floating">
                    <%--@elvariable id="message" type="com.johfloresm.eventos.models.Message"--%>
                    <textarea class="form-control" style="height: 100px">
                         <c:forEach items="${messages}" var="message">
                             ${message.user.firstName} says: ${message.message}
                             --------------------------------------------
                         </c:forEach>
                    </textarea>
                </div>
                <form action="/events/${event.id}/addMessage" method="post">
                    <div class="form-floating">
                        <textarea class="form-control" name="message"></textarea>
                        <label>Add Comment</label>
                    </div>
                    <button type="submit">Add Comment</button>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
