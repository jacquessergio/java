package br.com.dispesas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dispesas.model.Usuario;

public class UsuarioTest {

	public static void main(String[] args) {
	
		inserir();	

	}

	private static void inserir() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dispesa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		usu.setNome("Pricila Soares Callegari");
		usu.setLogin("pricila_callegari@yahoo.com.br");
		usu.setSenha("1234");
		usu.setType('U');
		
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();;
		
		em.close();
		emf.close();
		
	}
	
}
