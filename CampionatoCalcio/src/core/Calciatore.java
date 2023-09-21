package core;

import java.util.Objects;

import exception.NumberNotValidException;

public class Calciatore {

	private String nome;
	private String cognome;
	private String ruolo;
	private int numero;
	private int goal;
	
	//Costruttori
	public Calciatore(String nome, String cognome, String ruolo, int numero, int goal) {
		if(numero<1 || numero>99) {
			throw new NumberNotValidException();
		}
		else {
			this.nome = nome;
			this.cognome = cognome;
			this.ruolo = ruolo;
			this.numero = numero;
			this.goal = goal;
		}
	}
	public Calciatore(String nome, String cognome, String ruolo, int numero) {
		this(nome, cognome, ruolo, numero, 0);
	}

	
	//Get e Set
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRuolo() {
		return this.ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		if(numero<1 || numero>99) {
			throw new NumberNotValidException();
		}
		else {
			this.numero = numero;
		}
	}
	public int getGoal() {
		return this.goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}

	
	//Utility
	public String toString() {
		return "CALCIATORE = [Nome: " + this.nome + " Cognome: " + this.cognome + " Ruolo: " + this.ruolo 
				+ " Numero: " + this.numero + " Goal: " + this.goal + "]";
	}
	
	public int hashCode() {
		return Objects.hash(this.nome, this.cognome, this.ruolo, this.numero, this.goal);
	}
	
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		
		Calciatore other = (Calciatore)obj;
		return cognome.equalsIgnoreCase(other.cognome) && goal == other.goal
				&& nome.equalsIgnoreCase(other.nome) && numero == other.numero
				&& Objects.equals(ruolo, other.ruolo);
	}

}
