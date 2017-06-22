package local.dispesa.dao;

import java.util.List;


import javax.persistence.TypedQuery;

import local.dispesa.entidades.Usuario;
import local.dispesa.fabrica.ConectionMysql;

public class UsuarioDAO {
	
	
	
	public UsuarioDAO() {
		

	}
	
	public void inserir(Usuario u){
		
		ConectionMysql con = new ConectionMysql();
		
		con.getEm().getTransaction().begin();
		con.getEm().merge(u);
		con.getEm().getTransaction().commit();
		
		con.getEm().close();
		con.getFactory().close();
	}
	
	public void remove(Long id){
		
		ConectionMysql con = new ConectionMysql();
		
		Usuario query = con.getEm().find(Usuario.class, id);
		
		con.getEm().getTransaction().begin();
		con.getEm().remove(query);
		con.getEm().getTransaction().commit();
		con.getEm().close();
		con.getFactory().close();
		
	}
	
	public List<Usuario> lista(){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT x FROM Usuario x";
		
		TypedQuery<Usuario> qr = con.getEm().createQuery(jpql, Usuario.class);
		
		List<Usuario> lista = qr.getResultList();
		
		con.getEm().close();
		
		con.getFactory().close();
		
		return lista;
		
	}
	public Usuario busca(Long id){
		
		ConectionMysql con = new ConectionMysql();
		
		//String jpql = "SELECT x FROM Usuario x";
		
		//TypedQuery<Usuario> qr = con.getEm().createQuery(jpql, Usuario.class);
		
		Usuario query = con.getEm().find(Usuario.class, id);
		
		con.getEm().close();
		
		con.getFactory().close();
		
		
		return query;
		
	}	

}
