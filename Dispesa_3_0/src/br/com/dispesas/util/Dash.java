package br.com.dispesas.util;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean
public class Dash {
	
	private DashboardModel model;
	
	public Dash(){
		
		model = new DefaultDashboardModel();
		DashboardColumn col1 = new DefaultDashboardColumn();
		DashboardColumn col2 = new DefaultDashboardColumn();
		DashboardColumn col3 = new DefaultDashboardColumn();
		DashboardColumn col4 = new DefaultDashboardColumn();
		
		col1.addWidget("Dispesa");
		col2.addWidget("Investimento");
		col3.addWidget("Pagamento");
		col4.addWidget("Poupança");
		
		model.addColumn(col1);
		model.addColumn(col2);
		model.addColumn(col3);
		model.addColumn(col4);
		
		
	}

	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}
	
	

}
