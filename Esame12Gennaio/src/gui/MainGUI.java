package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.*;

public class MainGUI extends JFrame {

	private List<Autovettura> listAuto;
	private JPanel panel;
	
	public MainGUI(String titolo, List<Autovettura> listAuto) {
		this.listAuto = listAuto;
		setTitle(titolo);
		setSize(400, 500);
		setLocation(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = buildPanel();
		add(this.panel);
	}
	
	private JPanel buildPanel() {
		JPanel mainPanel =  new JPanel();
		JPanel dataPanel = new JPanel();
		JPanel butPanel = new JPanel();
		
		JLabel tipoLabel = new JLabel("Tipo");
		JComboBox<String> tipoBox = new JComboBox<String>();
		tipoBox.addItem("Macchina");
		tipoBox.addItem("Camion");
		
		JLabel ruoteLabel = new JLabel("Numero Ruote");
		JComboBox<Integer> ruoteBox = new JComboBox<Integer>();
		ruoteBox.addItem(4);
		ruoteBox.addItem(6);
		ruoteBox.addItem(8);
		
		JLabel cilLabel = new JLabel("Cilindrata");
		JTextField cilText = new JTextField("", 15);
		
		JLabel coloreLabel = new JLabel("Colore");
		JTextField coloreText = new JTextField("", 15);
		
		JButton b = new JButton("Inserisci");
		b.addActionListener((ActionEvent e)->{
			String tipo = (String) tipoBox.getSelectedItem();
			int ruote = (int) ruoteBox.getSelectedItem();
			int cilindrata = Integer.parseInt(cilText.getText());
			String colore = coloreText.getText();
			
			if(tipo.equalsIgnoreCase("Macchina")) {
				this.listAuto.add(new Macchina(tipo,ruote, cilindrata, colore, "", 0));
			}
			else {
				this.listAuto.add(new Camion(tipo,ruote,cilindrata, colore, "", 0, 0, 0));
			}
			System.out.println("Autoveicolo Aggiunto!");
		});
		
		JButton b2 = new JButton("Salva");
		b2.addActionListener((ActionEvent e)->{
			PrintWriter out = null;
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("autovettureFile.txt")));
				for(Autovettura x : this.listAuto) {
					out.println(x);
				}
				out.close();
			}
			catch(Exception exc) {
				exc.printStackTrace();
				out.close();
			}
		});
		
		dataPanel.setLayout(new GridLayout(4,2));
		dataPanel.add(tipoLabel);
		dataPanel.add(tipoBox);
		dataPanel.add(ruoteLabel);
		dataPanel.add(ruoteBox);
		dataPanel.add(cilLabel);
		dataPanel.add(cilText);
		dataPanel.add(coloreLabel);
		dataPanel.add(coloreText);
		
		butPanel.add(b);
		butPanel.add(b2);
		
		
		mainPanel.add(dataPanel);
		mainPanel.add(butPanel);
		
		return mainPanel;
	}
}
