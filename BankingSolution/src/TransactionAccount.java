
public class TransactionAccount extends Account{

	private int currentDeposits;
	private int depositsLimit = 3;
	private int currentWithdrawls;
	private int withdrawlsLimit = 3;
	private int minimumDepositLimit = 500;
	private int maximumDepositLimit = 50000;
	private int minimumWithdrawlLimit = 1000;
	private int maximumWithdrawlLimit = 25000;
	
	public TransactionAccount(int accountNumber, Person person) {
		super(accountNumber, person);
		
		this.currentDeposits = 0;
		this.currentWithdrawls = 0;
	}
	
	public boolean deposit(int amount)
	{
		if (amount < minimumDepositLimit)
		{
			System.out.println("Minimum deposit amount is " + Integer.toString(minimumDepositLimit));
			return false;
		}
		else if (amount > maximumDepositLimit)
		{
			System.out.println("Maximum deposit amount is " + Integer.toString(maximumDepositLimit));
			return false;
		}
		else if (currentDeposits >= depositsLimit)
		{
			System.out.println("Only " + depositsLimit + " deposits are allowed per day");
			return false;
		}
		else
		{
			balance += amount;
			return true;
		}
	}
	
	public boolean withdrawl(int amount)
	{
		if (amount < minimumWithdrawlLimit)
		{
			System.out.println("Minimum withdrawl amount is " + Integer.toString(minimumWithdrawlLimit));
			return false;
		}
		else if (amount > maximumWithdrawlLimit)
		{
			System.out.println("Maximum withdrawl amount is " + Integer.toString(maximumWithdrawlLimit));
			return false;
		}
		else if (currentWithdrawls >= withdrawlsLimit)
		{
			System.out.println("Only " + withdrawlsLimit + " withdrawls are allowed per day");
			return false;
		}
		else
		{
			balance -= amount;
			return true;
		}
	}
}
