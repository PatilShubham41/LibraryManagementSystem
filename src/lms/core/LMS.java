package lms.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/*
 * TO-Do's:
 * 1. issue of book
 *   basic functionality is done
 *   need to add date and time of issue
 * 2. deposition of book
 * 		yet to create the basic functionality                                     
 * 3. fine calculation
 * 4. 
 * 
 * 
 */
public class LMS {

	ArrayList<Book> books = new ArrayList<>();
	ArrayList<User> users = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void addBook(Scanner scan) {

		System.out.println("Give the book name: ");
		String name = scan.next();
		System.out.println("Give the book's author name: ");
		String author = scan.next();

		books.add(new Book(name, author, true));

		System.err.println("Added the book....\n");
		

	}

	public void addUser() {

		System.out.println("Give the user name: ");
		String name = scan.next();

		long UID = (long) (Math.random() * 1000000000);

		users.add(new User(UID, name));

		System.err.println("User Added.....\n name: " + name + " User ID: " + UID);
	}

	public void browseBooks() {

		for (Book b : books) {

			System.out.println(b.getName() + " =======>> " + b.getAuthor() + " =====>>" + b.isAvailable());

		}

		System.out.println();
	}

	public User searchUser() {

		System.out.println("Give the userID: ");
		long UID = scan.nextLong();

		for (User user : users) {
			if (user.getUserID() == UID) {
				System.err.println("Found the user....\n Username: " + user.getName() + " userID: " + user.getUserID());
				return user;
			}

		}

		System.err.println("Couldn't not the found user....");
		return null;

	}

	public void currentLMSSize() {

		System.out.println("Number of books in the library: " + books.size());
		System.out.println("Number of register users of library: " + users.size());

	}
	
	public void issueBook() {
		System.out.println("Enter the book name you want to issue: ");
		String bookName = scan.next();
		for(Book  b : books) {
			
			if(b.getName().equalsIgnoreCase(bookName))
			{
				System.err.println("Book found....");
				if(b.isAvailable()) {
					System.out.println("And book is available for issueing");
					System.out.println("Want to issue "+b.getName()+" book: ");
					System.out.println("1. Yes\n2. No");
					System.out.println("Please give your input: ");
					int option = scan.nextInt();
					switch(option) {
					case 1:
						User u = searchUser();
						if( u != null) {
							b.setAvailable(false);
							b.assignBorrower(u);
							u.setIssualTime(new Date());
							System.out.println("Book is issued....");
						}
						else
							System.err.println("Could not find you in the data base...");
						
						
						return;
					case 2:
						return;
					default:
						System.out.println("You chose wrong option");
						break;
					
					}
					
					
				}
				else {
					System.err.println("Sorry, book is currently not available in the library\n Currently issued by: "+b.getBorrowedUserName());
					return;
				}
			}
		}
		
			System.err.println("Couldn't find the book");
		
		
	}

	public boolean basicOps() {

		System.out.println("1. Add book to the library");
		System.out.println("2. Browse books in library");
		System.out.println("3. Add new User");
		System.out.println("4. Search the existing user");
		System.out.println("5. Issue a book");
		System.out.println("0. For EXIT");
		System.out.println(" ============================= OOOXXXXOOO ==================\n");
		currentLMSSize();
		System.out.println("\n ============================= OOOXXXXOOO ==================");
		System.out.println("Please enter the input: ");

		int input = scan.nextInt();

		switch (input) {
		case 0:
			System.out.println("Exited the program....");
			return false;

		case 1:
			addBook(scan);
			break;

		case 2:
			browseBooks();
			break;

		case 3:
			addUser();
			break;

		case 4:
			searchUser();
			break;
		
		case 5:
			issueBook();
			break;

		default:
			System.out.println("Failed to take the input");

		}

		return true;

	}

	public static void main(String[] args) {

		LMS myLMS = new LMS();

		while (myLMS.basicOps()) {
			continue;
		}

	}

}
