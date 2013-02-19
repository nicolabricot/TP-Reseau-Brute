package client.ihm;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import client.SessionClient;
import server.Data;

import brute.Bonus;
import brute.Brute;

public class PanneauBrute extends JPanel {
	String server = "localhost";
	private int idBruteME;
	
	public PanneauBrute(int id1){
		this.idBruteME = id1;
	}
	
	

	public void paintComponent(Graphics g) {
		try {
			SessionClient socket = new SessionClient(server);

			// Font font = new Font("Times New Roman", Font., 20);
			Brute bMe = socket.getBruteInfo(idBruteME);
			int id_ad = socket.getAdversaire(idBruteME);
			Brute bAd = socket.getBruteInfo(id_ad);
			ArrayList<Bonus> bonus_me = socket.getBruteBonus(idBruteME);
			ArrayList<Bonus> bonus_ad = socket.getBruteBonus(id_ad);
			for (int i=0; i<bonus_me.size(); i++)
				bMe.addBonus(bonus_me.get(i));
			for (int i=0; i<bonus_ad.size(); i++)
				bAd.addBonus(bonus_ad.get(i));
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