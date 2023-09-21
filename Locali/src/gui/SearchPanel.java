package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;

import core.LocaliManager;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel {

	private JLabel label;
	private JTextField text;
	private JButton button;
	private LocaliManager m;
	
	public SearchPanel(LocaliManager m) {
		this.m = m;
		this.label = new JLabel("Ricerca per Pizza");
		this.text = new JTextField(20);
		this.button = new JButton("Cerca");
		
		button.addActionListener((ActionEvent e)->{
			this.m.printPizzerieByPizza(this.text.getText());
		});
		
		add(this.label);
		add(this.text);
		add(this.button);
	}
}
