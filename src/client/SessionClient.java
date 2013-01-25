package client;

import java.io.IOException;
import java.net.Socket;

import common.Protocol;
import common.Writer;

public class SessionClient {
	
	protected Socket socket;
	
	public SessionClient(Socket socket) throws IOException {
		this.socket = socket;
	}
	
	public void getLogin(String user) throws IOException {
		Writer writer = new WriterClient(socket.getOutputStream());
		writer.writeDiscriminant(Protocol.GET_LOGIN);
		writer.writeString(user);
		writer.send();
	}
	
	public void test() {
		
	}

}
