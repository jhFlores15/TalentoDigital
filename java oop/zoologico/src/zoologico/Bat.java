package zoologico;

public class Bat extends Mammal {
	String name;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bat (String name) {
		this.name = name;
		this.energy = 300;
	}
	
	public void fly() {
		if(this.energy >= 50) {
			System.out.println("Despega...");
			this.modifyEnergy(-50);
		}
		else {
			System.out.println("murcielago no tiene energia suficiente para volar, dormirá para recuperar energia");
			this.sleep(300);
		}
	}
	
	public void eatHumans() {
		System.out.println("bueno, no importa");
		this.modifyEnergy(25);
	}
	
	public void attackTown() {
		if(this.energy >= 100) {
			System.out.println("Ciudad en llamas");
			this.modifyEnergy(-100);
		}
		else {
			System.out.println("murcielago no tiene energia suficiente para atacar la ciudad, dormirá para recuperar energia");
			this.sleep(300);
		}
		
		
	}
}
