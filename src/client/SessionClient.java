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
		if(discriminant == Protocol.REP_OK) {
			System.out.println("Réponse ok !");
					}
		else if(discriminant == Protocol.REP_KO){
			System.out.println("Réponse ko !");
		}
		return true;
	}
	
	

}
