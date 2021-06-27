package zoologico;

public class Mammal {
	int energy;	
	
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int displayEnergy() {
		System.out.println("Energía Actual " + this.energy);
		
		return this.energy;
	}
	
	public void modifyEnergy(int energy){
		this.energy = this.energy + energy ;
		this.displayEnergy();
	}
	
	public void sleep(int energyMax){
		System.out.println("Durmiendo...");
		this.energy = energyMax;
		this.displayEnergy();
	}
}
