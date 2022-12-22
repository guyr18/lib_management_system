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
		assertTrue(testBook.getId() == 5);
		
		// Test author functionality of Book object.
		testBook.setAuthor("J.K. Rowling");
		assertTrue(testBook.getAuthor().equals("J.K. Rowling"));
		
		// Test title functionality of Book object.
		testBook.setTitle("Harry Potter");
		assertTrue(testBook.getTitle().equals("Harry Potter"));
		
		// Test genre functionality of Book object.
		testBook.setGenre("Fantasy");
		assertTrue(testBook.getGenre().equals("Fantasy"));
		
		
	}
}