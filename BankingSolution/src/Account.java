
/**
 * This is an abstract class for a bank account. It contains common variables and methods one would
 * find in a bank account. Gives the flexibility to create different types of bank accounts by 
 * inheriting this class. 
 * @author ngutt094
 */
public abstract class Account {

	private int accountNumber;
	private Person person;
	protected int balance;
	
	/**
	 * Constructor for Account. Initialises the account number, person information and balance.
	 * @param accountNumber The account number of the account
	 * @param person The person object which contains details it. See Person class for more details.
	 */
	public Account(int accountNumber, Person person)
	{
		this.accountNumber = accountNumber;
		this.person = person;
		this.balance = 0;
	}

	/**
	 * Returns the account number
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Returns the person associated with the account
	 * @return the person object.
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Returns the account balance
	 * @return the account balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Compares an Account object with another
	 * @return true if the two compare objects are the same
	 */
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		
		Account account = (Account) o;
		
		return this.accountNumber == account.getAccountNumber();
	}
	
	/**
	 * Deposits the money amount into the account.
	 * @param amount The amount to be deposited
	 * @return true it was able to deposit successfully
	 */
	public abstract boolean deposit(int amount);
	
	/**
	 * Withdraws the money amount from the account
	 * @param amount The amount to be withdrawn
	 * @return true whether it was able to deposit successfully
	 */
	public abstract boolean withdrawl(int amount);
}
