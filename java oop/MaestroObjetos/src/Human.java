
public class Human {
	String name;
	int strength;
	int stealth;
	int intelligence;
	int health;
	
	public Human() {
		this.strength     = 3;
		this.stealth      = 3;
		this.intelligence = 3;
		this.health       = 100;
	}
	
	public Human (String name) {
		this();
		this.name = name;
	}
	
	public void attack(Human enemy) {
		enemy.setHealth(enemy.getHealth() - this.getStrength());
	}
	
	/**
	 * Getters and Setters
	 */	
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getStealth() {
		return stealth;
	}


	public void setStealth(int stealth) {
		this.stealth = stealth;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}
	
}
