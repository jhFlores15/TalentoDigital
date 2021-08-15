<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 15-08-2021
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Create Product</title>
</head>
<body>
    <div class="container p-3">
        <div class="row mb-5 w-50">
            <%--@elvariable id="product" type="com.johfloresm.productoscategorias.models.Product"--%>
            <form:form action="/products" method="post" modelAttribute="product">
                <div class="mb-3">
                    <form:label cssClass="form-label" path="name">Name</form:label>
                    <form:errors path="name"/>
                    <form:input cssClass="form-control" path="name"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="description">Description</form:label>
                    <form:errors path="description"/>
                    <form:input cssClass="form-control" path="description"/>
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="price">Price</form:label>
                    <form:errors path="price"/>
                    <form:input type="number" cssClass="form-control" path="price"/>
                </div>
                <input type="submit"  class="btn btn-primary" value="Submit"/>
            </form:form>
        </div>
    </div>
</body>
</html>
