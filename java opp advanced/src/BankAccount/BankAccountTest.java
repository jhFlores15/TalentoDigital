package BankAccount;

public class BankAccountTest {

	public static void main(String[] args) throws Exception {
		BankAccount accountOne = new BankAccount();
		BankAccount accountTwo = new BankAccount();
		
		try {
			accountOne.deposit(3000, BankAccount.TYPE_ACCOUNT_CC);
			accountOne.totalAmountByAccount();
			accountOne.deposit(3500, BankAccount.TYPE_ACCOUNT_CC);
			accountOne.totalAmountByAccount();
			accountOne.withdraw(5000, BankAccount.TYPE_ACCOUNT_SA);
			accountOne.totalAmountByAccount();
			accountOne.deposit(35000, BankAccount.TYPE_ACCOUNT_SA);
			accountOne.totalAmountByAccount();
			
			
			accountTwo.deposit(3000, BankAccount.TYPE_ACCOUNT_CC);
			accountTwo.deposit(35000, BankAccount.TYPE_ACCOUNT_SA);
			accountTwo.totalAmountByAccount();
			
			BankAccount.getTotalAmountAccounts();
			BankAccount.getTotalAccounts();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
