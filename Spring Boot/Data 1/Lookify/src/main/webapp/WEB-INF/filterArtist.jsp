<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 07-08-2021
  Time: 15:33
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
  <title>Title</title>
</head>
<body>
  <div class="container p-3">
    <div class="row">
      <div class="col-6"><p>Songs by artist: <c:out value="${artist}"/></p></div>
      <div class="col">
        <form class="row g-3" onsubmit="return false">
          <div class="col-auto">
            <input type="text" class="form-control" id="artist" value="<c:out value="${artist}"/>" placeholder="">
          </div>
          <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3" onclick="searchArtist()" >Search Artist</button>
          </div>
        </form>
      </div>
      <div class="col"><a href="/dashboard">Dashboard</a></div>
    </div>
    <div class="row mb-5 w-80">
      <h4>Songs</h4>
      <table id="songs" class="display">
        <thead>
        <tr>
          <th>Name</th>
          <th>Rating</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
          <tr>
            <td><a href="/songs/${song.id}">${song.title}</a></td>
            <td>${song.rating}</td>
            <td>
              <form class="d-inline" action="/songs/${song.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input class="btn btn-primary" type="submit" value="Delete">
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  </div>
</body>
</html>
