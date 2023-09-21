package tester;

import java.io.IOException;

import core.LocaliManager;
import core.Paninoteca;
import core.Pizzeria;
import gui.MainGUI;

public class LocaliTest {
	
	public static void main(String[] args) throws IOException {
		LocaliManager m = LocaliManager.createManager();
		
		MainGUI gui = new MainGUI("main", m);

		m.readPaninoteche("inputPaninoteche.txt");
		m.saveLocali("outputPaninoteche.txt", x -> x instanceof Paninoteca);
		m.readPizzerie("inputPizzerie.txt");
		m.saveLocali("outputPizzerie.txt", x -> x instanceof Pizzeria);
		m.saveLocali("output.txt", x-> true);
	}

}
