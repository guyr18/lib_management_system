package entities;

import javax.persistence.*;

// Book is an Entity class that is intended to serve as a template
// for a Book relation in the targeted DBMS data source.
@Entity
@Table(name = "books")
public class Book
{
	
	
	private int id; // A unique identifier (integer) for this Book instance.
	private String author; // A string representing the author of this Book instance.
	private String title; // A string representing the title or name of this Book instance.
	private String genre; // A string representing the genre of this Book instance.
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// GetId() returns the id of this Book instance.
	public int getId()
	{
		
		return id;
		
	}
	
	// SetId(idx) sets the id of this Book instance to @param idx. If @param idx < 0, then it will do nothing.
	public void setId(final int idx)
	{
		
		if(idx >= 0)
		{
			
			id = idx;
			
		}
	}
	
	// GetAuthor() returns the author of this Book instance.
	public String getAuthor()
	{
		
		return author;
		
	}
	
	// SetAuthor(t) sets the author of this Book instance to @param a. If @param a equals the empty string,
	// it will not do anything.
	public void setAuthor(final String a)
	{
		
		if(a != "")
		{
			
			author = a;
			
		}
	}
	
	// GetTitle() returns the title of this Book instance.
	public String getTitle()
	{
		
		return title;
		
	}
	
	// SetTitle(t) sets the title of this Book instance to @param t. If @param t equals the empty
	// string, it will not do anything.
	public void setTitle(final String t)
	{
		
		if(t != "")
		{
			
			title = t;
			
		}
	}
	
	// GetGenre() returns the genre of this Book instance.
	public String getGenre()
	{
		
		return genre;
		
	}
	
	// SetGenre(gen) sets the genre of this Book instance to @param gen. If @param gen equals
	// the empty string, it will not do anything.
	public void setGenre(final String gen)
	{
		
		if(gen != "")
		{
			
			genre = gen;
			
		}
	}
}