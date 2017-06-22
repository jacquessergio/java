package br.com.dispesas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dispesas.dao.UsuarioDao;
import br.com.dispesas.model.Usuario;
import br.com.dispesas.util.Autenticacao;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	public void inserir(Usuario u){
		
		new UsuarioDao().inserir(u);
	
	}
	
	public void remove(Long id){
		
		new UsuarioDao().remove(id);
	}
	
	public List<Usuario> listar(){

		List<Usuario> l = new UsuarioDao().listar();
		
		return l;
	
	}
	
	public void autentica(Usuario u){
		
		new Autenticacao().autentica(u);
	}
	
}
