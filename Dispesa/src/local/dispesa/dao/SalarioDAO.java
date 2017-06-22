package local.dispesa.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import local.dispesa.entidades.Salario;
import local.dispesa.fabrica.ConectionMysql;

public class SalarioDAO {

	
   public void inserir(Salario d){
		
		ConectionMysql con = new ConectionMysql();
		
		con.getEm().getTransaction().begin();
		con.getEm().merge(d);
		con.getEm().getTransaction().commit();
		
		con.getEm().close();
		con.getFactory().close();
	}
   
   public void remove(Long id){
		
		ConectionMysql con = new ConectionMysql();
		
		Salario query = con.getEm().find(Salario.class, id);
		
		con.getEm().getTransaction().begin();
		con.getEm().remove(query);
		con.getEm().getTransaction().commit();
		con.getEm().close();
		con.getFactory().close();
		
	}
   
   public Salario busca(Long id){
		
		ConectionMysql con = new ConectionMysql();
	
		Salario query = con.getEm().find(Salario.class, id);
					
		con.getEm().close();
		con.getFactory().close();
		
		
		return query;
		
	}	
	
	public List<Salario> salario(String data, Integer id){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT x FROM Salario x WHERE x.filraData = :d AND usuario_id = :u";
		
		TypedQuery<Salario> qr = con.getEm().createQuery(jpql, Salario.class);
		
		qr.setParameter("d", data);
		qr.setParameter("u", id);
		
		List<Salario> lista = qr.getResultList();
		
		con.getEm().close();
		
		con.getFactory().close();
		
		if(lista.isEmpty()){
			
			return null;
		
		}else{
			
			return lista;
		}
		
		
		
		
	}
	
	public Double salarioSomaMes(String data, Integer id){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT SUM(x.valor) FROM Salario x WHERE x.filraData = :d AND usuario_id = :u";
		
		TypedQuery<Double> qr = con.getEm().createQuery(jpql, Double.class);
		
		qr.setParameter("d", data);
		qr.setParameter("u", id);
		
		Double lista = qr.getSingleResult();
		
		
		
		con.getEm().close();
		
		con.getFactory().close();
		
		return lista;
		
		
	}
	
}
