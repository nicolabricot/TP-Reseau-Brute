package client;

import java.io.IOException;
import java.net.Socket;
import network.Protocol;
import network.Reader;
import network.Writer;

public class SessionClient {
	
	protected Socket socket;
	
	public SessionClient(Socket socket) throws IOException {
		this.socket = socket;
	}
	
	private boolean status(byte discriminant) {
		System.out.print("Client received: " +  (byte) discriminant + " ");
		
		if (discriminant == Protocol.OK) {
			System.out.println("[OK]");
			return true;
		}
		System.out.println("[KO]");
		return false;
	}
	
	public boolean login(String user) throws IOException {
		Writer w = new WriterClient(this.socket.getOutputStream());
		
		System.out.println("Client send: " + (byte) Protocol.LOGIN + " [LOGIN] " + user);
		
		w.writeDiscriminant(Protocol.LOGIN);
		w.writeString(user);
		w.send();
		
		Reader r = new ReaderClient(socket.getInputStream());
		return status(r.readDiscriminant());
	}

	public boolean query_test() throws IOException {
		Writer w = new WriterClient(this.socket.getOutputStream());
		
		System.out.println("Client send: " + (byte) Protocol.QUERY_TEST + " [QUERY_TEST]");
		w.writeDiscriminant(Protocol.QUERY_TEST);
		w.send();

		Reader r = new ReaderClient(socket.getInputStream());
		return status(r.readDiscriminant());
	}
	
	

}
