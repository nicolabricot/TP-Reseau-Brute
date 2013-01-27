package brute;

public class Bonus {
	
	protected String name;
	protected int level;
	protected int life;
	protected int strengh;
	protected int speed;
	
	public Bonus(String name, int level, int life, int strengh, int speed) {
		this.name = name;
		this.level = level;
		this.life = life;
		this.strengh = strengh;
		this.speed = speed;
	}
	
	public String name() {
		return name;
	}
	public int level() {
		return level;
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
	
	public String toString() {
		return level + "/" + life + "/" + strengh + "/" + speed;
	}
}
