package server;

import java.io.IOException;
import java.net.Socket;

import network.Protocol;
import network.Reader;

public class SessionServer {
	
	protected Socket socket;
	protected WriterServer w;
	
	public SessionServer(Socket socket) throws IOException {
		this.socket = socket;
		w = new WriterServer(socket.getOutputStream());
	}
	
	public void decode(Reader reader) throws IOException {
		
		byte discriminant = reader.readDiscriminant();
		System.out.print("Server received: " + discriminant + " ");
		
		int id, one, two;
		
		switch (discriminant) {
		
		case Protocol.QUERY_TEST:
			System.out.print("[QUERY_TEST]");
			w.ok();
			break;
			
		case Protocol.GET_LOGIN:
			String login = reader.readString();
			System.out.print("[GET_LOGIN] " + login);
			w.replyLogin(login);
			break;
			
		case Protocol.GET_BRUTE_INFO:
			id = reader.readInt();
			System.out.print("[GET_BRUTE_INFO] " + id);
			if (id >= 0 && id < Data.brutes.size())
				w.replyBruteInfo(id);
			else
				w.ko();
			break;
			
		case Protocol.GET_BRUTE_BONUS:
			id = reader.readInt();
			System.out.print("[GET_BRUTE_BONUS] " + id);
			if (id >= 0 && id < Data.brutes.size())
				w.replyBruteBonus(id);
			else
				w.ko();
			break;
			
		case Protocol.GET_ADVERSAIRE:
			id = reader.readInt();
			System.out.print("[GET_ADVERSAIRE] " + id);
			if (id >= 0 && id < Data.brutes.size())
				w.replyAdversaire(id);
			else
				w.ko();
			break;
			
		case Protocol.GET_VICTORY:
		case Protocol.GET_DEFEAT:
			one = reader.readInt();
			two = reader.readInt();
			System.out.print((discriminant == Protocol.GET_VICTORY ? "[GET_VICTORY]" : "[GET_DEFEAT]") + " " + one + " " + two);
			if (one >= 0 && one < Data.brutes.size() && two >= 0 && two < Data.brutes.size() && one != two) {
				if (discriminant == Protocol.GET_VICTORY)
					w.replyFakeCombat(one, two);
				else
					w.replyFakeCombat(two, one);
			}	
			else
				w.ko();
			break;
			
		case Protocol.GET_COMBAT:
			one = reader.readInt();
			two = reader.readInt();
			System.out.print("[GET_COMBAT] " + one + " " + two);
			if (one >= 0 && one < Data.brutes.size() && two >= 0 && two < Data.brutes.size() && one != two)
				w.replyCombat(one, two);
			else
				w.ko();
			break;
		
		default:
			w.ko();
		}
	}
	
	
	
	
	
}
