package core;

import exception.MotoreException;
import interfacce.Auto;

public class Macchina extends Autovettura {

	private int matricola;
	private String targa;
	private int marce;
	
	//costruttori
	public Macchina(String tipo, int ruote, int cilindrata, String colore, String targa, int marce) {
		super(tipo, ruote, cilindrata, colore);
		this.matricola = Autovettura.numAutovetture;
		this.targa = targa;
		this.marce = marce;
	}
	
	//get e set
	public int getMatricola() {
		return this.matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getTarga() {
		return this.targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getMarce() {
		return this.marce;
	}
	public void setMarce(int marce) {
		this.marce = marce;
	}

	//Accende l`auto
	@Override
	public void Accendi(Auto a) throws MotoreException {
		if(((Autovettura)a).getStato() == Autovettura.ACCESA) {
			throw new MotoreException("Auto Già Accesa!");
		}
		else {
			((Autovettura)a).setStato(Autovettura.ACCESA);
			System.out.println("Auto Accesa!");
		}

	}

	//Spegne l`auto
	@Override
	public void spegni(Auto a) throws MotoreException {
		if(((Autovettura)a).getStato() == Autovettura.SPENTA) {
			throw new MotoreException("Auto Già Spenta!");
		}
		else {
			((Autovettura)a).setStato(Autovettura.SPENTA);
			System.out.println("Auto Spenta!");
		}

	}

	//Auto avanti se è accesa
	public void avanti() {
		if(this.getStato() == Autovettura.ACCESA) {
			System.out.println("Avanti!");
		}
		else {
			System.out.println("Auto Spenta!");
		}
	}
	
	//Auto indietro se è accesa
	public void indietro() {
		if(this.getStato() == Autovettura.ACCESA) {
			System.out.println("Indietro!");
		}
		else {
			System.out.println("Auto Spenta!");
		}
	}


	//Utility
	public String toString() {
		return "Macchina = [Matricola:" + this.matricola + ", Targa:" + this.targa + ", Marce:" + this.marce
				+ " " + super.toString() + "]";
	}
	
}
