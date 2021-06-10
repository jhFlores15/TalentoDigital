import java.util.Scanner;

public class FizzBuzzTest {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);	
		FrizzBuzz frizzBuzz = new FrizzBuzz();		
		
		System.out.println("Ingrese numero a calcular: ");
	    int number = Integer.parseInt(sc.nextLine());
	    String resolve = frizzBuzz.fizzBuzz(number);
	    
		System.out.println(resolve);
	}
	
}
