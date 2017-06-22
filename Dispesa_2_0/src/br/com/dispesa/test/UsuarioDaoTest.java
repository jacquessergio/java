package br.com.dispesa.test;

import javax.persistence.EntityManager;


import br.com.dispesa.beans.UsuarioBean;
import br.com.dispesa.util.Factory;


public class UsuarioDaoTest {

	public static void main(String[] args){
		
		inserir();
		
	}

	public static void inserir() {
		
		//Factory emf = new Factory();
		
		EntityManager em = new Factory().factory();
		
		UsuarioBean usu = new UsuarioBean();
		
		usu.setNome("Jacques S. Testoni");
		usu.setEmail("jacquessergio@yahoo.com.br");
		usu.setSenha("123456");
		
		em.merge(usu);
	
		
	

		
	}
	
}
