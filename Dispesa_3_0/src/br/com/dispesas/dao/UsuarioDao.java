package br.com.dispesas.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dispesas.model.Usuario;
import br.com.dispesas.util.Factory;

public class UsuarioDao {

	   private EntityManager em;
	   private Usuario usu;
	   
	public UsuarioDao(){
		
		this.em = new Factory().factory();
		
	}
	
	
	public void inserir(Usuario u){
		
		this.em.merge(u);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado!", "Gravado com sucesso."));
		
	}
	public void remove(Long id){
		
		
		this.em.remove(this.em.find(Usuario.class, id));
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Removido!", "Removido com sucesso"));
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		
		Query qr = em.createQuery("SELECT x FROM Usuario x");
		
		return qr.getResultList();
	}
	
	
	@SuppressWarnings("finally")
	public Usuario login(Usuario u){
		
		this.usu = new Usuario();
		
		String jpql =  "SELECT x FROM Usuario x WHERE x.login = :u AND x.senha = :p";
		
		TypedQuery<Usuario> check = em.createQuery(jpql, Usuario.class);
		
		check.setParameter("u", u.getLogin());
		check.setParameter("p", u.getSenha());
		
		try {
			
			this.usu = check.getSingleResult();
			
		} catch (Exception e) {
								
			e.getMessage();
				
		}finally{
			
			return this.usu;
			
		}
	}
	
}
