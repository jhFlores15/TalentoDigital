package BankAccount;

import java.util.Random;

public class BankAccount {
	private String number;
	private double amountCC;
	private double amountSA;
	private static int totalAccounts = 0;
	private static double totalAmount = 0;
	
	static final String TYPE_ACCOUNT_CC = "CC";
	static final String TYPE_ACCOUNT_SA = "SA";
	
	public BankAccount() {
		this.number = this.getRandomNumberAccount();
		totalAccounts ++;
	}
	
	/**
	 * Getters and Setters
	 */

	public double getAmountCC() {
		return amountCC;
	}

	private void setAmountCC(double amountCC) {
		this.amountCC = amountCC;
	}

	public double getAmountSA() {
		return amountSA;
	}

	private void setAmountSA(double amountSA) {
		this.amountSA = amountSA;
	}

	public String getNumber() {
		return number;
	}
	
	/*****************************************************/
	
	
	
	
	private String getRandomNumberAccount() {
		Random r = new Random();
		String account = "";
		for(int i=0;i<10;i++) {
			account += String.valueOf(r.nextInt(10));
		}
		
		return account;
	}
	
	public void deposit(double amount, String typeAccount) throws Exception {
		switch(typeAccount) {
			case TYPE_ACCOUNT_CC:
				this.setAmountCC(this.getAmountCC() + amount);
				break;
			case TYPE_ACCOUNT_SA:
				this.setAmountSA(this.getAmountSA() + amount);
				break;
			default:
				throw new Exception("Tipo de cuenta no manejada");
			
		}
		totalAmount += amount;
	}
	
	public void withdraw(double amount, String typeAccount) throws Exception {
		switch(typeAccount) {
			case TYPE_ACCOUNT_CC:
				if(this.getAmountCC() < amount) {
					System.out.println("No tienes fondos suficientes. Tu retiro máximo es:" + this.getAmountCC());
				}else {
					this.setAmountCC(this.getAmountCC() - amount);
					totalAmount -= amount;
				}
				
				break;
			case TYPE_ACCOUNT_SA:
				if(this.getAmountSA() < amount) {
					System.out.println("No tienes fondos suficientes. Tu retiro máximo es:" + this.getAmountSA());
				}
				else {
					this.setAmountSA(this.getAmountSA() - amount);
					totalAmount -= amount;
				}
				
				break;
			default:
				throw new Exception("Tipo de cuenta no manejada");
		}
	}
	
	public void totalAmountByAccount(){
		System.out.println("El dinero de la cuenta es: " + (this.getAmountCC()+this.getAmountSA()));
		System.out.println("Cuenta Corriente: " + this.getAmountCC());
		System.out.println("Cuenta de Ahorros: " +this.getAmountSA());
	}
	
	public static void getTotalAmountAccounts() {
		System.out.println("Monto total de las cuentas "+ totalAmount);
	}
	
	public static void getTotalAccounts() {
		System.out.println("Cuentas Existentes "+ totalAccounts);
	}
	
	
}
