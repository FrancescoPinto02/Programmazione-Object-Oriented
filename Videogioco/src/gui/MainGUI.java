package gui;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.*;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	
	private ArrayList<Player> players;
	private JPanel panel;
	
	public MainGUI(String titolo) {
		this.players = new ArrayList<Player>();
		this.setTitle(titolo);
		this.setSize(500, 150);
		this.setLocation(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = buildPanel();
		this.add(panel);
	}
	
	private JPanel buildPanel() {
		JPanel mainPanel = new JPanel();
		
		JButton b1 = new JButton("Crea Players");
		b1.addActionListener((ActionEvent e) -> {
			Lottatore l1 = new Lottatore(100, 30, 50);
			Lottatore l2 = new Lottatore(120, 40, 40);
			Lottatore l3 = new Lottatore(140, 50, 30);
			Mago m1 = new Mago(50, 100, 30);
			Mago m2 = new Mago(55, 120, 30);
			Mago m3 = new Mago(60, 100, 40);
			LottatoreVolante lv1 = new LottatoreVolante(50, 60, 50);
			LottatoreVolante lv2 = new LottatoreVolante(40, 80, 40);
			LottatoreVolante lv3 = new LottatoreVolante(100, 40, 50);
			
			this.players.add(l1);
			this.players.add(l2);
			this.players.add(l3);
			this.players.add(m1);
			this.players.add(m2);
			this.players.add(m3);
			this.players.add(lv1);
			this.players.add(lv2);
			this.players.add(lv3);
		});
		
		JButton b2 = new JButton("Salva Player");
		b2.addActionListener((ActionEvent e) -> {
			PrintWriter out = null;
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("outputGUI.txt")));
				for(Player x : this.players) {
					out.println(x);
				}
				out.close();
			}
			catch(Exception e1) {
				e1.printStackTrace();
				out.close();
			}
		});
		
		
		JButton b3 = new JButton("Combattimento");
		b3.addActionListener((ActionEvent e) -> {
			if(this.players.size()==1) {
				System.out.println("\n\nVincitore Torneo: " + this.players.get(0));
				return;
			}
			
			Random r = new Random();
			int r1 = 0;
			int r2 = 0;
			
			r1 = r.nextInt(this.players.size());
			do {
				r2 = r.nextInt(this.players.size());
			}while(r1 == r2);
			
			
			Player p1 = this.players.get(r1);
			Player p2 = this.players.get(r2);
			this.players.remove(p1);
			this.players.remove(p2);
			
			System.out.println("\n\nCombattimento Tra:");
			System.out.println("P1 = " + p1);
			System.out.println("P2 = " + p2);
			
			for(int i=1; i<=10; i++) {
				System.out.println("ROUND " + i);
				if(i%2==0) {
					if(p1.attacco(p2)) {
						System.out.println("P1 ha attaccato con successo!");
					}
					else{
						System.out.println("P1 ha fallito l`attacco!");
					}
					
					p1.potenziamento();
					
				}
				else {
					if(p2.attacco(p1)) {
						System.out.println("P2 ha attaccato con successo!");
					}
					else{
						System.out.println("P2 ha fallito l`attacco!");
					}
					
					p2.potenziamento();
				}
				
				System.out.println("Aggiornamento statistiche");
				System.out.println("P1 = " + p1);
				System.out.println("P2 = " + p2);
				
				if(p1.getHp()<=0 || p2.getHp()<=0) {
					break;
				}	
			}
			
			System.out.println("Combattimento Terminato!");
			if(p1.getHp() > p2.getHp()) {
				System.out.println("Vincitore = P1!");
				this.players.add(p1);
			}
			else if(p2.getHp() > p1.getHp()) {
				System.out.println("Vincitore = P2!");
				this.players.add(p2);
			}
			else {
				System.out.println("Pareggio!");
				this.players.add(p1);
				this.players.add(p2);
			}
		});
		
		mainPanel.add(b1);
		mainPanel.add(b2);
		mainPanel.add(b3);
		
		return mainPanel;
	}
}
