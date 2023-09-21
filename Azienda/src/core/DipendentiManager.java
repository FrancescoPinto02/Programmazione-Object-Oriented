package core;

import java.io.*;
import java.util.*;

import interfacce.FileManager;

public class DipendentiManager implements FileManager {

	private ArrayList<Dipendente> dipendenti;
	
	//Costruttori
	public DipendentiManager() {
		this.dipendenti = new ArrayList<Dipendente>();
	}
	public DipendentiManager(ArrayList<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
	//Getter e setter
	public ArrayList<Dipendente> getDipendenti(){
		return this.dipendenti;
	}
	public void setDipendenti(ArrayList<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
	//Restituisce un elenco di tutti gli stagisti
	public ArrayList<Stagista> getStagisti(){
		ArrayList<Stagista> list = new ArrayList<Stagista>();
		
		for(Dipendente d : this.dipendenti) {
			if(d instanceof Stagista) {
				list.add((Stagista)d);
			}
		}
		
		return list;
	}
	
	//Stampa tutti i dipendenti con un stipendio mensile maggiore strettamente di x
	public void printDipendentiBySalario(int x) {
		System.out.println("DIPENDENTI CON SALARIO MAGGIORE DI " + x);
		
		for(Dipendente d : this.dipendenti) {
			if(d.calcolaStipendio() > x) {
				System.out.println(d);
			}
		}
	}
	
	//Lettura dipendenti indeterminati da file Indeterminatifilename
	@Override
	public void readLavoratori(String filename) {
		String filenameS = "Indeterminato" + filename;
		BufferedReader in = null;
		String nome;
		
		try {
			in = new BufferedReader(new FileReader(filenameS));
			while((nome = in.readLine())!=null) {
				String cognome = in.readLine();
				int id = Integer.parseInt(in.readLine());
				double salario = Double.parseDouble(in.readLine());
				String qualifica = in.readLine();
				
				Indeterminato i = new Indeterminato(nome , cognome, id, salario, qualifica);
				this.dipendenti.add(i);
				in.close();
			}
		}
		catch(Exception e) {
			System.out.println("Errore Lettura da File!");
			System.exit(-1);
		}
	}

	//Memorizza dipendenti su file binario
	public void saveLavoratoriSerializable(String filename) {
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(this.dipendenti);
			out.close();
		}
		catch(Exception e) {
			System.out.println("Errore Scrittura su file");
			System.exit(-1);
		}
	}
	
	
	//Memorizza Dipendenti sul file filename
	@Override
	public void saveLavoratori(String filename) {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(Dipendente d : this.dipendenti) {
				pw.println(d);
			}
		}
		catch(Exception e) {
			System.out.println("Errore Scrittura su file");
			System.exit(-1);
		}
		finally {
			pw.close();
		}
	}

}
