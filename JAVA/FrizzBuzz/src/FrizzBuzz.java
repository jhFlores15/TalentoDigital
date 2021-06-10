
public class FrizzBuzz {
	public String fizzBuzz(int number) {
		boolean tres = number%3 == 0;
		boolean cinco = number%5 == 0;
				
		if(tres && cinco) {
			return "FizzBuzz";
		}
		else if(tres) {
			return "Fizz";
		}
		else if(cinco) {
			return "Buzz";
		}else {
			return String.valueOf(number);
		}
	}
}
