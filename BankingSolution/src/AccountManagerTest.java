import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AccountManagerTest {

	@Test
	public void testDeposit() {
		AccountManager accountManager = new AccountManager();
		accountManager.createAccount("Steve Rogers");

		boolean expectedValue = true;
		boolean actualValue = accountManager.deposit(1000, 1000);
		Assert.assertEquals(expectedValue, actualValue);

		// Deposit when under the maximum allowable limit
		expectedValue = false;
		actualValue = accountManager.deposit(1000, 300);
		Assert.assertEquals(expectedValue, actualValue);

		// Deposit when over the maximum allowable limit
		expectedValue = false;
		actualValue = accountManager.deposit(1000, 51000);
		Assert.assertEquals(expectedValue, actualValue);

		// Deposit over the maximum allowable per day
		expectedValue = false;
		accountManager.deposit(1000, 1000);
		accountManager.deposit(1000, 1000);
		actualValue = accountManager.deposit(1000, 1000);
		Assert.assertEquals(expectedValue, actualValue);

		// Depositing invalid account
		expectedValue = false;
		actualValue = accountManager.deposit(1002, 500);
		Assert.assertEquals(expectedValue, actualValue);

	}

	@Test
	public void testWithdrawl() {
		AccountManager accountManager = new AccountManager();
		accountManager.createAccount("Diane Prince");

		accountManager.deposit(1000, 10000);

		boolean expectedValue = true;
		boolean actualValue = accountManager.withdrawl(1000, 1000);
		Assert.assertEquals(expectedValue, actualValue);

		// Withdraw when under the maximum allowable limit
		expectedValue = false;
		actualValue = accountManager.withdrawl(1000, 300);
		Assert.assertEquals(expectedValue, actualValue);

		// Withdraw when over the maximum allowable limit
		expectedValue = false;
		actualValue = accountManager.withdrawl(1000, 26000);
		Assert.assertEquals(expectedValue, actualValue);

		// Withdraw over the maximum allowable per day
		expectedValue = false;
		accountManager.withdrawl(1000, 1000);
		accountManager.withdrawl(1000, 1000);
		actualValue = accountManager.withdrawl(1000, 1000);
		Assert.assertEquals(expectedValue, actualValue);

		// Withdrawing invalid account
		expectedValue = false;
		actualValue = accountManager.deposit(1002, 500);
		Assert.assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testTransfer() {
		AccountManager accountManager = new AccountManager();
		accountManager.createAccount("Steve Rogers");
		accountManager.createAccount("Diane Prince");

		accountManager.deposit(1000, 10000);
		boolean expectedValue = true;
		boolean actualValue = accountManager.transfer(1000, 1001, 1000);
		Assert.assertEquals(expectedValue, actualValue);

		//Checking for balance in the source and destination account after successfully transferring
		int expectedSrcBalanceValue = 9000;
		int expectedDstBalanceValue = accountManager.getBalance(1000);
		Assert.assertEquals(expectedSrcBalanceValue, expectedDstBalanceValue);

		int actualSrcBalanceValue = 1000;
		int actualDstBalanceValue = accountManager.getBalance(1001);
		Assert.assertEquals(actualSrcBalanceValue, actualDstBalanceValue);

		// Transferring from an invalid account
		expectedValue = false;
		actualValue = accountManager.transfer(1001, 1002, 1000);
		Assert.assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetBalance() {
		AccountManager accountManager = new AccountManager();
		accountManager.createAccount("Steve Rogers");

		accountManager.deposit(1000, 1000);
		int expectedValue = 1000;
		int actualValue = accountManager.getBalance(1000);
		Assert.assertEquals(expectedValue, actualValue);
	}

}
