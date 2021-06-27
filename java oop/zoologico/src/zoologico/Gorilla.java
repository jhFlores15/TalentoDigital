package zoologico;

public class Gorilla extends Mammal{
	String name;
	
	public Gorilla (String name) {
		this.name = name;
		this.energy = 100;
	}
	
	public void throwSomething(String object) {
		System.out.println("gorila lanza "+ object);
		this.modifyEnergy(-5);
		
	}
	
	public void eatBananas() {
		System.out.println("gorila come bananas");
		this.modifyEnergy(10);
	}
	
	public void climb() {
		System.out.println("gorila trepa un arbol");
		this.modifyEnergy(-10);
	}
	
	
	
}
