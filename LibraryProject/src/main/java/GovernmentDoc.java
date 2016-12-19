
public class GovernmentDoc extends Item {

	private String country;
	
	public GovernmentDoc(int itemID, String name, String country) {
		super(itemID, "GovernmentDoc", name);
		this.country = country;
	
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
