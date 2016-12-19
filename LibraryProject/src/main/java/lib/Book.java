
public class Book extends Item {
	private String ISBN;
	private String Blurb;

	public Book(int itemID, String name, String ISBN) {
		super(itemID, "Book", name);
		this.ISBN = ISBN;
		
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBlurb() {
		return Blurb;
	}

	public void setBlurb(String blurb) {
		Blurb = blurb;
	}
	

}
