package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import common.Protocol;
import common.Reader;

public class Main {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(Protocol.PORT);
			
			while (true) {
				Socket client = server.accept();
				Reader reader = new ReaderServer(client.getInputStream());
				SessionServer session = new SessionServer(client);
				
				byte discriminant = reader.readDiscriminant();
				System.out.println("Server received: " + discriminant);
				
				if (discriminant == Protocol.QUERY_TEST) {
					System.out.println("[QUERY_TEST]");
				}
				else if (discriminant == Protocol.GET_LOGIN) {
					System.out.print("[GET_LOGIN] ");
					String login = reader.readString();
					System.out.println(login);
					if (login.equals("Valoo") || login.equals("Nico"))
						session.ok();
					else
						session.ko();
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
