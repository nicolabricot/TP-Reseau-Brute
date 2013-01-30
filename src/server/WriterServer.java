package server;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import brute.Bonus;
import brute.Brute;

import network.Protocol;
import network.Writer;

public class WriterServer extends Writer {
	
	public WriterServer (OutputStream os) {
		super.os = os;
	}
	
	public void ok() throws IOException {
		System.out.println("\nServer send: " +  (byte) Protocol.OK + " [OK]");
		super.writeDiscriminant(Protocol.OK);
		super.send();
	}
	public void ko() throws IOException {
		System.out.println("\nServer send: " +  (byte) Protocol.KO + " [KO]");
		super.writeDiscriminant(Protocol.KO);
		super.send();
	}
	
	public void replyLogin(String login) throws IOException {
		int id = -1;
		for (int i=0; i<Data.brutes.size(); i++) {
			if (Data.brutes.get(i).name().equals(login)) {
				id = i;
				break;
			}
		}
		
		if (id != -1) {
			System.out.println("\nServer send: " + (byte) Protocol.REPLY_LOGIN + " [REPLY_LOGIN] " + id);
			super.writeDiscriminant(Protocol.REPLY_LOGIN);
			super.writeInt(id);
			super.send();
		}
		else
			ko();
	}

	public void replyBruteInfo(int id) throws IOException {
		Brute b = new Brute(Data.brutes.get(id));
		System.out.print("\nServer send: " + (byte) Protocol.REPLY_BRUTE_INFO + " [REPLY_BRUTE_INFO] ");
		super.writeDiscriminant(Protocol.REPLY_BRUTE_INFO);
		System.out.println(b.name() + " " + b.level() + " " + b.life() + " " + b.strengh() + " " + b.speed());
		super.writeString(b.name());
		super.writeInt(b.level());
		super.writeInt(b.life());
		super.writeInt(b.strengh());
		super.writeInt(b.speed());
		super.send();
	}

	public void replyBruteBonus(int id) throws IOException {
		System.out.print("\nServer send: " + (byte) Protocol.REPLY_BRUTE_BONUS + " [REPLY_BRUTE_BONUS] ");
		super.writeDiscriminant(Protocol.REPLY_BRUTE_BONUS);
		
		ArrayList<Bonus> b = new ArrayList<Bonus>(Data.brutes.get(id).bonus());
		
		System.out.print(b.size() + " ");
		super.writeInt(b.size());
		
		for (int i=0; i<b.size(); i++) {
			System.out.print(b.get(i).name() + " " + b.get(i).life() + " " + b.get(i).strengh() + " " + b.get(i).speed() + " ");
			super.writeString(b.get(i).name());
			super.writeInt(b.get(i).life());
			super.writeInt(b.get(i).strengh());
			super.writeInt(b.get(i).speed());
		}
		System.out.println();
		super.send();
	}
	
	public void replyAdversaire(int me) throws IOException {
		if (Data.availableBrutes.size() >= 2) {
			int other = (int) Math.floor(Math.random()*Data.availableBrutes.size());
			while (me == other)
				other = (int) Math.floor(Math.random()*Data.availableBrutes.size());
			
			System.out.println("\nServer send: " + (byte) Protocol.REPLY_ADVERSAIRE + " [REPLY_ADVERSAIRE] " + other);
			super.writeDiscriminant(Protocol.REPLY_ADVERSAIRE);
			super.writeInt(other);
			super.send();
		}
		else
			ko();
	}
	
	public void replyFakeCombat(int one, int two) throws IOException {
		Combat c = new Combat(one, two);
		c.victory();
		ok();
	}

	public void replyCombat(int one, int two) throws IOException {
		Combat c = new Combat(one, two);
		c.loyal();
		
		System.out.println("\nServer send: " + (byte) Protocol.REPLY_COMBAT + " [REPLY_COMBAT] " + c.result());
		super.writeDiscriminant(Protocol.REPLY_COMBAT);
		super.writeInt(c.result());
		super.send();
	}

}
