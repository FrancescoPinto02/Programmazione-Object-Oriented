package tester;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

import core.*;
import gui.MainGUI;

public class Test {

	public static void main(String[] args) {
		MainGUI gui = new MainGUI("Esame 2 Febbraio");
		gui.setVisible(true);
		
		Gestore m = new Gestore(10);
		m.saveToFile("output.txt");
		
		//Esercizio 2
		System.out.println("\n\nStampa identificativo univoco di ogni orco");
		Test.printByCondLambda(m.getPersonaggi(),
				x->x instanceof Orco, 
				x->{System.out.println(((Orco)x).getId());});
		
		//Esercizio 3.1
		int count = (int)m.getPersonaggi().stream().filter(x->{
			return x instanceof Cavaliere && x.getEnergia()>50 &&x.getCurrentPos()<50;
		}).count();
		System.out.println("\n\nNumero cavalieri con piu di 50 di energia e posizione minore di 50: " + count);
		
		//Esercizio 3.2
		System.out.println("\n\nStampa identificativo univoco di ogni cavaliere con energia > 70");
		m.getPersonaggi().stream().filter(x->{
			return x instanceof Cavaliere && x.getEnergia()>70;
		}).map(x->x.getId()).forEach(System.out::println);

	}
	
	
	public static <T> void printByCondLambda(Iterable<T> it, Predicate<T> tester, Consumer<T> block) {
		for(T x : it) {
			if(tester.test(x)) {
				block.accept(x);
			}
		}
	}
	

}
