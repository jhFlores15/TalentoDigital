<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 22-08-2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Edit</title>
</head>
<body>
    <div class="container">
        <h2><c:out value="${event.name}"/></h2>
        <%--@elvariable id="event" type="com.johfloresm.eventos.models.Event"--%>
        <div class="row w-50">
            <h5>Edit Event</h5>
            <form:form action="/events/${event.id}" method="post" modelAttribute="event">
                <input type="hidden" name="_method" value="put">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="name">Name</form:label>
                    <form:errors path="name"/>
                    <form:input cssClass="form-control required" path="name" />
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="date">Date</form:label>
                    <form:errors path="date"/>
                    <form:input cssClass="form-control" type="date" path="date"/>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="mb-3">
                            <label class="form-label">Location</label>
                            <input class="form-control" type="text" name="locationStr" value="<c:out value="${event.location.name}"/>">

                        </div>
                    </div>
                    <div class="col">
                        <label class="form-label">State</label>
                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="stateId">
                                <%--@elvariable id="state" type="com.johfloresm.eventos.models.State"--%>
                            <c:forEach items="${states}" var="state">
                                <c:if test="${event.location.state.id == state.id}">
                                    <option selected value="${state.id}">${state.name}</option>
                                </c:if>
                                <c:if test="${event.location.state.id != state.id}">
                                    <option value="${state.id}">${state.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>

</body>
</html>
