package data;

public class Products {
	
	private int productID;
	private String productName;
	private int categoryID;
	private int supplierID;
	private int storage;
	private int amount;
	private int price;
	private String hsd;
	
	
	public Products()
	{
		
	}
	
	public Products(int productID, String productName, int categoryID, int supplierID, int storage, int amount,
			int price, String hsd) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.categoryID = categoryID;
		this.supplierID = supplierID;
		this.storage = storage;
		this.amount = amount;
		this.price = price;
		this.hsd = hsd;
	}
	
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getHsd() {
		return hsd;
	}
	public void setHsd(String hsd) {
		this.hsd = hsd;
	}
	
	
	
	
}
