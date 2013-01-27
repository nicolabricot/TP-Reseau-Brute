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
	
	public boolean getLogin(String user) throws IOException {
		Writer writer = new WriterClient(this.socket.getOutputStream());
		
		System.out.println("Client send: [GET_LOGIN] " + user);
		
		writer.writeDiscriminant(Protocol.LOGIN);
		writer.writeString(user);
		writer.send();
		
		Reader reader = new ReaderClient(socket.getInputStream());
		byte discriminant = reader.readDiscriminant();
		
		System.out.print("Client received: ");
		
		if(discriminant == Protocol.REP_OK)
			System.out.println("[OK]");
		else
			System.out.println("[KO]");

		return true;
	}
	
	

}
