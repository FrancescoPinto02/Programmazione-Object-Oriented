package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import core.Gestore;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private Gestore m;
	private JPanel panel;
	
	public MainGUI(String titolo) {
		this.setTitle(titolo);
		this.setSize(200,200);
		this.setLocation(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = buildPanel();
		this.m = null;
		add(panel);
	}

	private JPanel buildPanel() {
		JPanel mainPanel = new JPanel();
		
		JLabel l = new JLabel("Numero Personaggi");
		JTextArea t = new JTextArea("");
		
		JButton b = new JButton("Crea");
		b.addActionListener((ActionEvent e)->{
			this.m = new Gestore(Integer.parseInt(t.getText()));
			this.m.saveToFile("outputGUI.txt");
		});
		
		mainPanel.add(l);
		mainPanel.add(t);
		mainPanel.add(b);
		
		return mainPanel;
	}
}
