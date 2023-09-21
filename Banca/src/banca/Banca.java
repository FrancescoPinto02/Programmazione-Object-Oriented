package banca;

public class Banca {	
	private double balance;
	private String password;
	
	public Banca(String password) {
		this.balance = 0;
		this.password = password;
	}
	public Banca(String password, double initialBalance) {
		this.balance = initialBalance;
		this.password = password;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password, String newPassword) {
		if(this.passwordCheck(password)) {
			this.password = newPassword;
			System.out.println("Password modificata");
		}
		else {
			System.out.println("Password errata");
		}
	}
	
	private boolean passwordCheck(String password) {
		return password.equals(this.password);
	}
	private boolean balanceCheck(double value) {
		if(this.balance >= value) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deposit(String password, double amount) {
		if(this.passwordCheck(password)) {
			this.balance += amount;
			System.out.println("Importo depositato");
		}
		else {
			System.out.println("Password errata");
		}
	}
	public void withdraw(String password, double amount) {
		if(this.passwordCheck(password)) {
			if(this.balanceCheck(amount)) {
				this.balance -= amount;
				System.out.println("Importo prelevato");
			}
			else {
				System.out.println("Importo non disponibile");
			}
		}
		else {
			System.out.println("Password Errata");
		}
	}
}
