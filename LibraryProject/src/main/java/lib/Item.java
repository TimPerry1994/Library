
public abstract class Item {
	//Attributes
	private boolean checkedOut;
	private int itemID;
	private String itemType;
	private String name;
	
	//Constructor
	public Item(int itemID, String itemType, String name){
		this.checkedOut=false;
		this.itemID = itemID;
		this.itemType = itemType;
		this.name = name;								
	}

	//Methods
	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
}
