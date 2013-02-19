/**
 * @author Nicolas
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import network.Protocol;

public class ApplicationServer {

	public static void main(String[] args) {
		
		Data.populate();
		
		try {
			ServerSocket server = new ServerSocket(Protocol.PORT);
			System.out.println("Server started");
			SessionServer s;
			
			while (true) {
				System.out.println("\nready");
		
				Socket client = server.accept();		
				s = new SessionServer(client);
				s.decode(new ReaderServer(client.getInputStream()));
				client.close();
			}
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
