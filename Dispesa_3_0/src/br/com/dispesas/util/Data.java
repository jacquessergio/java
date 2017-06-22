package br.com.dispesas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.dispesas.model.Dispesa;


@ManagedBean
public class Data {

	private Date d_i, d_f;
	private SimpleDateFormat sdf;
	private Calendar cal;
	private HttpServletRequest request;
	
	public Data(){
		this.sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.d_i = new Date();
		this.d_f = new Date();
		this.cal = Calendar.getInstance();
		this.request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public void check(Dispesa u){
		
		//INSERE DATA ATUAL - CADASTRO
		//u.setData(new Date());
		
		//INI - CALCULA DATA FINAL DAS PARCELAS
		
		String cx = this.sdf.format(u.getData_inicial());
		
		String[] splt = cx.split(Pattern.quote("-"));
		
		int ano = Integer.parseInt(splt[0]);
		int mes = Integer.parseInt(splt[1]);
		int dia = Integer.parseInt(splt[2]);
		
		this.cal.set(ano, mes, dia);
		
		this.cal.add(Calendar.MONTH, u.getNum_parcelas() - 2);
		
		if (u.getParcelado().equals(true)) {

			u.setData_final(this.cal.getTime());
		}
		
		//FIM - CALCULA DATA FINAL DAS PARCELAS
		
		//CONVERTE DATA INICIAL
		
		try{			
			
			u.setData_inicial(this.sdf.parse(cx));
				
		}catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		//CONVERTE DATA INCIAL
		
	
	}
	

	
	
	public String setTab(){
		
		 int mes;
		    
		    int ano = this.cal.get(Calendar.YEAR);
		    
		    if(request.getParameter("i") == null){
		    	
		    	mes = this.cal.get(Calendar.MONTH);
		    
		    }else{
		    	
		    	mes = Integer.parseInt(request.getParameter("i"));
		    }
					
			String anoMes;
			
			switch (mes) {
			
			case 0:
				anoMes = "0";
				break;
			case 1:
				anoMes = "1";
				break;
			case 2:
				anoMes = "2";
				break;
			case 3:
				anoMes = "3";
				break;
			case 4:
				anoMes = "4";
				break;
			case 5:
				anoMes = "5";
				break;
			case 6:
				anoMes = "6";
				break;
			case 7:
				anoMes = "7";
				break;
			case 8:
				anoMes = "8";
				break;
			case 9:
				anoMes = "9";
				break;
			case 10:
				anoMes = "10";
				break;
			case 11:
				anoMes = "11";
				break;
			case 12:
				anoMes = "12";
				break;
			case 13:
				anoMes = "13";
				break;

			default:
				anoMes = ""+ano+"";
				break;
			}
			
			return anoMes;
	
		
}
	
	public String setMes(){
		
		 int mes;
		    
		    int ano = this.cal.get(Calendar.MONTH);
		    
		    if(request.getParameter("i") == null){
		    	
		    	mes = this.cal.get(Calendar.MONTH);
		    
		    }else{
		    	
		    	mes = Integer.parseInt(request.getParameter("i"));
		    }
					
			String anoMes;
			
			switch (mes) {
			
			case 0:
				anoMes = "JANEIRO";
				break;
			case 1:
				anoMes = "FEVEREIRO";
				break;
			case 2:
				anoMes = "MARÇO";
				break;
			case 3:
				anoMes = "ABRIL";
				break;
			case 4:
				anoMes = "MAIO";
				break;
			case 5:
				anoMes = "JUNHO";
				break;
			case 6:
				anoMes = "JULHO";
				break;
			case 7:
				anoMes = "AGOSTO";
				break;
			case 8:
				anoMes = "SETEMBRO";
				break;
			case 9:
				anoMes = "OUTURBO";
				break;
			case 10:
				anoMes = "NOVEMBRO";
				break;
			case 11:
				anoMes = "DEZEMBRO";
				break;

			default:
				anoMes = ""+ano+"";
				break;
			}
			
			return anoMes;
	
		
}
	
	
	
	
	public String filtra_data(){
		
	    		
	    int mes;
	    
	    int ano = this.cal.get(Calendar.YEAR);
	    
	    if(request.getParameter("i") == null){
	    	
	    	mes = this.cal.get(Calendar.MONTH);
	    
	    }else{
	    	
	    	mes = Integer.parseInt(request.getParameter("i"));
	    }
				
		String anoMes;
		
		switch (mes) {
		
		case 0:
			anoMes = ano + "-01";
			break;
		case 1:
			anoMes = ano + "-02";
			break;
		case 2:
			anoMes = ano + "-03";
			break;
		case 3:
			anoMes = ano + "-04";
			break;
		case 4:
			anoMes = ano + "-05";
			break;
		case 5:
			anoMes = ano + "-06";
			break;
		case 6:
			anoMes = ano + "-07";
			break;
		case 7:
			anoMes = ano + "-08";
			break;
		case 8:
			anoMes = ano + "-09";
			break;
		case 9:
			anoMes = ano + "-10";
			break;
		case 10:
			anoMes = ano + "-11";
			break;
		case 11:
			anoMes = ano + "-12";
			break;

		default:
			anoMes = ""+ano+"";
			break;
		}
		
		return anoMes;
	}
	
}
