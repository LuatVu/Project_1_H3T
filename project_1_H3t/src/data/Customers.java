package data;

public class Customers {
	private int customerID;
	private String customerName;
	private String customerAddress;
	private int phone;
	
	public Customers()
	{}
	
	public Customers(int customerID,String customerName,String customerAddress,int phone)
	{
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.phone = phone;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
}
