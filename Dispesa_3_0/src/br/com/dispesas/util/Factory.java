package br.com.dispesas.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class Factory {

	public EntityManager factory(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request =  (HttpServletRequest) ec.getRequest();
		
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		
		return manager;
	}
}
