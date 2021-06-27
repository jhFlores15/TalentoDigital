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
		
		System.out.println();
		System.out.println();
		
		Bat bat = new Bat("juanito");
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		bat.eatHumans();
		bat.eatHumans();
		bat.attackTown();
		bat.fly();
		bat.attackTown();
		bat.fly();
	}

}
