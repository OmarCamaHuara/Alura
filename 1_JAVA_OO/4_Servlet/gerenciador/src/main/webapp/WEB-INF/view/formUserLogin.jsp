<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>


<c:url value="/entrada" var="linkNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utilizando URI com TagLib</title>
</head>
<body>
	<form action="${linkNovaEmpresa}" method="post">
	
		<label>Usuario</label>
		<input type="text" name="user">
		<label>Password</label>
		<input type="password" name="password">
		<input type="hidden" name="acao" value="loginUser" />
		
		<input type="submit" name="Enviar">
	</form>
</body>
</html>