package local.dispesa.dao;

import javax.persistence.TypedQuery;

import local.dispesa.fabrica.ConectionMysql;

public class BalancoDao {

	
	public Double dispesaAno( Integer id){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT SUM(x.valor) FROM Dispesas x WHERE usuario_id = :id";
		
		TypedQuery<Double> qr = con.getEm().createQuery(jpql, Double.class);
		
		qr.setParameter("id", id);
		
		Double sm = qr.getSingleResult();
		
		return sm;
	}
	
	public Double pagamentoAno( Integer id){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT SUM(x.valor) FROM Salario x WHERE usuario_id = :id";
		
		TypedQuery<Double> qr = con.getEm().createQuery(jpql, Double.class);
		
		qr.setParameter("id", id);
		
		Double sm = qr.getSingleResult();
		
		return sm;
	}
	
}
