package local.dispesa.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Usuario extends GenericID {
	
	@Column(nullable=false, length=50)
	private String nome;
	
	
	@Column(nullable=false, length=60)
	private String email;
	
	
	@Column(nullable=false, length=10)
	private String senha;
	
		

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

		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
