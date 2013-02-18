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
		// 33% to win a bonus
		if (((int) Math.floor(Math.random()*100)) <= 33)
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
		// 50% to lose a bonus
		if (((int) Math.floor(Math.random()*10)) < 5)
			Data.brutes.get(brute).removeBonus();
	}
	
	public void victory() {
		winner = one;
		winner(one);
		looser(two);
	}
	
	public void loyal() {
		//winner = ((int) Math.floor(Math.random()*10)) < 5 ? one : two ;
		
		// a = probability (0-100) that one (b1) win
		int a = 0;
		
		Brute b1 = Data.brutes.get(one);
		Brute b2 = Data.brutes.get(two);
		
		// A little chance in this world
		a = ((int) Math.floor(Math.random()*10)) < 5 ? 25 : 75 ;
		
		// compare the level
		a += (b1.level() - b2.level() > 2) ? 10 : -10;
		a += (b1.level() - b2.level() > 8) ? 15 : 0;
		a += (b1.level() - b2.level() < 8) ? -15 : 0;
		
		// compare the strengh
		a += b1.strengh() > b2.strengh() ? 10 : -10;
		
		// compare the speed
		a += b1.speed() > b2.speed() ? 10 : -10;
		
		// compare the life
		a += b1.life() > b2.life() ? 10 : -10;
		
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
