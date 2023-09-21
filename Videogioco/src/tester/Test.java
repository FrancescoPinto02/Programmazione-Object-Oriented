package tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import core.*;

public class Test {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		
		Lottatore l1 = new Lottatore(100, 30, 50);
		Lottatore l2 = new Lottatore(120, 40, 40);
		Lottatore l3 = new Lottatore(140, 50, 30);
		Mago m1 = new Mago(50, 100, 30);
		Mago m2 = new Mago(55, 120, 30);
		Mago m3 = new Mago(60, 100, 40);
		
		players.add(l1);
		players.add(l2);
		players.add(l3);
		players.add(m1);
		players.add(m2);
		players.add(m3);
		
		Test.saveToFile(players, "players.txt");
		
		System.out.println("\n\nStampa di tutti i Player\n");
		Test.printPlayerByCond(players, p -> p instanceof Player, (System.out::println));
		
		System.out.println("\n\nStampa dei Player con attacco e difesa maggiori o uguali a 50\n");
		Test.printPlayerByCond(players, p -> {return p.getAttacco()>=50 && p.getDifesa()>=50;}, (System.out::println));
		
		System.out.println("\n\nStampa dei Player con vita maggiore o uguale della difesa\n");
		Test.printPlayerByCond(players, p -> {return p.getHp()>= p.getDifesa();}, (System.out::println));
		
		System.out.println("\n\nStampa dei Maghi\n");
		Test.printPlayerByCond(players, p -> p instanceof Mago, (System.out::println));
		
		System.out.println("\n\nStampa dei Lottatori\n");
		Test.printPlayerByCond(players, p -> p instanceof Lottatore, (System.out::println));
		
		System.out.println("\n\nStampa attacco di tutti i Player\n");
		Test.printPlayerByCond(players, p -> p instanceof Player, p -> System.out.println(p.getAttacco()));
		
		LottatoreVolante lv1 = new LottatoreVolante(50, 60, 50);
		LottatoreVolante lv2 = new LottatoreVolante(40, 80, 40);
		LottatoreVolante lv3 = new LottatoreVolante(100, 40, 50);
		
		players.add(lv1);
		players.add(lv2);
		players.add(lv3);
		
		Test.saveToFile(players, "players2.txt");
		
		System.out.println("\n\nStampa di tutti i Player\n");
		Test.printPlayerByCond(players, p -> p instanceof Player, (System.out::println));
		
		System.out.println("\n\nStampa dei Player con attacco e difesa maggiori o uguali a 50\n");
		Test.printPlayerByCond(players, p -> {return p.getAttacco()>=50 && p.getDifesa()>=50;}, (System.out::println));
		
		System.out.println("\n\nStampa dei Player con vita maggiore o uguale della difesa\n");
		Test.printPlayerByCond(players, p -> {return p.getHp()>= p.getDifesa();}, (System.out::println));
		
		System.out.println("\n\nStampa dei Maghi\n");
		Test.printPlayerByCond(players, p -> p instanceof Mago, (System.out::println));
		
		System.out.println("\n\nStampa dei Lottatori\n");
		Test.printPlayerByCond(players, p -> p instanceof Lottatore, (System.out::println));
		
		System.out.println("\n\nStampa attacco di tutti i Player\n");
		Test.printPlayerByCond(players, p -> p instanceof Player, p -> System.out.println(p.getAttacco()));
	}
	
	
	public static void printPlayerByCond(ArrayList<Player> list, Predicate<Player> tester, Consumer<Player> block) {
		list.stream().filter(tester).forEach(block);
	}
	
	public static void saveToFile(ArrayList<Player> list, String filename) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for(Player x : list) {
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
