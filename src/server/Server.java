package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import network.Protocol;
import network.Reader;

public class Server {

	public static void main(String[] args) {
		
		Data.populate();
		
		try {
			ServerSocket server = new ServerSocket(Protocol.PORT);
			System.out.println("Server started");
			
			while (true) {
				System.out.println("\nready");
				
				Socket client = server.accept();
				Reader reader = new ReaderServer(client.getInputStream());
				
				byte discriminant = reader.readDiscriminant();
				System.out.print("Server received: " + discriminant + " ");
				
				Process.decode(discriminant, client, reader);
				
				client.close();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
