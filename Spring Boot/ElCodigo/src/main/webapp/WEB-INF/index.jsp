<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 26-07-2021
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="webjars/bootstrap/5.0.1/css/bootstrap.min.css">
  <title>Title</title>
</head>
<body>
  <div class="container text-center">
    <h2 class="text-danger"><c:out value="${error}"/></h2>
    <h3>What is the code?</h3>
    <form action="" method="post">
      <input type="text" class="form-control w-25 me-auto ms-auto" name="code">
      <button class="btn btn-primary">Try code</button>
    </form>
  </div>
</body>
</html>
