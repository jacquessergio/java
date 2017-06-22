package br.com.dispesas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dispesas.dao.InvestimentoDao;
import br.com.dispesas.dao.PagamentoDao;
import br.com.dispesas.model.Investimento;
import br.com.dispesas.util.Data;


@ManagedBean
@ViewScoped
public class InvestimentoBean {

	private Data cx;
	
	public InvestimentoBean(){
		
		this.cx = new Data();
	}
	
	public void inserir(Investimento u){
		
		new InvestimentoDao().inserir(u);
	
	}
	
	public void remove(Long id){
		
		new InvestimentoDao().remove(id);
	}
	
	public List<Investimento> listar(){

		List<Investimento> l = new InvestimentoDao().listar();
		
		return l;
	
	}
	
	public List<Investimento> listaMes(){

		List<Investimento> l = new InvestimentoDao().listaMes(this.cx.filtra_data());
		
		return l;
	
	}
	
	
	 public Double somaMes() {
			
			Double l = new InvestimentoDao().somaMes(this.cx.filtra_data());

			return l;

		}
	 
	 public Double somaAno(String ano) {
			
			Double l = new InvestimentoDao().somaAno(ano);

			return l;

		}
}
