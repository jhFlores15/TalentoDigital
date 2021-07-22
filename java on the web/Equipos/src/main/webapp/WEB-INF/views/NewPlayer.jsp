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
	<h5><a href="Teams?id=<c:out value = "${idTeam}"/>">Volver al Team </a></h5>
		<% if(request.getAttribute("team") == null){%>
			<form  method="post">
				<h3>Crear Jugador</h3>
				<div class="mb-3">
					<label class="form-label">Nombre</label>
					<input type="text" class="form-control" name="name" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Apellido</label>
					<input type="text" class="form-control" name="lastName" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Edad</label>
					<input type="number" class="form-control" name="age" required>
					<input type="hidden" class="form-control" value="<c:out value = "${idTeam}"/>" name="idTeam" required>
				</div>
				<button type="submit" class="btn btn-primary" >Guardar</button>
			</form>
			
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