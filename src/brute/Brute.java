/**
 * @author Nicolas
 */

package brute;

import java.util.ArrayList;

public class Brute {
	
	protected String name;
	protected int level;
	protected int life;
	protected int strengh;
	protected int speed;
	
	protected ArrayList<Bonus> bonus = new ArrayList<Bonus>();
	
	public Brute(String name) {
		this.name = name;
		level = 0;
		life = 10;
		strengh = 1;
		speed = 1;
	}
	public Brute(Brute brute) {
		name = brute.name();
		level = brute.level;
		life = brute.life;
		strengh = brute.strengh;
		speed = brute.speed;
		bonus = new ArrayList<Bonus>(brute.bonus());
	}
	public Brute(String name, int level, int life, int strengh, int speed) {
		this.name = name;
		this.level = level;
		this.life = life;
		this.strengh = strengh;
		this.speed = speed;
	}
	
	public String name() {
		return name;
	}
	
	/* INFOS */
	
	public int level() {
		return level;
	}
	public Brute addLevel(int level) {
		this.level += level > 0 ? level : 0;
		return this;
	}
	public Brute removeLevel(int level) {
		this.level -= level > 0 ? level : 0;
		return this;
	}
	
	public int life() {
		int bonus = 0;
		for (int i=0; i<this.bonus.size(); i++)
			bonus += this.bonus.get(i).life();
		return (life + bonus) > 0 ? life + bonus : 0;
	}
	public Brute addLife(int life) {
		this.life += life > 0 ? life : 0;
		return this;
	}
	public Brute removeLife(int life) {
		this.life -= life > 0 ? life : 0;
		return this;
	}
	
	public int strengh() {
		int bonus = 0;
		for (int i=0; i<this.bonus.size(); i++)
			bonus += this.bonus.get(i).strengh();
		return (strengh + bonus) > 0 ? strengh + bonus : 0;
	}
	public Brute addStrengh(int strengh) {
		this.strengh += strengh > 0 ? strengh : 0;
		return this;
	}
	public Brute removeStrengh(int strengh) {
		this.strengh -= strengh > 0 ? strengh : 0;
		return this;
	}
	
	public int speed() {
		int bonus = 0;
		for (int i=0; i<this.bonus.size(); i++)
			bonus += this.bonus.get(i).speed();
		return (speed + bonus) > 0 ? speed + bonus : 0;
	}
	public Brute addSpeed(int speed) {
		this.speed += speed > 0 ? speed : 0;
		return this;
	}
	public Brute removeSpeed(int speed) {
		this.speed += speed > 0 ? speed : 0;
		return this;
	}
	
	/* BONUS */
	
	public int numberOfBonus() {
		return bonus.size();
	}
	public ArrayList<Bonus> bonus() {
		return bonus;
	}
	public Bonus firstBonus() {
		return bonus.size() <= 0 ? null : bonus.get(0);
	}
	public Bonus secondBonus() {
		return bonus.size() <= 1 ? null : bonus.get(1);
	}
	public Bonus thirdBonus() {
		return bonus.size() <= 2 ? null : bonus.get(2);
	}
	public void addBonus(Bonus bonus) {
		if (this.bonus.size() < 2)
			this.bonus.add(bonus);
		else {
			this.bonus.remove(0);
			this.bonus.add(bonus);
		}
	}
	public void removeBonus() {
		if (this.bonus.size() > 0)
			this.bonus.remove(this.bonus.size()-1);
	}
	
	
	public String toString() {
		return "[" + name + "]\nLevel: \t" + level() + "\nLife: \t" + life() + "\nPower: \t" + strengh() + "\nSpeed: \t" + speed() ;
	}
	
}
