package client.ihm;

import java.awt.Graphics;
import javax.swing.JPanel;
import server.Data;

import brute.Brute;

public class PanneauBrute extends JPanel {
	String server = "localhost";
	private int idBrute1;
	
	public PanneauBrute(int id1){
		this.idBrute1 = id1;
	}
	
	

	public void paintComponent(Graphics g) {
		try {

			// Font font = new Font("Times New Roman", Font., 20);
			Brute bMe = new Brute(Data.availableBrutes.get(this.idBrute1));
			Brute bAd = new Brute(Data.availableBrutes.get(1));
			// g.setFont(font);

			// x1, y1, width, height
			g.drawRoundRect(30, 0, 1130, 90, 10, 10);
			g.drawRoundRect(30, 100, 550, 500, 10, 10);
			g.drawRoundRect(610, 100, 550, 500, 10, 10);

			g.drawString("Brute Me  ", 50, 120);
			g.drawString("Name : " + bMe.name(), 50, 150);
			g.drawString("Level : " + bMe.level(), 50, 180);
			g.drawString("Life : " + bMe.life(), 50, 210);
			g.drawString("Strengh : " + bMe.strengh(), 50, 240);
			g.drawString("Speed : " + bMe.speed(), 50, 270);
			g.drawString("Bonus 1 : " + bMe.firstBonus(), 50, 300);
			g.drawString("Bonus 2 : " + bMe.secondBonus(), 50, 330);
			g.drawString("Bonus 3 : " + bMe.thirdBonus(), 50, 360);

			g.drawString("Brute Challenger  ", 630, 120);
			g.drawString("Name : " + bAd.name(), 630, 150);
			g.drawString("Level : " + bAd.level(), 630, 180);
			g.drawString("Life : " + bAd.life(), 630, 210);
			g.drawString("Strengh : " + bAd.strengh(), 630, 240);
			g.drawString("Speed : " + bAd.speed(), 630, 270);
			g.drawString("Bonus 1 : " + bAd.firstBonus(), 630, 300);
			g.drawString("Bonus 2 : " + bAd.secondBonus(), 630, 330);
			g.drawString("Bonus 3 : " + bAd.thirdBonus(), 630, 360);
		} catch (Exception e) {
			System.out.println("Error: unknown host for " + server + "!");
			// e.printStackTrace();
		}
	}

}