package br.com.dispesas.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
@Entity
public class Usuario extends GenericID {
	
	@NotNull(message = "Campo nome não pode ser nulo")
	@Column(nullable = false, length = 50)
	@Size(min=5,max=50, message = "O campo nome deve conter de 5 a 50 caracteres ")
	private String nome;
	
	
	@NotNull(message = "Campo email não pode ser nulo")
	@Pattern(regexp = ".+@.+\\.[a-z]+" , message = "Email Inválido")
	@Column(nullable = false, length = 70)
	private String login;
	
	@NotNull(message = "Campo senha não pode ser nulo")
	@Column(nullable = false, length = 10)
	@Size(min=5,max=10, message = "O campo senha deve conter de 5 a 10 caracteres ")
	private String senha;
	
	@NotNull(message = "Campo tipo não pode ser nulo")
	@Column(nullable = false, length = 1)
	private Character type;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Usuario(){
		
		this.data = new Date();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Character getType() {
		return type;
	}
	public void setType(Character type) {
		this.type = type;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	
	
}
