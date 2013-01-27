package server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import brute.Bonus;
import brute.Brute;

public abstract class Data {
	
	public static ArrayList<Brute> brutes = new ArrayList<Brute>();
	
	public static final List<Brute> availableBrutes = Arrays.asList(
				new Brute("R2D2", 2, 20, 5, 0),
				new Brute("Stupid bot One"),
				new Brute("Stupid bot Two"),
				new Brute("Stupid bot Tree")
			);
	public static final List<Bonus> availableBonus = Arrays.asList(
				//new Bonus("Chuck Norris", 50, 100, 100, 100),
				new Bonus("Usain Bolt", 0, 0, 0, 10),
				new Bonus("Sébastien Chabal", 0, 0, 10, 0 ),
				new Bonus("Harry Potter", 10, 0, 0, 0),
				new Bonus("Hermione Granger", 5, 5, 0, 0),
				new Bonus("Hagrid", 8, 0, 8, -4)
			);
	
	public static void populate() {
		for (int i=0; i<availableBrutes.size(); i++)
			brutes.add(availableBrutes.get(i));
	}
}
