package core;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListaPacchiNatale extends ListaPacchi {

	private int numPacchi;
	
	//Costruttori
	public ListaPacchiNatale(GregorianCalendar dataCreazione, GregorianCalendar dataConsegna, ArrayList<Pacco>pacchi) {
		super(dataCreazione, dataConsegna, pacchi);
		this.numPacchi = 0;
	}
	public ListaPacchiNatale(GregorianCalendar dataCreazione, GregorianCalendar dataConsegna) {
		super(dataCreazione, dataConsegna);
		this.numPacchi = 0;
	}
	
	//Get e Set
	public int getNumPacchi() {
		return this.numPacchi;
	}
	public void setNumPacchi(int numPacchi) {
		this.numPacchi = numPacchi;
	}
	
	//Aggiunge il Pacco p alla lista
	@Override
	public boolean aggiungi(Pacco p) {
		ArrayList<Pacco> l = super.getPacchi();
		if(l.contains(p)) {
			return false;
		}
		else {
			l.add(p);
			this.numPacchi++;
			return true;
		}
	}

	//Rimuove il Pacco p dalla lista
	@Override
	public boolean rimuovi(Pacco p) {
		ArrayList<Pacco> l = super.getPacchi();
		if(!(l.contains(p))) {
			return false;
		}
		else {
			l.remove(p);
			this.numPacchi--;
			return true;
		}

	}

	//Modifica la data di consegna
	@Override
	public boolean modifica(GregorianCalendar data) {
		if(GregorianCalendar.getInstance().after(data)) {
			return false;
		}
		else {
			super.setDataConsegna(data);
			return true;
		}
	}

	//Memorizza la lista di regali sul file
	public void saveToFile(String filename) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			out.println("ID LISTA: " + super.getCodice());
			for(Pacco p : super.getPacchi()) {
				out.println(p);
			}
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			out.close();
		}
	}
	
	public static void printDataLambda(ArrayList<Pacco> list, Predicate<Pacco> tester, Consumer<Pacco> block) {
		for(Pacco p: list) {
			if(tester.test(p)) {
				block.accept(p);
			}
		}
	}
	
}
