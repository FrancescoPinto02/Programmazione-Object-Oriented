package rettangolo;

public class Rettangolo implements Comparable<Rettangolo> {
	static final int DEF_BASE = 10;
	static final int DEF_ALTEZZA = 5;
	
	private int base = 0;
	private int altezza = 0;
	
	//Costruttore con parametri base e altezza
	public Rettangolo(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	//Costruttore senza parametri
	public Rettangolo() {
		this(DEF_BASE, DEF_ALTEZZA); //chiama l`altro costruttore passando come parametri i valori default (costanti)
	}
	
	//Metodi Get e Set
	public int getBase() {
		return this.base;
	}
	
	public void setBase(int base) {
		this.base = base;
	}
	
	public int getAltezza() {
		return this.altezza;
	}
	
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}


	//Calcolare l`area
	public int area() {
		return this.base * this.altezza;
	}
	
	//Calcolare perimetro
	public int perimetro() {
		return (this.base + this.altezza)*2 ;
	}
	
	//Metodo Finalize
	public void finalize() {
		System.out.println("Rettangolo Distrutto");
	}
		
	public String toString() {
		return "Base: " + this.base + " Altezza: " + this.altezza;
	}
	
	public int compareTo(Rettangolo r) {
		if(this.base == r.base) {
			return 0;
		}
		else if(this.base > r.base) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
