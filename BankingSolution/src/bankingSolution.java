
public class bankingSolution {

	public static void main(String[] args) {

//		AccountManager manager = new AccountManager();
//		
//		manager.createAccount("Tin", "Nguyen");
//		
//		manager.deposit(32,600);
//		
		Bank bank = new Bank();
		
		bank.input("Create \"Steve Rogers\"");
		bank.input("Create \"Diane Prince\"");
		
		bank.input("Deposit 1000 500");
		bank.input("depOsit 1000 1000");
		bank.input("DEpOsiT 1000 100");
		bank.input("DEpOsiT 1000 60000");
		bank.input("DEpOsiT 1000 10000");
		bank.input("deposit 1000 10000");
		
		bank.input("Balance 1000");
		
		bank.input("Withdraw 1000 500");
		bank.input("Withdraw 1000 20000");
		bank.input("Withdraw 1000 1000");
		bank.input("Withdraw 1000 1900");
		bank.input("WIthdraw 1000 1000");
		bank.input("withdraw 1000 5000");
		
		bank.input("Create \"Iron Man\"");
		
		bank.input("deposit 1001 5000");
		
		bank.input("Transfer 1001 1002 300");
		bank.input("Transfer 1001 1000 30000");
	}

}
