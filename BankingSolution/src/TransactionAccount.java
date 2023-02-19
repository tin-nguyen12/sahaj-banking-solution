
/**
 * Transaction class is inherited from the Accoutn class. Contains variables and method implementation that
 * is specific to transactions only.
 * @author ngutt094
 *
 */
public class TransactionAccount extends Account {

	private int currentDeposits;
	private int depositsLimit = 3;
	private int currentWithdrawls;
	private int withdrawlsLimit = 3;
	private int minimumDepositLimit = 500;
	private int maximumDepositLimit = 50000;
	private int minimumWithdrawlLimit = 1000;
	private int maximumWithdrawlLimit = 25000;
	private int maximumBalance = 100000;

	/**
	 * Constructor that initialises the transaction account with an account number and a person
	 * @param accountNumber account number of the account
	 * @param person the person which the account belongs to
	 */
	public TransactionAccount(int accountNumber, Person person) {
		super(accountNumber, person);

		this.currentDeposits = 0;
		this.currentWithdrawls = 0;
	}

	/**
	 * Increase the balance of the account by the amount given
	 * @param amount the amount of money to be added to the accounts balance
	 * @return true if it was able to successfully deposit into the account
	 */
	public boolean deposit(int amount) {
		if (amount < minimumDepositLimit) {
			System.out.println("Minimum deposit amount is " + Integer.toString(minimumDepositLimit) + " "
					+ "for account " + getAccountNumber());
			
		} else if (amount > maximumDepositLimit) {
			System.out.println("Maximum deposit amount is " + Integer.toString(maximumDepositLimit) + " "
					+ "for account " + getAccountNumber());
			
		} else if (currentDeposits >= depositsLimit) {
			System.out.println(
					"Only " + depositsLimit + " deposits are allowed in a day " + "for account " + getAccountNumber());
			
		} else if ((balance + amount) > maximumBalance) {
			System.out.println("Maximum balance is " + maximumBalance + " for account " + getAccountNumber());
			
		} else {
			balance += amount;
			currentDeposits++;
			return true;
		}
		return false;
	}

	/**
	 * Decreases the balance of the account by the amount given
	 * @param amount the amount of money to be removed from the accounts balance
	 * @return true if it was able to successfully withdraw out of the account
	 */
	public boolean withdrawl(int amount) {
		if (amount < minimumWithdrawlLimit) {
			System.out.println("Minimum withdrawl amount is " + Integer.toString(minimumWithdrawlLimit) + " "
					+ "for account " + getAccountNumber());
			
		} else if (amount > maximumWithdrawlLimit) {
			System.out.println("Maximum withdrawl amount is " + Integer.toString(maximumWithdrawlLimit) + " "
					+ "for account " + getAccountNumber());
			
		} else if (currentWithdrawls >= withdrawlsLimit) {
			System.out.println("Only " + withdrawlsLimit + " withdrawls are allowed in a day " + "for account "
					+ getAccountNumber());
			
		} else if ((balance - amount) < 0) {
			System.out.println("Insufficient balance" + " for account " + getAccountNumber());
			
		} else {
			balance -= amount;
			currentWithdrawls++;
			return true;
		}
		return false;
	}
}
