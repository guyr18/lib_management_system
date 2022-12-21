package pages;

import java.util.ArrayList;
import java.util.Scanner;

import managers.TransactionManager;
// MANAGERS
import managers.UserManager;

// ENTITIES
import entities.User;

public class UpdateUserPage extends Page {

	private ArrayList<String> queries;
	private int queryIndex = 0;
	
	@Override
	public void log()
	{

		System.out.println("Welcome to the update user page of LMS. Type (m / M) to exit.");
		queries = new ArrayList<>();
		queries.add("\nEnter Email (press enter to skip): ");
		queries.add("\nEnter First Name (press enter to skip): ");
		queries.add("\nEnter Last Name (press enter to skip): ");
		queries.add("\nEnter Age (press enter to skip): ");
		this.monitor();
		
	}

	@Override
	protected void monitor()
	{

		Scanner scanner = new Scanner(System.in);
		boolean returnToMainMenu = false;
		User updatedUser = new User();
		User tempUser = null;
		
		while(queryIndex < queries.size())
		{
			
			System.out.println(queries.get(queryIndex));
			String response = scanner.nextLine().trim();
			
			if(response.length() == 1 && response.toUpperCase() == "M")
			{
				
				returnToMainMenu = true;
				break;
				
			}
			else
			{
				
				if(queryIndex == 0)
				{
					
					// Email input cannot be skipped; this is how we identify the user to update.
					if(response.equals("")) { continue; }
					
					tempUser = UserManager.getInstance().doesEmailExist(response);
					
					// Email address does not exist in database.
					if(tempUser == null)
					{
						
						System.out.println("Invalid email address entered.");
						
					}
					else // Email address is linked to a user; update updatedUser properties accordingly to represent current state.
					{
						
						updatedUser.setId(tempUser.getId());
						updatedUser.setEmail(response);
						
					}
					
				}
				else if(queryIndex == 1)
				{
					
					updatedUser.setFirstName(response.equals("") ? tempUser.getFirstName() : response);
					
				}
				else if(queryIndex == 2)
				{
					
					updatedUser.setLastName(response.equals("") ? tempUser.getLastName() : response);
					
				}
				else
				{
					
					updatedUser.setAge(response.equals("") ? tempUser.getAge() : Integer.parseInt(response));
					
				}
				
				queryIndex++;
				
			}
		}
		
		if(!returnToMainMenu)
		{
			
			UserManager.getInstance().updateUser(updatedUser);
			System.out.println("User updated successfully! Press any key to return to main menu...");
			scanner.useDelimiter("'");
			scanner.nextLine();
			
		}
		
		Pages.updateUserPage = null;
		Pages.mainPage = new MainPage();
		Pages.mainPage.log();
		
	}
}