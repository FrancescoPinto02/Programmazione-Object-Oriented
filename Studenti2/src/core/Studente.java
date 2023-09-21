package core;

import java.util.ArrayList;
import java.util.Objects;

public class Studente {
	
	public static final int IN_CORSO = 0;
	public static final int FUORI_CORSO = 1;
	
	private static int countMatricole = 0;
	private static String matricolaBase = "051210000";

	private String matricola;
	private String nome;
	private String cognome;
	private int categoria;
	private int eta;
	private ArrayList<Corso> corsi;
	
	//Costruttori
	public Studente(String nome, String cognome, int categoria, int eta) {
		Studente.countMatricole++;
		this.matricola = Studente.matricolaBase + Studente.countMatricole;
		this.nome = nome;
		this.cognome = cognome;
		this.categoria = categoria;
		this.eta = eta;
		this.corsi = new ArrayList<Corso>();
	}
	
	//Get e Set
	public String getMatricola() {
		return this.matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
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
	public int getCategoria() {
		return this.categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getEta() {
		return this.eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public ArrayList<Corso> getCorsi() {
		return this.corsi;
	}
	public void setCorsi(ArrayList<Corso> corsi) {
		this.corsi = corsi;
	}

	//Confronta l`eta di due studenti
	public static int compareByEta(Studente a, Studente b) {
		if(a.getEta()==b.getEta()) {
			return 0;
		}
		else if(a.getEta()>b.getEta()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	//Utility
	public String toString() {
		return "STUDENTE = [matricola: " + matricola + " nome: " + nome + " cognome: " + cognome + " categoria: "
				+ categoria + " eta: " + eta + "]";
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
		
		Studente other = (Studente) obj;
		return categoria == other.categoria && cognome.equalsIgnoreCase(other.cognome) && eta == other.eta
				&& matricola.equalsIgnoreCase(other.matricola) && nome.equalsIgnoreCase(other.nome);
	}
	public int hashCode() {
		return Objects.hash(categoria, cognome, eta, matricola, nome);
	}
	
	
}
