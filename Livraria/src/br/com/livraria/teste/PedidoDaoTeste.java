package br.com.livraria.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.jpa.Cliente;
import br.com.livraria.jpa.Pedido;

public class PedidoDaoTeste {

	public static void main(String[] args) {
		
		inserir();

	}

	private static void inserir() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Cliente cli = new Cliente();
		Pedido  ped = new Pedido();
		
		cli.setNome("LALINHO PREGUIÇOSO");
		ped.setCliente(cli);
		ped.setData(Calendar.getInstance());
		
		em.getTransaction().begin();
		em.persist(cli);
		em.persist(ped);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
		
		
	}
	
	

}
