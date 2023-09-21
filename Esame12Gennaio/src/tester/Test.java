package tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import core.*;
import gui.MainGUI;

public class Test {

	public static void main(String[] args) {
		ArrayList<Autovettura> auto = new ArrayList<Autovettura>();

		Macchina m1 = new Macchina("Macchina", 4, 1100, "Verde", "T10001T", 5);
		Macchina m2 = new Macchina("Macchina", 4, 1500, "Rossa", "T20002T", 6);
		Camion c1 = new Camion("Camion", 8, 2000, "Nero", "T30003T", 8, 500, 3000);
		Camion c2 = new Camion("Camion", 9, 2500, "Bianco", "T40004T", 8, 800, 5000);
		
		auto.add(m1);
		auto.add(m2);
		auto.add(c1);
		auto.add(c2);
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("autovetture.txt")));
			for(Autovettura x : auto) {
				out.println(x);
			}
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			out.close();
		}
		
		//Esercizio 2: Stampa matricola di ogni camion presente nella lista di autovetture
		Test.printCamion(auto, 
				x->x instanceof Camion, 
				x->System.out.println(((Camion)x).getMatricola()));
		
		//Esercizion 3a: Contare numero dei camion che trasportano un rimorchio con un peso maggiore di 5 tonnellate e hanno un limite di velocità maggiore a 80km/h
		int c = Test.countCamionByCondition(auto, x->{return x instanceof Camion && ((Camion)x).getPesoMax()>5000  && ((Camion)x).getLimVel()>80;});
		System.out.println("Camion che trasportano rimorchio con peso maggiore di 5 tonnellate e hanno velocità maggiore a 80km/h: " + c);
		
		//Esercizio 3b: Stampare le macchine che hanno almeno 6 marce
		Test.printMacchineByMarce(auto, 6);
	
	
		MainGUI gui = new MainGUI("Esame 12 Gennaio" , auto);
		gui.setVisible(true);
	
	
	}
	

	public static void printCamion(Iterable<Autovettura> list, Predicate<Autovettura> pred, Consumer<Autovettura> con) {
		for(Autovettura x : list) {
			if(pred.test(x)) {
				con.accept(x);
			}
		}
	}
	
	public static int countCamionByCondition(List<Autovettura> list, Predicate<Autovettura> pred) {
		int count = 0;
		count = (int) list.stream().filter(pred).count();
		
		return count;
	}
	
	public static void printMacchineByMarce(List<Autovettura> list, int marce) {
		list.stream().filter(x->{
			return x instanceof Macchina && ((Macchina)x).getMarce()>=marce;
		}).forEach(System.out::println);
	}
	
}



