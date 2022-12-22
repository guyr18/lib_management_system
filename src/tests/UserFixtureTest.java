package tests;

import junit.framework.*;

// ENTITIES
import entities.User;

public final class UserFixtureTest extends TestCase
{

	protected User testUser; // Testing User object.
	
	protected void setUp()
	{
		
		testUser = new User();
		
	}
	
	public void testSetters()
	{
		
		// Test id functionality of User object.
		testUser.setId(5);
		testUser.setId(-3);
		assertTrue(testUser.getId() == 5);
		
		// Test first name functionality of User object.
		testUser.setFirstName("Robert");
		testUser.setFirstName(""); // Empty string should not be accepted.
		assertTrue(testUser.getFirstName().equals("Robert"));
		
		// Test last name functionality of User object.
		testUser.setLastName("Guy");
		testUser.setLastName(""); // Empty string should not be accepted.
		assertTrue(testUser.getLastName().equals("Guy"));
		
		// Test age functionality of User object.
		testUser.setAge(26);
		testUser.setAge(-23); // Negative ages are not accepted! this line should not do anything.
		assertTrue(testUser.getAge() == 26);
		
		// Test email address functionality of User object.
		testUser.setEmail("guyr18@students.ecu.edu");
		testUser.setEmail(""); // Empty string should not be accepted.
		assertTrue(testUser.getEmail().equals("guyr18@students.ecu.edu"));
		
	}
}
