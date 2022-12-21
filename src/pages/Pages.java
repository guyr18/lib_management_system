package pages;

public final class Pages
{
	
	// This is a static resource class that should never be initialized.
	private Pages() { }
	
	// Initialize at startup, since this is the initial page.
	public static MainPage mainPage = new MainPage();
	
	// Set other pages to null as it is not guaranteed that they will be visible during the applications lifetime.
	public static ListBooksPage listBooksPage = null;
	public static AddBookPage addBookPage = null;
	public static RegisterUserPage registerUserPage = null;
	public static IssueBookPage issueBookPage = null;
	public static ReturnBookPage returnBookPage = null;
	public static UpdateUserPage updateUserPage = null;
	
}