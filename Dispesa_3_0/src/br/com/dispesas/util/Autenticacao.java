package br.com.dispesas.util;

import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import br.com.dispesas.dao.UsuarioDao;
import br.com.dispesas.model.Usuario;

@ManagedBean
public class Autenticacao {
	
		
	public String autentica(Usuario u){
		
				
		Usuario usu = new UsuarioDao().login(u);
		
		FacesContext fc = FacesContext.getCurrentInstance();
				
		if(usu.getLogin() != null){
			
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", usu.getNome());
			session.setAttribute("idUser",  usu.getId());
						
			return "/index.xhtml";
			
		
		}else{
			
			FacesMessage msg = new FacesMessage("Login Invalido!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, msg);
			
			return "login.xhtml";
		}
		
		
	}
	
	public String registraSaida(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");
		session.removeAttribute("idUser");
		
		return "login.xhtml";
	}


	

	
	

	
	
}
