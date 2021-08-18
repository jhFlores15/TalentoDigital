<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 16-08-2021
  Time: 20:33
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
    <title>Questions</title>
</head>
<body>
    <div class="container p-3">
        <div class="row mb-5 w-50">
            <h4>Songs</h4>
            <table id="dtTable" class="display">
                <thead>
                <tr>
                    <th>Question</th>
                    <th>Tags</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${questions}" var="question">
                    <tr>
                        <td><a href="/questions/${question.id}">${question.question}</a></td>
                        <td>${question.getTagsComma()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
