package br.com.dispesas.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dispesas.model.Dispesa;
import br.com.dispesas.model.Usuario;
import br.com.dispesas.util.Factory;

public class ResumoDao {

	   private EntityManager em;
	
	public ResumoDao(){
		
		this.em = new Factory().factory();
		
	}
	
	
	
	public Double somaMes(String data){
		
	    String jpql = "SELECT (SUM(x.valor) - SUM(y.valor)) FROM"
	    			+ "	Dispesa x, Pagamento y  "
	    			+ " WHERE"
	    			+ " DATE_FORMAT(y.data, '%Y-%m')"
	    			+ " LIKE :d"
	    			+ " AND"
	    			+ "	:d"
					+ " BETWEEN"
					+ " DATE_FORMAT(x.data_inicial, '%Y-%m')"
					+ " AND "
					+ " DATE_FORMAT(x.data_final, '%Y-%m')";
		
	    
	    
		TypedQuery<Double> liQuery = em.createQuery(jpql, Double.class).setParameter("d", data);
				
		Double soma = liQuery.getSingleResult();
		
		
		return soma ;
	}
	
}
