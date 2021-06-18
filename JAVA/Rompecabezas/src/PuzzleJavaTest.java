import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJavaTest {

	public static void main(String[] args) {

		PuzzleJava p = new PuzzleJava();
		
		// 1)
		int [] list = { 3,5,1,2,7,9,8,13,25,32};
		System.out.println(p.getHigher(list, 10));
		
		ArrayList<String> names = new ArrayList<>(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
		
		// 2)		
		System.out.println(p.getHigherCaracter(names, 5));
		
		// 3)
		ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
		
		boolean isVowel = p.lastIsVowel(alphabet);
		
		// 4)
		System.out.print(p.getArray());
		
		// 5)
		System.out.print(p.getArrayRandom());
		
		// 6)
		System.out.println(p.createRandomString(5));
		
		// 7)
		System.out.println(Arrays.toString(p.getArrayStrings(10,5)));
	}

}
