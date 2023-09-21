package banca;

public class BancaTester {

	public static void main(String[] args) {
		Banca b1 = new Banca(new String("Pass1"));
		
		b1.deposit("Pass1", 1000);
		System.out.println("Saldo corrente: "+ b1.getBalance());
		b1.withdraw("Pass2", 400);
		b1.withdraw("Pass1", 1200);
		b1.withdraw("Pass1", 400);
		System.out.println("Saldo corrente: "+ b1.getBalance());

	}

}
