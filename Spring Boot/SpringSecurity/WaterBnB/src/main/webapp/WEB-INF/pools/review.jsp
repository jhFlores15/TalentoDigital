<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 22-08-2021
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>WaterBnB</title>
</head>
<body>
    <div class="container">
        <div class="row float-end">
            <a href="/">Home</a>
            <a href="/logout">Logout!</a>
        </div>
        <%--@elvariable id="rating" type="com.johfloresm.waterbnb.models.Rating"--%>
        <%--@elvariable id="pool" type="com.johfloresm.waterbnb.models.Pool"--%>
        <h4>Review of ${pool.address}</h4>

        <div class="row">
            <form  action="/pools/${pool.id}/review" method="post" >
                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <textarea type="text" class="form-control" name="description"></textarea>
                </div>
                <div class="mb-3">
                    <label class="form-label">Rating</label>
                    <select name="rating" class="form-select">
                        <c:forEach items="${ratings}" var="rating">
                            <option value="${rating}">${rating}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit Review"/>
            </form>


        </div>
    </div>

</body>
</html>
