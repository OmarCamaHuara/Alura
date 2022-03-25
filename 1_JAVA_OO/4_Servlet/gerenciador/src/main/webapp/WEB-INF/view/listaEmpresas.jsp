<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:import url="SairParcial.jsp" />
	<br>
	
	<a href="index.html">Nova Empresa</a>
	
	<h1>Login from ${loguedUser.user}</h1>
	
	<br>
	<br>
	<c:if test="${not empty nomeDaEmpresa }">
		Empresa ${ nomeDaEmpresa } cadastrada com sucesso!!!
	</c:if>

<h1>Lista de Empresas</h1>

<ul>
	<c:forEach items="${empresas}" var="empresa">
		<li>
			${ empresa.nome } - <fmt:formatDate value="${ empresa.date }" pattern="dd/MM/yyyy" />
			<a href="/gerenciador/entrada?acao=removeEmpresa&id=${ empresa.id }">Remove</a>
			<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${ empresa.id }">Altera</a>
		</li>
	</c:forEach>
</ul>

<hr>

<ul>
	<%
		List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");  //${empresas}
		for(Empresa empresa : lista){
	%>		
			<li><%= empresa.getNome()%></li>
	<%
		}
	%>
</ul>

</body>
</html>