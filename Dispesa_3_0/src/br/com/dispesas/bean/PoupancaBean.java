package br.com.dispesas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dispesas.dao.InvestimentoDao;
import br.com.dispesas.dao.PoupancaDao;
import br.com.dispesas.model.Poupanca;
import br.com.dispesas.util.Data;


@ManagedBean
@ViewScoped
public class PoupancaBean {

private Data cx;
	
	public PoupancaBean(){
		
		this.cx = new Data();
	}
	
	public void inserir(Poupanca u){
		
		new PoupancaDao().inserir(u);
	
	}
	
	public void remove(Long id){
		
		new PoupancaDao().remove(id);
	}
	
	public List<Poupanca> listar(){

		List<Poupanca> l = new PoupancaDao().listar();
		
		return l;
	
	}
	public List<Poupanca> listaMes(){

		List<Poupanca> l = new PoupancaDao().listaMes(this.cx.filtra_data());
		
		return l;
	
	}
	
	
	 public Double somaMes() {
			
			Double l = new PoupancaDao().somaMes(this.cx.filtra_data());

			return l;

		}
	 
	 public Double somaAno(String ano) {
			
			Double l = new PoupancaDao().somaAno(ano);

			return l;

		}
	
}
