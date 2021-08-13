<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 12-08-2021
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Create Ninja</title>
</head>
<body>
    <div class="container p-3">
        <div class="row mb-5 w-50">
            <h4>New Ninja</h4>
            <%--@elvariable id="ninja" type="com.johfloresm.dojosninjas.models.Ninja"--%>
            <form:form action="/ninjas" method="post" modelAttribute="ninja">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="dojo">Student</form:label>
                    <form:errors path="dojo"/>
                    <form:select cssClass="form-select" path="dojo">
                        <%--@elvariable id="dojo" type="com.johfloresm.dojosninjas.models.Dojo"--%>
                        <c:forEach items="${dojos}" var="dojo">
                            <form:option value="${dojo.id}">${dojo.name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="firstName">firstName</form:label>
                    <form:errors path="firstName"/>
                    <form:input cssClass="form-control" path="firstName"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="lastName">lastName</form:label>
                    <form:errors path="lastName"/>
                    <form:input cssClass="form-control" path="lastName"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="age">Age</form:label>
                    <form:errors path="age"/>
                    <form:input type="number" cssClass="form-control" path="age"/>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>

</body>
</html>
