package br.com.dispesas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dispesas.dao.ResumoDao;
import br.com.dispesas.util.Data;

@ManagedBean
@ViewScoped
public class ResumoBean {

	private Data cx;
	
	public ResumoBean(){
		
		this.cx = new Data();
	}

	public Double saldoMes() {
			
			Double l = new ResumoDao().somaMes(this.cx.filtra_data());

			return l;

		}
	
}
