import java.util.ArrayList;

public class BasicJava {
	
	public void printAllNumbers(int number) {
		for(int i=1; i<= number;i++) {
			if(i == number) {
				System.out.println(i);
				continue;
			}
			System.out.print(i + ", ");
		}
	}
	
	public void printNumbersOdd(int number) {
		for(int i=1; i<= number;i++) {
			if(i % 2 == 1) {
				if(i == 1) {
					System.out.print(i);
					continue;
				}
				System.out.print(", " + i);
			}
		}
	}
	
	public void printAdd(int number) {
		int cont = 0;
		for(int i=0; i<= number;i++) {
			cont += i;
			System.out.println("Nuevo Numero:" + i + " Suma: " + cont);			
		}
	}

	public void printArray(int [] list) {
		for (int item : list) {
			System.out.print(item + "  ");
		}
	}
	
	public void printMax(int list []) {
		int max = 0;
		for(int i = 0; i< list.length ;i++){
			if(i == 0) {
				max = list[0];
				continue;
			}
			if(list[i] > max) {
				max = list[i];
			}
		}
		
		System.out.println("El numero mayor del array es: "+max);
	}
	
	public void printAvg(int list []) {
		int sum = 0;
		for(int number:  list){
			sum += number;
		}
		
		System.out.println("El promedio del array es: "+sum/list.length);
	}
	
	public ArrayList<Integer> getNumbersOdd(int number) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<= number;i++) {
			if(i % 2 == 1) {
				list.add(i);
			}
		}
		
		return list;
	}
	
	public int getHowManyHigher(int number, int [] list) {
		int sum = 0;
		for(int item:  list){
			if(item > number) {
				sum++;
			}
		}
		
		return sum;
	}
	
	public int[] squared(int [] list) {
		for(int i = 0; i< list.length ;i++){
			list[i] = list[i]*list[i];
		}
		
		return list;
	}
	
	public int[] withoutNegatives(int [] list) {
		for(int i = 0; i< list.length ;i++){
			if(list[i] < 0) {
				list[i] = 0;
			}
		}
		
		return list;
	}
	
	public int[] getMaxMinAvg(int list []) {
		int max = 0;
		int min = 0;
		int sum = 0;
		for(int i = 0; i< list.length ;i++){
			sum += list[i];
			if(i == 0) {
				max = list[0];
				min = list[0];
				continue;
			}
			if(list[i] > max) {
				max = list[i];
			}
			if(list[i] < min) {
				min = list[i];
			}
		}
		
		int [] result = {max,min,(sum/list.length)};
		return result;
	}
	
	public int[] theLast(int [] list) {
		for(int i = 0; i< list.length ;i++){
			if(i == list.length-1) {
				list[i] = 0;
				continue;
			}
			list[i] = list[i+1];
		}
		
		return list;
	}
}

