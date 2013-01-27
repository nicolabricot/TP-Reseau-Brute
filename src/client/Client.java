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
			
			System.out.println("Client started\n");
			
			//*
			client = new Socket(server, Protocol.PORT);
			session = new SessionClient(client);
			System.out.println("[" + state++ + "]");
			boolean connect = session.query_test();
			client.close();
			
			if (connect) {
				client = new Socket(server, Protocol.PORT);
				session = new SessionClient(client);
				System.out.println("[" + state++ + "]");
				session.login("Valoo");
				client.close();
				
				client = new Socket(server, Protocol.PORT);
				session = new SessionClient(client);
				System.out.println("[" + state++ + "]");
				session.login("unknown");
				client.close();
				
				client = new Socket(server, Protocol.PORT);
				session = new SessionClient(client);
				System.out.println("[" + state++ + "]");
				session.login("Nico");
				client.close();
			}
			else
				System.out.println("Can't connect to " + server);
			
			//*/
			
			System.out.println("\nClient stopped");
		}
		catch (Exception e) {
			System.out.println("Error: unknown host for " + server + "!");
			// e.printStackTrace();
		}
		

	}

}
