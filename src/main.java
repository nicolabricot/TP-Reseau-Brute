import client.ihm.Application;
import server.ApplicationServer;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("START");
		
		new Thread() {
			public void run() {
				ApplicationServer.main(new String[]{});
			}
		}.start();
		
		Application.main(args);
	}

}
