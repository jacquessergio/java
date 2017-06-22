package local.dispesa.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import local.dispesa.entidades.Dispesas;
import local.dispesa.entidades.Salario;
import local.dispesa.entidades.Usuario;
import local.dispesa.fabrica.ConectionMysql;

public class ConectionTest {

	public static void main(String[] args) {

		 //creatTables();
		 //inserirUsuario();
		 //inserirDipesas();
		 //inserirSalario();

	}

	
	public void inserirSalario() {
		
		ConectionMysql con = new ConectionMysql();
		
		Salario s = new Salario();
	
		Usuario u = con.getEm().find(Usuario.class, 2L);
		s.setData(Calendar.getInstance());
		s.setFilraData(new SimpleDateFormat("yyyy-MM").format(new Date()));
		s.setValor(1563.69);
		s.setUsuario(u);
		
		con.getEm().getTransaction().begin();
		
		con.getEm().persist(s);
		
		con.getEm().getTransaction().commit();
		
		con.getEm().close();
		con.getFactory().close();
		
		
	}

	public static void inserirDipesas() {
		
		ConectionMysql con = new ConectionMysql();
		
					
		Dispesas d = new Dispesas();
		
		d.setDescricao("Emprestimo2");
		//Calendar.getInstance()
		d.setData(Calendar.getInstance());
		d.setFiltraData(new SimpleDateFormat("yyyy-MM").format(new Date()));
		d.setParcelas(10);
		d.setValor(965.25);
		d.setObservacao("obs emprestimo");
		
		
		Usuario u = con.getEm().find(Usuario.class, 2L); 
		
		d.setUsuario(u);
		
		con.getEm().getTransaction().begin();
		con.getEm().persist(d);
		con.getEm().getTransaction().commit();
		con.getEm().close();
		con.getFactory().close();
		
	}

	public static void creatTables() {

		ConectionMysql con = new ConectionMysql();
		con.getFactory();
		con.getFactory();

		con.getEm().close();
		con.getFactory().close();
	}

	public static void inserirUsuario() {

		ConectionMysql con = new ConectionMysql();

		Usuario u = new Usuario();
		u.setNome("pricila");
		u.setEmail("pricila@yahoo.com.br");
		u.setSenha("123456");

		con.getEm().getTransaction().begin();
		con.getEm().persist(u);
		con.getEm().getTransaction().commit();
		con.getEm().close();
		con.getFactory().close();

	}

}
