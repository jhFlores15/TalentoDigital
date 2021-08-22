<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Events</title>
</head>
<body>
<%--@elvariable id="user" type="com.johfloresm.eventos.models.User"--%>

    <div class="container">
        <h3>Welcome, <c:out value="${user.firstName}  ${user.lastName}"/></h3>
        <div class="row mb-5 w-80">
            <h6>Here are some of the events in your state</h6>
            <table id="dtTable" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${eventsState}" var="event">
                    <tr>
                        <td><a href="/events/${event.id}">${event.name}</a></td>
                        <td>${event.date}</td>
                        <td>${event.location.name}</td>
                        <td>${event.host.firstName}</td>
                        <td>
                            <c:if test="${user.id != event.host.id && user.events.contains(event)}">
                                Joining
                                <a href="/events/${event.id}/join/cancel">Cancel</a>
                            </c:if>
                            <c:if test="${user.id != event.host.id && !user.events.contains(event)}">
                                <a href="/events/${event.id}/join">Join</a>
                            </c:if>
                            <c:if test="${user.id == event.host.id}">
                                <a href="/events/${event.id}/edit">Edit</a>
                                <a href="/events/${event.id}/delete">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row mb-5 w-80">
            <h6>Here are some of the events in other states</h6>
            <table id="dtTable2" class="display">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${eventsNotState}" var="event">
                    <tr>
                        <td><a href="/events/${event.id}">${event.name}</a></td>
                        <td>${event.date}</td>
                        <td>${event.location.name}</td>
                        <td>${event.host.firstName}</td>
                        <td>
                            <c:if test="${user.id != event.host.id && user.events.contains(event)}">
                                Joining
                                <a href="/events/${event.id}/join/cancel">Cancel</a>
                            </c:if>
                            <c:if test="${user.id != event.host.id && !user.events.contains(event)}">
                                <a href="/events/${event.id}/join">Join</a>
                            </c:if>
                            <c:if test="${user.id == event.host.id}">
                                <a href="/events/${event.id}/edit">Edit</a>
                                <a href="/events/${event.id}/delete">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row w-50">
            <h5>Create an Event</h5>
            <form:form action="/events" method="post" modelAttribute="event">
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
                            <input class="form-control" type="text" name="locationStr">

                        </div>
                    </div>
                    <div class="col">
                        <label class="form-label">State</label>
                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="stateId">
                                <%--@elvariable id="state" type="com.johfloresm.eventos.models.State"--%>
                            <c:forEach items="${states}" var="state">
                                <option value="${state.id}">${state.name}</option>
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
