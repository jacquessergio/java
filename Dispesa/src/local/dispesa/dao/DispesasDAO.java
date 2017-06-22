package local.dispesa.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import local.dispesa.entidades.Dispesas;
import local.dispesa.fabrica.ConectionMysql;

public class DispesasDAO {
	
	
	
	public DispesasDAO() {
		

	}
	
	public void inserir(Dispesas d){
		
		ConectionMysql con = new ConectionMysql();
		
		con.getEm().getTransaction().begin();
		con.getEm().merge(d);
		con.getEm().getTransaction().commit();
		
		con.getEm().close();
		con.getFactory().close();
	}
	
	public List<Dispesas> lista(String data, Integer id){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT x FROM Dispesas x WHERE x.filtraData = :d AND usuario_id = :id";
		
		TypedQuery<Dispesas> qr = con.getEm().createQuery(jpql, Dispesas.class);
		
		qr.setParameter("d", data);
		qr.setParameter("id", id);
		
		List<Dispesas> lista = qr.getResultList();
		
		con.getEm().close();
		
		con.getFactory().close();
		
		
		if(lista.isEmpty()){
			
			return null;
		
		}else{
			
			return lista;
		}
		
	}
	
	public Double soma(String data, Integer id){
		
		ConectionMysql con = new ConectionMysql();
		
		String jpql = "SELECT SUM(x.valor) FROM Dispesas x WHERE x.filtraData = :d AND usuario_id = :id";
		
		TypedQuery<Double> qr = con.getEm().createQuery(jpql, Double.class);
		
		qr.setParameter("d", data);
		qr.setParameter("id", id);
		
		Double sm = qr.getSingleResult();
		
		return sm;
	}
	
	public void remove(Long id){
		
		ConectionMysql con = new ConectionMysql();
		
		Dispesas query = con.getEm().find(Dispesas.class, id);
		
		con.getEm().getTransaction().begin();
		con.getEm().remove(query);
		con.getEm().getTransaction().commit();
		con.getEm().close();
		con.getFactory().close();
		
	}
	
	public Dispesas busca(Long id){
		
		ConectionMysql con = new ConectionMysql();
	
		Dispesas query = con.getEm().find(Dispesas.class, id);
					
		con.getEm().close();
		con.getFactory().close();
		
		
		return query;
		
	}	

}
