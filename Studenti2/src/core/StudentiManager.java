package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import eccezioni.SalvataggioControllatoException;
import interfacce.StudentiOperations;

public class StudentiManager implements StudentiOperations {

	private ArrayList<Studente> studenti;
	
	//Costruttori
	public StudentiManager() {
		this.studenti = new ArrayList<Studente>();
	}
	
	//Get e set
	public ArrayList<Studente> getStudenti(){
		return this.studenti;
	}
	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}
	
	//Aggiunge uno studente alla lista
	@Override
	public boolean add(Studente s) {
		if(this.studenti.contains(s)) {
			return false;
		}
		else {
			this.studenti.add(s);
			return true;
		}
	}

	//Rimuove lo studente s dalla lista
	@Override
	public boolean remove(Studente s) {
		if(!(this.studenti.contains(s))) {
			return false;
		}
		else {
			this.studenti.remove(s);
			return true;
		}
	}

	//Aggiunge il corso c alla lista dei corsi dello studente s
	@Override
	public boolean addCorso(Studente s, Corso c) {
		if(!(this.studenti.contains(s))){
			return false;
		}
		else {
			for(Studente x : this.studenti) {
				if(x.equals(s)) {
					x.getCorsi().add(c);
				}
			}
			return true;
		}
	}

	//Salva la lista di studenti sul file
	public void saveOnFile(String filename) throws SalvataggioControllatoException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			
			for(Studente s: this.studenti) {
				out.println(s);
			}
			
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			out.close();
		}
	}
	
	//Ricerca con parametri da usare con espressioni Lambda
	public static void printStudByCond(List<Studente> list, Predicate<Studente> tester, Consumer<Studente> block) {
		for(Studente x : list) {
			if(tester.test(x)) {
				block.accept(x);
			}
		}
	}
}
