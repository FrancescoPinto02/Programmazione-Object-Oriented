package core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import exception.NumberNotAvailableException;
import exception.SquadraRegisteredException;

public class Campionato {

	private String nome;
	private List<Squadra> squadre;
	
	//Costruttori
	public Campionato(String nome) {
		this.nome = nome;
		this.squadre = new ArrayList<Squadra>();
	}
	
	//Get e Set
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Squadra> getSquadre(){
		return this.squadre;
	}
	public void setSquadre (List<Squadra> squadre) {
		this.squadre = squadre;
	}

	//Aggiunge un giocatore alla squadra
	public boolean addPlayer(Calciatore c, Squadra s) {
		if(!this.squadre.contains(s)) {
			return false;
		}
		else if(s.getRosa().contains(c)) {
			return false;
		}
		else {
			for(Calciatore x : s.getRosa()) {
				if(x.getNumero() == c.getNumero()) {
					throw new NumberNotAvailableException();
				}
			}
			s.getRosa().add(c);
			return true;
		}
	}

	//Aggiunge una squadra al campionato
	public boolean squadraSubscription(Squadra s) throws SquadraRegisteredException{
		if(this.squadre.contains(s)) {
			throw new SquadraRegisteredException();
		}
		else {
			this.squadre.add(s);
			return true;
		}
	}
	
	//Ricerca una squadra per nome 
	public Squadra searchBySquadra(String nomeSquadra) {
		Squadra s = null;
		Stream<Squadra> stream = this.squadre.stream().filter(x->{return x.getNome().equalsIgnoreCase(nomeSquadra);});
		
		Optional<Squadra> opt = stream.findFirst();
		if(opt.isPresent()) {
			s = opt.get();
		}
		
		return s;
	}
	
	//Stampa squadre ordinate in ordine decrescente rispetto al numero di scudetti vinti
	public void printSquadraByScudetti() {
		this.squadre.stream().sorted((a,b)->{
			if(a.getScudetti() == b.getScudetti()) {return 0;}
			else if(a.getScudetti() > b.getScudetti()) {return -1;}
			else {return 1;}
		}).forEach(System.out :: println);
	}
	public void printSquadraByScudetti2()
	{
		Comparator<Squadra> squadra = Comparator.comparing(Squadra::getScudetti);
		this.squadre.stream().sorted(squadra.reversed()).forEach(System.out::println);
	}
	
	//Utility
	public String toString() {
		return "CAMPIONATO = [Nome: " + this.nome + "]";
	}
}
