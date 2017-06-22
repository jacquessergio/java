package local.dispesa.controller;

import java.io.IOException;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.dispesa.dao.DispesasDAO;
import local.dispesa.dao.UsuarioDAO;
import local.dispesa.entidades.Dispesas;


/**
 * Servlet implementation class DispesasServlet
 */
@WebServlet("/novaDespesa")
public class DispesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
				
		DispesasDAO dao = new DispesasDAO();
		
		dao.remove(Long.parseLong(req.getParameter("id")));

		String URL = "admin?action="+req.getParameter("action")+"&data="+req.getParameter("data");
		
		resp.sendRedirect(URL);
				
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String URL;
		
		Dispesas dispesas = new Dispesas();
		
		if(request.getParameter("id_disp") != null){
			
			dispesas.setId(Long.parseLong(request.getParameter("id_disp")));
			
			URL = "editDespesa.jsp?action="+request.getParameter("id_user")+"&data="+request.getParameter("data")+"&id="+request.getParameter("id_disp");
		
		}else{
			
			URL = "novaDespesa.jsp?action="+request.getParameter("id")+"&data="+request.getParameter("data");
		}
		
		dispesas.setDescricao(request.getParameter("descricao"));
		
		dispesas.setData(Calendar.getInstance());
		
		dispesas.setFiltraData(request.getParameter("data"));
		
		dispesas.setParcelas((Integer.parseInt(request.getParameter("parcelas"))));
		
		dispesas.setValor(Double.parseDouble(request.getParameter("valor")));
		
		dispesas.setObservacao(request.getParameter("observacao"));
		
		UsuarioDAO u = new UsuarioDAO();
		
		dispesas.setUsuario(u.busca(Long.parseLong(request.getParameter("id"))));
		
		DispesasDAO dao = new DispesasDAO();
		
		dao.inserir(dispesas);
		
		
		
		response.sendRedirect(URL);
	}

}
