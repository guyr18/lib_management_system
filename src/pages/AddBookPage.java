package pages;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Book;
import managers.BookManager;

public final class AddBookPage extends Page
{
	
	private ArrayList<String> queries; // ArrayList of strings that represents questions that the user will be asked.
									   // i.e.: book attributes from DBMS schema.
	
	private int queryIndex = 0; // The index of the current question (array indexes from 0 -> n - 1).
	
	@Override
	public void log()
	{
		
		System.out.println("\nWelcome to the add book page of LMS. In a few moments, you will be queried on several book parameters.");
		System.out.println("If at any time you wish to negate this process and return to the main menu, press (m / M).");
		queries = new ArrayList<>();
		queries.add("\nEnter Book Author: ");
		queries.add("\nEnter Book Title: ");
		queries.add("\nEnter Book Genre: ");
		this.monitor();
		
	}
	
	@Override
	protected void monitor()
	{
		
		Scanner scanner = new Scanner(System.in);
		boolean returnToMainMenu = false;
		Book newBook = new Book();
		
		while(queryIndex < queries.size())
		{
			
			System.out.println(queries.get(queryIndex));
			String response = scanner.nextLine().trim();
			
			if(response.length() == 1 && response.toUpperCase() == "M")
			{
				
				returnToMainMenu = true;
				break;
				
			}
			else if(response.length() >= 2)
			{
				
				if(queryIndex == 0)
				{
					
					newBook.setAuthor(response);
					
				}
				else if(queryIndex == 1)
				{
					
					newBook.setTitle(response);
					
				}
				else
				{
					
					newBook.setGenre(response);
					
				}
				
				queryIndex++;
				
			}
		}
			
		if(!returnToMainMenu)
		{
			
			BookManager.getInstance().insertBook(newBook);
			System.out.println("Book added successfully! Press any key to return to main menu...");
			scanner.useDelimiter("'");
			scanner.nextLine();
		
		}
		
		Pages.addBookPage = null;
		Pages.mainPage = new MainPage();
		Pages.mainPage.log();
			
	}
}