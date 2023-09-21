package core;

import exception.MotoreException;
import interfacce.Auto;

public abstract class Autovettura implements Auto {
	
	static final boolean ACCESA = true;
	static final boolean SPENTA = false;
	
	protected static int numAutovetture = 0;
	
	private String tipo;
	private int ruote;
	private int cilindrata;
	private String colore;
	private boolean stato;
	
	//costruttori
	public Autovettura(String tipo, int ruote, int cilindrata, String colore) {
		this.tipo = tipo;
		this.ruote = ruote;
		this.cilindrata = cilindrata;
		this.colore = colore;
		this.stato = Autovettura.SPENTA;
		Autovettura.numAutovetture++;
	}
	
	//Get e Set
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getRuote() {
		return this.ruote;
	}
	public void setRuote(int ruote) {
		this.ruote = ruote;
	}
	public int getCilindrata() {
		return this.cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public String getColore() {
		return this.colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public boolean getStato() {
		return this.stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}

	//spegne auto
	public abstract void spegni(Auto a) throws MotoreException;
	
	//Utility
	public String toString() {
		return "Autovettura = [Tipo:" + this.tipo + ", Ruote:" + this.ruote + ", Cilindrata:" + this.cilindrata
				+ ", Colore:" + this.colore + ", Stato:" + this.getStato() + "]";
	}

	
}
