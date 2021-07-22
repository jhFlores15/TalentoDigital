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
    <script src="../js/scripts.js"></script>
    <title>Lista</title>
</head>
<body>
	<div class="row m-2 w-50 ">
		<div class="col ">
			<h2>Lista de Equipos</h2>
			<a href="Teams">Crear Equipo</a>
			
			<table id="teams" class="display">
			    <thead>
			        <tr>
			            <th>Nombre</th>
			            <th>Jugadores</th>
			            <th>Acciones</th>
			        </tr>
			    </thead>
			    <tbody>
				    <c:forEach items="${teams}" var="team">
				    	<tr>
				    		<td><c:out value = "${team.getName()}"/></td>
				    		<td><c:out value = "${team.getPlayers().size()}"/></td>
				    		<td>
				    			<a href="Teams?id=<c:out value = "${team.getId()}"/>">Details</a>
				    			<a href="DeleteTeam?id=<c:out value = "${team.getId()}"/>">Delete</a>
				    		</td>
				    	</tr>
		      		</c:forEach>
			    </tbody>
			</table>
			
		</div>
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
$(document).ready( function () {<font></font>
	$('#teams').DataTable();<font></font>
} );
</script>