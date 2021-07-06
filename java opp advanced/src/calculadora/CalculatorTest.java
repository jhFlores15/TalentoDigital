package calculadora;

public class CalculatorTest {
	public static void main(String[] args) throws Exception {
		
		Calculator c = new Calculator(10.5, '-', 5.2);
		c.performOperation();
		System.out.println(c.getResult());
		
	}
}
