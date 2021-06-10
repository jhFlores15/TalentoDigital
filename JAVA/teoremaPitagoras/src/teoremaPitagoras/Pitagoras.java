package teoremaPitagoras;

public class Pitagoras {
	public double calcularHipotenusa(int catetoA, int catetoB) {
		
		double a = Math.pow(catetoA, 2);
		double b = Math.pow(catetoB, 2);
		
		double hypot = Math.sqrt(a+b);
		
		return hypot;
		//return Math.hypot(catetoA, catetoB);
	}
}
