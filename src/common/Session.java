package common;

import java.net.Socket;

public abstract class Session {
	
	protected Socket socket;
	protected Reader reader;
	protected Writer writer;
	
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
