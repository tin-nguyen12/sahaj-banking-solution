import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InputInterpreterTest {

	@Test
	public void testInput() {
		InputInterpreter inputInterpreter = new InputInterpreter();
		
		// ------------- Test Create command -------------
		String inputCommand = "Create \"Steve Rogers\"";
		Assert.assertTrue(inputInterpreter.input(inputCommand));
		
		//Different capitalisation on the Create command
		inputCommand = "cReatE \"Steve Rogers\"";
		Assert.assertTrue(inputInterpreter.input(inputCommand));
		
		//When the create command has extra inputs
		inputCommand = "cReatE \"Steve Rogers\" 123";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		
		// ------------- Test deposit command -------------
		inputCommand = "Deposit 1000 500";
		Assert.assertTrue(inputInterpreter.input(inputCommand));
		
		//When deposit command has extra inputs
		inputCommand = "Deposit 1000 500 3123";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		//When invalid account does not have enough inputs
		inputCommand = "Deposit 1002";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		// ------------- Test withdraw command -------------
		inputCommand = "Withdraw 1000 500";
		Assert.assertTrue(inputInterpreter.input(inputCommand));
		
		//When withdraw command has extra inputs
		inputCommand = "Withdraw 1000 500 3123";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		//When withdraw account does not have enough inputs
		inputCommand = "Withdraw 1002";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		// ------------- Test balance command -------------
		inputCommand = "Balance 1000";
		Assert.assertTrue(inputInterpreter.input(inputCommand));
		
		//When balance command has extra inputs
		inputCommand = "Balance 1000 500";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		// ------------- Test transfer command -------------
		inputCommand = "Transfer 1000 3000 1000";
		Assert.assertTrue(inputInterpreter.input(inputCommand));
		
		//When transfer command has extra inputs
		inputCommand = "Balance 1000 500 231 45553";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		//When transfer command does not have enough inputs
		inputCommand = "Balance 1000 500";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
		
		// ------------- Test unknown command -------------
		inputCommand = "Delete 1000";
		Assert.assertFalse(inputInterpreter.input(inputCommand));
	}

}
