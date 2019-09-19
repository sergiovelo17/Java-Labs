package lab03;

import java.util.GregorianCalendar;


public class LibraryBook extends Book {
	
	private String holder;
	private GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title) {
		super(isbn,author,title);
		holder = null;
		dueDate = null;
	}

	public String getHolder() {
		return this.holder;
	}
	
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	public void checkin() {
		this.holder = null;
		this.dueDate = null;
	}
	
	public void checkout(String holder, GregorianCalendar dueDate){
		
		this.dueDate = new GregorianCalendar(dueDate.get(GregorianCalendar.YEAR),dueDate.get(GregorianCalendar.MONTH),dueDate.get(GregorianCalendar.DATE));
		this.holder = new String(holder);
	}	

	// Do not override the equals method in Book

}