package tester;

import java.util.ArrayList;

import core.*;

public class StudentiTest {

	public static void main(String[] args) {
		Studente s1 = new Studente("1122334455", "Mario", "Rossi");
		s1.insertEsame(new Esame("Programmazione 1" , 9, 30));
		s1.insertEsame(new Esame("Matematica Discreta" , 9, 25));
		
		Studente s2 = new Studente("6677889900", "Giorgio", "Bianchi");
		s1.insertEsame(new Esame("PSD" , 9, 28));
		
		StudenteDSA s3 = new StudenteDSA("5544332211", "Marco", "Verdi", "Diabete Lieve");
		s1.insertEsame(new Esame("Analisi 1" , 9, 20));
		s1.insertEsame(new Esame("MMI" , 6, 25));
		
		StudenteDSA s4 = new StudenteDSA("0099887766", "Alfredo", "Neri", "Diabete Grave");
		s1.insertEsame(new Esame("Analisi 1" , 9, 20));
		s1.insertEsame(new Esame("Reti" , 6, 25));
		
		ArrayList<Studente> l = new ArrayList<Studente>();
		l.add(s1);
		l.add(s2);
		l.add(s3);
		l.add(s4);
		
		StudentiManager roster = new StudentiManager();
		roster.setStudenti(l);
		
		roster.store("studenti.txt");
		roster.storeDSA("studentiDSA.txt");
		
	}

}
