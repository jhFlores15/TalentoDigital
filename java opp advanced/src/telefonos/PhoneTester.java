package telefonos;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9",94,"Verizon","Ring Ring!");
		IPhone iphone = new IPhone("X",100,"AT&T","Poing Poing!");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iphone.displayInfo();
		System.out.println(iphone.ring());
		System.out.println(iphone.unlock());

	}

}
