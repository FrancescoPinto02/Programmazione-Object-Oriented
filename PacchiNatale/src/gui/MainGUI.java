package gui;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

import core.ListaPacchiNatale;
import core.Pacco;

public class MainGUI extends JFrame {
	
	private ListaPacchiNatale lista;
	
	public MainGUI(String titolo, ListaPacchiNatale lista) {
		this.lista = lista;
		setTitle(titolo + " ID:" + lista.getCodice());
		setSize(500,500);
		setLocation(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(buildPanel());
		setVisible(true);
	}
	
	private JPanel buildPanel() {
		JPanel mainPanel = new JPanel();
		
		JLabel labDesc = new JLabel("Descrizione");
		JTextField textDesc = new JTextField("",15);
		
		JLabel labTipo = new JLabel("Tipo");
		JComboBox<String> boxTipo = new JComboBox<String>();
		boxTipo.addItem("PICCOLO");
		boxTipo.addItem("MEDIO");
		boxTipo.addItem("GRANDE");
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	    Calendar cal = Calendar.getInstance();
	    JLabel labData = new JLabel("Data arrivo");
		JTextField dataArrivo = new JTextField(10);
		dataArrivo.setText(dateFormat.format(cal.getTime()));
		
		JButton button = new JButton("Aggiungi");
		button.addActionListener((ActionEvent e) ->{
			String descrizione = textDesc.getText();
			int tipo = 0;
			String d = dataArrivo.getText();
			
			if(boxTipo.getSelectedItem().equals("PICCOLO")) {
				tipo = Pacco.PICCOLO;
			}
			else if(boxTipo.getSelectedItem().equals("MEDIO")) {
				tipo = Pacco.MEDIO;
			}
			else {
				tipo = Pacco.GRANDE;
			}
			
			String[] dSplit = d.split("/");
			GregorianCalendar data = new GregorianCalendar(Integer.parseInt(dSplit[2]), Integer.parseInt(dSplit[1]), Integer.parseInt(dSplit[0]));
			
			Pacco p = new Pacco(descrizione, tipo, data);
			this.lista.aggiungi(p);
			lista.saveToFile("outputGUI.txt");
		});
		
		mainPanel.add(labDesc);
		mainPanel.add(textDesc);
		mainPanel.add(labTipo);
		mainPanel.add(boxTipo);
		mainPanel.add(labData);
		mainPanel.add(dataArrivo);
		mainPanel.add(button);
		
		return mainPanel;
	}
}
