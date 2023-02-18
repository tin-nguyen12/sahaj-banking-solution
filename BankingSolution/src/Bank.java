import java.util.Scanner;

public class Bank
{
	private AccountManager accountManager;
	private Scanner scanInput;
	
	public Bank()
	{
		accountManager = new AccountManager();
		scanInput = new Scanner(System.in);
	}
	
	public void input(String input)
	{
		String[] strings = input.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?"); 
	}
	
	public void createAccount(String firstName, String lastName)
	{
		accountManager.createAccount(firstName, lastName);
	}
}