<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 10-08-2021
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
  <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
  <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
  <script src="/js/scripts.js"></script>
  <title>New License</title>
</head>
<body>
  <div class="container p-3">
    <div class="row mb-5 w-50">
      <%--@elvariable id="license" type="com.johfloresm.licenciamanejo.models.License"--%>
      <form:form action="/licenses" method="post" modelAttribute="license">

        <div class="mb-3">
          <form:label cssClass="form-label" path="person">person</form:label>
          <form:errors path="person"/>

          <form:select cssClass="form-control" path="person">
            <%--@elvariable id="person" type="com.johfloresm.licenciamanejo.models.Person"--%>
            <c:forEach items="${persons}" var="person">
              <form:option value="${person.id}">${person.firstName}</form:option>
            </c:forEach>

          </form:select>
        </div>
        <div class="mb-3">
          <form:label cssClass="form-label" path="state">state</form:label>
          <form:errors path="state"/>
          <form:input cssClass="form-control" path="state"/>
        </div>
        <div class="mb-3">
          <form:label cssClass="form-label" path="expirationDate">expirationDate</form:label>
          <form:errors path="expirationDate"/>
          <form:input type="date" cssClass="form-control" path="expirationDate"/>
        </div>
        <input type="submit"  class="btn btn-primary" value="Submit"/>
      </form:form>
    </div>
  </div>

</body>
</html>
