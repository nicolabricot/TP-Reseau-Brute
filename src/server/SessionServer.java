package server;

import java.io.IOException;
import java.net.Socket;
import network.Protocol;
import network.Writer;

public class SessionServer {
	
	protected Socket socket;
	protected Writer writer;
	
	public SessionServer(Socket socket) throws IOException {
		this.socket = socket;
		writer = new WriterServer(socket.getOutputStream());
	}
	
	public void ok() throws IOException {
		System.out.println("\nServer send: " +  (byte) Protocol.OK + " [OK]");
		writer.writeDiscriminant(Protocol.OK);
		writer.send();
	}
	public void ko() throws IOException {
		System.out.println("\nServer send: " +  (byte) Protocol.KO + " [KO]");
		writer.writeDiscriminant(Protocol.KO);
		writer.send();
	}

}
