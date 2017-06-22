package br.com.dispesas.bean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import br.com.dispesas.dao.DispesaDao;
import br.com.dispesas.model.Dispesa;
import br.com.dispesas.util.Data;

@ManagedBean
@ViewScoped
public class DispesaBean {
	
	private Data cx;
	
	public DispesaBean(){
		
		this.cx = new Data();
	}

	public void inserir(Dispesa u) {
		
		//Controle para dispesas parceladas
		
		if(u.getParcelado().equals(true)){
				
			this.cx.check(u);
		}
		
		new DispesaDao().inserir(u);

	}

	public void remove(Long id) {

		new DispesaDao().remove(id);
	}

	public List<Dispesa> listar(Long id) {
		
		List<Dispesa> l = new DispesaDao().listar(this.cx.filtra_data(), id);

		return l;

	}
	
   public Double somaMes() {
		
		Double l = new DispesaDao().somaMes(this.cx.filtra_data());

		return l;

	}
   
   public Double somaAno(String ano){
	   
	   Double l = new DispesaDao().somaAno(ano);

	   return l;
	   
   }
   
  


}
