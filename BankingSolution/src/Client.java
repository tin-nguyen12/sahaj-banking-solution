import java.util.Scanner;

/**
 * The class is responsible for interpreting the input from a text file (or an input command) and calling
 * the necessary functions as required by the input. 
 * @author ngutt094
 *
 */
public class Client {
	private AccountManager accountManager;

	/**
	 * Constructor for the client. Initilises the  account manager
	 */
	public Client() {
		accountManager = new AccountManager();
	}

	/**Assess the input, splits the string accordingly into an array and uses the first
	 * index to determine what command is being issued and calling the required function.
	 * @param input the input from the text file
	 * @return true if it was able to successfully execute the commands.
	 */
	public boolean input(String input) {
		// Splits by white space unless enclosed in quotations
		String[] inputArray = input.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");

		if (checkInputValidity(inputArray)) {

			String inputCommand = inputArray[0];

			if (inputCommand.equalsIgnoreCase("Create")) {
				try {
					accountManager.createAccount(inputArray[1]);
				} catch (Exception e) {
					printInvalidInput();
				}

			} else if (inputCommand.equalsIgnoreCase("Deposit")) {
				try {
					accountManager.deposit(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
				} catch (Exception e) {
					printInvalidInput();
				}

			} else if (inputCommand.equalsIgnoreCase("Withdraw")) {
				try {
					accountManager.withdrawl(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
				} catch (Exception e) {
					printInvalidInput();
				}

			} else if (inputCommand.equalsIgnoreCase("Balance")) {
				try {
					accountManager.getBalance(Integer.parseInt(inputArray[1]));
				} catch (Exception e) {
					printInvalidInput();
				}

			} else if (inputCommand.equalsIgnoreCase("Transfer")) {
				try {
					accountManager.transfer(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]),
							Integer.parseInt(inputArray[3]));
				} catch (Exception e) {
					printInvalidInput();
				}

			} else {
				System.out.print("Invalid command ");
				return false;
			}
			return true;
		}
		return false;
	}

	private boolean checkInputValidity(String[] array) {
		if (array.length < 2 || array.length > 4) {
			printInvalidInput();
			return false;
		}
		return true;
	}
	
	private void printInvalidInput()
	{
		System.out.print("Invalid input ");;
	}

}