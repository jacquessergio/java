package local.dispesa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.dispesa.dao.DispesasDAO;
import local.dispesa.dao.SalarioDAO;
import local.dispesa.dao.UsuarioDAO;
import local.dispesa.entidades.Usuario;

/**
 * Servlet implementation class usuario
 */
@WebServlet("/admin")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("action").equals("del")){
			
			UsuarioDAO dao = new UsuarioDAO();
			
			dao.remove(Long.parseLong(request.getParameter("id")));

			String URL = "usuario?action=list";
			
			response.sendRedirect(URL);
			
			
		}else{
		
		Integer id = Integer.parseInt(request.getParameter("action"));

		String data = request.getParameter("data");

		DispesasDAO u = new DispesasDAO();

		SalarioDAO s = new SalarioDAO();

		RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");

		request.setAttribute("lista", u.lista(data, id));

		request.setAttribute("salario", s.salario(data, id));

		request.setAttribute("salarioSoma", s.salarioSomaMes(data, id));

		disp.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String URL;

		Usuario usuario = new Usuario();

		if (request.getParameter("id_usuario") != null) {

			usuario.setId(Long.parseLong(request.getParameter("id_usuario")));

			URL = "editUsuario.jsp?id="+request.getParameter("id_usuario");

		} else {

			URL = "novoUsuario.jsp";
		}


		
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		UsuarioDAO dao = new UsuarioDAO();

		dao.inserir(usuario);

		response.sendRedirect(URL);

	}

}
