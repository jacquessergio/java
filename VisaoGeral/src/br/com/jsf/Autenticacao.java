package br.com.jsf;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class Autenticacao {

	private static Map<String, String> mapa = new HashMap<String, String>();
	
	private String usuario;
	private String senha;
	
	static{
		
		Autenticacao.mapa.put("jacques", "123");
		Autenticacao.mapa.put("pricila", "123");
		
	}
	
	public String autentica(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(Autenticacao.mapa.containsKey(this.usuario) && Autenticacao.mapa.get(this.usuario).equals(this.senha)){
			
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", this.usuario);
			
			
			
			return "/check.xhtml";
			
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
		
		return "login.xhtml";
	}

	public static Map<String, String> getMapa() {
		return mapa;
	}

	public static void setMapa(Map<String, String> mapa) {
		Autenticacao.mapa = mapa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
		
	
}
