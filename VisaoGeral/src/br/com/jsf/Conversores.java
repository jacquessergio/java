package br.com.jsf;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Conversores {
	
	private Double numero;
	private Date data;

	
	public Conversores() {
		
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
		
		this.numero = 5.380;
		this.data = new Date();
		
		
		
	}
	
	
	public Double getNumero() {
		return numero;
	}
	public void setNumero(Double numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
