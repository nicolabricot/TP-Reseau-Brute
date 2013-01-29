package client;

import java.net.Socket;
import java.util.Scanner;

import network.Protocol;

public class Client {
	
	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		String server = "localhost";
		int state = 0;
		
		try {
			
			Scanner sc = new Scanner(System.in);
			boolean connection = false;
			
			while(!connection){
				Socket client = new Socket(server, Protocol.PORT);
				SessionClient session = new SessionClient(client);
				System.out.println("Bienvenue dans le jeu des Brutes");
				System.out.println("Quel est votre login ?");
				String login = sc.nextLine();
				int IDbrute = session.getLogin(login);
				client.close();
				
				if(IDbrute>=0){
					System.out.println("Bonjour " + login);
					client = new Socket(server, Protocol.PORT);
					session = new SessionClient(client);
					session.getBruteInfo(IDbrute);
					client.close();
					boolean combat = true ;
					while(combat){
						System.out.println("Choisissez le type de combat :");
						System.out.println("1. Je veux gagner.");
						System.out.println("2. Je veux perdre.");
						System.out.println("3. Je veux un combat équitable.");
						String typeCombat = sc.nextLine();
						
						if(typeCombat == "1"){
							client = new Socket(server, Protocol.PORT);
							session = new SessionClient(client);
							int IDadversaire = session.getAdversaire(IDbrute);
							session.getVictory(IDbrute, IDadversaire);
							client.close();
						}
						else if (typeCombat == "2"){
							client = new Socket(server, Protocol.PORT);
							session = new SessionClient(client);
							int IDadversaire = session.getAdversaire(IDbrute);
							session.getDefeat(IDbrute, IDadversaire);
							client.close();
						}
						else if (typeCombat == "3"){
							client = new Socket(server, Protocol.PORT);
							session = new SessionClient(client);
							int IDadversaire = session.getAdversaire(IDbrute);
							session.getCombat(IDbrute, IDadversaire);
							client.close();
						}
						else {
							System.out.println("Mauvais choix de combat.");
						}
						
					}
					
				}
				else System.out.println("Login incorect");
			}
			
			
			
			
			
			
			/*
			
			
			System.out.println("Client started");
			
			// QUERY_TEST
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.query_test();
			client.close();
			
			// LOGIN
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getLogin("Valoo");
			client.close();
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getLogin("unknown");
			client.close();
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getLogin("Nico");
			client.close();
			
			// BRUTE_INFO & BRUTE_BONUS
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			System.out.println(session.getBruteInfo(3));
			client.close();
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			System.out.println(session.getBruteBonus(0));
			client.close();
			
			// ADVERSAIRE
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getAdversaire(1);
			client.close();
			
			// COMBAT
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getVictory(0, 0);
			client.close();
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getDefeat(0, 0);
			client.close();
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getVictory(1, 2);
			client.close();
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.getDefeat(2, 3);
			client.close();
			
			for (int i=0; i<10; i++) {
				client = new Socket(server, Protocol.PORT);
				session = new SessionClient(client);
				System.out.println("\n[" + state++ + "]");
				session.getCombat(2, 3);
				client.close();
			}*/
			
			System.out.println("\nClient stopped");
		}
		catch (Exception e) {
			System.out.println("Error: unknown host for " + server + "!");
			// e.printStackTrace();
		}
		

	}

}
