package local.dispesa.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Dispesas extends GenericID {
	
	
	@ManyToOne
	private Usuario usuario;
	
	@Column(nullable = false, length = 75)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private String filtraData;
	
	@Column(nullable = false)
	private Integer parcelas;
	
	@Column(nullable = false)
	private Double valor;
	
	private String observacao;

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFiltraData() {
		return filtraData;
	}

	public void setFiltraData(String filtraData) {
		this.filtraData = filtraData;
	}
	
	
	
	
	
	
	
}
