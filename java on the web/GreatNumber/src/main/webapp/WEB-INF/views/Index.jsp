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
    <title>Counter</title>
</head>
<body>
	<div class="row m-2 w-25 ">
		<div class="col text-center">
		<form  method="post">
	        <h3>Bienvenido al juego "Gran Número"</h3>
	        
	        <h5>Estoy pensando en un numero entre el 1 al 100</h5>  
	        
	    	<p>Intentos :  <c:out value="${attempts}"/>/5</p>
	    	
	    	
	    	<div class="<%= (Boolean) request.getAttribute("isCorrect") ? "green" : "red" %>">
	    		<h3><c:out value="${message}"/></h3>
	    	</div>
	       
	         <input type="number" class="form-control" id="number" name="number" >
			<button class="btn btn-primary w-25 mb-3" >Submit!</button>	
		</form>
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