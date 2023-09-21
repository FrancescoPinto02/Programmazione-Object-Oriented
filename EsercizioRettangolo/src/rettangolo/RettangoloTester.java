package rettangolo;

import java.util.ArrayList;

public class RettangoloTester {

	public static void main(String[] args) {
		Rettangolo r1 = new Rettangolo();
		System.out.println("r1: " + r1);
		System.out.println("Area: " + r1.area());
		System.out.println("Perimetro: " + r1.perimetro());
		
		Rettangolo r2 = new Rettangolo(20, 15);
		System.out.println("r2: " + r2);
		System.out.println("Area: " + r2.area());
		System.out.println("Perimetro: " + r2.perimetro());
		
		ArrayList<Rettangolo> list = new ArrayList<Rettangolo>();
		list.add(r2);
		list.add(r1);
		
		System.out.println(list);
		list.sort(null);
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(Rettangolo i : list) {
			System.out.println(i);
		}
	}
}
