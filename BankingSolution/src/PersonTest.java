import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;

public class PersonTest {

	@Test
	public void testGetName() {
		Person person = new Person("Steve Rogers");
		
		String expectedString = "Steve Rogers";
		String actualString = person.getName();
		Assert.assertEquals(actualString, expectedString);
	}

	@Test
	public void testSetName() {
		Person person = new Person("Steve Rogers");
		
		person.setName("Diane Prince");
		
		String expectedString = "Diane Prince";
		String actualString = person.getName();
		Assert.assertEquals(actualString, expectedString);
	}

}
