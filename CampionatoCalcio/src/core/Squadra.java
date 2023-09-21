package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Squadra {

	private List<Calciatore> rosa;
	private String nome;
	private int scudetti;
	
	//Costruttori
	public Squadra(String nome, int scudetti) {
		this.nome = nome;
		this.scudetti = scudetti;
		this.rosa = new ArrayList<Calciatore>();
	}
	
	//Get e Set
	public List<Calciatore> getRosa(){
		return this.rosa;
	}
	public void setRosa(List<Calciatore> rosa) {
		this.rosa = rosa;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getScudetti() {
		return this.scudetti;
	}
	public void setScudetti(int scudetti) {
		this.scudetti = scudetti;
	}
	
	
	public void printPlayerByCond(Predicate<Calciatore> tester, Consumer<Calciatore> block) {
		this.rosa.stream().filter(tester).forEach(block);
	}
	
	//Utility
	public String toString() {
		return "SQUADRA = [Nome: " + this.nome + " Scudetti: " + this.scudetti + "]";
	}
	
	public int hashCode() {
		return Objects.hash(nome, scudetti, rosa);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return nome.equals(other.nome) && scudetti == other.scudetti;
	}
	
	
}
