package zoologico;

public class Test {

	public static void main(String[] args) {
		Gorilla gorilla = new Gorilla("pepito");
		
		gorilla.throwSomething("banana");
		gorilla.throwSomething("rama");
		gorilla.throwSomething("manzana");
		gorilla.eatBananas();
		gorilla.eatBananas();
		gorilla.climb();
		
		
		Bat bat = new Bat("juanito");
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		bat.eatHumans();
		bat.eatHumans();
		bat.fly();
		bat.fly();
	}

}
