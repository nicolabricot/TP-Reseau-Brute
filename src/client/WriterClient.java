/**
 * @author Nicolas
 */

package client;

import java.io.IOException;
import java.io.OutputStream;

import network.Protocol;
import network.Writer;

public class WriterClient extends Writer {
	
	private boolean mute = false;

	public WriterClient (OutputStream os){
		super.os = os;
	}
	
	public void mute() {
		this.mute = true;
	}
	public void talk() {
		this.mute = false;
	}
	
	public void query_test() throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.QUERY_TEST + " [QUERY_TEST]");
		super.writeDiscriminant(Protocol.QUERY_TEST);
		super.send();
	}
	
	public void getLogin(String user) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_LOGIN + " [GET_LOGIN] " + user);
		super.writeDiscriminant(Protocol.GET_LOGIN);
		super.writeString(user);
		super.send();
	}

	public void getBruteInfos(int id) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_BRUTE_INFO + " [GET_BRUTE_INFO] " + id);
		super.writeDiscriminant(Protocol.GET_BRUTE_INFO);
		super.writeInt(id);
		super.send();
	}

	public void getBruteBonus(int id) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_BRUTE_BONUS + " [GET_BRUTE_BONUS] " + id);
		super.writeDiscriminant(Protocol.GET_BRUTE_BONUS);
		super.writeInt(id);
		super.send();
	}

	public void getAdversaire(int me) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_ADVERSAIRE + " [GET_ADVERSAIRE] " + me);
		super.writeDiscriminant(Protocol.GET_ADVERSAIRE);
		super.writeInt(me);
		super.send();
	}

	public void getVictory(int one, int two) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_VICTORY + " [GET_VICTORY] " + one + " " + two);
		super.writeDiscriminant(Protocol.GET_VICTORY);
		super.writeInt(one);
		super.writeInt(two);
		super.send();
	}
	
	public void getDefeat(int one, int two) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_DEFEAT + " [GET_DEFEAT] " + one + " " + two);
		super.writeDiscriminant(Protocol.GET_DEFEAT);
		super.writeInt(one);
		super.writeInt(two);
		super.send();
	}

	public void getCombat(int one, int two) throws IOException {
		if (!mute) System.out.println("\nClient send: " + (byte) Protocol.GET_COMBAT + " [GET_COMBAT] " + one + " " + two);
		super.writeDiscriminant(Protocol.GET_COMBAT);
		super.writeInt(one);
		super.writeInt(two);
		super.send();
	}
	
	
}
