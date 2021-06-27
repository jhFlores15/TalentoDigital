
public class HumanTest {

	public static void main(String[] args) {
		Human human = new Human("pepito");
		Human enemy = new Human("juanito");
		
		human.attack(enemy);
		
		System.out.println(enemy.health);

	}

}
