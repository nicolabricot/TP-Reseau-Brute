/**
 * @author Nicolas
 */

package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import brute.Bonus;
import brute.Brute;

import network.Protocol;
import network.Reader;

public class ReaderClient extends Reader {
	
	public ReaderClient (InputStream is) {
		super.is = new DataInputStream(is);
	}
	
	public int replyLogin() throws IOException {
		byte d = super.readDiscriminant();
		System.out.print("Client received: " + d + " ");
		
		if (d == Protocol.REPLY_LOGIN) {
			int id = super.readInt();
			System.out.println("[REPLY_LOGIN] " + id);
			return id;
		}
		
		System.out.println("[KO]");
		return -1;
	}

	public Brute replyBruteInfo() throws IOException {
		byte d = super.readDiscriminant();
		System.out.print("Client received: " + d + " ");
		
		if (d == Protocol.REPLY_BRUTE_INFO) {
			System.out.print("[REPLY_BRUTE_INFO] ");
			String name = super.readString();
			int level = super.readInt();
			int life = super.readInt();
			int strengh = super.readInt();
			int speed = super.readInt();
			System.out.println(name + " " + level + " " + life + " " + strengh + " " + speed);
			return new Brute(name, level, life, strengh, speed);
		}
		
		System.out.println("[KO]");
		return null;
	}

	public ArrayList<Bonus> replyBruteBonus() throws IOException {
		byte d = super.readDiscriminant();
		System.out.print("Client received: " + d + " ");
		
		if (d == Protocol.REPLY_BRUTE_BONUS) {		
			System.out.print("[REPLY_BRUTE_BONUS] ");
			
			int size = super.readInt();
			System.out.print(size + " ");
			
			ArrayList<Bonus> bonus = new ArrayList<Bonus>();
			for (int i=0; i<size; i++) {
				String name = super.readString();
				int level = super.readInt();
				int life = super.readInt();
				int strengh = super.readInt();
				int speed = super.readInt();
				System.out.print(name + " " + level + " " + life + " " + strengh + " " + speed + " ");
				bonus.add(new Bonus(name, life, strengh, speed));
			}
			
			System.out.println();
			return bonus;
		}
		System.out.println("[KO]");
		return null;
	}

	public int replyAdversaire() throws IOException {
		byte d = super.readDiscriminant();
		System.out.print("Client received: " + d + " ");
		
		if (d == Protocol.REPLY_ADVERSAIRE) {
			System.out.print("[REPLY_ADVERSAIRE] ");
			int other = super.readInt();
			System.out.println(other);
			return other;
		}
		
		System.out.println("[KO]");
		return -1;
	}

	public int replyCombat() throws IOException {
		byte d = super.readDiscriminant();
		
		System.out.print("Client received: " + d + " ");
		
		if (d == Protocol.REPLY_COMBAT) {
			System.out.print("[REPLY_COMBAT] ");
			int winner = super.readInt();
			System.out.println(winner);
			return winner;
		}
		
		System.out.println("[KO]");
		return -1;
	}
	
		
}
