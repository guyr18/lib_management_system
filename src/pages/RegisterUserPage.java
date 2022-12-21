package pages;

import java.util.ArrayList;
import java.util.Scanner;

import entities.User;
import managers.UserManager;

public final class RegisterUserPage extends Page
{
	
	private ArrayList<String> queries; // ArrayList of strings that represents questions that the user will be asked.
									   // i.e.: user attributes from DBMS schema.
	
	private int queryIndex = 0; // The index of the current question (array indexes from 0 -> n - 1).
	
	@Override
	public void log()
	{
		
		System.out.println("\nWelcome to the register user page of LMS. In a few moments, you will be queried on several user parameters.");
		System.out.println("If at any time you wish to negate this process and return to the main menu, press (m / M).");
		queries = new ArrayList<>();
		queries.add("\nEnter First Name: ");
		queries.add("\nEnter Last Name: ");
		queries.add("\nEnter Age: ");
		queries.add("\nEnter Email: ");
		this.monitor();
		
	}
	
	@Override
	protected void monitor()
	{
		
		Scanner scanner = new Scanner(System.in);
		boolean returnToMainMenu = false;
		User newUser = new User();
		
		while(queryIndex < queries.size())
		{
			
			System.out.println(queries.get(queryIndex));
			String response = scanner.nextLine().trim();
			
			if(response.length() == 1 && response.toUpperCase() == "M")
			{
				
				returnToMainMenu = true;
				
			}
			else if(!response.trim().equals(" "))
			{
				
				if(queryIndex == 0)
				{
					
					newUser.setFirstName(response);
					
				}
				else if(queryIndex == 1)
				{
					
					newUser.setLastName(response);
					
				}
				else if(queryIndex == 2)
				{
					
					newUser.setAge(Integer.parseInt(response));
					
				}
				else
				{
					
					newUser.setEmail(response);
					
				}
				
				queryIndex++;
				
			}
		}
			
		if(!returnToMainMenu)
		{
			
			UserManager.getInstance().insertUser(newUser);
			System.out.println("User added successfully! Press any key to return to main menu...");
			scanner.useDelimiter("'");
			scanner.nextLine();
		
		}
		
		Pages.registerUserPage = null;
		Pages.mainPage = new MainPage();
		Pages.mainPage.log();
			
	}
}