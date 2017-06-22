package local.dispesa.fabrica;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionMysql {

	
	private EntityManagerFactory factory;
	
	private EntityManager em;
	
				
	public ConectionMysql() {
		
		this.factory =  Persistence.createEntityManagerFactory("dispesa");
		this.em = this.factory.createEntityManager();
		
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}


	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


		
}
