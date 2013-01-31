package client.ihm;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import server.Data;

import brute.Brute;
import client.SessionClient;
  
public class PanneauBrute extends JPanel {
	String server = "localhost";
	public void paintComponent(Graphics g){
		try{
		
		SessionClient s = new SessionClient(server);
		Font font = new Font("Courier", Font.BOLD, 20);
		Brute bMe = new Brute(Data.availableBrutes.get(0));
		Brute bAd = new Brute(Data.availableBrutes.get(1));
		g.setFont(font);
	
		//x1, y1, width, height
		g.drawRoundRect(30, 10, 1130, 70, 10, 10);
		g.drawRoundRect(30, 100, 550, 500, 10, 10);
		g.drawRoundRect(610, 100, 550, 500, 10, 10);
    
    
		g.drawString("Brute Me  ", 50, 120);
		g.drawString("Name : "+bMe.name(), 50, 170);
		g.drawString("Level : "+bMe.level(), 50, 220);
		g.drawString("Life : "+bMe.life(), 50, 270);
		g.drawString("Strengh : "+bMe.strengh(), 50, 320);
		g.drawString("Speed : "+bMe.speed(), 50, 370);
		g.drawString("Bonus 1 : "+bMe.firstBonus(), 50, 420);
		g.drawString("Bonus 2 : "+bMe.secondBonus(), 50, 470);
		g.drawString("Bonus 3 : "+bMe.thirdBonus(), 50, 520);
    
		g.drawString("Brute Challenger  ", 630, 120);
		g.drawString("Name : "+bAd.name(), 630, 170);
		g.drawString("Level : "+bAd.level(), 630, 220);
		g.drawString("Life : "+bAd.life(), 630, 270);
		g.drawString("Strengh : "+bAd.strengh(), 630, 320);
		g.drawString("Speed : "+bAd.speed(), 630, 370);
		g.drawString("Bonus 1 : "+bAd.firstBonus(), 630, 420);
		g.drawString("Bonus 2 : "+bAd.secondBonus(), 630, 470);
		g.drawString("Bonus 3 : "+bAd.thirdBonus(), 630, 520);
		}	catch (Exception e) {
		System.out.println("Error: unknown host for " + server + "!");
		// e.printStackTrace();
	}
	}
             
}