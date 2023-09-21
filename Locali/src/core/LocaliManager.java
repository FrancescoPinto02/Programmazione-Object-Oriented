package core;

import java.io.*;
import java.util.HashMap;
import java.util.function.Predicate;

import interfacce.LocaleOptions;

public class LocaliManager implements LocaleOptions {

	private HashMap<Integer, Locale> locali;
	
	//Costruttori
	public LocaliManager() {
		this.locali = new HashMap<Integer, Locale>();
	}
	
	//Getter e Setter
	public HashMap<Integer, Locale> getLocali(){
		return this.locali;
	}
	public void setLocali(HashMap<Integer, Locale> locali) {
		this.locali = locali;
	}
	
	//Metodo per prenotare un locale
	@Override
	public void prenotazione(int np, Locale l) {
		if(this.locali.containsValue(l)) {
			if(l.prenota(np)) {
				System.out.println("Prenotazione Effettuata");
			}
			else {
				System.out.println("Prenotazione Fallita");
			}
		}
		else {
			System.out.println("Locale non registrato");
		}
	}

	//Metodo per stampare tutte le informazioni dei locali
	@Override
	public void printInfo() {
		System.out.println("STAMPA INFO DI TUTTI I LOCALI");
		for(Integer key : this.locali.keySet()) {
			System.out.println(this.locali.get(key));
		}

	}

	//Metodo per registrare un nuovo locale
	@Override
	public void insertLocale(Locale l) {
		if(this.locali.containsValue(l)) {
			System.out.println("Locale già registrato");
		}
		else {
			this.locali.put(l.hashCode(), l);
			System.out.println("Locale registrato");
		}
		

	}

	//Metodo per stampare le pizzerie che hanno una specifica pizza nel menu
	public void printPizzerieByPizza(String pizza) {
		System.out.println("STAMPA INFO DI TUTTE LE PIZZERIE CHE HANNO LA PIZZA " + pizza.toUpperCase() + " IN MENU");
		for(Integer k : this.locali.keySet()) {
			
			Locale l = this.locali.get(k);
			
			if(l instanceof Pizzeria && ((Pizzeria)l).getMenu().containsKey(pizza)) {
				System.out.println(l);
				System.out.println("Prezzo Pizza " + pizza + ":" +((Pizzeria)l).getMenu().get(pizza));
			}
		}
	}

	//Metodo per creare, riempire e restituire un`istanza di LocaliManager
	public static LocaliManager createManager() {
		LocaliManager lm = new LocaliManager();
		
		Paninoteca p1 = new Paninoteca("Panino Figo", "Via della fame n. 7", 30, 40, 20);
		Paninoteca p2 = new Paninoteca("Paniniamo", "Via del cibo n. 22", 10, 20, 10);
		
		Pizzeria p3 = new Pizzeria("Speedy Pizza", "Corso degli alberghi", 20);
		Pizzeria p4 = new Pizzeria("Pizziamo", "Corso Europa", 0);
		
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		map1.put("Margherita", 7);
		map1.put("Diavola", 8);
		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		map2.put("Mais", 5);
		map2.put("Diavola", 6);
		p3.setMenu(map1);
		p4.setMenu(map2);
		
		lm.insertLocale(p1);
		lm.insertLocale(p2);
		lm.insertLocale(p3);
		lm.insertLocale(p4);
		
		return lm;
	}
	
	public void saveLocali(String filename, Predicate<Locale> condition) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(Integer k : this.locali.keySet()) {
				Locale l = this.locali.get(k);
				if(condition.test(l) == true) {
					pw.println(l);
				}
			}
			pw.close();
		}
		catch(Exception e) {
			System.out.println("Errore di scrittura!");
			System.exit(-1);
		}
	}
	
	public void saveLocaliFull(String filename) {
		this.saveLocali(filename, x -> x.getPostiDisp()==0);
	}
	
	public void readPaninoteche(String filename) throws IOException {
		BufferedReader bf = null;
		try {
			bf=new BufferedReader(new FileReader(filename));
			
			String nome = null;
			while((nome = bf.readLine()) != null) {
				String indirizzo = bf.readLine();
				int postiDisp = Integer.parseInt(bf.readLine());
				int panini = Integer.parseInt(bf.readLine());
				int birre = Integer.parseInt(bf.readLine());
				
				Paninoteca p = new Paninoteca(nome, indirizzo, postiDisp, panini, birre);
				this.locali.put(p.hashCode(), p);
			}
		}
		catch(Exception e){
			e.printStackTrace();;
			System.exit(-1);
		}
		finally {
			bf.close();
		}
	}
	
	public void readPizzerie(String filename) throws IOException {
		BufferedReader bf = null;
		try {
			bf=new BufferedReader(new FileReader(filename));
			
			String nome = new String();
			while((nome = bf.readLine()) != null) {
				String indirizzo = bf.readLine();
				int postiDisp = Integer.parseInt(bf.readLine());
				Pizzeria p = new Pizzeria(nome, indirizzo, postiDisp);
				
				int numPizze = Integer.parseInt(bf.readLine());
				for(int i=0; i<numPizze; i++) {
					p.addPizza(bf.readLine(), Integer.parseInt(bf.readLine()));
				}
				
				this.locali.put(p.hashCode(), p);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally {
			bf.close();
		}
	}


}
