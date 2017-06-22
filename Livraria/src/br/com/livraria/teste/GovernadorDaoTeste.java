package br.com.livraria.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.jpa.Estado;
import br.com.livraria.jpa.Governador;

public class GovernadorDaoTeste {
	
	public static void main(String[] args){
		
		inserir();
		//buscar();
		
	}

	
	private static void buscar() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		
		EntityManager em = factory.createEntityManager();
		
		Estado e = em.find(Estado.class, 1L);
		Governador g = e.getGovernador();
		
		System.out.println(g.getNome());
		
		em.close();
		factory.close();
		
		
	}


	private static void inserir() {
		
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
	
	EntityManager em = factory.createEntityManager();
	
	Governador g = new Governador();
	g.setNome("JOÃO DORIA");
	
	Estado e = new Estado();
	e.setGovernador(g);
	e.setNome("São Paulo");
	
	em.getTransaction().begin();
	em.persist(g);
	em.persist(e);
	em.getTransaction().commit();
	
	
	em.close();
	factory.close();
	
		
	}
	
	
	
	

}
