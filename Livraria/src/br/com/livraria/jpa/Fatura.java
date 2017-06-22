package br.com.livraria.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fatura {

	@Id
	@GeneratedValue
	private Long id;
	
	
	@OneToMany(mappedBy="fatura")
	private Collection<Ligacao> ligacao = new ArrayList<Ligacao>();
	
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Collection<Ligacao> getLigacao() {
		return ligacao;
	}

	public void setLigacao(Collection<Ligacao> ligacao) {
		this.ligacao = ligacao;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}
	
	
	
	
}
