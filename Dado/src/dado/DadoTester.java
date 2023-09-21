package dado;

public class DadoTester {

	public static void main(String[] args) {
		Dado d1 = new Dado();
		Dado d2 = new Dado(6);
		int v1;
		int v2;
			
		do {
			v1 = d1.lancia();
			System.out.println("Lancio dado 1: " + v1);
			v2 = d2.lancia();
			System.out.println("Lancio dado 2: " + v2);
			
			
			if(v1>v2) {
				System.out.println("Dado 1 Vince");
			}
			else if(v2>v1) {
				System.out.println("Dado 2 Vince");
			}
			else {
				System.out.println("Pareggio");
			}
		}while(v1==v2);
	}
}
