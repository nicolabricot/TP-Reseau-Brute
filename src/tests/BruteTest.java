package tests;

import server.Combat;
import server.Data;
import brute.Brute;

public class BruteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Brute me = new Brute("Nicolas");
		//me.addBonus(Data.availableBonus.get(4));
		Brute challenger = new Brute("valoo");
		
		Data.brutes.add(me);
		Data.brutes.add(challenger);
		
		System.out.println(Data.brutes);
		
		Combat c = new Combat(0, 1);
		for (int i=0; i<10; i++)
			c.loyal();
		
		System.out.println("\n" + Data.brutes);		
	}

}
