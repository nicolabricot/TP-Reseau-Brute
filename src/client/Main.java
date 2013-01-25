package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import common.Writer;
import common.Protocol;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String serverName = "localhost";
		try {
			Socket client = new Socket(serverName, Protocol.PORT);
			BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
			while (true) {
				
				String text = input.readLine();
				Writer writer = new WriterClient (client.getOutputStream());
				writer.writeUTF("Bonjour");
				writer.send ();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
