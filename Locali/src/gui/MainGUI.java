package gui;

import java.awt.Color;

import javax.swing.*;

import core.LocaliManager;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	
	private LocaliManager m;
	JPanel mainPanel;
	
	public MainGUI(String title, LocaliManager m) {
		setBackground(Color.BLUE);
		setSize(1000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		this.m = m;
		this.mainPanel = buildPanel();
		add(this.mainPanel);
		setVisible(true);
	}
	
	public JPanel buildPanel() {
		JPanel mainPanel = new JPanel();
		JPanel searchPanel = new SearchPanel(this.m);
		JPanel savePanel = new SavePanel(this.m);
		
		mainPanel.add(searchPanel);
		mainPanel.add(savePanel);
		
		return mainPanel;
	}
	
	
}
