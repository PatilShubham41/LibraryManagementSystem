package lms.core;

public class Book {
	
	private String name;
	private String author;
	private boolean isAvailable;
	private User borrowedUser;
	
	public Book() {
		
		this("EMPTY", "UNKNOWN", false);
		
	}
	
	public Book(String name, String author, boolean status) {
		
		this.name = name;
		this.author = author;
		this.isAvailable = status;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void assignBorrower(User lUser) {
		borrowedUser = lUser;
	}
	
	public String getBorrowedUserName() {
		return borrowedUser.getName();
	}
	

}
