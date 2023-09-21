package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Studente;
import core.StudentiManager;
import eccezioni.CampiVuotiException;
import eccezioni.SalvataggioControllatoException;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

		private StudentiManager studenti;
		private JPanel mainPanel;
		
		public MainGUI(String title, StudentiManager studenti) {
			this.studenti = studenti;
			setTitle(title);
			setSize(450,400);
			setLocation(350,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.mainPanel = buildPanel();
			add(this.mainPanel);
		}
		
		public JPanel getMainPanel() {
			return mainPanel;
		}

		public void setMainPanel(JPanel mainPanel) {
			this.mainPanel = mainPanel;
		}
		
		private JPanel buildPanel() {
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			
			//---------------Pannello superiore-----------------------
			JPanel northPanel = new JPanel();
			
			JButton saveButton = new JButton("Salva su File");
			saveButton.addActionListener((ActionEvent e)->{
				try {
					this.studenti.saveOnFile("output.txt");
				} 
				catch (SalvataggioControllatoException e1) {
					e1.printStackTrace();
				}
			});
			northPanel.add(saveButton);
			//---------------------------------------------------------
			
			//--------------------Pannello Centrale--------------------------
			JPanel centralPanel = new JPanel();
			
			JLabel nameLabel = new JLabel("Nome");
			JTextField nameText = new JTextField("", 15);
			
			JLabel cognomeLabel = new JLabel("Cognome");
			JTextField cognomeText = new JTextField("",15);
			
			JLabel etaLabel = new JLabel("Età");
			JComboBox<Integer> etaBox = new JComboBox<Integer>();
			for(int i=18; i<=40; i++) {
				etaBox.addItem(i);
			}
			
			JLabel categoriaLabel = new JLabel("Categoria");
			JComboBox<String> categoriaBox = new JComboBox<String>();
			categoriaBox.addItem("IN CORSO");
			categoriaBox.addItem("FUORI CORSO");
			
			JButton addButton = new JButton("Aggiungi");
			addButton.addActionListener((ActionEvent e)->{
				String nome = nameText.getText();
				String cognome = cognomeText.getText();
				int eta = (int) etaBox.getSelectedItem();
				int categoria;
					
				try {
					if(nome.equals("") || cognome.equals("")) {
						throw new CampiVuotiException();
					}
					
					if(((String)categoriaBox.getSelectedItem()).equals("IN CORSO")) {
						categoria = Studente.IN_CORSO;
					}
					else {
						categoria = Studente.FUORI_CORSO;
					}
					
					Studente s = new Studente(nome, cognome, categoria, eta);
					this.studenti.add(s);
					System.out.println("Aggiunto");
				}
				catch(CampiVuotiException e1) {
					System.out.println(e1.getMessage());
				}
			});
			
			centralPanel.add(nameLabel);
			centralPanel.add(nameText);
			centralPanel.add(cognomeLabel);
			centralPanel.add(cognomeText);
			centralPanel.add(etaLabel);
			centralPanel.add(etaBox);
			centralPanel.add(categoriaLabel);
			centralPanel.add(categoriaBox);
			centralPanel.add(addButton);
			//--------------------------------------------------------------------
			
			
			//---------------------------Pannello Sud------------------------------
			JPanel southPanel = new JPanel();
			
			JButton b1 = new JButton("Studenti per Età");
			b1.addActionListener((ActionEvent e)->{
				Studente[] arrayStudenti = this.studenti.getStudenti().toArray(new Studente[this.studenti.getStudenti().size()]);
				Arrays.sort(arrayStudenti, (a, b)->{
					return Studente.compareByEta(a, b);
				});
				
				System.out.println("\n\nStampa studenti ordinati per eta'\n\n");
				for(Studente s : arrayStudenti) System.out.println(s);
			});
			
			JButton b2 = new JButton("Studenti Fuori Corso");
			b2.addActionListener((ActionEvent e)->{
					System.out.println("\n\nStampa studenti Fuori Corso'\n\n");
					StudentiManager.printStudByCond(this.studenti.getStudenti(), 
							s->s.getCategoria()==Studente.FUORI_CORSO, 
							s->System.out.println(s));
				});
			
			JButton b3 = new JButton("Studenti over 30");
			b3.addActionListener((ActionEvent e)->{
					System.out.println("\n\nStampa studenti Over 30\n\n");
					StudentiManager.printStudByCond(this.studenti.getStudenti(), 
							s->s.getEta()>30, 
							s->System.out.println(s));
				});
			
			JButton b4 = new JButton("Studenti under 30");
			b4.addActionListener((ActionEvent e)->{
					System.out.println("\n\nStampa studenti under 30\n\n");
					StudentiManager.printStudByCond(this.studenti.getStudenti(), 
							s->s.getEta()< 30, 
							s->System.out.println(s));
				});
			
			southPanel.setLayout(new GridLayout(2,2));
			southPanel.add(b1);
			southPanel.add(b2);
			southPanel.add(b3);
			southPanel.add(b4);
			//------------------------------------------------------------------------------------------
			
			mainPanel.add(northPanel, BorderLayout.NORTH);
			mainPanel.add(centralPanel, BorderLayout.CENTER);
			mainPanel.add(southPanel, BorderLayout.SOUTH);
			
			return mainPanel;
		}
}
