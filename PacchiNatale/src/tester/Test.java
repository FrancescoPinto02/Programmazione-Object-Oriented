package tester;

import java.util.Collections;
import java.util.GregorianCalendar;

import core.ListaPacchiNatale;
import core.Pacco;
import gui.MainGUI;

public class Test {

	public static void main(String[] args) {
		
		//Creazione Regali
		Pacco p1 = new Pacco("Computer", Pacco.GRANDE, new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 20));
		Pacco p2 = new Pacco("Cuffie", Pacco.MEDIO, new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 21));
		Pacco p3 = new Pacco("Telefono", Pacco.PICCOLO, new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 18));
		Pacco p4 = new Pacco("Fumetto", Pacco.PICCOLO, new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 19));
		
		//Creazione Lista
		GregorianCalendar creazione = new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 10);
		GregorianCalendar consegna = new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 25);
		ListaPacchiNatale lista = new ListaPacchiNatale(creazione, consegna);
		
		//Aggiunta regali alla lista
		lista.aggiungi(p1);
		lista.aggiungi(p2);
		lista.aggiungi(p3);
		lista.aggiungi(p4);

		//Salvataggio lista su file
		lista.saveToFile("output.txt");
		
		//Ordinamento lista
		Collections.sort(lista.getPacchi(), (a, b)->{return Pacco.compareByDataArrivo(a,b);});
		lista.saveToFile("outputSorted.txt");
		
		//Stampa data di consegna di ogni pacco grande presente nella lista
		ListaPacchiNatale.printDataLambda(lista.getPacchi(),
				p->p.getTipo()==Pacco.GRANDE, 
				p->System.out.println(p.formatData()));
		
		//Test GUI
		MainGUI gui = new MainGUI("prova", lista);
	}

}
