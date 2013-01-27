package server;

import java.io.IOException;
import java.net.Socket;
import common.Protocol;
import common.Writer;

public class SessionServer {
	
	protected Socket socket;
	protected Writer writer;
	
	public SessionServer(Socket socket) throws IOException {
		this.socket = socket;
		writer = new WriterServer(socket.getOutputStream());
	}
	
	public void ok() throws IOException {
		writer.writeDiscriminant(Protocol.REP_OK);
		writer.send();
	}
	public void ko() throws IOException {
		writer.writeDiscriminant(Protocol.REP_KO);
		writer.send();
	}

}
