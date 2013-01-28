package server;

import java.io.IOException;
import java.net.Socket;

import network.Protocol;
import network.Reader;

public abstract class Process {
	
	public static void decode(byte discriminant, Socket client, Reader reader) throws IOException {
		SessionServer session = new SessionServer(client);
		
		int id;
		
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
			
		case Protocol.GET_BRUTE_INFO:
			id = reader.readInt();
			System.out.print("[GET_BRUTE_INFO] " + id);
			if (id >= 0 && id < Data.brutes.size())
				session.replyBruteInfo(id);
			else
				session.ko();
			break;
			
		case Protocol.GET_BRUTE_BONUS:
			id = reader.readInt();
			System.out.print("[GET_BRUTE_BONUS] " + id);
			if (id >= 0 && id < Data.brutes.size())
				session.replyBruteBonus(id);
			else
				session.ko();
			break;
		
		default:
			session.ko();
		}
		
	}
	
	
}
