package tester;

import java.util.Collections;

import core.*;
import eccezioni.SalvataggioControllatoException;
import gui.MainGUI;

public class Test {

	public static void main(String[] args) throws SalvataggioControllatoException {
		StudentiManager studenti = new StudentiManager();
		
		Studente s1 = new Studente("Mario" , "Rossi", Studente.IN_CORSO, 20);
		Studente s2 = new Studente("Francesco" , "Pinto", Studente.IN_CORSO, 21);
		Studente s3 = new Studente("Fausto" , "Bonobo", Studente.FUORI_CORSO, 19);
		Studente s4 = new Studente("Gino" , "Buonvino", Studente.FUORI_CORSO, 23);
		
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		studenti.add(s4);
		
		MainGUI main = new MainGUI("main", studenti);
		main.setVisible(true);
		
		/*
		studenti.saveOnFile("output.txt");
		
		Collections.sort(studenti.getStudenti(), (a, b)->{
			return Studente.compareByEta(a, b);
		});
		studenti.saveOnFile("outputSorted.txt");
		
		StudentiManager.printStudByCond(studenti.getStudenti(), 
				s->s.getCategoria()==Studente.FUORI_CORSO,
				s->System.out.println(s));
		
		StudentiManager.printStudByCond(studenti.getStudenti(), 
				s->s.getEta()>30,
				s->System.out.println(s));
		
		StudentiManager.printStudByCond(studenti.getStudenti(), 
				s->s.getEta()<30,
				s->System.out.println(s)); */
	}

}
