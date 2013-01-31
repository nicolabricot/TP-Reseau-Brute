/**
 * @author Nicolas
 */

package server;

public class Combat {
	
	private int one;
	private int two;
	private int winner = 0;

	public Combat(int one, int two) {
		this.one = one;
		this.two = two;
	}
	
	private void winner(int brute) {
		Data.brutes.get(brute).addLevel(1);
	}
	private void looser(int brute) {
		Data.brutes.get(brute).removeLife(1);
	}
	
	public void victory() {
		winner = one;
		winner(one);
		looser(two);
	}
	
	public void loyal() {
		winner = ((int) Math.floor(Math.random()*10)) < 5 ? one : two ;
		winner(winner);
		looser(winner == one ? two : one);
	}
	
	public int result() {
		return winner;
	}
	
	
}
