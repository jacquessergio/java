package br.com.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Ajax {

	private String nome;

	public void nom_completo(){
		
		this.nome = "Seu nome é" + nome;
				
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
