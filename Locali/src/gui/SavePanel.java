package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.*;

@SuppressWarnings("serial")
public class SavePanel extends JPanel {

	private JLabel label;
	private JTextField text;
	private JButton button;
	private LocaliManager m;
	
	public SavePanel(LocaliManager m) {
		this.m = m;
		this.label = new JLabel("Salva Su File");
		this.text = new JTextField(20);
		this.button = new JButton("Salva");
		
		button.addActionListener((ActionEvent e)->{
			this.m.saveLocali(this.text.getText() + ".txt", x -> x instanceof Locale);
			this.m.saveLocali(this.text.getText() + "Pizzerie.txt", x -> x instanceof Pizzeria);
			this.m.saveLocali(this.text.getText() + "Paninoteche.txt", x -> x instanceof Paninoteca);
			this.m.saveLocaliFull(this.text.getText() + "Full.txt");
		});
		
		add(this.label);
		add(this.text);
		add(this.button);
	}
}
