package client;

import java.io.DataInputStream;
import java.net.Socket;

import common.Protocol;
import common.Session;
import common.Writer;
import common.Reader;

public class SessionClient extends Session{
	
	
	
	public SessionClient(Socket socket) {
		super.socket = socket;
		super.writer = new WriterClient(socket.getOutputStream());
		super.reader = new ReaderClient( socket.getInputStream());
		
	}
	
	public void getLogin(String user){
		super.writer().writeDiscriminant(Protocol.GET_LOGIN);		
	}

}
