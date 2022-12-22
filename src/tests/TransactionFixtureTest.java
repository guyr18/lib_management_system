package tests;

import junit.framework.*;

// ENTITIES
import entities.Transaction;

public final class TransactionFixtureTest extends TestCase
{

	protected Transaction testTransaction; // Testing Transaction object.
	
	protected void setUp()
	{
		
		testTransaction = new Transaction();
		
	}
	
	public void testSetters()
	{
		
		// Test id functionality of Transaction object.
		testTransaction.setId(2);
		testTransaction.setId(-5); // Negative ids should not be accepted.
		assertTrue(testTransaction.getId() == 2);
		
		// Test user_id functionality of Transaction object.
		testTransaction.setUserId(2);
		testTransaction.setUserId(-5); // Negative ids should not be accepted.
		assertTrue(testTransaction.getUserId() == 2);
				
		// Test book_id functionality of Transaction object.
		testTransaction.setBookId(2);
		testTransaction.setBookId(-5); // Negative ids should not be accepted.
		assertTrue(testTransaction.getBookId() == 2);
		
		// Test start_date functionality of Transaction object.
		testTransaction.setStartDate("2021.5.21");
		testTransaction.setStartDate(""); // Empty string should not be accepted.
		assertTrue(testTransaction.getStartDate().equals("2021.5.21"));
		
		// Test end_date functionality of Transaction object.
		testTransaction.setEndDate("2021.5.21");
		testTransaction.setEndDate(""); // Empty string should not be accepted.
		assertTrue(testTransaction.getEndDate().equals("2021.5.21"));
		
	}
}
