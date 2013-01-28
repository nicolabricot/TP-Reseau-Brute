package client;

import java.net.Socket;

import network.Protocol;

public class Client {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String server = "localhost";
		int state = 0;
		
		try {
			Socket client;
			SessionClient session;
			
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
			}
			
			System.out.println("\nClient stopped");
		}
		catch (Exception e) {
			System.out.println("Error: unknown host for " + server + "!");
			// e.printStackTrace();
		}
		

	}

}
