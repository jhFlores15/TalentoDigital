<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 11-08-2021
  Time: 19:33
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
</head>
<body>
  <div class="container">
    <div class="row mb-5">
       <div class="col"><a href="/persons/new">Crear Persona</a></div>
       <div class="col align-content-end"><a href="/licenses/new">Crear Licencia</a></div>
    </div>
    <div class="row">
      <table id="persons" class="display">
        <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>License</th>
          <th>State</th>
          <th>Expiration Date</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="person" type="com.johfloresm.licenciamanejo.models.Person"--%>
        <c:forEach items="${persons}" var="person">
          <tr>
            <td><a href="/persons/${person.id}">${person.firstName}</a></td>
            <td>${person.lastName}</td>
            <td>${person.license.number}</td>
            <td>${person.license.state}</td>
            <td>${person.license.expirationDate}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>
