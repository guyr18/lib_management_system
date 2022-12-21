package managers;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class SessionFactoryUtil
{
	
	// Mark constructor as private to avoid instantiation. This class should only be utilized
	// for its static methods.
	private SessionFactoryUtil() {}
	
	// FetchSessionFactoryInstance() returns a SessionFactory instance that is constructed by interpreting
	// the XML tree of hibernate.cfg.xml. If an error occurs during serialization, this method will return null.
	public static SessionFactory fetchSessionFactoryInstance()
	{
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	
    	try
    	{
    		
    		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	    
    	} catch (Exception ex) {
    		
    		System.out.println(ex.toString());
    	    StandardServiceRegistryBuilder.destroy(registry);
    	    return null;
    	    
    	}
	}
}