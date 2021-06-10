package teoremaPitagoras;

import java.util.Scanner;

public class PitagorasTest {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Ingrese CatetoA y CatetoB para calcular la hipotenusa");
		
		System.out.println("Cateto A: ");
	    int catetoA = Integer.parseInt(sc.nextLine());
	    
	    System.out.println("Cateto B: ");
	    int catetoB = Integer.parseInt(sc.nextLine());
	    
	    
	    Pitagoras pitagoras = new Pitagoras();
		double hipotenusa = pitagoras.calcularHipotenusa(catetoA,catetoB);
		
		System.out.println("hipotenusa: "+hipotenusa);
	}
	
}
