package br.com.livraria.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.livraria.jpa.Autor;
import br.com.livraria.jpa.Livro;

public class LivroDaoTeste {

	public static void main(String[] args) {

		// inserir();
		// quantidade();
		// soma();
		// minMax();
		// media();
		lista();

	}

	private static void lista() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();

		String jpql_1 = "SELECT x FROM Livro x";
		String jpql_2 = "SELECT x FROM Livro x WHERE x.preco >= 100";
		String jpql_3 = "SELECT x FROM Livro x WHERE x.preco <= 100";
		
		
		TypedQuery<Livro> consulta = em.createQuery(jpql_3, Livro.class);
		
		List<Livro> resultado = consulta.getResultList();
		
		Autor a;
		
		for(Livro u: resultado){
			
			a = em.find(Autor.class, u.getId());
			
			System.out.println(" Titulo: "   + u.getTitulo() +
							   " Preço R$: " + u.getPreco()  + 
   						       " Autor: "    + a.getNome());
			
		}
		
		
		em.close();
		factory.close();
	}

	private static void media() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();

		// O preço médio dos livros
		String jpql_1 = "SELECT AVG(x.preco) FROM Livro x";

		// O preçomédio dos livros com preço maior ou igual a 100
		String jpql_2 = "SELECT AVG(x.preco) FROM Livro x WHERE x.preco >= 100";

		TypedQuery<Double> consulta = em.createQuery(jpql_2, Double.class);

		Double resultado = consulta.getSingleResult();

		System.out.println(resultado);

		em.close();
		factory.close();

	}

	private static void minMax() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();

		// preço do livro mais barato
		String jpql_1 = "SELECT MIN(x.preco) FROM Livro x";

		// preço do livro mais caro
		String jpql_2 = "SELECT MAX(x.preco) FROM Livro x";

		// O menor preço de um livro que seja maior ou igual a 100
		String jpql_3 = "SELECT MIN(x.preco) FROM Livro x WHERE x.preco >= 100";

		// maior preço de umlivro que seja menor ou igual a 100
		String jpql_4 = "SELECT MAX(x.preco) FROM Livro x WHERE x.preco <= 100";

		TypedQuery<Double> consulta = em.createQuery(jpql_4, Double.class);

		Double resultado = consulta.getSingleResult();

		System.out.println(resultado);

		em.close();
		factory.close();

	}

	private static void soma() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();

		// Soma dos preços dos livros
		String jpql_1 = "SELECT SUM(x.preco) FROM Livro x";

		// Soma dos preços dos livros com preço maior ou igual a 100
		String jpql_2 = "SELECT SUM(x.preco) FROM Livro x WHERE x.preco >= 100";

		TypedQuery<Double> consulta = em.createQuery(jpql_2, Double.class);

		Double resultado = consulta.getSingleResult();

		System.out.println(resultado);

		em.close();
		factory.close();
	}

	private static void quantidade() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();

		// CONTA A QUANTIDADE DE REGISTROS
		String jpql_1 = "SELECT COUNT(x) FROM Livro x";

		String jpql_2 = "SELECT COUNT(x) FROM Livro x WHERE x.preco >= 100";

		TypedQuery<Long> consulta = em.createQuery(jpql_2, Long.class);

		Long resultado = consulta.getSingleResult();

		System.out.println(resultado);

		em.close();
		factory.close();

	}

	private static void inserir() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();

		Autor aut = new Autor();
		Livro liv = new Livro();

		aut.setNome("EDITORA ABRIL");
		liv.setTitulo("THIAGO MENTIROSO RS ");
		liv.setPreco(30.10);
		liv.getAutores().add(aut);

		em.getTransaction().begin();
		em.persist(aut);
		em.persist(liv);
		em.getTransaction().commit();

		em.close();
		factory.close();

	}
}
