package local.dispesa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.dispesa.dao.UsuarioDAO;

/**
 * Servlet implementation class usuario
 */
@WebServlet("/usuario")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String url = request.getParameter("action");
		
		UsuarioDAO u = new UsuarioDAO();
		
		if(url.equals("list")){
			
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			
			request.setAttribute("lista", u.lista());
			
			disp.forward(request, response);
			
		
		}else if(url.equals("insert")){
			
			//System.out.println("inserido...");	
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
