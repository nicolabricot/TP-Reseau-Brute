/**
 * @author Nicolas
 */

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
	private boolean mute = false;
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
	public void mute() {
		mute = true;
	}
	public void talk() {
		mute = false;
	}
	
	private boolean status(byte discriminant) throws IOException {		
		if (!mute) System.out.print("Client received: " +  (byte) discriminant + " ");
		
		if (discriminant == Protocol.OK) {
			if (!mute) System.out.println("[OK]");
			return true;
		}
		if (!mute) System.out.println("[KO]");
		return false;
	}
	
	public boolean query_test() throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.query_test();

		r = new ReaderClient(in());
		if (mute) r.mute();
		boolean response = status(r.readDiscriminant());
		close();
		
		return response;
	}
	
	public int getLogin(String user) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getLogin(user);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		int response = r.replyLogin();
		close();
		
		return response;
	}

	public Brute getBruteInfo(int id) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getBruteInfos(id);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		Brute response = r.replyBruteInfo();
		close();
		
		return response;
	}
	
	public ArrayList<Bonus> getBruteBonus(int id) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getBruteBonus(id);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		ArrayList<Bonus> response = r.replyBruteBonus();
		close();
		
		return response;
	}
	
	public int getAdversaire(int me) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getAdversaire(me);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		int response = r.replyAdversaire();
		close();
		
		return response;
	}
	
	public boolean getVictory(int one, int two) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getVictory(one, two);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		boolean response = status(r.readDiscriminant());
		close();
		
		return response;
	}
	
	public boolean getDefeat(int one, int two) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getDefeat(one, two);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		boolean response = status(r.readDiscriminant());
		close();
		
		return response;
	}
	
	public int getCombat(int one, int two) throws IOException {
		open();
		w = new WriterClient(out());
		if (mute) w.mute();
		w.getCombat(one, two);
		
		r = new ReaderClient(in());
		if (mute) r.mute();
		int response = r.replyCombat();
		close();
		
		return response;
	}
	
}
