package br.com.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MostraNome {
	
	private String nome;
	private Integer n1;
	private Integer n2;
	private Double media;
	
	public void mediaAluno(){
		
		this.media = (double) ((this.n1 + this.n2) / 2);
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getN1() {
		return n1;
	}

	public void setN1(Integer n1) {
		this.n1 = n1;
	}

	public Integer getN2() {
		return n2;
	}

	public void setN2(Integer n2) {
		this.n2 = n2;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

}
