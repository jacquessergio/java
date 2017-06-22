package br.com.jsf;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

	private static List<Curso> cursos = new ArrayList<Curso>();
	
	static{
		
		cursos.add(new Curso(1L,  "K01", "Lógica de Programação", "logo"));
		cursos.add(new Curso(2L,  "K02", "Desenvolvimento Web com HTML , CSS e JavaScript", "logo"));
		cursos.add(new Curso(3L,  "K03", "SQL e Modelo Relacional", "logo"));
		cursos.add(new Curso(4L,  "K04", "Desenvolvimento Web com JSF2 e JPA2", "logo"));
		cursos.add(new Curso(5L,  "K04", "Persistência com JAP2 e Hibernate", "logo"));
		cursos.add(new Curso(6L,  "K04", "Desenvolvimento Web Avançado com EJB , JSF e CDI", "logo"));
		cursos.add(new Curso(7L,  "K04", "Integração de Sistemas com Webservices , JMS e EJB", "logo"));
		cursos.add(new Curso(8L,  "K04", "C# e Orientação a Objetos", "logo"));
		cursos.add(new Curso(9L,  "K04", "Desenvolvimento Web com ASP .NET MVC", "logo"));
		cursos.add(new Curso(10L, "K04", "Desenvolvimento Mobile com Android", "logo"));
		cursos.add(new Curso(11L, "K04", "Design Patterns em Java", "logo"));
		cursos.add(new Curso(12L, "K04", "Desenvolvimento Web com Struts", "logo"));
		
	}
	
	
	public List<Curso> getCursos() {
		
		return cursos;
	}

	
	
	
}
