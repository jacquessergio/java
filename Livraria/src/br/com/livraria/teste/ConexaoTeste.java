package br.com.livraria.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.livraria.entidades.Editora;

public class ConexaoTeste {

	public static void main(String[] args) {
		
		 buildDB();
		//inserir();
		//buscar();
		//atualiza();
		//remover();
		//listar();
		
	}
	
	
	public static void buildDB(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		em.close();

		
	}

	public static void inserir(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		Editora editora = new Editora();
		
		editora.setNome("k19 - Livros4");
		editora.setEmail("contato4@k19.com.br");
		
		em.getTransaction().begin();
		em.persist(editora);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
	public static void buscar(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Editora editora = em.find(Editora.class, 1L);
		
		System.out.println("nome: "+ editora.getNome() + " - E-mail: " + editora.getEmail());
		
		em.close();
		factory.close();
		
	}
	
	public static void remover(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Editora editora = em.find(Editora.class, 2L);
		
		em.getTransaction().begin();
		em.remove(editora);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
		
	}
	
	public static void atualiza(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Editora editora = em.find(Editora.class, 2L);
		
		editora.setNome("Cabum");
		editora.setEmail("cabum@cabum.com.br");
		
		em.getTransaction().begin();
		em.persist(editora);
		em.getTransaction().commit();
				

		em.close();
		factory.close();
		
	}
	
	private static void listar() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("SELECT e FROM Editora e");
		
		@SuppressWarnings("unchecked")
		List<Editora> editora = query.getResultList();
		
		for(Editora li : editora){
			
			System.out.println("nome: "+ li.getNome() + " - E-mail: " + li.getEmail());
		}
		
		em.close();
		factory.close();
		
		
	}

}
