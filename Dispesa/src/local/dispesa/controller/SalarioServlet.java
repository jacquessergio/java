package local.dispesa.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.dispesa.dao.SalarioDAO;
import local.dispesa.dao.UsuarioDAO;
import local.dispesa.entidades.Salario;


/**
 * Servlet implementation class SalarioServlet
 */
@WebServlet("/salario")
public class SalarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
				
		SalarioDAO dao = new SalarioDAO();
		
		dao.remove(Long.parseLong(req.getParameter("id")));

		String URL = "admin?action="+req.getParameter("action")+"&data="+req.getParameter("data");
		
		resp.sendRedirect(URL);
				
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String URL;
		
		Salario salario = new Salario();
		
		if(request.getParameter("id_salario") != null){
			
			salario.setId(Long.parseLong(request.getParameter("id_salario")));
			
			URL = "editPagamento.jsp?action="+request.getParameter("id_user")+"&data="+request.getParameter("data")+"&id="+request.getParameter("id_salario");
		
		}else{
			
			URL = "novoPagamento.jsp?action="+request.getParameter("id_user")+"&data="+request.getParameter("data");
		}
		
		
		salario.setData(Calendar.getInstance());
		
		salario.setFilraData(request.getParameter("data"));
		
		salario.setValor(Double.parseDouble(request.getParameter("valor")));
				
		UsuarioDAO u = new UsuarioDAO();
		
		salario.setUsuario(u.busca(Long.parseLong(request.getParameter("id_user"))));
		
		SalarioDAO dao = new SalarioDAO();
		
		dao.inserir(salario);
		
		
		
		response.sendRedirect(URL);
	}

}
