package core;

import java.io.*;
import java.util.ArrayList;

import interfacce.EsameManager;
import interfacce.FileManager;

public class StudentiManager implements FileManager, EsameManager {
	private ArrayList<Studente> studenti;

	//Costruttori
	public StudentiManager() {
		studenti = new ArrayList<Studente>();
	}
	
	
	//Getter e Setter
	public ArrayList<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}
	
	//Restituisce una collection di studenti che hanno superato l`esame e
	public ArrayList<Studente> getStudentiByEsame(Esame e){
		ArrayList<Studente> list = new ArrayList<Studente>();
		
		for(Studente s : this.studenti) {
			if(s.getEsami().contains(e)) {
				list.add(s);
			}
		}
		
		return list;
	}

	//Aggiunge un esame alla lista degli esami completati di uno studente
	@Override
	public boolean addEsame(Esame e, Studente s) {
		if(e.getVoto() < 18 || e.getVoto()>30) {
			return false;
		}
		else {
			for(Studente studente : this.studenti) {
				if(studente.equals(s)) {
					return studente.insertEsame(e);
				}
			}
		}
		return false;
	}

	//Memorizza in un file tutti gli studenti DSA
	@Override
	public void storeDSA(String filename) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(Studente s : this.studenti) {
				if(s instanceof StudenteDSA) {
					pw.println(s);
					System.out.println("Scritto dsa");
				}
			}
			pw.close();
		}
		catch(Exception e) {
			System.out.println("Errore Scrittura");
			System.exit(-1);
		}

	}

	//Memorizza in un file tutti gli studenti non DSA
	@Override
	public void store(String filename) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(Studente s : this.studenti) {
				if(!(s instanceof StudenteDSA)) {
					pw.println(s);
					System.out.println("Scritto");
				}
			}
			pw.close();
		}
		catch(Exception e) {
			System.out.println("Errore Scrittura");
			System.exit(-1);
		}

	}

	public void printInfoDSA() {
		for(Studente s : this.studenti) {
			if(s instanceof StudenteDSA) {
				System.out.println(s);
			}
		}
	}
	
	public ArrayList<StudenteDSA> getStudentiByPat(String patologia){
		ArrayList<StudenteDSA> list = new ArrayList<StudenteDSA>();
		for(Studente s : this.studenti) {
			if((s instanceof StudenteDSA) && (((StudenteDSA) s).getPatologia().contains(patologia))) {
				list.add((StudenteDSA)s);
			}
		}
		return list;
	}
}
