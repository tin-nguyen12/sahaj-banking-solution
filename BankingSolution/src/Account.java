
public abstract class Account {

	private int accountNumber;
	private Person person;
	protected int balance;
	
	public Account(int accountNumber, Person person)
	{
		this.accountNumber = accountNumber;
		this.person = person;
		this.balance = 0;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getBalance() {
		return balance;
	}
	
	public abstract boolean deposit(int amount);
	
	public abstract boolean withdrawl(int amount);
}
