package br.com.jsf;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Contato {
	
	private String nome;
	private String email;
	private String telefone;
	private String comentario;
	private String ass;
	private String sex;
	
	private Map<String, String> sexo = new LinkedHashMap<String, String>();
	private Map<String, String> assunto = new LinkedHashMap<String, String>();
	
	
	public Contato(){
	
		this.sexo.put("Masculino", "M");
		this.sexo.put("Feminino", "F");
		
		this.assunto.put("Recursos humanos", "RH");
		this.assunto.put("Suporte Técnico", "TI");
		this.assunto.put("Outros", "OUTROS");
	}
	
	public String forumlario(){
		
		this.nome = getNome();
		this.email = getEmail();
		this.telefone = getTelefone();
		this.comentario = getComentario();
		this.sex = this.sexo.get(this.sex);
		this.ass = this.assunto.get(this.ass);
		
		return "frm_contato";
		
		
	}
	
	
	
	
	public String getAss() {
		return ass;
	}

	public void setAss(String ass) {
		this.ass = ass;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Map<String, String> getSexo() {
		return sexo;
	}
	public void setSexo(Map<String, String> sexo) {
		this.sexo = sexo;
	}
	public Map<String, String> getAssunto() {
		return assunto;
	}
	public void setAssunto(Map<String, String> assunto) {
		this.assunto = assunto;
	}
	
	
	
}
