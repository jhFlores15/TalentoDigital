<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 27-07-2021
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/5.0.1/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/5.0.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/styles.css">
    <title>Game Ninja</title>
</head>
<body>
    <div class="container p-3">
        <div class="row">
            <div class="row">
                <div class="col-2"> <h3> Your Gold</h3></div>
                <div class="col-3"><input type="text" class="form-control w-25" readonly value="<c:out value='${ninja.getGold()}'/>"></div>
                <div class="col text-end">
                    <form action="/reset" method="post"><button class="btn btn-primary">Reset</button></form>
                </div>
            </div>

        </div>

        <div class="row text-center">
            <div class="col">
                <form action="/farm" method="post">
                    <h5>Farm</h5>
                    <p>(earns 10-20 gold)</p>
                    <button class="btn btn-primary">Find Gold!</button>
                </form>
            </div>
            <div class="col">
                <form action="/cave" method="post">
                    <h5>Cave</h5>
                    <p>(earns 5-10 gold)</p>
                    <button class="btn btn-primary">Find Gold!</button>
                </form>
            </div>
            <div class="col">
                <form action="/house" method="post">
                    <h5>House</h5>
                    <p>(earns 2-5 gold)</p>
                    <button class="btn btn-primary">Find Gold!</button>
                </form>
            </div>
            <div class="col">
                <form action="/casino" method="post">
                    <h5>Casino</h5>
                    <p>(earns/takes 0-50 gold)</p>
                    <button class="btn btn-primary">Find Gold!</button>
                </form>
            </div>
            <div class="col">
                <form action="/spa" method="post">
                    <h5>Spa</h5>
                    <p>(takes 5-20 gold)</p>
                    <button class="btn btn-primary">Find Gold!</button>
                </form>
            </div>
        </div>

        <h4>Activities:</h4>
        <div class="overflow-auto p-3 mb-3 mb-md-0 mr-md-3 bg-light w-85 mh-100">
            <c:forEach items="${ninja.getActivities()}" var="activity">
               <p class=" bold
                <c:if test="${activity.getAmount() >= 0}">
                    colorGreen
                </c:if>
                <c:if test="${activity.getAmount() < 0}">
                    colorRed
                </c:if>
                ">${activity.getDetails()}</p>
            </c:forEach>
        </div>

    </div>

</body>
</html>
