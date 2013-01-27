package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import network.Protocol;
import network.Reader;

public class Main {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(Protocol.PORT);
			System.out.println("Server started");
			
			while (true) {
				System.out.println("\nnew boucle");
				
				Socket client = server.accept();
				Reader reader = new ReaderServer(client.getInputStream());
				SessionServer session = new SessionServer(client);
				
				byte discriminant = reader.readDiscriminant();
				System.out.print("Server received: ");
				
				if (discriminant == Protocol.QUERY_TEST) {
					System.out.println("[QUERY_TEST]");
				}
				else if (discriminant == Protocol.LOGIN) {
					System.out.print("[GET_LOGIN] ");
					String login = reader.readString();
					System.out.println(login);
					if (login.equals("Valoo") || login.equals("Nico"))
						session.ok();
					else
						session.ko();
				}
				client.close();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
