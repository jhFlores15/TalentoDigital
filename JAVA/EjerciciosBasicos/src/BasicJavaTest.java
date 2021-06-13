
public class BasicJavaTest {

	public static void main(String[] args) {		
		BasicJava b = new BasicJava();
		
		// 1)
		b.printAllNumbers(255);
		
		// 2)
		b.printNumbersOdd(255);
		
		System.out.println();
		// 3)		
		b.printAdd(255);
		
		//4)
		
		int array [] = {3,3,9,0,13};
		b.printArray(array);
		
		
		b.printMax(array);
		
		b.printAvg(array);
		
		b.getHowManyHigher(3, array);
		
		b.squared(array);
		
		b.getMaxMinAvg(array);
		
		b.theLast(array);
	}

}
