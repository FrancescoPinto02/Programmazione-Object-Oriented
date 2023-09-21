package interfacce;

import core.Corso;
import core.Studente;

public interface StudentiOperations {
	boolean add(Studente s);
	boolean remove(Studente s);
	boolean addCorso(Studente s, Corso c);
}
