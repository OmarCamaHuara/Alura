<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="SairParcial.jsp" />
		
	<form action="${linkEntradaServlet}" method="post">
	
		<label>Nome da Empresa</label>
		<input type="text" name="nome" value="${empresa.nome}">
		<label>Data</label>
		<input type="text" name="date" value="<fmt:formatDate value="${ empresa.date }" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${empresa.id }" />
		<input type="hidden" name="acao" value="alteraEmpresa"/>
		
		<input type="submit" name="Enviar">
	</form>
</body>
</html>