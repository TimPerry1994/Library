
import java.util.Scanner;
public class Main {

	/* Known issues:
	 * 
	 * A bit clunky, as acquiring information about items/people requires ID number, can't get information by inputting name.
	 * 
	 *To do:
	 * 
	 * Potential for adding I/O to save information after program has finished running
	 * Find way to ensure valid countries or ISBN codes
	 */

	
	public static void main(String[] args) {
		
		//Create library
		Library testLibrary = new Library("My Library");
		
		//Using the same scanner for both ints and Strings caused problems, so using two separate ones.
		Scanner sc = new Scanner(System.in);
		Scanner lsc = new Scanner(System.in);
		//add things
		testLibrary.addItem(new Book(0,"Java Book","AB51"));
		testLibrary.addItem(new GovernmentDoc(1,"Top Secret Memes","UK"));
		
		testLibrary.addPerson(new Person(0,"Jeff Bridges"));
		
		//variable "done" in the while loop means the program loops back to the menu if the user asks to do so, rather than ending the program.
		//this is done at the end of the while loop
		int done = 1;
		while(done==1){		
			
			System.out.println("What would you like to do?");
			System.out.println("1: Register a new person");
			System.out.println("2: Update a current registered person's name");
			System.out.println("3: Remove a registered person");
			System.out.println("4: Check in an item");
			System.out.println("5: Check out an item");
			System.out.println("6: Add an item");
			System.out.println("7: Remove an item");
			System.out.println("8: Check details of an item");
			System.out.println("9: Check details of a registered person");
			System.out.println("10: Show list of registered people");
			int i = sc.nextInt();
	
			int itemID=0;
			int personID=0;

			// Automatically assigns an ID based on the number of registered users to ensure no repeated ID. User inputs their name and it creates a person.
			if(i==1){
				personID = testLibrary.personCount;
				System.out.print("Enter customer name: ");
				String name = lsc.nextLine();
				testLibrary.addPerson(new Person(personID,name));
				
				System.out.println(name + " has been added as a registered person. His ID number is " + personID + ".");					
			}
			
			// User finds ID of a person and then changes their assigned name. Could do with a way of identifying people by their previous name rather than ID
			else if(i==2){
				System.out.print("Type the ID number of the name you would like to change: ");
				personID = sc.nextInt();
				try{
					testLibrary.registeredPeople.get(personID);
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered \n");
					continue;
				}
				System.out.println("Type the new name: ");
				String name = lsc.nextLine();
				testLibrary.updatePerson(testLibrary.registeredPeople.get(personID),name);
				
				System.out.println("Name updated to " + name);
			}
			
			// User removes a currently registered person by finding their ID. Like above, could use name search function
				else if(i==3){
				System.out.print("Type the ID number of the person you would like to remove ");
				personID = sc.nextInt();
				
				try{
				System.out.println((testLibrary.registeredPeople.get(personID)).getName() + " removed.");
				testLibrary.removePerson(testLibrary.registeredPeople.get(personID));
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered");
				}
				finally{
					
				}
	
				
			}
			
			// Changes item boolean checkedOut to false. checkInItem runs regardless of whether or not the item is already checked in, may want to check for this
			else if(i==4){
				System.out.print("Give the ID of the item to check in: ");
				itemID = sc.nextInt();
				try{
					testLibrary.checkInItem(testLibrary.libraryItems.get(itemID));
					
					System.out.println((testLibrary.libraryItems.get(itemID)).getName() + " successfully checked in.");
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered");
				}
			}
			
			// As above, but checks item out. 
			else if(i==5){
				System.out.print("Give the ID of the book to check out: ");
				itemID = sc.nextInt();
				try{
					testLibrary.checkOutItem(testLibrary.libraryItems.get(itemID));
					
					System.out.println((testLibrary.libraryItems.get(itemID)).getName() + " successfully checked out.");
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered");
				}
				
			}
			
			// Adds new item, user inputs the name and what item type it is, then assigns other variables according to the item type. 
			// ID added in the same way as person registration
			else if(i==6){
				
				int itemType = 1;
				itemID = testLibrary.itemCount;
				System.out.print("Enter the item's name: ");
				String name = lsc.nextLine();
				System.out.print("Enter the type of item (1  = Book, 2 = Government Document): ");
				itemType = sc.nextInt();
				
				if(itemType==1){
					System.out.print("Enter the ISBN code: ");
					String ISBN = lsc.nextLine();
					Book book = new Book(itemID, name, ISBN);
					testLibrary.addItem(book);
					System.out.println(name + " has been registered. It's ID number is " + itemID + ".");
				}
				
				else if(itemType==2){
					System.out.print("Enter the country: ");
					String country = lsc.nextLine();
					GovernmentDoc gDoc = new GovernmentDoc(itemID, name, country);
					testLibrary.addItem(gDoc);
					System.out.println(name + " has been registered. It's ID number is " + itemID + ".");
				}
				else{
					System.out.println("This isn't a valid option");
				}
			}
			
			// Removes item based on ID. Again, could do with removal by name.
			else if(i==7){
				System.out.print("Enter the ID of the item to remove: "); 
				itemID = sc.nextInt();
				try{
					testLibrary.removeItem(testLibrary.libraryItems.get(itemID));
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered");
				}
			}
			
			// Finds and prints details of an item based off its ID.
			else if(i==8){
				System.out.println("Enter item ID: ");
				itemID = sc.nextInt();
				try{
					if((testLibrary.libraryItems.get(itemID)).getItemType()=="Book"){
					System.out.println(testLibrary.getItemDetails((Book)testLibrary.libraryItems.get(itemID)));
					}
					if((testLibrary.libraryItems.get(itemID)).getItemType()=="GovernmentDoc"){
					System.out.println(testLibrary.getItemDetails((GovernmentDoc)testLibrary.libraryItems.get(itemID)));
					}
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered");
				}
			}
			
			// Returns name of a person when user inputs ID. Could be improved to work vice versa
			else if(i==9){
				System.out.print("Enter registered person's ID: ");
				personID = sc.nextInt();
				try{
				System.out.println(testLibrary.getPersonDetails(testLibrary.registeredPeople.get(personID)));
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("That ID is not currently registered");
				}
				finally{}
			}
			
			// Returns a list of all registered people. Causes an error if a person has been removed (Option 3).
			else if(i==10){
				for(int j=0;j<testLibrary.personCount;j++){
					try{
						System.out.println(testLibrary.getPersonDetails(testLibrary.registeredPeople.get(j)));
					}
					catch(IndexOutOfBoundsException e){}
					finally{}
				}
			}
			else{
				System.out.println("That isn't a valid option");
	
			}
			
			// Checks if user would like to do more, while it says "2 = no", any number other than 1 will cause program to end. 
			System.out.println(" ");
			System.out.print("Would you like to do anything else? (1 = yes, 2 = no) ");
			done = sc.nextInt();
		}
		System.out.println(" ");
		System.out.println("Session ended.");

		sc.close();
		lsc.close();
	}

}
