package unl.cse.library;

/**
 * Models an author of a book
 *
 */
public class Author {
	
	private String firstName;   
	private String lastName;
	
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return String.format("%s, %s", firstName, lastName);
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("You have to have a author's first name!");
		}
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("You have to have a author's last name!");
		}
		this.lastName = lastName;
	}
	
	
	

}


// book java

package unl.cse.library;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class models an individual book.
 *
 */
public class Book {

    private String title;
    private String isbn;
    private Author author;
    private String publishDate;
    private int year;
    
    

    public Book(String title, Author author, String isbn, String publishDate) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publishDate = publishDate;
	}

	/**
     * Getter method for author
     * @return
     */
    public Author getAuthor() {
        return this.author;
    }

    /**
     * Setter method for authors
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Getter method for call number.
     * @return
     */
    public String getISBN() {
        return isbn;
    }
   

    /**
     * Setter method for call number.
     * @param callNumber
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter method for title
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter method for title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for the publish date
     * @return publishDate
     */
    public String getPublishDate() {
    	return this.publishDate;
    }

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * returns the age of the book in years
	 * @return
	 */
    
    public int getAge() {
    	LocalDate today = LocalDate.now();
    	LocalDate year = LocalDate.parse(this.publishDate);
    	Period p = year.until(today);
    	return p.getYears();
    	
    }
	
    
}
