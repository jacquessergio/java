package br.com.dispesas.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@ManagedBean
@Entity
public class Dispesa extends GenericID  {

	
	public Dispesa(){
		
		this.data = new Date();
	}
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "Campo não pode ser vazio.")
	private String nome;
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "Campo não pode ser vazio.")
	private Double valor;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull(message = "Campo (Dispesa parcelada) não pode ser nulo")
	@Column(nullable = false)
	private Boolean parcelado;
	
	private Integer num_parcelas;
	
	
	private Double val_parcelas;
	
	@Temporal(TemporalType.DATE)
	private Date data_inicial;
	
	@Temporal(TemporalType.DATE)
	private Date data_final;
	
	private String descricao;
	
	@ManyToOne
	private Usuario usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getParcelado() {
		return parcelado;
	}

	public void setParcelado(Boolean parcelado) {
		this.parcelado = parcelado;
	}

	public Integer getNum_parcelas() {
		return num_parcelas;
	}

	public void setNum_parcelas(Integer num_parcelas) {
		this.num_parcelas = num_parcelas;
	}
	
	public Double getVal_parcelas() {
		return val_parcelas;
	}

	public void setVal_parcelas(Double val_parcelas) {
		this.val_parcelas = val_parcelas;
	}

	public Date getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	
	
	
	
	
	
	
	
	
}
