import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
	
	
	public ArrayList<Integer> getHigher(int [] list, int number) {
		int sum = 0;
		 ArrayList<Integer> array = new ArrayList<Integer>();
		for (int item : list) {
			sum += item;
			if(item > number) {
				array.add(item);
			}
		}
		
		System.out.println("la suma de todos los numeros del array es: "+sum);
		return array;
	}
	
	public ArrayList<String> getHigherCaracter(ArrayList<String> list, int caracter) {
		ArrayList<String> array = new ArrayList<String>();
		Collections.shuffle(list);	
		
		for (String item : list) {
			System.out.println(item);
			if(item.length() > caracter) {
				array.add(item);
			}
		}
		
		return array;
	}
	
	public boolean lastIsVowel (ArrayList<String> list) {
		Collections.shuffle(list);
		ArrayList<String> vowels = new ArrayList<>(Arrays.asList("a","e","i","o","u"));
		
		String first = list.get(0);
		String last = list.get(list.size() -1);
		
		
		System.out.println("Primera Letra: "+first);
		System.out.println("Ultima Letra: "+last);
		
		return vowels.contains(first);	
	}
	
	
	public ArrayList<Integer> getArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		int max = 100;
		int min = 55;
		
		for(int i = 0; i < 10; i++) {
			list.add(r.nextInt((max-min)+1) + min);
		}
		
		return list;
		
	}
	
	public ArrayList<Integer> getArrayRandom() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		int max = 100;
		int min = 55;
		
		for(int i = 0; i < 10; i++) {
			list.add(r.nextInt((max-min)+1) + min);
		}
		
		Collections.sort(list);
		
		for(int item : list) {
			System.out.println(item);
		}
		
		System.out.println("El valor mas pequeño del array es: "+ list.get(0));
		
		return list;
		
	}
}
