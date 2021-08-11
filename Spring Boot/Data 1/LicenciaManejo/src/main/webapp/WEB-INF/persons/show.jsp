<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 10-08-2021
  Time: 22:40
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
    <div class="container">
        <div class="row w-50">
            <%--@elvariable id="person" type="com.johfloresm.licenciamanejo.models.Person"--%>
            <h4><c:out value="${person.firstName}  ${person.lastName}"/></h4>

            <div class="row">
                <div class="col">
                    <p>License Number</p>
                    <p>State</p>
                    <p>Expiration Date</p>
                </div>
                <div class="col">
                    <p><c:out value="${person.license.number}"/></p>
                    <p><c:out value="${person.license.state}"/></p>
                    <p><c:out value="${person.license.expirationDate}"/></p>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
