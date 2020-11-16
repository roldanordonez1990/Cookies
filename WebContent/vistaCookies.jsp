<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Cookies almacenadas:</h2>
	<%
		if (request.getParameter("visualizar") != null) {

			Cookie[] total = request.getCookies();
			

			for (Cookie co : total) {

				out.println(co.getName() + "-" + co.getValue() + "</br>");
			}

		}
	
	
	%>
	<br>
	<br>
	<form action="index.jsp" method="post">
	
		<input type="submit" name="" value="Volver atrás">
		
	</form>

</body>
</html>