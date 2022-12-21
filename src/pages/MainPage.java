package pages;

import java.io.*;

public class MainPage extends Page
{
	
	@Override
	public void log()
	{
		
		System.out.println("Welcome to Library Management System!\n");
		System.out.println("1) View All Book Titles");
		System.out.println("2) Add Book");
		System.out.println("3) Register User");
		System.out.println("4) Issue Book");
		System.out.println("5) Return Book");
		System.out.println("6) Update User Attribute(s)");
		System.out.println("7) Exit");
		this.monitor();
		
	}
	
	@Override
	protected void monitor()
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			
			try
			{
				
				char keyPressed = (char)in.read();
				
				if(keyPressed == '7')
				{
					
					System.exit(0);
					
				}
				
				Pages.mainPage = null;
				
				if(keyPressed == '1')
				{
					
					Pages.listBooksPage = new ListBooksPage();
					Pages.listBooksPage.log();
					
				}
				else if(keyPressed == '2')
				{
					
					Pages.addBookPage = new AddBookPage();
					Pages.addBookPage.log();
					
				}
				else if(keyPressed == '3')
				{
					
					Pages.registerUserPage = new RegisterUserPage();
					Pages.registerUserPage.log();
					
				}
				else if(keyPressed == '4')
				{
					
					Pages.issueBookPage = new IssueBookPage();
					Pages.issueBookPage.log();
					
				}
				else if(keyPressed == '5')
				{
					
					Pages.returnBookPage = new ReturnBookPage();
					Pages.returnBookPage.log();
					
				}
				else if(keyPressed == '6')
				{
					
					Pages.updateUserPage = new UpdateUserPage();
					Pages.updateUserPage.log();
					
				}
				
			} catch(IOException ioe) {
				
				System.exit(1);
				
			}
		}
	}
}