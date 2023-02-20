import java.util.HashMap;

/**
 * This class is responsible for the creation and management of the accounts. This includes depositing, withdrawing
 * and transferring of money.
 * @author ngutt094
 */
public class AccountManager {

	private HashMap<Integer, Account> accountList;
	private int initalAccountNumber = 1000;

	/**
	 * Constructor that initialises the account list hash map
	 */
	public AccountManager() {
		accountList = new HashMap<Integer, Account>();
	}

	/**
	 * Creates an account given a name and assigns it with an account number.
	 * @param name Name of the account holder
	 */
	public void createAccount(String name) {
		int accountNumber = generateAccountNumber();

		accountList.put(accountNumber, new TransactionAccount(accountNumber, new Person(name)));

		System.out.println(accountNumber);
	}

	/**
	 * Deposits money into an account given an account number and an amount.
	 * @param accountNumber the account number to deposit the money into
	 * @param amount the amount of money to deposit into the account 
	 * @return true if able to successfully deposit
	 */
	public boolean deposit(int accountNumber, int amount) {
		Account account = getAccount(accountNumber);
		
		if (account != null) {
			if (account.deposit(amount)) {
				System.out.println(account.getBalance());
				return true;
			}
		}
		return false;
	}

	/**
	 * Withdraws money out of an account given an account number and an amount.
	 * @param accountNumber the account number to withdraw the money out of
	 * @param amount the amount of money to withdraw out of the account 
	 * @return true if able to successfully withdraw 
	 */
	public boolean withdrawl(int accountNumber, int amount) {
		Account account = getAccount(accountNumber);
		
		if (account != null) {
			if (account.withdrawl(amount)) {
				System.out.println(account.getBalance());
				return true;
			}
		}
		return false;
	}

	/**
	 * Transfers money in between accounts
	 * @param accountNumberSrc the account number to withdraw money from
	 * @param accountNumberDst the account number to deposit into
	 * @param amount the amount of money to transfer in between accounts 
	 * @return true if able to successfully transfer
	 */
	public boolean transfer(int accountNumberSrc, int accountNumberDst, int amount) {
		Account accountSrc = getAccount(accountNumberSrc);
		Account accountDst = getAccount(accountNumberDst);
		
		if ((accountSrc != null) && (accountDst != null)) {
			if (accountSrc.withdrawl(amount) && accountDst.deposit(amount)) {
				System.out.println("Successful");
				return true;
			} else {
				System.out.println("Failure");
			}
		}
		return false;
	}

	/**
	 * Returns the balance of an account
	 * @param accountNumber the account number to return the balance of
	 * @return the balance of the account
	 */
	public int getBalance(int accountNumber) {
		int balance = getAccount(accountNumber).getBalance();
		System.out.println(balance);
		return balance;
	}

	/**
	 * Returns the account object from the hashmap
	 * @param accountNumber The number of the account
	 * @return the account
	 */
	private Account getAccount(int accountNumber) {
		if (!accountList.containsKey(accountNumber)) {
			System.out.println("Account " + accountNumber + " does not exist.");
			return null;
		} else {
			return accountList.get(accountNumber);
		}
	}
	
	/**Generates the account number
	 * @return the new account number to be assigned to the account.
	 */
	private int generateAccountNumber() {
		return initalAccountNumber++;
	}
}