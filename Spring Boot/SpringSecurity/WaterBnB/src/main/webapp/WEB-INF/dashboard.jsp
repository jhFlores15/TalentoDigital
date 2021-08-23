<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 22-08-2021
  Time: 21:35
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
    <title>WaterBnB</title>
</head>
<body>
    <div class="container">
        <div class="row ">
            <div class="col float-start">Currents Listings</div>
            <div class="col float-end"><a href="/logout">Logout!</a></div>
            <div class="row mb-5 w-80">
                <table id="dtTable" class="display">
                    <thead>
                    <tr>
                        <th>Address</th>
                        <th>Pool Size</th>
                        <th>Cost per Nigth</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%--@elvariable id="pool" type="com.johfloresm.waterbnb.models.Pool"--%>
                    <c:forEach items="${pools}" var="pool">
                        <tr>
                            <td>${pool.address}</td>
                            <td>${pool.size.name}</td>
                            <td>$${pool.cost_per_nigth}</td>
                            <td><a href="/pools/${pool.id}/edit">Edit</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="row mb-5 w-50">
                <h4>New Listing</h4>
                <%--@elvariable id="pool" type="com.johfloresm.waterbnb.models.Pool"--%>
                <form:form action="/pool" method="post" modelAttribute="pool">
                    <div class="mb-3">
                        <form:label cssClass="form-label" path="address">Address</form:label>
                        <form:errors path="address"/>
                        <form:input cssClass="form-control" path="address"/>
                    </div>
                    <div class="mb-3">
                        <form:label cssClass="form-label" path="description">Description</form:label>
                        <form:errors path="description"/>
                        <form:textarea cssClass="form-control" path="description"/>
                    </div>
                    <div class="mb-3">
                        <form:label cssClass="form-label" path="cost_per_nigth">Cost per nigth</form:label>
                        <form:errors path="cost_per_nigth"/>
                        <form:input type="number" cssClass="form-control" path="cost_per_nigth"/>
                    </div>
                    <div class="mb-3">
                        <form:label cssClass="form-label" path="size">Pool Size</form:label>
                        <form:errors path="size"/>
                        <form:select cssClass="form-select" path="size">
                            <%--@elvariable id="size" type="com.johfloresm.waterbnb.models.Size"--%>
                            <c:forEach items="${sizes}" var="size">
                                <form:option value="${size.id}">${size.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <input type="submit"  class="btn btn-primary" value="Submit"/>
                </form:form>
            </div>

        </div>
    </div>

</body>
</html>
