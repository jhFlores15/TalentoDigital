<%--
  Created by IntelliJ IDEA.
  User: johfl
  Date: 25-09-2021
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="\webjars\bootstrap\5.0.1\css\bootstrap.min.css">
    <script src="\webjars\bootstrap\5.0.1\js\bootstrap.min.js"></script>
    <script src="\webjars\jquery\3.6.0\jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
    <script src="\js\scripts.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <form class="row gx-3 gy-2 align-items-center">
                <div class="col-sm-3">
                    <%--@elvariable id="item" type="com.johfloresm.homeflix.models.Category"--%>
                    <label class="form-label" for="">Categoría</label>
                    <select class="form-select"  name="idCategory">
                        <option
                                <c:if test="${category == null}">
                                    selected
                                </c:if>
                        ></option>
                            <c:forEach items="${categories}" var="item">
                                <option
                                <c:if test="${category != null && (category.category_id == item.category_id)}">
                                    selected
                                </c:if>
                                        value="${item.category_id}">${item.name}</option>
                            </c:forEach>
                    </select>
                </div>
                <div class="col-sm-3">
                    <label class="form-label" for="">Título</label>
                    <input type="text" class="form-control" id="" name="title"

                        <c:if test="${title != null}">
                           value = "${title}"
                        </c:if>
                           placeholder="Ingrese título...">
                </div>
                <div class="col-auto">
                    <label class="form-label" for="">&nbsp;</label>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
            </form>
        </div>
        <div class="row">
            <%--@elvariable id="film" type="com.johfloresm.homeflix.models.Film"--%>
            <table id="dt" class="display">
                <thead>
                <tr>
                    <th>Categoría</th>
                    <th>Id Film</th>
                    <th>Titulo</th>
                    <th>Duración</th>
                    <th>Rating</th>
                    <th>Precio</th>
                    <th>Duración Arriendo</th>
                    <th>Acción</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${films}" var="film">
                    <tr>
                        <td>${film.categories[0].name}</td>
                        <td>${film.film_id}</td>
                        <td>${film.title}</td>
                        <td>${film.length}</td>
                        <td>${film.rating}</td>
                        <td>${film.rental_rate}</td>
                        <td>${film.rental_duration}</td>
                        <td>
                            <button class="btn btn-primary">Ver</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
