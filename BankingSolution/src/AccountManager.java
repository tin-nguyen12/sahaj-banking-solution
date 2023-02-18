import java.util.HashMap;

public class AccountManager {

	private HashMap<Integer,Account> accountList;
	private int initalAccountNumber = 1000;

	
	public AccountManager()
	{
		accountList = new HashMap<Integer, Account>();
	}
	
	public void createAccount(String firstName, String lastName)
	{
		int accountNumber = generateAccountNumber();
		
		accountList.put(accountNumber, new TransactionAccount(accountNumber, new Person(firstName, lastName)));
		
		System.out.println(accountNumber);
	}
	
	public void deposit(int accountNumber, int amount)
	{	
		if (getAccount(accountNumber) != null)
		{
			if(getAccount(accountNumber).deposit(amount))
			{
				System.out.println(amount);
			}
		}
	}
	
	public void withdrawl(int accountNumber, int amount)
	{
		if (getAccount(accountNumber) != null)
		{
			if(getAccount(accountNumber).withdrawl(amount))
			{
				System.out.println(amount);
			}
		}
	}
	
	public void transfer(int accountNumberSrc, int accountNumberDst, int amount)
	{
		if((getAccount(accountNumberSrc) != null) && (getAccount(accountNumberDst) != null))
		{
			if(getAccount(accountNumberSrc).withdrawl(amount) && getAccount(accountNumberDst).deposit(amount))
			{
				System.out.println("Succesful");
			}
			else
			{
				System.out.println("Failure");
			}
		}
	}

	public void getBalance(int accountNumber)
	{
		System.out.println(getAccount(accountNumber).getBalance());
	}
	
	private int generateAccountNumber()
	{
		return initalAccountNumber++;
	}
	
	private Account getAccount(int accountNumber)
	{
		if (!accountList.containsKey(accountNumber))
		{
			System.out.println("Account " + accountNumber + " does not exist.");
			return null;
		}
		else
		{
			return accountList.get(accountNumber);
		}
	}
}