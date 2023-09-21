package core;

import java.util.ArrayList;
import java.util.Date;

import gui.MainGui;

public class Tester {

	public static void main(String[] args) {
		Determinato d1 = new Determinato("Mario", "Rossi", 1, 1000, new Date(2024, 10, 20));
		Indeterminato i1 = new Indeterminato("Giorgio", "Bianchi", 2, 1500, "Dirigente");
		Stagista s1 = new Stagista("Gino", "Buonvino", 3, 800, i1);
		
		ArrayList<Dipendente> l = new ArrayList<Dipendente>();
		l.add(d1);
		l.add(i1);
		l.add(s1);
		
		DipendentiManager dm = new DipendentiManager(l);
		MainGui mg = new MainGui("Main", dm);

	}

}
