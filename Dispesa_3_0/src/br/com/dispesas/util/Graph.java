package br.com.dispesas.util;


import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.dispesas.dao.DispesaDao;
import br.com.dispesas.dao.InvestimentoDao;
import br.com.dispesas.dao.PagamentoDao;
import br.com.dispesas.dao.PoupancaDao;

@ManagedBean
public class Graph {

	  private CartesianChartModel model;
	
	   public Graph(){
		   
		   DispesaDao d = new DispesaDao();
		   PagamentoDao p = new PagamentoDao();
		   InvestimentoDao i = new InvestimentoDao();
		   PoupancaDao c = new PoupancaDao();
		   
		   model = new CartesianChartModel();
		   		   
		   ChartSeries mes = new ChartSeries();
	
		  		   
		   mes.setLabel("Dispesa");
		  
		   mes.set("Janeiro", d.somaMes("2017-01"));
		   mes.set("Fevereiro", d.somaMes("2017-02"));
		   mes.set("Março", d.somaMes("2017-03"));
		   mes.set("Abril", d.somaMes("2017-04"));
		   mes.set("Maio", d.somaMes("2017-05"));
		   mes.set("Junho", d.somaMes("2017-06"));
		   mes.set("Julho", d.somaMes("2017-07"));
		   mes.set("Agosto", d.somaMes("2017-08"));
		   mes.set("Setembro", d.somaMes("2017-09"));
		   mes.set("Outubro", d.somaMes("2017-10"));
		   mes.set("Novembro", d.somaMes("2017-11"));
		   mes.set("Dezembro", d.somaMes("2017-02"));
		   
	 	
		   ChartSeries pagamento = new ChartSeries();
		 	 
		   pagamento.setLabel("Pagamento");
		 	
		   pagamento.set("Janeiro", p.somaMes("2017-01"));
		   pagamento.set("Fevereiro", p.somaMes("2017-02"));
		   pagamento.set("Março", p.somaMes("2017-03"));
		   pagamento.set("Abril", p.somaMes("2017-04"));
		   pagamento.set("Maio", p.somaMes("2017-05"));
		   pagamento.set("Junho", p.somaMes("2017-06"));
		   pagamento.set("Julho", p.somaMes("2017-07"));
		   pagamento.set("Agosto", p.somaMes("2017-08"));
		   pagamento.set("Setembro", p.somaMes("2017-09"));
		   pagamento.set("Outubro", p.somaMes("2017-10"));
		   pagamento.set("Novembro", p.somaMes("2017-11"));
		   pagamento.set("Dezembro", p.somaMes("2017-12"));
		   
		   
		   ChartSeries saldo = new ChartSeries();
		 	 
		   saldo.setLabel("Saldo");
		 	
		   saldo.set("Janeiro", p.somaMes("2017-01") - d.somaMes("2017-01") );
		   saldo.set("Fevereiro", p.somaMes("2017-02") - d.somaMes("2017-02"));
		   saldo.set("Março", p.somaMes("2017-03") - d.somaMes("2017-03"));
		   saldo.set("Abril", p.somaMes("2017-04") - d.somaMes("2017-04"));
		   saldo.set("Maio", p.somaMes("2017-05") - d.somaMes("2017-05"));
		   saldo.set("Junho", p.somaMes("2017-06") - d.somaMes("2017-06"));
		   saldo.set("Julho", p.somaMes("2017-07") - d.somaMes("2017-07"));
		   saldo.set("Agosto", p.somaMes("2017-08") - d.somaMes("2017-08"));
		   saldo.set("Setembro", p.somaMes("2017-09") - d.somaMes("2017-09"));
		   saldo.set("Outubro", p.somaMes("2017-10") - d.somaMes("2017-10"));
		   saldo.set("Novembro", p.somaMes("2017-11") - d.somaMes("2017-11"));
		   saldo.set("Dezembro", p.somaMes("2017-12") - d.somaMes("2017-12"));
		   
		   
		   
		   
		   
		   ChartSeries investimento = new ChartSeries();
		 	 
		   investimento.setLabel("Investimento");
		 	
		   investimento.set("Janeiro", i.somaMes("2017-01"));
		   investimento.set("Fevereiro", i.somaMes("2017-02"));
		   investimento.set("Março", i.somaMes("2017-03"));
		   investimento.set("Abril", i.somaMes("2017-04"));
		   investimento.set("Maio", i.somaMes("2017-05"));
		   investimento.set("Junho", i.somaMes("2017-06"));
		   investimento.set("Julho", i.somaMes("2017-07"));
		   investimento.set("Agosto", i.somaMes("2017-08"));
		   investimento.set("Setembro", i.somaMes("2017-09"));
		   investimento.set("Outubro", i.somaMes("2017-10"));
		   investimento.set("Novembro", i.somaMes("2017-11"));
		   investimento.set("Dezembro", i.somaMes("2017-12"));
		   
		   
		   ChartSeries poupanca = new ChartSeries();
		 	 
		   poupanca.setLabel("Poupanca");
		 	
		   poupanca.set("Janeiro", c.somaMes("2017-01"));
		   poupanca.set("Fevereiro", c.somaMes("2017-02"));
		   poupanca.set("Março", c.somaMes("2017-03"));
		   poupanca.set("Abril", c.somaMes("2017-04"));
		   poupanca.set("Maio", c.somaMes("2017-05"));
		   poupanca.set("Junho", c.somaMes("2017-06"));
		   poupanca.set("Julho", c.somaMes("2017-07"));
		   poupanca.set("Agosto", c.somaMes("2017-08"));
		   poupanca.set("Setembro", c.somaMes("2017-09"));
		   poupanca.set("Outubro", c.somaMes("2017-10"));
		   poupanca.set("Novembro", c.somaMes("2017-11"));
		   poupanca.set("Dezembro", c.somaMes("2017-12"));
		   
		   
		   
		   model.addSeries(mes);
		   model.addSeries(pagamento);
		   model.addSeries(investimento);
		   model.addSeries(poupanca);
		   model.addSeries(saldo);
		 	 
			   
	   }

		public CartesianChartModel getModel() {
			return model;
		}
	
		public void setModel(CartesianChartModel model) {
			this.model = model;
		}
		   
	   



	   
}
