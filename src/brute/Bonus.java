/**
 * @author Nicolas
 */

package brute;

public class Bonus {
	
	protected String name;
	protected int life;
	protected int strengh;
	protected int speed;
	
	public Bonus(String name, int life, int strengh, int speed) {
		this.name = name;
		this.life = life;
		this.strengh = strengh;
		this.speed = speed;
	}
	
	public String name() {
		return name;
	}
	public int life() {
		return life;
	}
	public int strengh() {
		return strengh;
	}
	public int speed() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "[" + name + "] life: " + life + " | power: " + strengh + " | speed: " + speed;
	}
}
