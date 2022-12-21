package pages;

import java.util.Set;

import entities.Book;
import managers.BookManager;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ListBooksPage extends Page
{

	private HashMap<Character, String> genres = null;
	
	@Override
	public void log()
	{
		
		ArrayList<String> temp = BookManager.getInstance().fetchGenres();
			
		if(temp.size() > 0)
		{
				
			System.out.println("LMS prefers to load books by their genre. Below, we have provided a list of available genres. Select one to proceed.\n");
			genres = new HashMap<>();
			 
			for(String genre : temp)
			{
				
				char firstChar = genre.charAt(0);
				genres.put(firstChar, genre);
				System.out.println(firstChar + ") " + genre);
				
				
			}
		}
		else
		{
			
			System.out.println("No entries in database. Press any key to return to main menu..");
			Scanner tempScanner = new Scanner(System.in);
			tempScanner.useDelimiter("'");
			tempScanner.nextLine();
			Pages.listBooksPage = null;
			Pages.mainPage = new MainPage();
			Pages.mainPage.log();
			return;
			
		}
		
		this.monitor();
		
	}
	
	@Override
	protected void monitor()
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean runAgain = false;
		
		while(true)
		{
			
			try
			{
				
				char keyPressed = Character.toUpperCase((char)in.read());
				
				if(genres.containsKey(keyPressed))
				{
					
					// run some action based on genres.get(keyPressed)
					ArrayList<Book> tempBooks = BookManager.getInstance().readByGenre(genres.get(keyPressed));
					listBooks(tempBooks);
										
					System.out.println("Would you like to view another category? (y/n)");
					Scanner scanner = new Scanner(System.in);
					String resp = scanner.next().toUpperCase().trim();
					
					if(resp.equals("Y"))
					{
						
						runAgain = true;
						
					}
					
					break;
					
				}
				
			} catch(IOException ioe) {
				
				break;
				
			}
		}
				
		if(runAgain)
		{
			
			this.log();
			
		}
		else
		{
			
			Pages.listBooksPage = null;
			Pages.mainPage = new MainPage();
			Pages.mainPage.log();
			
		}
	}
	
	// ListBooks(src) prints all attributes of Book objects in @param src to the standard output stream.
	private void listBooks(final ArrayList<Book> src)
	{
		
		for(Book book : src)
		{
			
			System.out.println("(" + book.getId() + ") : " + book.getTitle());
			
		}
	}
}