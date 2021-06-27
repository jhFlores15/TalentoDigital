package zoologico;

public class Mammal {
	int energy;	
	
	public int displayEnergy() {
		System.out.println("Energía Actual " + this.energy);
		
		return this.energy;
	}
	
	public void modifyEnergy(int energy){
		this.energy = this.energy + energy ;
		this.displayEnergy();
	}
}
