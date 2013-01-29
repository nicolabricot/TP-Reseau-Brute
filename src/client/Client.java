package client;

public class Client {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String server = "localhost";
		
		try {
			SessionClient s = new SessionClient(server);
			
			System.out.println("Client started");
			
			s.query_test();
			
			s.getLogin("Nicolas");
			s.getLogin("R2D2");
			
			s.getBruteInfo(s.getLogin("R2D2"));
			s.getBruteInfo(10);
			
			s.getBruteBonus(s.getLogin("R2D2"));
			s.getBruteBonus(2);
			s.getBruteBonus(10);
			
			s.getAdversaire(s.getLogin("R2D2"));
			
			s.getVictory(0, 1);
			s.getDefeat(1,1);
			
			for (int i=0; i<10; i++)
				s.getCombat(2, 3);
			

			System.out.println("\nClient stopped");
		}
		catch (Exception e) {
			System.out.println("Error: unknown host for " + server + "!");
			// e.printStackTrace();
		}
		

	}

}
