package br.com.struts.aprendendo;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TesteAction extends ActionSupport {

	private String texto;
	
	public String execute() throws Exception{
		
		return TesteAction.SUCCESS;
			
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTexto(){
		
		return texto;
	}
}
