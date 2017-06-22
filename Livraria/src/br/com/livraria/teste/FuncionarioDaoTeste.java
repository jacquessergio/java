package br.com.livraria.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.jpa.Departamento;
import br.com.livraria.jpa.Funcionario;

public class FuncionarioDaoTeste {

	public static void main(String[] args) {
		
		inserir();

	}

	private static void inserir() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Funcionario fun = new Funcionario();
		Departamento dep = new Departamento();
		
		fun.setNome("PRICILA SOARES");
		dep.setNome("COMERCIAL");
		
		dep.getFuncionarios().add(fun);
		
		em.getTransaction().begin();
		em.persist(fun);
		em.persist(dep);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
		
		
		
		
	}
	
	

}
