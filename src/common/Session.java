package common;

import java.net.Socket;

public abstract class Session {
	
	private Socket socket;
	private Reader reader;
	private Writer writer;
	
	public Socket socket() {
		return socket;
	}
	
	public Writer writer() {
		return writer;
	}
	
	public Reader reader() {
		return reader;
	}

}
