<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 04-08-2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
  <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
  <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
<h1>New Book</h1>
  <div class="container">
    <form:form action="/books" method="post" modelAttribute="book">
      <div class="mb-3">
            <form:label cssClass="form-label" path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input cssClass="form-control" path="title"/>
      </div>
      <div class="mb-3">
        <form:label cssClass="form-label" path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea cssClass="form-control" path="description"/>
      </div>
      <div class="mb-3">
        <form:label cssClass="form-label" path="language">Language</form:label>
        <form:errors path="language"/>
        <form:input cssClass="form-control" path="language"/>
      </div>
      <div class="mb-3">
        <form:label cssClass="form-label" path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages"/>
        <form:input cssClass="form-control" type="number" path="numberOfPages"/>
      </div>
      <input type="submit"  class="btn btn-primary" value="Submit"/>
    </form:form>
  </div>
</body>
</html>
