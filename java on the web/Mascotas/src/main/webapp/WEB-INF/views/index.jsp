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
    <script src="../js/scripts.js"></script>
    <title>Home</title>
</head>
<body>
	<div class="row m-2">
		<div class="col-3">
			<form onsubmit="createDog();">
				<h3>Crear Perro</h3>
				<div class="mb-3">
					<label class="form-label">name</label>
					<input type="text" class="form-control" id="nameDog" required>
				</div>
				<div class="mb-3">
					<label class="form-label">breed</label>
					<input type="text" class="form-control" id="breedDog" required>
				</div>
				<div class="mb-3">
					<label class="form-label">weight</label>
					<input type="number" class="form-control" id="weightDog" required>
				</div>
				<button type="submit" class="btn btn-primary" >Crear Perro</button>
			</form>
		</div>
		<div class="col-3">
			<form onsubmit="createCat();">
				<h3>Crear Gato</h3>
				<div class="mb-3">
					<label class="form-label">name</label>
					<input type="text" class="form-control" id="nameCat" required>
				</div>
				<div class="mb-3">
					<label class="form-label">breed</label>
					<input type="text" class="form-control" id="breedCat" required>
				</div>
				<div class="mb-3">
					<label class="form-label">weight</label>
					<input type="number" class="form-control" id="weightCat" required>
				</div>
				<button type="submit" class="btn btn-primary" >Crear Gato</button>
			</form>
		</div>

	</div>
</body>
</html>
<script>
	function createDog(){
		event.preventDefault();
		let name = $("#nameDog").val();
		let breed = $("#breedDog").val();
		let weight = $("#weightDog").val();

		window.location.href="Dogs?name="+name+"&breed="+breed+"&weight="+weight;
	}

	function createCat(){
		event.preventDefault();
		let name = $("#nameCat").val();
		let breed = $("#breedCat").val();
		let weight = $("#weightCat").val();

		window.location.href="Cats?name="+name+"&breed="+breed+"&weight="+weight;
	}
</script>