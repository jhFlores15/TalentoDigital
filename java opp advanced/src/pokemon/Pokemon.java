package pokemon;

public class Pokemon {
	String name;
	int health;
	String type;
	static int count = 0;
	
	public Pokemon(String name, int healt, String type) {
		this.health = healt;
		this.name = name;
		this.type = type;
		count++;
	}
	
	
	public static int getCount() {
		return count;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getHealth() {
		return health;
	}



	public void setHealth(int health) {
		this.health = health;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.getHealth() - 10);
	}
}
