package local.jsf.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PrimeiroBean {

	private int numero;
	
	public int getNumero(){
		
		return numero;
	}
	
	public void setNumero(int numero){
		
		this.numero = numero;
	}
}
