<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Gestión de Cookies</h2>

<form action="/Cookie/ServletCookies" method="post">

	Nombre de la Cookie: <input type="text" name="nombre">
	<br>
	Valor de la Cookie: <input type="text" name="valor">
	<br>
	<br>
	<input type="submit" name="crear" value="Crear">
	<input type="submit" name="modificar" value="Modificar">
	<input type="submit" name="eliminar" value="Eliminar">
</form>

<br>

<form action="vistaCookies.jsp" method="post">
	<input type="submit" name="visualizar" value="Visualizar">
</form>
<br>

</body>
</html>