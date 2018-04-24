
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista de trabajador</title>
</head>
<body>

	<h2>Vista de trabajador</h2>


	<table border=1>
		<tr>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Estado</th>
		</tr>

		<c:forEach items="${proyectos_list}" var="tfgi">
			<tr>
				<td>${proyectos.nombre}</td>
				<td>${proyectos.descripcion}</td>
				<td>${proyectos.estado_proyecto}</td>
				<td>
					<c:if test="${proyecto.estado_proyecto !=="completado"}">
						<%@ include file="Form1Trabajador.jsp" %>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	



</body>
</html>