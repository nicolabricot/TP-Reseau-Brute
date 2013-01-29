package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import brute.Bonus;
import brute.Brute;

import network.Protocol;

public class SessionClient {
	

	private String server = "localhost";
	private WriterClient w;
	private ReaderClient r;
	private Socket socket;
	
	public SessionClient() {
	}
	
	public SessionClient(String server) throws IOException {
		this.server = server;
	}
	
	private void open() throws UnknownHostException, IOException {
		socket = new Socket(server, Protocol.PORT);
	}
	private void close() throws IOException {
		socket.close();
	}
	private OutputStream out() throws IOException {
		return socket.getOutputStream();
	}
	private InputStream in() throws IOException {
		return socket.getInputStream();
	}
	
	private boolean status(byte discriminant) throws IOException {		
		System.out.print("Client received: " +  (byte) discriminant + " ");
		
		if (discriminant == Protocol.OK) {
			System.out.println("[OK]");
			return true;
		}
		System.out.println("[KO]");
		return false;
	}
	
	public boolean query_test() throws IOException {
		open();
		w = new WriterClient(out());
		w.query_test();

		r = new ReaderClient(in());
		boolean response = status(r.readDiscriminant());
		close();
		
		return response;
	}
	
	public int getLogin(String user) throws IOException {
		open();
		w = new WriterClient(out());
		w.getLogin(user);
		
		r = new ReaderClient(in());
		int response = r.replyLogin();
		close();
		
		return response;
	}

	public Brute getBruteInfo(int id) throws IOException {
		open();
		w = new WriterClient(out());
		w.getBruteInfos(id);
		
		r = new ReaderClient(in());
		Brute response = r.replyBruteInfo();
		close();
		
		return response;
	}
	
	public ArrayList<Bonus> getBruteBonus(int id) throws IOException {
		open();
		w = new WriterClient(out());
		w.getBruteBonus(id);
		
		r = new ReaderClient(in());
		ArrayList<Bonus> response = r.replyBruteBonus();
		close();
		
		return response;
	}
	
	public int getAdversaire(int me) throws IOException {
		open();
		w = new WriterClient(out());
		w.getAdversaire(me);
		
		r = new ReaderClient(in());
		int response = r.replyAdversaire();
		close();
		
		return response;
	}
	
	public boolean getVictory(int one, int two) throws IOException {
		open();
		w = new WriterClient(out());
		w.getVictory(one, two);
		
		r = new ReaderClient(in());
		boolean response = status(r.readDiscriminant());
		close();
		
		return response;
	}
	
	public boolean getDefeat(int one, int two) throws IOException {
		open();
		w = new WriterClient(out());
		w.getDefeat(one, two);
		
		r = new ReaderClient(in());
		boolean response = status(r.readDiscriminant());
		close();
		
		return response;
	}
	
	public int getCombat(int one, int two) throws IOException {
		open();
		w = new WriterClient(out());
		w.getCombat(one, two);
		
		r = new ReaderClient(in());
		int response = r.replyCombat();
		close();
		
		return response;
	}
	
}
