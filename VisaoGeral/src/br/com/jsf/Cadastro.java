package br.com.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class Cadastro {

	private List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
	
	private UsuarioBean usuario = new UsuarioBean();
	
	public void adicionaUsuario(){
		
		this.usuarios.add(this.usuario);
		this.usuario = new UsuarioBean();
		
		FacesMessage msg = new FacesMessage("Usuario Adicionado");
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	
	
}
