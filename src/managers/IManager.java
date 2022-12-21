package managers;

import org.hibernate.SessionFactory;

public interface IManager
{
	
	SessionFactory setup();
	
	void exit();
	
}