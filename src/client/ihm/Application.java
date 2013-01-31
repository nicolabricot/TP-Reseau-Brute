package client.ihm;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
  
public class Application {
	
  public static void main(String[] args){
 
    JFrame fenetre = new JFrame();
    JButton login = new JButton("Log in");
    JButton challenger = new JButton("Challenger");
    JButton combat = new JButton("Combat loyal");
    JButton loose = new JButton("Loose");
    JButton win = new JButton("win");
                 
    //Définit un titre pour notre fenêtre
    fenetre.setTitle("Jeu des Brutes");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    fenetre.setSize(1200, 700);
    //Nous demandons maintenant à notre objet de se positionner au centre
    fenetre.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    fenetre.setContentPane(new PanneauBrute());
    fenetre.add(win);
    fenetre.add(loose);
    fenetre.add(combat);
    fenetre.add(challenger);
    fenetre.add(login);
    
    
    fenetre.setVisible(true);
  }       
}