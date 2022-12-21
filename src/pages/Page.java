package pages;

public abstract class Page
{
	
	// Log() is an abstract method designed to print static information
	// to the standard output stream.
	public abstract void log();
	
	// Monitor() is an abstract method designed to accept and monitor
	// asynchronous user input.
	protected abstract void monitor();
	
}