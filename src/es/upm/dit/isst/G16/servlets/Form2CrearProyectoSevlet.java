package es.upm.dit.isst.G16.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.G16.servlets.Professor;
import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.TFG;




@WebServlet("/Form2CrearProyectoSevlet")
public class Form2CrearProyectoSevlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		String fecha_inicio = req.getParameter("fecha_inicio");
		String gestorEmail = req.getParameter("gestor_email");
		
		Gestor gest = GestorDAOImplementation.getInstance().readGestor(gestorEmail);
			
		Proyecto proy = new Proyecto();
		
		proy.setNombre(nombre);
		proy.setDescripcion(descripcion);
		proy.setFecha_inicio(fecha_inicio);
		proy.setGestor(gest);
		
		ProyectDAOImplementation.getInstance().createProyect(proy);
		resp.sendRedirect(req.getContextPath()+"/FormLogin.jsp");
	}
	
}
