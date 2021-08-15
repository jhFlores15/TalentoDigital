<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 15-08-2021
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Show Product</title>
</head>
<body>
<div class="container">
    <%--@elvariable id="product" type="com.johfloresm.productoscategorias.models.Product"--%>
    <h4><c:out value="${product.name}"/></h4>
    <div class="row">
        <div class="col">
            <h6>Categories:</h6>
            <ul>
                <c:forEach items="${product.categories}" var="category">
                    <li>${category.name}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="col">
            <form action="/products/<c:out value="${product.id}"/>" method="post">
                <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idCategory">
                    <option selected>Select the Category</option>
                    <%--@elvariable id="category" type="com.johfloresm.productoscategorias.models.Category"--%>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>

</div>

</body>
</html>