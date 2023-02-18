import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	@Before
	public void setUp() throws Exception {
		AccountManager accountManager = new AccountManager();
		
		accountManager.createAccount("Tin Nguyen");
	}

	@Test
	public void testDeposit() {
		Account account = new TransactionAccount(1000, new Person("Tin Nguyen") );
		
		//Test deposit
		Assert.assertTrue(account.deposit(1000));
		
		//Test deposit when less than the minimum amount allowable
		Assert.assertFalse("Deposit amount less than the minimum amount allowable", account.deposit(499));
		
		//Test deposit when more than the maximum amount allowable
		Assert.assertFalse("Deposit amount more than maximum allowable",account.deposit(50001));
	}

	@Test
	public void testWithdrawl() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransactionAccount() {
		fail("Not yet implemented");
	}

}
