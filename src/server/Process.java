package server;

import java.io.IOException;
import java.net.Socket;

import network.Protocol;
import network.Reader;

public abstract class Process {
	
	public static void decode(byte discriminant, Socket client, Reader reader) throws IOException {
		SessionServer session = new SessionServer(client);
		
		int id, one, two;
		
		switch (discriminant) {
		
		case Protocol.QUERY_TEST:
			System.out.print("[QUERY_TEST]");
			session.ok();
			break;
			
		case Protocol.GET_LOGIN:
			String login = reader.readString();
			System.out.print("[GET_LOGIN] " + login);
			session.replyLogin(login);
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
			
		case Protocol.GET_ADVERSAIRE:
			id = reader.readInt();
			System.out.print("[GET_ADVERSAIRE] " + id);
			if (id >= 0 && id < Data.brutes.size())
				session.replyAdversaire(id);
			else
				session.ko();
			break;
			
		case Protocol.GET_VICTORY:
		case Protocol.GET_DEFEAT:
			one = reader.readInt();
			two = reader.readInt();
			System.out.print((discriminant == Protocol.GET_VICTORY ? "[GET_VICTORY]" : "[GET_DEFEAT]") + " " + one + " " + two);
			if (one >= 0 && one < Data.brutes.size() && two >= 0 && two < Data.brutes.size() && one != two) {
				if (discriminant == Protocol.GET_VICTORY)
					session.replyFakeCombat(one, two);
				else
					session.replyFakeCombat(two, one);
			}	
			else
				session.ko();
			break;
			
		case Protocol.GET_COMBAT:
			one = reader.readInt();
			two = reader.readInt();
			System.out.print("[GET_COMBAT] " + one + " " + two);
			if (one >= 0 && one < Data.brutes.size() && two >= 0 && two < Data.brutes.size() && one != two)
				session.replyCombat(one, two);
			else
				session.ko();
			break;
		
		default:
			session.ko();
		}
		
	}	
	
}
