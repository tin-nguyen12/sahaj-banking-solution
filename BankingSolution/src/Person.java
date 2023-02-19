
/**
 * The person class. Holds information about the person that owns an account. Has flexibility to add
 * more information such as DOB, address, phone number etc.
 * @author ngutt094
 *
 */
public class Person {
	
	private String name;

	/**Constructor that initialses with the person's name
	 * @param name name of the person
	 */
	public Person(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the name
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Sets the name of the person
	 * @param name of the person
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	/**
	 * Compares an Person object with another
	 * @return true if the two compare objects are the same
	 */
	public boolean equals(Object o)
	{
		if(o == this)
		{
			return true;
		}
		
		Person person = (Person) o;
		return this.name == person.getName();
	}
}
