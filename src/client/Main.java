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
				SessionClient session = new SessionClient(new Socket(serverName, Protocol.PORT));
				System.out.println("[1]");
				session.getLogin("Valoo");
				
				session = new SessionClient(new Socket(serverName, Protocol.PORT));
				System.out.println("[2]");
				session.getLogin("Nico");				
				
				session = new SessionClient(new Socket(serverName, Protocol.PORT));
				System.out.println("[3]");
				session.getLogin("Bidule");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
