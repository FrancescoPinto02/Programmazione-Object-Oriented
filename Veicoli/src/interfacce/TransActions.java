package interfacce;

import core.Ticket;
import exception.IllegalActionException;

public interface TransActions {

	boolean checkTicket(Ticket t);
	
	Ticket buyTicket(int money) throws IllegalActionException;
}
