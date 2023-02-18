import java.util.HashMap;

public class AccountManager {

	private HashMap<Integer,Account> accountList;
	private int initalAccountNumber = 1000;

	
	public AccountManager()
	{
		accountList = new HashMap<Integer, Account>();
	}
	
	public void createAccount(String name)
	{
		int accountNumber = generateAccountNumber();
		
		accountList.put(accountNumber, new TransactionAccount(accountNumber, new Person(name)));
		
		System.out.println(accountNumber);
	}
	
	public boolean deposit(int accountNumber, int amount)
	{	
		if (getAccount(accountNumber) != null)
		{
			if(getAccount(accountNumber).deposit(amount))
			{
				System.out.println(getAccount(accountNumber).getBalance());
				return true;
			}
		}
		return false;
	}
	
	public boolean withdrawl(int accountNumber, int amount)
	{
		if (getAccount(accountNumber) != null)
		{
			if(getAccount(accountNumber).withdrawl(amount))
			{
				System.out.println(getAccount(accountNumber).getBalance());
				return true;
			}
		}
		return false;
	}
	
	public boolean transfer(int accountNumberSrc, int accountNumberDst, int amount)
	{
		if((getAccount(accountNumberSrc) != null) && (getAccount(accountNumberDst) != null))
		{
			if(getAccount(accountNumberSrc).withdrawl(amount) && getAccount(accountNumberDst).deposit(amount))
			{
				System.out.println("Succesful");
				return true;
			}
			else
			{
				System.out.println("Failure");
			}
		}
		return false;
	}

	public void getBalance(int accountNumber)
	{
		System.out.println(getAccount(accountNumber).getBalance());
	}
	
	private int generateAccountNumber()
	{
		return initalAccountNumber++;
	}
	
	public Account getAccount(int accountNumber)
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