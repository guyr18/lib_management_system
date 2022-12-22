package tests;

import junit.framework.*;

// ENTITIES
import entities.Book;

public final class BookFixtureTest extends TestCase
{

	protected Book testBook; // Testing Book object.
	
	protected void setUp()
	{
		
		testBook = new Book();
		
	}
	
	public void testSetters()
	{
		
		// Test id functionality of Book object.
		testBook.setId(5);
		testBook.setId(-3);
		assertTrue(testBook.getId() == 5);
		
		// Test author functionality of Book object.
		testBook.setAuthor("J.K. Rowling");
		testBook.setAuthor(""); // Empty string should not be accepted.
		assertTrue(testBook.getAuthor().equals("J.K. Rowling"));
		
		// Test title functionality of Book object.
		testBook.setTitle("Harry Potter");
		testBook.setTitle(""); // Empty string should not be accepted.
		assertTrue(testBook.getTitle().equals("Harry Potter"));
		
		// Test genre functionality of Book object.
		testBook.setGenre("Fantasy");
		testBook.setGenre(""); // Empty string should not be accepted.
		assertTrue(testBook.getGenre().equals("Fantasy"));
		
		
	}
}
