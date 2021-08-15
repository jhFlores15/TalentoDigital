<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 15-08-2021
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Show Category</title>
</head>
<body>
    <div class="container">
        <%--@elvariable id="category" type="com.johfloresm.productoscategorias.models.Category"--%>
        <h4><c:out value="${category.name}"/></h4>
        <div class="row">
            <div class="col">
                <h6>Products:</h6>
                <ul>
                    <c:forEach items="${category.products}" var="product">
                        <li>${product.name}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col">
                <form action="/categories/<c:out value="${category.id}"/>" method="post">
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idProduct">
                        <option selected>Select the Product</option>
                        <%--@elvariable id="product" type="com.johfloresm.productoscategorias.models.Product"--%>
                        <c:forEach items="${products}" var="product">
                            <option value="${product.id}">${product.name}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form>
            </div>
        </div>

    </div>

</body>
</html>
