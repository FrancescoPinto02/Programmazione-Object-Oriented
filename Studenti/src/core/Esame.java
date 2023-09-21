package core;

public class Esame {
	String nome;
	int voto;
	int cfu;
	
	//Costruttori
	public Esame(String nome, int voto, int cfu) {
		this.nome = nome;
		this.voto = voto;
		this.cfu = cfu;
	}
	
	
	//Getter e Setter
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVoto() {
		return this.voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	
	//Utility
	public String toString() {
		return "ESAME = [Nome: " + this.nome + " Voto: " + this.voto + " Cfu: " + this.cfu + "]";
	}
	public boolean equals(Esame e) {
		return (this.nome.equals(e.getNome()) && this.voto == e.getVoto() && this.cfu == e.getCfu());
	}
}
