package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import brute.Bonus;
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

	public void replyBruteBonus(int id) throws IOException {
		System.out.print("\nServer send: " + (byte) Protocol.REPLY_BRUTE_BONUS + " [REPLY_BRUTE_BONUS] ");
		writer.writeDiscriminant(Protocol.REPLY_BRUTE_BONUS);
		
		ArrayList<Bonus> b = new ArrayList<Bonus>(Data.brutes.get(id).bonus());
		
		System.out.print(b.size() + " ");
		writer.writeInt(b.size());
		
		for (int i=0; i<b.size(); i++) {
			System.out.print(b.get(i).name() + " " + b.get(i).level() + " " + b.get(i).life() + " " + b.get(i).strengh() + " " + b.get(i).speed() + " ");
			writer.writeString(b.get(i).name());
			writer.writeInt(b.get(i).level());
			writer.writeInt(b.get(i).life());
			writer.writeInt(b.get(i).strengh());
			writer.writeInt(b.get(i).speed());
		}
		System.out.println();
		writer.send();
		
	}
}
