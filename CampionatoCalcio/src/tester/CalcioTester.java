package tester;

import core.*;
import exception.NumberNotAvailableException;
import exception.NumberNotValidException;
import exception.SquadraRegisteredException;

public class CalcioTester {

	public static void main(String[] args) {
		//Creazione Campionato
		Campionato c = new Campionato("Serie A");
		
		//Creazione Squadre
		Squadra s1 = new Squadra("Napoli", 2);
		Squadra s2 = new Squadra("Inter", 5);
		Squadra s3 = new Squadra("Milan", 4);
		Squadra s4 = new Squadra("Juventus", 7);
		Squadra s5 = new Squadra("Roma", 3);
		
		//Aggiunta Squadre al campionato
		try {
			if(c.squadraSubscription(s1)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(c.squadraSubscription(s2)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(c.squadraSubscription(s3)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(c.squadraSubscription(s4)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(c.squadraSubscription(s5)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(c.squadraSubscription(s1)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			System.out.println("Squadra NON aggiunta!\n\n");
		}
		
		
		//Creazione e aggiunta calciatori alle squadre
		Calciatore c1 = new Calciatore("Lautaro","Martinez","Attaccante",10);
		Calciatore c2 = new Calciatore("Frank","Ribery","Centrocampista",9);
		Calciatore c3 = new Calciatore("Olivier","Giroud","Attaccante",9);
		Calciatore c4 = new Calciatore("Davide","Frattesi","Centrocampista",20);
		Calciatore c5 = null;
		
		try
		{
			c5 = new Calciatore("Hirving","Lozano","Attaccante",0);
		}
		catch(NumberNotValidException e)
		{
			System.out.println(e.getMessage());
			c5 = new Calciatore("Hirving","Lozano","Attaccante",11);
		}
		
		if(c.addPlayer(c1, s2)) System.out.println("\n\n" + c1 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c1 + " NON aggiunto!\n\n");
		
		if(c.addPlayer(c2, s4)) System.out.println("\n\n" + c2 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c2 + " NON aggiunto!\n\n");
		
		if(c.addPlayer(c3, s3)) System.out.println("\n\n" + c3 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c3 + " NON aggiunto!\n\n");
		
		if(c.addPlayer(c4, s5)) System.out.println("\n\n" + c4 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c4 + " NON aggiunto!\n\n");

		if(c.addPlayer(c5, s1)) System.out.println("\n\n" + c5 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c5 + " NON aggiunto!\n\n");
		
		Calciatore c6 = new Calciatore("Romelu","Lukaku","Attaccante",10);
		
		try
		{
			if(c.addPlayer(c6, s2)) System.out.println("\n\n" + c6 + " aggiunto!\n\n");
			else System.out.println("\n\n" + c6 + " NON aggiunto!\n\n");
		}
		catch(NumberNotAvailableException e)
		{
			System.out.println(e.getMessage());
			c6.setNumero(99);
			if(c.addPlayer(c6, s2)) System.out.println("\n\n" + c6 + " aggiunto!\n\n");
			else System.out.println("\n\n" + c6 + " NON aggiunto!\n\n");
		}
		
		
		//Stampa di tutti i calciatori numero 9 iscritti al campionato
		System.out.println("\n\nStampo le info di tutti i numeri 9 iscritti al campionato\n\n");
		for(Squadra s: c.getSquadre()) {
			s.printPlayerByCond(
					x->x.getNumero()==9, 
					x->System.out.println(x));
		}
		
		//Cerca Squadra per nome
		System.out.println("\n\nStampo le info di una squadra cercata per nome");
		System.out.println(c.searchBySquadra("Napoli"));
		
		//Stampa squadre per scudetti
		System.out.println("\n\nStampo le squadre in ordine decrescente di scudetti");
		c.printSquadraByScudetti();

	}

}
