import java.util.Scanner;

public class MiPrimerPrograma {
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cual es tu nombre? : ");
	    String nombre = sc.nextLine();
	    
	    System.out.println("¿Cual es tu edad? : ");
	    Integer edad = Integer.parseInt(sc.nextLine());
	    
	    System.out.println("¿Donde vives? : ");
	    String ciudad = sc.nextLine();   
	    
		System.out.println("Tu nombre es "+ nombre);
		System.out.println("Tienes "+edad+" años de edad.");
		System.out.println("Vives en la ciudad "+ciudad);
	}

}
