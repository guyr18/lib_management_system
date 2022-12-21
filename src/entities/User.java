package entities;

import javax.persistence.*;

// User is an Entity class that is intended to serve as a template
// for a User relation in the targeted DBMS data source.
@Entity
@Table(name = "users")
public class User
{
	
	
	private int id; // A unique identifier (integer) for this User instance.
	private String first_name; // A string representing the first name of this User instance.
	private String last_name; // A string representing the last name of this User instance.
	private int age; // A integer representing the age of this User instance.
	private String email; // A string representing the email address of this User instance. 
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// GetId() returns the id of this User instance.
	public int getId()
	{
		
		return id;
		
	}
	
	// SetId(idx) sets the id of this User instance to @param idx. If @param idx < 0, then it will do nothing.
	public void setId(final int idx)
	{
		
		if(idx >= 0)
		{
			
			id = idx;
			
		}
	}
	
	@Column(name="first_name")
	// GetFirstName returns the first name of this User instance.
	public String getFirstName()
	{
		
		return first_name;
		
	}
	
	// SetFirstName(fn) sets the first name of this User instance to @param fn. If @param fn equals the empty string,
	// it will not do anything.
	public void setFirstName(final String fn)
	{
		
		if(fn != "")
		{
			
			first_name = fn;
			
		}
	}
	
	@Column(name="last_name")
	// GetLastName() returns the last name of this User instance.
	public String getLastName()
	{
		
		return last_name;
		
	}
	
	// SetLastName(ln) sets the last name of this User instance to @param ln. If @param ln equals the empty
	// string, it will not do anything.
	public void setLastName(final String ln)
	{
		
		if(ln != "")
		{
			
			last_name = ln;
			
		}
	}
	
	// GetAge() returns the age of this User instance.
	public int getAge()
	{
		
		return age;
		
	}
	
	// SetAge(a) sets the age of this instance to @param a. If a is <= 0, this method will do nothing.
	public void setAge(final int a)
	{
		
		if(a > 0)
		{
			
			age = a;
			
		}
	}
	
	// GetEmail() returns the email address of this User instance.
	public String getEmail()
	{
		
		return email;
		
	}
	
	// SetEmail(e) sets the email address of this User instance to @param e. If @param e equals the empty
	// string, it will not do anything.
	public void setEmail(final String e)
	{
		
		if(e != "")
		{
			
			email = e;
			
		}
	}
}