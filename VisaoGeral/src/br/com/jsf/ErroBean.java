package br.com.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ErroBean {

	public void geraErro(){
		
		System.out.println(10/0);
	}
}
