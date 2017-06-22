package br.com.dispesa.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.persistence.TypedQuery;

import br.com.dispesa.beans.UsuarioBean;
import br.com.dispesa.util.Factory;

@ManagedBean
public class UsuarioDao {

	private EntityManager em;	
	
	public UsuarioDao(){
		
		this.em = new Factory().factory();
	}
	
	
	public void inserir(UsuarioBean u) {
		
			this.em.persist(u);

	}

	@SuppressWarnings("unchecked")
	public List<UsuarioBean> lista(){
		
		Query query = this.em.createQuery("SELECT x FROM Usuario x");
		
		//String jpql = "SELECT x FROM Usuario x";
		
		//TypedQuery<UsuarioBean> query = this.em.createQuery(jpql, UsuarioBean.class);
		
		//List<UsuarioBean> lista = query.getResultList();
		
		return query.getResultList();
		
	}

}
