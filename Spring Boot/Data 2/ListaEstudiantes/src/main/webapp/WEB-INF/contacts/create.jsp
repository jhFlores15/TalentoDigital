<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 11-08-2021
  Time: 22:57
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
    <div class="container p-3">
        <div class="row mb-5 w-50">
            <%--@elvariable id="contact" type="com.johfloresm.listaestudiantes.models.Contact"--%>
            <form:form action="/contacts" method="post" modelAttribute="contact">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="student">Student</form:label>
                    <form:errors path="student"/>
                    <form:select cssClass="form-select" path="student">
                        <%--@elvariable id="student" type="com.johfloresm.listaestudiantes.models.Student"--%>
                        <c:forEach items="${students}" var="student">
                            <form:option value="${student.id}">${student.firstName} ${student.lastName}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="address">Address</form:label>
                    <form:errors path="address"/>
                    <form:input cssClass="form-control" path="address"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="city">City</form:label>
                    <form:errors path="city"/>
                    <form:input cssClass="form-control" path="city"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="state">State</form:label>
                    <form:errors path="state"/>
                    <form:input  cssClass="form-control" path="state"/>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>

</body>
</html>
