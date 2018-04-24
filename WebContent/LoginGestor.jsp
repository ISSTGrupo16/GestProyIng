<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Vista de gestor</h2>
	
	<table border=1>
		<tr>
			<th>Nombre</th>
			<th>Descripci�n</th>
			<th>Estado</th>
		</tr>
	
		<c:forEach items="${proyectos_list}" var="tfgi">
			<tr>
				<td>${proyectos.nombre}</td>
				<td>${proyectos.descripcion}</td>
				<td>${proyectos.estado_proyecto}</td>
				<td>
					<c:if test="${proyecto.estado_proyecto !=="completado"}">
						<%@ include file="Form3anadirTrabajador.jsp" %>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<%@ include file="Form2CrearProyecto.jsp" %>
		</tr>
	</table>

</body>
</html>