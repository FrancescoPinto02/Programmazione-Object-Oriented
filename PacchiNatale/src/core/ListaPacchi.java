package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import interfacce.Lista;

public abstract class ListaPacchi implements Lista {
	
	private static int ID = 0;
	
	private int codice;
	private GregorianCalendar dataCreazione;
	private GregorianCalendar dataConsegna;
	private ArrayList<Pacco> pacchi;
	
	//Costruttori
	public ListaPacchi(GregorianCalendar dataCreazione, GregorianCalendar dataConsegna, ArrayList<Pacco>pacchi) {
		ListaPacchi.ID++;
		this.codice = ID;
		this.dataCreazione = dataCreazione;
		this.dataConsegna = dataConsegna;
		this.pacchi = pacchi;
	}
	public ListaPacchi(GregorianCalendar dataCreazione, GregorianCalendar dataConsegna) {
		this(dataCreazione, dataConsegna, new ArrayList<Pacco>());
	}
	
	
	//Get e Set
	public int getCodice() {
		return this.codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public GregorianCalendar getDataCreazione() {
		return this.dataCreazione;
	}
	public void setDataCreazione(GregorianCalendar dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public GregorianCalendar getDataConsegna() {
		return this.dataConsegna;
	}
	public void setDataConsegna(GregorianCalendar dataConsegna) {
		this.dataConsegna = dataConsegna;
	}
	public ArrayList<Pacco> getPacchi(){
		return this.pacchi;
	}
	public void setPacchi(ArrayList<Pacco> pacchi) {
		this.pacchi = pacchi;
	}

	public abstract boolean modifica(GregorianCalendar data);

}
