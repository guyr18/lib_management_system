package pages;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

// ENTITIES
import entities.Transaction;
import entities.User;

// MANAGERS
import managers.BookManager;
import managers.UserManager;
import managers.TransactionManager;

public class IssueBookPage extends Page {

	private ArrayList<String> queries;
	
	private int queryIndex = 0;
	
	@Override
	public void log()
	{
		
		if(BookManager.getInstance().fetchGenres().size() == 0)
		{
			
			System.out.println("There are currently no books in stock. Press any key to return to the main menu...");
			Scanner temp = new Scanner(System.in);
			temp.useDelimiter("'");
			temp.nextLine();
			Pages.issueBookPage = null;
			Pages.mainPage = new MainPage();
			Pages.mainPage.log();
			
		}
		else
		{
			
			System.out.println("Welcome to the issue book page of LMS. Press (m / M) at any time to exit..");
			queries = new ArrayList<>();
			queries.add("\nEnter Targeted Customer Email: ");
			queries.add("\nEnter Requested Book ID: ");
			this.monitor();
			
		}
	}

	@Override
	protected void monitor() 
	{
		
		Scanner scanner = new Scanner(System.in);
		boolean returnToMainMenu = false;
		Transaction newTransaction = new Transaction();
		
		while(queryIndex < queries.size())
		{
			
			System.out.println(queries.get(queryIndex));
			String response = scanner.nextLine().trim();
			
			if(response.length() == 1 && response.toUpperCase() == "M")
			{
				
				returnToMainMenu = true;
				break;
				
			}
			else if(response.length() >= 1)
			{
				
				if(queryIndex == 0)
				{
				
					User tempUser = UserManager.getInstance().doesEmailExist(response);
					
					if(tempUser != null)
					{
					
						newTransaction.setUserId(tempUser.getId());
						queryIndex++;
					
					}
					else
					{
					
						System.out.println("\nInvalid email address specified.");
						
					}
				}
				else
				{
					
					if(!BookManager.getInstance().isBookIdValid(Integer.parseInt(response)))
					{
						
						System.out.println("Invalid book id specified. You may wish to use the listing utility page to locate an appropriate id.");
						
					}
					else
					{
						
						Transaction tempTrans = TransactionManager.getInstance().isBookInStock(Integer.parseInt(response));
						
						// This book is in stock.
						if(tempTrans == null)
						{
							
							ZoneId z = ZoneId.of( "America/Edmonton" ) ;  // Or `ZoneId.systemDefault()`. 
							LocalDate today = LocalDate.now( z ) ;
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd.MM.uuuu" ) ;
							String date = today.format(dtf) ;
							newTransaction.setBookId(Integer.parseInt(response));
							newTransaction.setStartDate(date);
							newTransaction.setEndDate(date);
							queryIndex++;
							
						}
						else // Book is not in stock.
						{
							
							System.out.println("This book is not in stock. It will return on " + tempTrans.getEndDate());
							
						}
					}
				}
			}
		}
		
		if(!returnToMainMenu)
		{
			
			TransactionManager.getInstance().insertTransaction(newTransaction);
			System.out.println("Transaction added successfully! Press any key to return to main menu...");
			scanner.useDelimiter("'");
			scanner.nextLine();
		
		}
		
		Pages.issueBookPage = null;
		Pages.mainPage = new MainPage();
		Pages.mainPage.log();
		
	}
}