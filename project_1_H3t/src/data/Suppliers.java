package data;

public class Suppliers {
	private int supplierID;
	private String supplierName;
	private String supplierAddress;
	private int phone;
	
	public Suppliers()
	{
		super();
	}

	public Suppliers(int supplierID, String supplierName, String supplierAddress, int phone) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.phone = phone;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
}
