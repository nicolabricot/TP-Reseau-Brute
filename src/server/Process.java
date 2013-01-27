package server;

import java.io.IOException;
import java.net.Socket;

import network.Protocol;
import network.Reader;

public abstract class Process {
	
	public static void decode(byte discriminant, Socket client, Reader reader) throws IOException {
		SessionServer session = new SessionServer(client);
		
		switch (discriminant) {
		
		case Protocol.QUERY_TEST:
			System.out.print("[QUERY_TEST]");
			session.ok();
			break;
			
		case Protocol.LOGIN:
			String login = reader.readString();
			System.out.print("[LOGIN] " + login);
			if (login.equals("Valoo") || login.equals("Nico"))
				session.ok();
			else
				session.ko();
			break;
		
		default:
			session.ko();
		}
		
	}
	
	
}
