package tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import core.Autobus;
import core.Treno;
import core.Veicolo;

public class Test {

	public static void main(String[] args) {
		ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();
		
		Treno t1 = new Treno(65);
		Treno t2 = new Treno(60);
		
		Autobus a1 = new Autobus(40);
		Autobus a2 = new Autobus(50);
		
		veicoli.add(a1);
		veicoli.add(a2);
		veicoli.add(t1);
		veicoli.add(t2);
		
		Test.saveToFile(veicoli, "output.txt");
		
		System.out.println("\n\nTreni in ritardo di almeno 60 minuti");
		Test.printByCond(veicoli, x->{return x instanceof Treno && ((Treno)x).getMinRitardo()>=60;} ,(System.out::println));

		System.out.println("\n\nAutobus con almeno 30 posti");
		Test.printByCond(veicoli, x->{return x instanceof Autobus && ((Autobus)x).getPosti()>=30;} ,(System.out::println));
	}
	
	
	public static <T> void printByCond(Iterable<T> list, Predicate<T> tester, Consumer<T> block) {
		for(T x : list) {
			if(tester.test(x)) {
				block.accept(x);
			}
		}
	}
	
	public static <T> void saveToFile(ArrayList<T> list, String filename) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(T x : list) {
				out.println(x);
			}
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			out.close();
		}
	}

}
