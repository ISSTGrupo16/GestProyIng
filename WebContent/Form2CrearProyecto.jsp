<form action="Form2CrearProyectoSevlet">
	
	<input type="number" name ="proyectID" placeholder="ID_proyecto" />
	<input type="text" name="nombre" placeholder="Nombre" />
	<input type="text" name="descripcion" placeholder="Descripcion" />
	
	<input type="date" name="fecha_inicio" placeholder="Fecha de inicio" />
	<input type="hidden" value="${gestor.email}" name="gestor_email" />
	
	<select name="trabajador">
		<option value="" disabled selected>Elija un trabajador</option>
		<c:forEach items="${trabajador_list}" var="trabajador_i">
			<option value=${ trabajador_i.email}>${trabajador_i.name}-${trabajador_i.email}</option>
		</c:forEach>
	</select>
	
	<input type="submit">Crear nuevo proyecto</input>

</form>