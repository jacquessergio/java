package br.com.dispesas.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dispesas.model.Dispesa;
import br.com.dispesas.model.Usuario;

public class DispesaTest {

	public static void main(String[] args) {
	
		inserir();	
		
		//calcula_data();	
			
		
	}

	
	public Date calcula_data(String data, int parcelas) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dx  = new Date();
		
		String[] es = data.split(Pattern.quote("-"));
				
		int ano = Integer.parseInt(es[0]);
		int mes = Integer.parseInt(es[1]);
		int dia = Integer.parseInt(es[2]);
		
	//	Calendar xz = c;
		
		Calendar cl = Calendar.getInstance();
				
		cl.set(ano, mes, dia);
		
		cl.add(Calendar.MONTH, parcelas);
		
		dx = cl.getTime();
		
		return dx;
		
	}


	private static void inserir() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dispesa");
		EntityManager em = emf.createEntityManager();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date data_inicial  = new Date();
			
		try{			
			data_inicial = df.parse("2017-07-14");
				
		}catch (ParseException e) {
			
			e.printStackTrace();
		}
		
				
		Dispesa  d = new Dispesa();
			
		Date data_final = new DispesaTest().calcula_data("2017-07-14", (5 - 1));	
			
		d.setNome("Emprestimo");
		d.setValor(1500.52);
		d.setData(new Date());
		d.setDescricao("Emprestimo banco bradesco");
		
		d.setParcelado(true);
		d.setNum_parcelas(5);
		d.setVal_parcelas(300.15);
		
		d.setData_inicial(data_inicial);
		d.setData_final(data_final);
		
		d.setUsuario(em.find(Usuario.class, 1L));

		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		
	
		em.close();
		emf.close();
		
	}
	
}
