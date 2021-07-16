<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Insert title here</title>
</head>
<body>
<div class="container">
    <%
        int width = Integer.parseInt(request.getParameter("width"));
        int heigth = Integer.parseInt(request.getParameter("heigth"));
        boolean isBlue = false;
        for (int i = 0; i <= heigth; i++) {
    %>
    <div class="row">
        <%
            isBlue = isBlue?true:false;
            for (int j = 0; j <= width; j++) {
                if (isBlue) {
                    isBlue = false;
        %>
             <div class="col boxDarkorchid cuadrado"></div>
        <%
                }
                else{
                    isBlue = true;
        %>
        <div class="col boxBlue cuadrado"></div>
        <%
                }
            }
        %>
    </div>
    <%
        }
    %>
    <%=  width + " " + heigth %>
</div>
</body>
</html>