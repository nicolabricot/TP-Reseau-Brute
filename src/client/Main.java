package client;

import java.net.Socket;

import common.Protocol;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String serverName = "localhost";
		
		try {
			
			while (true) {
				Socket client = new Socket(serverName, Protocol.PORT);
				
				SessionClient session = new SessionClient(client);
				System.out.println("[1]");
				session.getLogin("Valoo");
				client.close();
				
				client = new Socket(serverName, Protocol.PORT);
				session = new SessionClient(client);
				System.out.println("[2]");
				session.getLogin("Nico");				
				client.close();
				
				client = new Socket(serverName, Protocol.PORT);
				session = new SessionClient(new Socket(serverName, Protocol.PORT));
				System.out.println("[3]");
				session.getLogin("Bidule");
				client.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
