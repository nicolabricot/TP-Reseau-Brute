package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import common.Protocol;
import common.Reader;
import common.Writer;

public class SessionClient {
	
	protected Socket socket;
	
	public SessionClient(Socket socket) throws IOException {
		this.socket = socket;
	}
	
	public boolean getLogin(String user) throws IOException {
		Writer writer = new WriterClient(this.socket.getOutputStream());
		writer.writeDiscriminant(Protocol.GET_LOGIN);
		writer.writeString(user);
		writer.send();
		
		Reader reader = new ReaderClient((DataInputStream) socket.getInputStream());
		byte discriminant = reader.readDiscriminant();
		if(discriminant == Protocol.GET_LOGIN) {
			System.out.println("Discriminant de GET_LOGIN a fonctionné !");
			System.out.println(reader.readString());
		}
		return true;
	}
	
	

}
