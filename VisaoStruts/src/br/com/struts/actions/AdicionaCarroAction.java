package br.com.struts.actions;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import br.com.struts.model.Carro;
import br.com.struts.model.CarroRepository;

@SuppressWarnings("serial")
public class AdicionaCarroAction extends ActionSupport {

	private Carro carro = new Carro();
	
	public String execute() throws Exception{
		
		EntityManager manager =  this.getEntityManager();		
		CarroRepository repository =  new CarroRepository(manager);
		
		repository.adiciona(this.carro);
		this.carro = new Carro();
		return AdicionaCarroAction.SUCCESS;
	}
	
	public List<Carro> getCarros(){
		
		EntityManager manager =  this.getEntityManager();		
		CarroRepository repository =  new CarroRepository(manager);
		
		return repository.lista();
		
	}
	
	private EntityManager getEntityManager(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		
		return manager;
		
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
}
