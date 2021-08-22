<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

  <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
  <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
  <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
  <script src="/js/scripts.js"></script>
  <link rel="stylesheet" href="/css/styles.css">
  <title>Home</title>
</head>
<body>
<div class="container">
  <h2>Welcome</h2>
  <div class="row">
    <p class="color-red bold"><c:out value="${error}" /></p>
      <div class="col me-3">
        <h3>Register</h3>
        <%--@elvariable id="user" type="com.johfloresm.eventos.models.User"--%>
        <form:form action="/registration" method="post" modelAttribute="user">
          <div class="mb-3">
            <form:label cssClass="form-label" path="firstName">First Name</form:label>
            <form:errors path="firstName"/>
            <form:input cssClass="form-control" path="firstName"/>
          </div>
          <div class="mb-3">
            <form:label cssClass="form-label" path="lastName">Last Name</form:label>
            <form:errors path="lastName"/>
            <form:input cssClass="form-control" path="lastName"/>
          </div>
          <div class="mb-3">
            <form:label cssClass="form-label" path="email">Email</form:label>
            <form:errors path="email"/>
            <form:input cssClass="form-control" path="email"/>
          </div>

          <div class="mb-3">
            <label class="form-label">Location</label>
            <input class="form-control" type="text" name="locationStr">

          </div>
          <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="state">
            <option selected>Select the State</option>
              <%--@elvariable id="state" type="com.johfloresm.eventos.models.State"--%>
            <c:forEach items="${states}" var="state">
              <option value="${state.id}">${state.name}</option>
            </c:forEach>
          </select>

          <div class="mb-3">
            <form:label cssClass="form-label" path="password">Password:</form:label>
            <form:errors path="password"/>
            <form:password cssClass="form-control" path="password"/>
          </div>
          <div class="mb-3">
            <form:label cssClass="form-label" path="passwordConfirmation">Password Confirmation:</form:label>
            <form:errors path="passwordConfirmation"/>
            <form:password cssClass="form-control" path="passwordConfirmation"/>
          </div>
          <input type="submit"  class="btn btn-primary" value="Register!"/>
        </form:form>
      </div>
      <div class="col ms-3">
        <h3>Login</h3>
        <form action="/login" method="post">
          <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email">
          </div>
          <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="password" class="form-control" name="password">
          </div>
          <button type="submit" class="btn btn-primary">Login!</button>
        </form>
      </div>
  </div>
</div>


</body>
</html>