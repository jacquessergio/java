package br.com.jsit.sisonline.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa extends GenericDomain {
	
	@Column(nullable=false, length = 30)
	private String nome;
	@Column(nullable=false, length = 2)
	private Integer idade;
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	
	
}
