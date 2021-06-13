
public class FrizzBuzz {
	public String fizzBuzz(int number) {
		boolean tres = number%3 == 0;
		boolean cinco = number%5 == 0;
		
		String result;
		if(tres && cinco) {
			result = "FizzBuzz";
		}
		else if(tres) {
			result = "Fizz";
		}
		else if(cinco) {
			result = "Buzz";
		}else {
			result = String.valueOf(number);
		}
		
		return result;
	}
}
