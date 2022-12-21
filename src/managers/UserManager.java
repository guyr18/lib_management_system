package managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.User;
import java.util.ArrayList;
import java.util.List;

public final class UserManager implements IManager
{
	
    private SessionFactory sessionFactory; // SessionFactory instance facilitating
                                           // Hibernate session.
    private static UserManager instance; // Singleton instance for this UserManager.
    
    // GetInstance() returns a static UserManager object reference. If the current
    // reference (@see instance) is null, space is allocated on the heap.
    public static UserManager getInstance()
    {
    	
    	if(instance == null)
    	{
    		
    		instance = new UserManager();
    		
    	}
    	
    	return instance;
    	
    }
 
    // Setup() initializes a new SessionFactory instance by reading the values of hibernate.cfg.xml.
    public SessionFactory setup() 
    {
    	
    	sessionFactory = SessionFactoryUtil.fetchSessionFactoryInstance();
    	return sessionFactory;
    	
    }
 
    // Exit() closes the current SessionFactory instance, if @see sessionFactory
    // is not null. Otherwise, it will not do anything.
    public void exit()
    {
    	
    	if(sessionFactory != null)
    	{
    		
    		sessionFactory.close();
    	
    	}
    }

    // DoesEmailExist(email) returns a User object if @param email is linked to an existing user. Otherwise,
    // this method will return null.
    public User doesEmailExist(final String email)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	List<User> temp = session.createNativeQuery("SELECT * FROM users WHERE email='" + email + "'", User.class).list();
    	return temp.size() == 1 ? temp.get(0) : null;
    	
    }
    
    // InsertUser(newUser) inserts a new row into the users table by invoking an ORM transaction
    // that corresponds to the User Entity class attributes.
    public void insertUser(final User newUser)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(newUser);
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    // UpdateUser(updatedUser) updates an existing user in the users table by invoking an ORM Transaction
    // that corresponds to @param updatedUser.
    public void updateUser(final User updatedUser)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(updatedUser);
    	session.getTransaction().commit();
    	session.close();
    	
    }
}