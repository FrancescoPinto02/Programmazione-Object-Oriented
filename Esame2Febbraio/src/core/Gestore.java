package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Gestore {

	private ArrayList<Personaggio> personaggi;

	//Costruttore
	public Gestore(int numPers) {
		this.personaggi = randomPers(numPers);
	}

	
	//Getter e Setter
	public ArrayList<Personaggio> getPersonaggi() {
		return personaggi;
	}
	public void setPersonaggi(ArrayList<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}
	
	//Crea una lista di numPers personaggi casuali
	private ArrayList<Personaggio> randomPers(int numPers) {
		ArrayList<Personaggio> pers = new ArrayList<Personaggio>();
		Random r = new Random();
		
		for(int i=0; i<numPers; i++) {
			if(i%2 == 0) {
				pers.add(new Cavaliere(r.nextInt(100+1)));
			}
			else {
				pers.add(new Orco(r.nextInt(100+1)));
			}
		}
		
		return pers;
	}
	
	//Salva i personaggi su file
	public void saveToFile(String filename) {
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(Personaggio x : this.personaggi) {
				out.println(x);
			}
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			out.close();
		}
	}
	
	public int getPos(Personaggio pers) {
		return pers.getCurrentPos();
	}
	
	public ArrayList<String> getPosAll(){
		ArrayList<String> pos = new ArrayList<String>();
		
		for(Personaggio x : this.personaggi) {
			String p = "ID:" + x.getId() + " posizione:" + x.getCurrentPos();
			pos.add(p);
		}
		
		return pos;
	}
	
	public String getType(Personaggio pers)
	{
		return pers.getTipo();
	}
	
	
}
