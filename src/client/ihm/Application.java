package client.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import client.SessionClient;

public class Application {
	static int i = 0;
	private static PanneauBrute brutes;
	private static int loginMe;
	private static int loginAd;
	static JButton buttonEquals = new JButton("Combat loyal");
	static JButton buttonLoose = new JButton("Perdre");
	static JButton buttonWin = new JButton("Gagner");

	public static void main(String[] args) {

		final SessionClient s;
		try {
			s = new SessionClient("localhost");
			s.query_test();

			loginMe = s.getLogin("R2D2");
			loginAd = s.getLogin("Stupid bot Tree");

			if (loginMe == 0)
				System.out.println("Bien connecté");
			
			
			final JFrame fenetre = new JFrame();

			fenetre.setTitle("Jeu des Brutes");
			fenetre.setSize(1200, 700);
			fenetre.setLocationRelativeTo(null);
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.setVisible(true);

			brutes = new PanneauBrute(loginMe);
			fenetre.setContentPane(brutes);

			final JPanel b1 = new JPanel();
			b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));

			final JPanel b3 = new JPanel();

			final JButton button = new JButton("Log in");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if (button.getText().equals("Log in")) {
						button.setText("Log out");
						
						buttonEquals.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event) {
								try {
									s.getCombat(loginMe, loginAd);
									fenetre.setContentPane(brutes);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
						
						buttonLoose.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event) {
								try {
									s.getDefeat(loginMe, loginAd);
									fenetre.setContentPane(brutes);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
						
						buttonWin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event) {
								try {
									s.getVictory(loginMe, loginAd);
									fenetre.setContentPane(brutes);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
						
						b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
						b3.add(buttonEquals);
						b3.add(buttonLoose);
						b3.add(buttonWin);
					} else {
						b3.removeAll();
						fenetre.setSize(1201, 701);
						fenetre.setSize(1200, 700); // WTF, only God known why I
													// did
													// it !
						b3.revalidate();
						b3.repaint();
						button.setText("Log in");

					}
				}
			});

			b1.add(button);

			JPanel b4 = new JPanel();
			b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
			b4.add(b1);
			b4.add(b3);

			fenetre.getContentPane().add(b4);

			fenetre.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}