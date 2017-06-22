package br.com.struts.jpa;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ConexaoRequest {

	private HttpServletRequest request;
	private EntityManager manager;
	
	public ConexaoRequest() {
		
		this.request = ServletActionContext.getRequest();
		this.manager = (EntityManager) this.request.getAttribute("EntityManager");
	}

	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	
	
}
