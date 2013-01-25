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
			Socket client = new Socket(serverName, Protocol.PORT);
			
			while (true) {
				SessionClient session = new SessionClient(client);
				session.getLogin("Valoo");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
