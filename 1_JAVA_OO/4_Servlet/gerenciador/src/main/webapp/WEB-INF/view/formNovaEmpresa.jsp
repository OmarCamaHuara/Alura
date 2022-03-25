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

	<c:import url="SairParcial.jsp" />
	
	<form action="${linkNovaEmpresa}" method="post">
	
		<label>Nome da Empresa</label>
		<input type="text" name="nome">
		<label>Data</label>
		<input type="text" name="date">
		<input type="hidden" name="acao" value="novaEmpresa" />
		
		<input type="submit" name="Enviar">
	</form>
</body>
</html>