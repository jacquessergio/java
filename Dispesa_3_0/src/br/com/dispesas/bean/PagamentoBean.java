package br.com.dispesas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dispesas.dao.DispesaDao;
import br.com.dispesas.dao.PagamentoDao;
import br.com.dispesas.model.Pagamento;
import br.com.dispesas.util.Data;

@ManagedBean
@ViewScoped
public class PagamentoBean {

	private Data cx;
	
	public PagamentoBean(){
		
		this.cx = new Data();
	}

	public void inserir(Pagamento u){
		
		new PagamentoDao().inserir(u);
	
	}
	
	public void remove(Long id){
		
		new PagamentoDao().remove(id);
	}
	
	public List<Pagamento> listar(){

		List<Pagamento> l = new PagamentoDao().listar();
		
		return l;
	
	}
	
	public List<Pagamento> listaMes(){

		List<Pagamento> l = new PagamentoDao().listaMes(this.cx.filtra_data());
		
		return l;
	
	}
	
	
	 public Double somaMes() {
			
			Double l = new PagamentoDao().somaMes(this.cx.filtra_data());

			return l;

		}
	 
	 public Double somaAno(String ano) {
			
			Double l = new PagamentoDao().somaAno(ano);

			return l;

		}
	
}
