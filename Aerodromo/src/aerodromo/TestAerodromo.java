package aerodromo;

import java.util.ArrayList;
import java.io.*;

public class TestAerodromo {

	public static void main(String[] args) {
		Aliante al1 = new Aliante("423ABE", 120);
		Aliante al2 = new Aliante("621CAA", 110);
		Aereomotore am1 = new Aereomotore("441DFA", 95);
		Aereomotore am2 = new Aereomotore("690FAD", 65);
		
		ArrayList<Aeromobile> l = new ArrayList<Aeromobile>();
		l.add(al1);
		l.add(am1);
		l.add(al2);
		l.add(am2);
		System.out.println(l);

		if(am1.superiore(am2)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		if(al1.superiore(al2)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", false)));
			for(Aeromobile a : l) {
				out.println(a);
			}
			out.close();
		}
		catch(Exception e) {
			System.out.println("Errore output!");
			System.exit(-1);
		}
	}

}
