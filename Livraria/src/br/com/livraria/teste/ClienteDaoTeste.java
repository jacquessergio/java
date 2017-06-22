package br.com.livraria.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.entidades.Cliente;
import br.com.livraria.entidades.Endereco;

public class ClienteDaoTeste {

	public static void main(String[] args){
		
		inserir();
		
	}
	
	
	
	public static void inserir(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager em = factory.createEntityManager();
		
		Cliente cli = new Cliente();
		
		cli.setNome("LAZARO SOARES JUNIOR");
		cli.setCpf("355.688.522.36");
		
		Endereco end = new Endereco();
		
		end.setPais("BRASIL");
		end.setCep("06703-390");
		end.setLogradouro("RUA DOS CANÁRIOS");
		end.setNumero("738");
		end.setComplemento("CASA");
		end.setCidade("COTIA");
		end.setEstado("SP");
		
		cli.setEndereco(end);
		
		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
			
		em.close();
		factory.close();
	}
	
}
