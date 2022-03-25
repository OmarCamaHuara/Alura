<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="SairParcial.jsp" />

	<c:if test="${not empty nomeDaEmpresa }">
		Empresa ${ nomeDaEmpresa } cadastrada com sucesso!!!
	</c:if>
	
	<c:if test="${empty nomeDaEmpresa }">
		Nenhuma empresa cadastrada!
	</c:if>
	
	<hr>
	
	<c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
     </c:forEach>
	
</body>
</html>