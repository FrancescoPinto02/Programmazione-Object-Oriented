package core;

import java.util.GregorianCalendar;

public class Pacco {

	public static final int PICCOLO = 0;
	public static final int MEDIO = 1;
	public static final int GRANDE = 2;
	
	private static int ID = 0;
	
	private int codice;
	private String descrizione;
	private int tipo;
	private GregorianCalendar arrivo;
	
	//Costruttori
	public Pacco(String descrizione, int tipo, GregorianCalendar arrivo) {
		Pacco.ID++;
		this.codice = ID;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.arrivo = arrivo;
	}
	
	
	//Get e Set
	public int getCodice() {
		return this.codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return this.descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getTipo() {
		return this.tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public GregorianCalendar getArrivo() {
		return this.arrivo;
	}
	public void setArrivo(GregorianCalendar arrivo) {
		this.arrivo = arrivo;
	}
	
	
	//Utility
	public String toString() {
		return "PACCO = [codice: " + this.codice + " Descrizione: " + this.descrizione + " Tipo: " + this.tipo + " Data di Arrivo: " + this.formatData() +"]";
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
		
		Pacco p = (Pacco)obj;
		
		return this.codice == p.getCodice() && this.descrizione.equals(p.getDescrizione()) 
				&& this.tipo == p.getTipo() && this.arrivo.equals(p.getArrivo());
	}

	//Per formattare la data di arrivo in dd/mm/yyyy
	public String formatData() {
		GregorianCalendar c = this.arrivo;
		return c.get(GregorianCalendar.DAY_OF_MONTH) + "/" + c.get(GregorianCalendar.MONTH) + "/" + c.get(GregorianCalendar.YEAR);
	}
	
	public static int compareByDataArrivo(Pacco a, Pacco b) {
		return a.getArrivo().compareTo(b.getArrivo());
	}
	
}
