/**
 * @author Nicolas
 */

package server;

import brute.Brute;

public class Combat {
	
	private int one;
	private int two;
	private int winner = 0;

	public Combat(int one, int two) {
		this.one = one;
		this.two = two;
	}
	
	private void winner(int brute) {
		// Win a level
		Data.brutes.get(brute).addLevel(1);
		// 45% to win a bonus
		if (((int) Math.floor(Math.random()*100)) <= 45)
			Data.brutes.get(brute).addBonus(Data.availableBonus.get((int) Math.floor(Math.random()*Data.availableBonus.size())));
		// 33% to win life between 1 and 5
		if (((int) Math.floor(Math.random()*100)) <= 33)
			Data.brutes.get(brute).addLife(((int) Math.floor(Math.random()*4))+1);
		// 33% to win strengh between 1 and 5
		if (((int) Math.floor(Math.random()*100)) <= 33)
			Data.brutes.get(brute).addStrengh(((int) Math.floor(Math.random()*4))+1);
		// 33% to win speed between 1 and 5
		if (((int) Math.floor(Math.random()*100)) <= 33)
			Data.brutes.get(brute).addSpeed(((int) Math.floor(Math.random()*4))+1);
	}
	private void looser(int brute) {
		// 40% to lose a bonus
		if (((int) Math.floor(Math.random()*10)) <= 4)
			Data.brutes.get(brute).removeBonus();
	}
	
	public void victory() {
		winner = one;
		winner(one);
		looser(two);
	}
	
	public void loyal() {
		
		// a = probability (0-100) that one (b1) win
		int a = 50;
		
		Brute b1 = Data.brutes.get(one);
		Brute b2 = Data.brutes.get(two);
		
		System.out.println("\n  > details combat");
		
		// compare the level
		int level = b1.level() - b2.level();
		if (level == 0) {
			a += ((int) Math.floor(Math.random()*10)) < 5 ? 5 : -5;
		}
		else if (level > 0 && level <= 4)
			a += 8;
		else if (level > 4)
			a += 16;
		else if (level < 0 && level >= -4)
			a -= 8;
		else
			a -= 16;
		System.out.println("    probability to win: " + a);
		
		// compare the strengh
		int strengh = b1.strengh() - b2.strengh();
		if (strengh == 0) {
			a += ((int) Math.floor(Math.random()*10)) < 5 ? 5 : -5;
		}
		else if (strengh > 0 && strengh <= 4)
			a += 8;
		else if (strengh > 4)
			a += 16;
		else if (strengh < 0 && strengh >= -4)
			a -= 8;
		else
			a -= 16;
		System.out.println("    probability to win: " + a);
		
		// compare the speed
		int speed = b1.speed() - b2.speed();
		if (speed == 0) {
			a += ((int) Math.floor(Math.random()*10)) < 5 ? 5 : -5;
		}
		else if (speed > 0 && speed <= 4)
			a += 8;
		else if (speed > 4)
			a += 16;
		else if (speed < 0 && speed >= -4)
			a -= 8;
		else
			a -= 16;
		System.out.println("    probability to win: " + a);
		
		// compare the life
		int life = b1.life() - b2.life();
		if (life == 0) {
			a += ((int) Math.floor(Math.random()*10)) < 5 ? 5 : -5;
		}
		else if (life > 0 && life <= 4)
			a += 8;
		else if (life > 4)
			a += 16;
		else if (life < 0 && life >= -4)
			a -= 8;
		else
			a -= 16;
		System.out.print("    probability to win: " + a);
		
		// And finnaly the winner...
		winner = a > 50 ? one : two;
		// Apply successes
		winner(winner);
		looser(winner == one ? two : one);
	}
	
	public int result() {
		return winner;
	}
	
	
}
