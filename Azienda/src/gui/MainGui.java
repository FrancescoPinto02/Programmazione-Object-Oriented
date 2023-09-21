package gui;
import java.awt.event.ActionEvent;

import javax.swing.*;
import core.DipendentiManager;

public class MainGui extends JFrame {
	
	private DipendentiManager manager;
	
	public MainGui(String titolo, DipendentiManager manager) {
		this.manager = manager;
		setTitle(titolo);
		setSize(300,150);
		setLocation(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = buildPanel();
		add(mainPanel);
		setVisible(true);
	}
	
	private JPanel buildPanel() {
		JPanel mainPanel = new JPanel();
		JPanel stipPanel = new JPanel();
		JPanel filePanel = new JPanel();
		
		JLabel stipLabel = new JLabel("Ricerca Per Stipendio");
		JTextField stipText = new JTextField("stipendio minimo");
		JButton stipButton = new JButton("Cerca");
		stipButton.addActionListener((ActionEvent e)->{
			this.manager.printDipendentiBySalario(Integer.parseInt(stipText.getText()));
		});
		
		JLabel fileLabel = new JLabel("Salva dipendenti su file");
		JTextField fileText = new JTextField("Nome File");
		JButton fileButton = new JButton("Salva");
		fileButton.addActionListener((ActionEvent e)->{
			this.manager.saveLavoratori(fileText.getText());
		});
		
		stipPanel.add(stipLabel);
		stipPanel.add(stipText);
		stipPanel.add(stipButton);
		
		filePanel.add(fileLabel);
		filePanel.add(fileText);
		filePanel.add(fileButton);
		
		mainPanel.add(stipPanel);
		mainPanel.add(filePanel);
		
		return mainPanel;
	}
}
