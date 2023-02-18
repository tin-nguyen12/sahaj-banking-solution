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
		String[] inputArray = input.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
		
		checkInputValidity(inputArray);
		
		String inputCommand = inputArray[0];
		
		if(inputCommand.equalsIgnoreCase("Create"))
		{
			try {
				accountManager.createAccount(inputArray[1]);
			}
			catch (Exception e)
			{
				System.out.println("Invalid Input");
			}
		}
		else if(inputCommand.equalsIgnoreCase("Deposit"))
		{
			try {
				accountManager.deposit(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
			}
			catch (Exception e)
			{
				System.out.println("Invalid Input");
			}
		}
		else if(inputCommand.equalsIgnoreCase("Withdraw"))
		{
			try {
				accountManager.withdrawl(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
			}
			catch (Exception e) {
				System.out.println("Invalid Input");
			}
		}
		else if(inputCommand.equalsIgnoreCase("Balance"))
		{
			try {
				accountManager.getBalance(Integer.parseInt(inputArray[1]));
			}
			catch (Exception e)
			{
				System.out.println("Invalid input");
			}
		}
		else if(inputCommand.equalsIgnoreCase("Transfer"))
		{
			try {
				accountManager.transfer(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]), 
						Integer.parseInt(inputArray[3]));
			}
			catch (Exception e)
			{
				System.out.println("Invalid input");
			}
		}
		else
		{
			System.out.println("Invalid command");
		}
	}
	
	private boolean checkInputValidity(String[] array)
	{
		if(array.length < 0 || array.length > 4) {
			System.out.println("Invalid input");
			return false;
		}
		return true;
	}
	
}