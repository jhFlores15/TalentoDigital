package zoologico;

public class Bat extends Mammal {
	String name;
	
	public Bat (String name) {
		this.name = name;
		this.energy = 300;
	}
	
	public void fly() {
		System.out.println("Despega...");
		this.modifyEnergy(-50);
	}
	
	public void eatHumans() {
		System.out.println("bueno, no importa");
		this.modifyEnergy(25);
	}
	
	public void attackTown() {
		System.out.println("Ciudad en llamas");
		this.modifyEnergy(-100);
	}
}
