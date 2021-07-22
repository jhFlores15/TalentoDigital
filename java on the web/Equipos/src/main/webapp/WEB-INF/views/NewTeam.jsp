<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css"><font></font>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
    <title>Lista</title>
</head>
<body>
	
	<div class="row m-2 w-50 ">
		<h5><a href="Home">Volver a Home</a></h5>
		<% if(request.getAttribute("team") == null){%>
			<form  method="post">
		        <h3>Crear Equipo</h3>
		         <p>Nombre: </p>
		         <input type="text" class="form-control" name="name" >
				<button class="btn btn-primary w-25 mb-3" >Submit!</button>	
			</form>
			
		<%} %>
			
		
		<% if(request.getAttribute("team") != null){%>
			<div class="col ">
				<h2><c:out value = "${team.getName()}"/></h2>
				<a href="Players?id=<c:out value = "${team.getId()}"/>">Crear Jugadores</a>
				
				<table id="players" class="display">
				    <thead>
				        <tr>
				            <th>Nombre</th>
				            <th>Apellido</th>
				            <th>Edad</th>
				            <th>Acciones</th>
				        </tr>
				    </thead>
				    <tbody>
					    <c:forEach items="${team.getPlayers()}" var="player">
					    	<tr>
					    		<td><c:out value = "${player.getName()}"/></td>
					    		<td><c:out value = "${player.getLastName()}"/></td>
					    		<td><c:out value = "${player.getAge()}"/></td>
					    		<td>
					    			<a href="DeletePlayer?idTeam=<c:out value = "${team.getId()}"/>&idPlayer=<c:out value = "${player.getId()}"/>">Delete</a>
					    		</td>
					    	</tr>
			      		</c:forEach>
				    </tbody>
				</table>
				
			</div>
		<%} %>
		
		
		
	</div>
	
</body>
</html>
<style>
.red{
	color:red;
}
.green{
	color:green;
}
</style>
<script>
$(document).ready( function () {
	$('#teams').DataTable();
} );
</script>