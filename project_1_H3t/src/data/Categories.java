package data;

public class Categories {
	private int categoryID;
	private String categoryName;
	private String description;
	
	public Categories()
	{}

	public Categories(int categoryID, String categoryName, String description) 
	{
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.description = description;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
