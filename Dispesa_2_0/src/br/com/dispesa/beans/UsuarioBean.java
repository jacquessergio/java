package br.com.dispesa.beans;


import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@ManagedBean
@Entity(name="Usuario")
@Table(name="Usuario")
public class UsuarioBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "Campo não pode ser nulo")
	private String nome;
	
	@NotNull(message = "Campo não pode ser nulo")
	@Pattern(regexp = ".+@.+\\.[a-z]+" , message = "Email Inválido")
	private String email;
	
	@NotNull(message = "Campo não pode ser nulo")
	private String senha;
	
	
	public Long getId() {
		
		return id;
		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
