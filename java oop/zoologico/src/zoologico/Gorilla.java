package zoologico;

public class Gorilla extends Mammal{
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gorilla (String name) {
		this.name = name;
		this.energy = 100;
	}
	
	public void throwSomething(String object) {
		if(this.energy >= 5) {
			System.out.println("gorila lanza "+ object);
			this.modifyEnergy(-5);
		}
		else {
			System.out.println("gorila no tiene energia suficiente para lanzar objeto, dormirá para recuperar energia");
			this.sleep(100);
		}
		
	}
	
	public void eatBananas() {		
		System.out.println("gorila come bananas");
		this.modifyEnergy(10);
	}
	
	public void climb() {
		if(this.energy >= 10) {
			System.out.println("gorila trepa un arbol");
			this.modifyEnergy(-10);
		}
		else {
			System.out.println("gorila no tiene energia suficiente para trepar arbol, dormirá para recuperar energia");
			this.sleep(100);
		}
		
	}
	
	
	
}
