package br.com.struts.jpa;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class JPAFilter implements Filter {

	private EntityManagerFactory factory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		this.factory = Persistence.createEntityManagerFactory("struts");
	}
	
	@Override
	public void destroy() {

		this.factory.close();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//CHEGADA
		EntityManager manager = this.factory.createEntityManager();
		req.setAttribute("EntityManager", manager);
		manager.getTransaction().begin();
		
		//FILTRO DO STRUTS
		chain.doFilter(req, res);
		
		//SAIDA
		try {
			manager.getTransaction().commit();						
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}

	}


}
