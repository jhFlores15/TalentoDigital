<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 17-08-2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <title>New Question</title>
</head>
<body>
<div class="container p-3">
    <div class="row mb-5 w-50">
        <form action="/questions" method="post">
            <div class="mb-3">
                <label class="form-label">Question</label>
                <textarea type="text" class="form-control" name="question"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Tags</label>
                <input type="text" class="form-control" name="tags"/>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
