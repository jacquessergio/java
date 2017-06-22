package br.com.struts.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CarroRepository {

	private EntityManager manager;
	
	public CarroRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(Carro carro){
		
		this.manager.persist(carro);
	}
	
	public List<Carro> lista(){
		
		Query query = this.manager.createQuery("SELECT x FROM Carro x");
		
		return query.getResultList();
		
	}
	
}
