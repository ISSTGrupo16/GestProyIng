package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.TFG;



@WebServlet("/Form1TrabajadorServlet")
public class Form1trabajadorServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proyectID = req.getParameter("proyect_id");
		Proyecto proy = ProyectDAOImplementation.getInstance().readProyect(proyectID);
		req.getSession().setAttribute("proyect", proy);
		resp.sendRedirect(req.getContextPath() + "/AnadirHoras.jsp");
	}
	
}