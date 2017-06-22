package local.dispesa.util;

import java.text.NumberFormat;

public class FormatoMoeda {

	public String frmMoeda(Double val){
				
		if(val != 0){
		
			return NumberFormat.getCurrencyInstance().format(val);
		
		}else{
			
			return NumberFormat.getCurrencyInstance().format("000");	
		}
	}
	
	
}
