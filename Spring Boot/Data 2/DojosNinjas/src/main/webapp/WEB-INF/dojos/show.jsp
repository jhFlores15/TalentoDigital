<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 12-08-2021
  Time: 20:37
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
    <title>Show Dojo</title>
</head>
<body>
    <div class="container p-3">
        <div class="row mb-5">
            <div class="row mb-5 w-50">
                <h4><c:out value="${dojo.name}" /> Ninjas</h4>
                <table id="ninjas" class="display">
                    <thead>
                    <tr>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Age</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%--@elvariable id="ninja" type="com.johfloresm.dojosninjas.models.Ninja"--%>
                    <%--@elvariable id="dojo" type="com.johfloresm.dojosninjas.models.Dojo"--%>
                    <c:forEach items="${dojo.ninjas}" var="ninja">
                        <tr>
                            <td>${ninja.firstName}</td>
                            <td>${ninja.lastName}</td>
                            <td>${ninja.age}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
