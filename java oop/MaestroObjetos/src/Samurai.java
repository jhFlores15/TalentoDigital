
public class Samurai extends Human {
	
	private static int numOfSamurai = 0;
	
	public Samurai() {
		this.setHealth(200);
		numOfSamurai++;
	}
	
	public void deathBlow(Human human) {
		human.setHealth(0);
		this.setHealth(this.getHealth()/2);
	}
	
	public void meditate(Human human) {
		this.setHealth(this.getHealth()/2 + this.getHealth());
	}
	
	public void howMany(){
		System.out.println("La cantidad de Samurais es: " + numOfSamurai);
	}
}
