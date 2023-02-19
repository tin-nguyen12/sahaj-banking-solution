import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	@Test
	public void testAccountInit()
	{
		Account account = new TransactionAccount(1000, new Person("Steve Rogers"));
		
		//Test for account number
		int expectedValue = 1000;
		int actualValue = account.getAccountNumber();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for person object
		Person expectedPerson = new Person("Steve Rogers");
		Person actualPerson = account.getPerson();
		Assert.assertEquals(expectedPerson, actualPerson);
	}
	
	@Test
	public void testDeposit() 
	{
		//Pre-test set up
		Account account = new TransactionAccount(1000, new Person("Steve Rogers"));
		
		//Test deposit
		Assert.assertTrue(account.deposit(1000));
		
		//Deposit when less than the minimum amount allowable
		Assert.assertFalse("Deposit amount less than the minimum amount allowable", account.deposit(499));
		
		//Deposit when more than the maximum amount allowable
		Assert.assertFalse("Deposit amount more than the maximum amount allowable",account.deposit(50001));
		
		//Test for multiple deposits by depositing 2 more times for a total of 4 attempts
		Assert.assertTrue(account.deposit(1000));
		Assert.assertTrue(account.deposit(1000));
		Assert.assertFalse(account.deposit(1000));
	}

	@Test
	public void testWithdrawl() 
	{
		//Pre-test set up
		Account account = new TransactionAccount(1000, new Person("Diance Prince"));
		account.deposit(50000);
		
		//Test withdraw
		Assert.assertTrue(account.withdrawl(1000));
		
		//Withdraw less than the minimum amount allowable
		Assert.assertFalse("Withdraw amount less than the minimum amount allowable",account.withdrawl(999));
		
		//Withdraw more than the maximum amount allowable 
		Assert.assertFalse("Withdraw amount more than the maximum amount allowable",account.withdrawl(25001));
		
		//Test for multiple withdraws by attempting to withdrawl at least 4 times
		Assert.assertTrue(account.withdrawl(1000));
		Assert.assertTrue(account.withdrawl(1000));
		Assert.assertFalse(account.withdrawl(1000));
		
	}


	@Test
	public void testBalance()
	{
		//Pre-test set up
		Account account = new TransactionAccount(1000, new Person("Steve Rogers"));
		
		//Test for balance return with a normal deposit
		account.deposit(3000);
		int expectedValue = 3000;
		int actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for balance return with a normal deposit
		account.withdrawl(1200);
		expectedValue = 1800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for balance return with a higher than allowable deposit
		account.deposit(60000);
		expectedValue = 1800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for balance return with a lower than allowable deposit
		account.deposit(100);
		expectedValue = 1800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for balance return with a higher than allowable withdraw
		account.withdrawl(26000);
		expectedValue = 1800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for balance return with a lower than allowable withdraw
		account.withdrawl(400);
		expectedValue = 1800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		//Test for exceeding maximum deposits and withdraws
		account.deposit(1000);
		account.deposit(1000);
		account.deposit(1000);
		expectedValue = 3800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);
		
		account.withdrawl(1000);
		account.withdrawl(1000);
		account.withdrawl(1000);
		expectedValue = 1800;
		actualValue = account.getBalance();
		Assert.assertEquals(expectedValue, actualValue);

	}

}
