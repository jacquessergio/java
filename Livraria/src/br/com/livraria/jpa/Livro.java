package br.com.livraria.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//EXEMPLO DE MUITOS PARA MUITOS - 1 LIVRO PODE TER VARIOS AUTORES, ASSIM COMO VARIOS AUTORES PODEM TER VARIOS LIVROS

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	@JoinTable(name="liv_aut", joinColumns=@JoinColumn(name="liv_id"), inverseJoinColumns=@JoinColumn(name="aut_id"))
	private Collection<Autor> autores = new ArrayList<Autor>();
	private String titulo;
	private Double preco;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
	
	
	
}
