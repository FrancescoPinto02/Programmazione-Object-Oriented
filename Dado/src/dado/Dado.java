package dado;
import java.util.Random;

/*
 * Scrivere un programma che usi la classe Random per simulare il lancio di un 
 * dado, visualizzando un numero casuale compreso tra 1 e n , dove n è il numero delle facce del dado.
 * 
 * NB: un dado può avere 4,6,8,10,12,20 facce
 */


public class Dado {
	static final int FACE[] = {4,6,8,10,12,20}; //possibili numeri facce
	static final int DEF_FACE = 6; //facce default
	
	static Random generatore = new Random(); //generatore numero casuale lancio del dado
	
	private int facce; //numero facce del dado
	
	//Costruttori
	public Dado(int facce){
		if(controlloFacce(facce)==true) {
			this.facce=facce;
		}
		else {
			this.facce=DEF_FACE;
		}
	}
	public Dado() {
		this(DEF_FACE);
	}
	
	//Get e Set
	public int getFacce() {
		return this.facce;
	}
	public void setFacce(int newFacce) {
		if(controlloFacce(newFacce)==true) {
			this.facce=newFacce;
		}
		else {
			System.out.println("Errore: Numero facce non valido");
		}
	}
	
	//Controllo valore facce valido
	private boolean controlloFacce(int value) {
		//controlla se un valore è tra le facce consentite
		for(int j : FACE) {
			if(j == value) {
				return true; //restituisce true se il valore è consentito
			}
		}
		return false; //restituisce false se il valore non è consentito
	}

	//Metodo lancia dado
	public int lancia() {
		return generatore.nextInt(this.facce) + 1; //restituisce un numero casuale tra 1 e il numero di facce
	}
}
