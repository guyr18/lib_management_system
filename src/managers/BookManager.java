package managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Book;

import java.util.ArrayList;
import java.util.List;

public final class BookManager implements IManager
{
	
    private SessionFactory sessionFactory; // SessionFactory instance facilitating
                                           // Hibernate session.
    private static BookManager instance; // Singleton instance for this BookManager.
    
    // GetInstance() returns a static BookManager object reference. If the current
    // reference (@see instance) is null, space is allocated on the heap.
    public static BookManager getInstance()
    {
    	
    	if(instance == null)
    	{
    		
    		instance = new BookManager();
    		
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
 
    // InsertBook(newBook) inserts a new row into the books table by invoking an ORM transaction
    // that corresponds to the Book Entity class attributes.
    public void insertBook(Book newBook)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(newBook);
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    // FetchGenres() returns an ArrayList of strings that represent each
    // distinct genre. 
    public ArrayList<String> fetchGenres()
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	List<Object> temp = session.createNativeQuery("SELECT DISTINCT genre FROM books").list();
    	ArrayList<String> result = new ArrayList<String>();
    	
    	for(Object obj : temp)
    	{
    		
    		result.add(obj.toString());
    		
    	}
    	
    	session.close();
    	return result;
    	
    }
    
    // IsBookIdValid(id) returns true if a relation exists with an id attribute that is equal to @param id. Otherwise,
    // this method will return false.
    public boolean isBookIdValid(final int id)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	List<Integer> temp = session.createNativeQuery("SELECT id FROM books WHERE id='" + id + "' LIMIT 1").list();
    	return temp.size() > 0;
    	
    }
    
    // ReadByGenre(genre) returns an ArrayList of Book objects with a genre
    // that matches @param genre.
    public ArrayList<Book> readByGenre(final String genre)
    {
    	
    	if(sessionFactory == null)
    	{
    		
    		this.setup();
    		
    	}
    	
    	Session session = sessionFactory.openSession();
    	List<Book> temp = session.createNativeQuery("SELECT * FROM books WHERE genre='" + genre + "'", Book.class).list();
    	ArrayList<Book> result = new ArrayList<>();
    	session.close();
    	
    	for(Book book : temp)
    	{
    		
    		result.add(book);
    		
    	}
    	
    	return result;
    	
    }
}