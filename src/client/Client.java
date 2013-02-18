/**
 * @author Nicolas
 */

package client;

import java.util.ArrayList;
import java.util.Scanner;

import brute.Brute;
import brute.Bonus;

public class Client {
	
	private static final String prompt_char = "-> ";
	private static Scanner scan = new Scanner(System.in);	
	private static boolean run = true;
	
	private static String fetch() {
		return scan.next();
	}
	
	private static void menu() {
		System.out.println("\n[c] loyal combat");
		System.out.println("[w] force to win");
		System.out.println("[l] force to loose");
		System.out.println("[q] quit program");
		prompt();
	}
	
	private static void prompt() {
		System.out.print(prompt_char);
	}
	
	private static void decode(String cmd) {
		if (cmd.equals("q"))
			run = false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String server = "localhost";
		
		int id = -1; // id of me
		int adversaire = -1; // id of challenger
		Brute me;
		ArrayList<Bonus> me_bonus;
		Brute challenger;
		ArrayList<Bonus> challenger_bonus;
		
		System.out.println("Client started");
		
		// get server info
		/*
		System.out.println("\nChoose the server you want to connect (e.g. localhost)");
		prompt()
		server = fetch();
		*/
		server = "192.168.0.10";
		
		try {
			
			SessionClient s = new SessionClient(server);
			s.mute();
			
			// get brute id
			while (run) {
				System.out.println("\nChoose the brute you want to play (e.g. Hassen)");
				prompt();
				id = s.getLogin(fetch());
				if (id != -1)
					run = false;
				else
					System.out.println("This user doesn't exist. Try again.");
			}
			
			// display brute and bonus info
			me = s.getBruteInfo(id);
			System.out.println("\n" + me);
			me_bonus = s.getBruteBonus(id);
			if (me_bonus.isEmpty())
				System.out.println("\nYou have no bonus yet!");
			else
				System.out.println("\nYou have " + me_bonus.size() + " bonus :) " + "\n" + me_bonus);

			
			// it's time to play
			run = true;
			while (run) {
				// get (new) adversaire
				adversaire = s.getAdversaire(id);
				challenger = s.getBruteInfo(adversaire);
				System.out.println("\nYour adversaire is " + challenger);
				challenger_bonus = s.getBruteBonus(adversaire);
				if (challenger_bonus.isEmpty())
					System.out.println("\nAdversaire has no bonus yet!");
				else
					System.out.println("\nAdversaire has " + challenger_bonus.size() + " bonus :( " + "\n" + challenger_bonus);
				
				// display menu
				menu();
				decode(fetch());
			}


		}
		catch (Exception e) {
			System.out.println("Server not found!");
		}
		
		
		
		System.out.println("\nClient stopped");
		

	}

}
