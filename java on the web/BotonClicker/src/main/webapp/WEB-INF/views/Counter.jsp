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
			<button class="btn btn-primary w-25 mb-3" onclick="location.reload();" >Click Me!</button>			
			<h3>You have clicked this button  <c:out value="${countClicker}"/> times</h3>
		</form>
			
		</div>
		
	</div>
	
</body>
</html>
<script>

</script>