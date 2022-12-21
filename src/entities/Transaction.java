package entities;

import javax.persistence.*;

// Transaction is an Entity class that is intended to serve as a template
// for a Transaction relation in the targeted DBMS data source.
@Entity
@Table(name = "transactions")
public class Transaction
{
	
	
	private int id; // A unique identifier (integer) for this Transaction instance.
	private int user_id; // A unique identifier (integer) for the user linked to this Transaction instance.
	private int book_id; // A unique identifier (integer) for the book linked to this Transaction instance.
	private String start_date; // The date that this transaction began (as a string).
	private String end_date; // The date that this book is due back (as a string).
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// GetId() returns the id of this Transaction instance.
	public int getId()
	{
		
		return id;
		
	}
	
	// SetId(idx) sets the id of this Transaction instance to @param idx. If @param idx < 0, then it will do nothing.
	public void setId(final int idx)
	{
		
		if(idx >= 0)
		{
			
			id = idx;
			
		}
	}
	
	@Column(name = "user_id")
	// GetUserId() returns the user id of this Transaction instance.
	public int getUserId()
	{
		
		return user_id;
		
	}
	
	// SetUserId(idx) sets the user id of this Transaction instance to @param idx. If @param idx < 0, then it will do nothing.
	public void setUserId(final int idx)
	{
		
		if(idx >= 0)
		{
			
			user_id = idx;
			
		}
	}
	
	@Column(name = "book_id")
	// GetBookId() returns the book id of this Transaction instance.
	public int getBookId()
	{
		
		return book_id;
		
	}
	
	// SetBookId(idx) sets the book id of this Transaction instance to @param idx. If @param idx < 0, then it will do nothing.
	public void setBookId(final int idx)
	{
		
		if(idx >= 0)
		{
			
			book_id = idx;
			
		}
	}
	
	@Column(name = "start_date")
	// GetStartDate() returns the start date of this Transaction instance.
	public String getStartDate()
	{
		
		return start_date;
		
	}
	
	// SetStartDate(sd) sets the start date of this Transaction instance to @param sd. If @param sd is equal to
	// the empty string, this method will do nothing.
	public void setStartDate(final String sd)
	{
		
		if(sd != "")
		{
			
			start_date = sd;
			
		}
	}
	
	@Column(name = "end_date")
	// GetEndDate() returns the end date of this Transaction instance.
	public String getEndDate()
	{
		
		return end_date;
		
	}
	
	// SetEndDate(ed) sets the end date of this Transaction instance to @param ed. If @param ed is equal to
	// the empty string, this method will do nothing.
	public void setEndDate(final String ed)
	{
		
		if(ed != "")
		{
			
			end_date = ed;
			
		}
	}
}