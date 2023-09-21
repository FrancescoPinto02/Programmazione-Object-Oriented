package core;

import java.util.Objects;

public class Corso {
	private String nome;
	private String docente;
	private int cfu;
	
	//Costruttori
	public Corso(String nome, String docente, int cfu) {
		this.nome = nome;
		this.docente = docente;
		this.cfu = cfu;
	}
	
	//Get e Set
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocente() {
		return this.docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	//Utility
	public String toString() {
		return "CORSO = [Nome: " + this.nome + " Docente: " + this.docente + " Cfu: " + this.cfu + "]";
	}
	public int hashCode() {
		return Objects.hash(this.nome, this.docente, this.cfu);
	}
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Corso c = (Corso)obj;
		return this.nome.equals(c.getNome()) && this.docente.equals(c.getDocente()) && this.cfu == c.getCfu();
	}

	
}
