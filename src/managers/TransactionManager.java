package managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Book;
import entities.Transaction;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public final class TransactionManager implements IManager
{
	
    private SessionFactory sessionFactory; // SessionFactory instance facilitating
                                           // Hibernate session.
    private static TransactionManager instance; // Singleton instance for this TransactionManager.
    
    // GetInstance() returns a static TransactionManager object reference. If the current
    // reference (@see instance) is null, space is allocated on the heap.
    public static TransactionManager getInstance()
    {
    	
    	if(instance == null)
    	{
    		
    		instance = new TransactionManager();
    		
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
    
    // IsBookInStock(bookId) returns a Transaction object if the book is NOT in stock. And otherwise, will return null.
    // This Transaction instance may be used to relay information to the user such as when the book can be expected to be
    // back in stock.
    public Transaction isBookInStock(final int bookId)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	List<Transaction> temp = session.createNativeQuery("SELECT * FROM transactions WHERE book_id=" + bookId + " LIMIT 1", Transaction.class).list();
    	return temp.size() == 0  ? null : temp.get(0);
    	
    }
    
    // InsertTransaction(newTransaction) inserts a new row into the transactions table by invoking an ORM transaction
    // that corresponds to the Transaction Entity class attributes.
    public void insertTransaction(final Transaction newTransaction)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(newTransaction);
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    // DeleteTransaction(oldTransaction) deletes an existing row from the transactions table by invoking an ORM transaction
    // that corresponds to @param oldTransaction.
    public void deleteTransaction(final Transaction oldTransaction)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(oldTransaction);
    	session.getTransaction().commit();
    	session.close();
    	
    }
}