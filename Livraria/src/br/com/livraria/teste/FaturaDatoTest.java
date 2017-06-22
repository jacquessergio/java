package br.com.livraria.teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.livraria.jpa.Fatura;
import br.com.livraria.jpa.Ligacao;

public class FaturaDatoTest {

	public static void main(String[] args) {
		
		//ligacao();
		quantidade();
	}

	private static void quantidade() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		
		String jpql = "SELECT COUNT(x) FROM Fatura x";
		
		TypedQuery<Long> consulta = em.createQuery(jpql, Long.class);
		
		Long resultado = consulta.getSingleResult();
		
		System.out.println(resultado);
		
		em.close();
		factory.close();
		
		
	}

	private static void ligacao() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Fatura f = new Fatura();
		Ligacao l = new Ligacao();

		l.setDuracao(5);
		l.setFatura(f);
		
		f.getLigacao().add(l);
		
		
		f.setVencimento(new GregorianCalendar(2016, 07, 06));
		
		em.getTransaction().begin();
		em.persist(f);
		em.persist(l);
		em.getTransaction().commit();
			
		em.close();
		factory.close();
		
	}

}
