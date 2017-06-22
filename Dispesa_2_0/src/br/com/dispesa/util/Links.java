package br.com.dispesa.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Links {

	private Map<String, String> link = new LinkedHashMap<String, String>();
	
	private String usuario;
	
	public Links(){
		
		link.put("usuario", "usuario.xhtml");
		this.usuario = "javascript:popUp('usuario.xhtml')";
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

		
	public void gLink(){
		
		link.get(this.link);
	}
	
	
	public Map<String, String> getLink() {
		return link;
	}

	public void setLink(Map<String, String> link) {
		this.link = link;
	}
	
	
	
}
