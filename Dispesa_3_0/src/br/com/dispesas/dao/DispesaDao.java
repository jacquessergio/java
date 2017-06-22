package br.com.dispesas.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dispesas.model.Dispesa;
import br.com.dispesas.model.Usuario;
import br.com.dispesas.util.Data;
import br.com.dispesas.util.Factory;

public class DispesaDao {

	   private EntityManager em;
	
	public DispesaDao(){
		
		this.em = new Factory().factory();
		
	}
	
	
	public void inserir(Dispesa u){
		
		u.setUsuario(this.em.find(Usuario.class, u.getId()));
		this.em.merge(u);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado!", "Gravado com sucesso."));
		
	}
	public void remove(Long id){
		
		
		this.em.remove(this.em.find(Dispesa.class, id));
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Removido!", "Removido com sucesso"));
	}
	
	@SuppressWarnings("unchecked")
	public List<Dispesa> listar(String data, Long id){
	    	
		
		Query qr = em.createQuery("SELECT x FROM Dispesa x WHERE"
								+ " DATE_FORMAT(x.data_inicial, '%Y-%m')"
								+ " LIKE"
								+ "	:d"
								+ " OR"
								+ "	:d"
								+ " BETWEEN"
								+ " DATE_FORMAT(x.data_inicial, '%Y-%m')"
								+ " AND "
								+ " DATE_FORMAT(x.data_final, '%Y-%m')"
								+ "	AND"
								+ " usuario_id = :i").setParameter("d", data).setParameter("i", id);
	
		return qr.getResultList();
	}
	
	
	public Double somaMes(String data){
		
				    String jpql = "SELECT SUM(x.valor) FROM Dispesa x WHERE"
					    		+ " DATE_FORMAT(x.data_inicial, '%Y-%m')"
								+ " LIKE"
								+ "	:d"
								+ " OR"
								+ "	:d"
								+ " BETWEEN"
								+ " DATE_FORMAT(x.data_inicial, '%Y-%m')"
								+ " AND "
								+ " DATE_FORMAT(x.data_final, '%Y-%m')";
			    
		TypedQuery<Double> liQuery = em.createQuery(jpql, Double.class).setParameter("d", data);
		
		Double soma = liQuery.getSingleResult();
		
		if(soma == null){
			
			soma = 0.00;
		}
		
		return soma;
	}
	
	public Double somaAno(String data){
		
		String jpql = "SELECT SUM(x.num_parcelas * x.valor) FROM Dispesa x WHERE"
				+ "	:d"
				+ " BETWEEN"
				+ " DATE_FORMAT(x.data_inicial, '%Y')"
				+ " AND "
				+ " DATE_FORMAT(x.data_final, '%Y')";
    
		TypedQuery<Double> liQuery = em.createQuery(jpql, Double.class).setParameter("d", data);
		
		Double soma = liQuery.getSingleResult();
		
		if(soma == null){
		
		soma = 0.00;
		}
		
		return soma;
		}
	
}
