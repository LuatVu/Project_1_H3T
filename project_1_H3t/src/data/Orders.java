package data;

public class Orders {
	private int orderID;
	private int customerID;
	private String date;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderID, int customerID, String date) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.date = date;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
