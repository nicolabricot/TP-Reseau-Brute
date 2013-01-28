package server;

import java.io.IOException;
import java.net.Socket;

import brute.Brute;
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

	public void replyBruteInfo(int id) throws IOException {
		Brute b = new Brute(Data.brutes.get(id));
		System.out.print("\nServer send: " + (byte) Protocol.REPLY_BRUTE_INFO + " [REPLY_BRUTE_INFO] ");
		writer.writeDiscriminant(Protocol.REPLY_BRUTE_INFO);
		System.out.println(b.name() + " " + b.level() + " " + b.life() + " " + b.strengh() + " " + b.speed());
		writer.writeString(b.name());
		writer.writeInt(b.level());
		writer.writeInt(b.life());
		writer.writeInt(b.strengh());
		writer.writeInt(b.speed());
		writer.send();
	}
}
