package client;

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
			
			while (true) {
				Writer writer = new WriterClient(client.getOutputStream());
				writer.writeDiscriminant(Protocol.QUERY_TEST);
				writer.send();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
