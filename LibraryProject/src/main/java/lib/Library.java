import java.util.ArrayList;

public class Library {
	//Attributes
	ArrayList<Item> libraryItems;
	ArrayList<Person> registeredPeople;
	private String libraryName;
	protected int itemCount = 0;
	protected int personCount = 0;
		
	//Constructor
	public Library(String libraryName){
		this.libraryName = libraryName;
		libraryItems = new ArrayList<Item>();
		registeredPeople = new ArrayList<Person>();
	}
	
	//Method
	
	

	public ArrayList<Item> getLibraryItems() {
		return libraryItems;
	}

	public ArrayList<Person> getRegisteredPeople() {
		return registeredPeople;
	}


	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
		
	public void addItem(Item item){
		//add item to libraryItems
		libraryItems.add(item);
		itemCount++;
	}

	public void removeItem(Item item){
		//remove item from libraryItems
		libraryItems.remove(item);	
	}
	
	public void addPerson(Person person){
		//add person to registeredPeople
		registeredPeople.add(person);
		personCount++;
	}
	
	public void removePerson(Person person){
		//remove person from registeredPeople
		registeredPeople.remove(person);
	}
	
	public void updatePerson(Person p, String name){
		//change name of registered person
		p.setName(name);
	}
	
	
	
	public void checkOutItem(Item item){
		//change items checkedOut boolean to true
		item.setCheckedOut(true);
	}
	
	public void checkInItem(Item item){
		item.setCheckedOut(false);
	}
	
	public String getItemDetails(Book book){
		//get book details
		StringBuilder sb = new StringBuilder();
		sb.append("ISBN: " + book.getISBN() + "\n");
		sb.append("ID: " + book.getItemID() + "\n");
		sb.append("Name: " + book.getName() + "\n");
		//return ISBN, id, name
		return sb.toString();
	}
	
	public String getItemDetails(GovernmentDoc gDoc){
		//get govDoc details
		StringBuilder sb = new StringBuilder();
		
		sb.append("Country: " + gDoc.getCountry() + "\n");
		sb.append("ID: " + gDoc.getItemID() + "\n");
		sb.append("Name: " + gDoc.getName() + "\n");
		
		//return country, id, name
		return sb.toString();
	}
	
	public String getPersonDetails(Person p){
		StringBuilder sb = new StringBuilder();
		
		sb.append("ID: " + p.getId() + "\n");
		sb.append("Name: " + p.getName() + "\n");		
		
		return sb.toString();
	}
	
	
}
