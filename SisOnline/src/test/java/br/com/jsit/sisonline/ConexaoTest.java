package br.com.jsit.sisonline;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Ignore;
import org.junit.Test;

public class ConexaoTest {

	@Test
	@Ignore
	public void conxaoTest(){
		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("sisonline");
		
		em.createEntityManager();
	}
	
	public static void main(String[] args){
		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("sisonline");
		
		em.createEntityManager();
	}
	
	
}
