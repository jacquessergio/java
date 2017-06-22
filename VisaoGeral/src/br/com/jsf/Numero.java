package br.com.jsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;

@ManagedBean
public class Numero {
	
	@NotNull(message="O campo não pode estar vazio")
	private Integer numero;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
