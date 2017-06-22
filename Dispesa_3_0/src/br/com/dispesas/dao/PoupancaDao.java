package br.com.dispesas.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dispesas.model.Poupanca;
import br.com.dispesas.model.Poupanca;
import br.com.dispesas.model.Usuario;
import br.com.dispesas.util.Factory;

public class PoupancaDao {

	   private EntityManager em;
	
	public PoupancaDao(){
		
		this.em = new Factory().factory();
		
	}
	
	
	public void inserir(Poupanca u){
		
		u.setUsuario(this.em.find(Usuario.class, u.getId()));
		this.em.merge(u);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado!", "Gravado com sucesso."));
		
	}
	public void remove(Long id){
		
		
		this.em.remove(this.em.find(Poupanca.class, id));
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Removido!", "Removido com sucesso"));
	}
	
	public List<Poupanca> listar(){
		
		Query qr = em.createQuery("SELECT x FROM Poupanca x");
		
		return qr.getResultList();
	}
	
	public List<Poupanca> listaMes(String data){
		
		Query qr = em.createQuery("SELECT x FROM Poupanca x WHERE DATE_FORMAT(x.data, '%Y-%m') LIKE :d").setParameter("d", data);
		
		return qr.getResultList();
	}
	
	public Double somaMes(String data){
		
	    String jpql = "SELECT SUM(x.valor) FROM Poupanca x WHERE DATE_FORMAT(x.data, '%Y-%m') LIKE :d";
		
		TypedQuery<Double> liQuery = em.createQuery(jpql, Double.class).setParameter("d", data);
		
		Double soma = liQuery.getSingleResult();
		
		if(soma == null){
			
			soma = 0.00;
		}
		
		return soma;
	}
	
	public Double somaAno(String data){
		
	    String jpql = "SELECT SUM(x.valor) FROM Poupanca x WHERE DATE_FORMAT(x.data, '%Y') = :d ";
		
		TypedQuery<Double> liQuery = em.createQuery(jpql, Double.class).setParameter("d", data);
		
		Double soma = liQuery.getSingleResult();
		
		if(soma == null){
			
			soma = 0.00;
		}
		
		return soma;
	}
	
}
