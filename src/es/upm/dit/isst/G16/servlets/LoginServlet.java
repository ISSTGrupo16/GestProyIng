package es.upm.dit.isst.G16.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Professor;
import es.upm.dit.isst.webLab.dao.model.TFG;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Gestor gest = GestorDAOImplementation.getInstance().loginGestor(email,password);
		Trabajador trab = TrabajadorDAOImplementation.getInstance().loginTrabajador(email, password);
		RRHH rec = RRHHDAOImplementation.getInstance().loginRRHH(email, password);
				
		else if(gest != null) {
			//Redirigir a Vista TFG
				
			req.getSession().setAttribute("proyect_list", ProyectoDAOImplementation.getinstance.getProyectos(gest.correo));
			resp.sendRedirect(req.getContextPath() + "/LoginGestor.jsp");

		}else if(trab != null) {
			//Redirigir vista Professor
			req.getSession().setAttribute("proyect_list", ProyectoDAOImplementation.getinstance.getProyectos(trab.correo));
			resp.sendRedirect(req.getContextPath() + "/LoginTrabajador.jsp");

		}else if(trab != null) {
			//Redirigir vista Professor
			req.getSession().setAttribute("proyect_list", ProyectoDAOImplementation.getinstance.getProyectos(RRHH.correo));
			resp.sendRedirect(req.getContextPath() + "/LoginRRHH.jsp");

		}
		else{
			//FormLogin
			resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");

		}
		
	}
	
}
