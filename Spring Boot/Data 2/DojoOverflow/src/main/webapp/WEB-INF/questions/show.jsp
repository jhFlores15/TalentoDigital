<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 18-08-2021
  Time: 18:33
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
    <title>Show Question</title>
</head>
<body>
    <div class="container">
        <h4><c:out value="${question.question}"/></h4>
        <div class="row">
            <div class="col-1">Tags</div>
            <c:forEach items="${question.tags}" var="tag">
                <div class="col-1">${tag.subject}</div>
            </c:forEach>
        </div>
        <div class="row ">
            <div class="col">
                <h4>Songs</h4>
                <table id="dtTable" class="display">
                    <thead>
                    <tr>
                        <th>Answers</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${question.answers}" var="answer">
                        <tr>
                            <td>${answer.answer}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <h4>Add your Answers</h4>
                <form:form action="/questions/${question.id}/addAnswer" method="post" modelAttribute="answer">
                    <div class="mb-3">
                        <form:label cssClass="form-label" path="answer">Answer</form:label>
                        <form:errors path="answer"/>
                        <form:textarea cssClass="form-control" path="answer"/>
                    </div>
                    <input type="submit"  class="btn btn-primary" value="Submit"/>
                </form:form>
            </div>

        </div>
    </div>


</body>
</html>
