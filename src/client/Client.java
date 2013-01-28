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
			
			//*
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.query_test();
			client.close();
			
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.login("Valoo");
			client.close();
			
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.login("unknown");
			client.close();
			
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("\n[" + state++ + "]");
			session.login("Nico");
			client.close();
			
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
			
			//*/
			
			System.out.println("\nClient stopped");
		}
		catch (Exception e) {
			System.out.println("Error: unknown host for " + server + "!");
			// e.printStackTrace();
		}
		

	}

}
