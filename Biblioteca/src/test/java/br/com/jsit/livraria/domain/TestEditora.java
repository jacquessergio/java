package br.com.jsit.livraria.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Ignore;
import org.junit.Test;

public class TestEditora {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria");

	EntityManager em = emf.createEntityManager();
	

	@Test
	@Ignore
	public void salvar() {

		Editora editora = new Editora();
		editora.setNome("Remover - Livros");
		editora.setEmail("remover@cabum.com.br");
		em.getTransaction().begin();
		em.persist(editora);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

	@Test
	@Ignore
	public void buscar() {

		Editora editora = new Editora();
		editora = em.find(Editora.class, 6L);
		System.out.println("Editora: " + editora.getNome());
		System.out.println("Email: " + editora.getEmail());
		
		em.close();
		emf.close();

	}
	
	@Test
	public void listar() {

		//Editora editora = new Editora();
		

		//Query query = em.createQuery("SELECT a FROM editora a", Editora.class);
		
		List<Editora> lista =  em.createQuery("SELECT a FROM Editora a", Editora.class).getResultList();
		
		for(Editora e: lista){
			
			System.out.println("Editora: " + e.getNome());
			System.out.println("Email: " + e.getEmail());
			
		}
		
	
		
		//em.close();
		//emf.close();
		

	}
	
	@Test
	@Ignore
	public void remove(){
		Editora editora = em.find(Editora.class, 7L);
		em.getTransaction().begin();
		em.remove(editora);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	@Test
	@Ignore
	public void atualiza(){
		Editora editora = em.find(Editora.class, 6L);
		editora.setNome("Caelum - Livro de publicações");
		em.getTransaction().begin();
		em.persist(editora);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
