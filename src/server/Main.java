package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import common.Protocol;
import common.Reader;

public class Main {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(Protocol.PORT);
			
			while (true) {
				Socket client = server.accept();
				Reader reader = new ReaderServer(client.getInputStream());
				System.out.println(reader.readDiscriminant());
				byte discnriminant = reader.readDiscriminant();
				if (discnriminant == Protocol.QUERY_TEST) {
					System.out.println("Discriminant de test a fonctionné !");
				}
				else if (discnriminant == Protocol.GET_LOGIN) {
					System.out.println("Discriminant de GET_LOGIN a fonctionné !");
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
