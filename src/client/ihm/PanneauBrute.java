package client.ihm;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
  
public class PanneauBrute extends JPanel {
  public void paintComponent(Graphics g){
	  
	Font font = new Font("Courier", Font.BOLD, 20);
	g.setFont(font);
	
    //x1, y1, width, height
	g.drawRoundRect(30, 10, 1130, 70, 10, 10);
    g.drawRoundRect(30, 100, 550, 500, 10, 10);
    g.drawRoundRect(610, 100, 550, 500, 10, 10);
    
    
    g.drawString("Brute Me", 50, 120);
    g.drawString("Name : ", 50, 170);
    g.drawString("Level : ", 50, 220);
    g.drawString("Life : ", 50, 270);
    g.drawString("Strengh : ", 50, 320);
    g.drawString("Speed : ", 50, 370);
    g.drawString("Bonus : ", 50, 420);    
    
    g.drawString("Brute Challenger", 630 , 120);
    g.drawString("Name : ", 630, 170);
    g.drawString("Level : ", 630, 220);
    g.drawString("Life : ", 630, 270);
    g.drawString("Strengh : ", 630, 320);
    g.drawString("Speed : ", 630, 370);
    g.drawString("Bonus : ", 630, 420);
  }               
}