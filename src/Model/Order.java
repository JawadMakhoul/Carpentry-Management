package Model;

import Enumeration.OrderStatus;

public class Order {

	
	private static int idCounter=1;
	private String customerID;
	private String orderID="Order_";
	private String projectID;
	private String status;
	private char newShekelSign = '\u20AA';
	private String cost;
	
	public Order(String orderID,String customerID, String projectID, String status,String cost) {
		super();
		this.customerID = customerID;
		this.orderID = orderID;
		this.projectID = projectID;
		this.status = status;
		this.cost=cost+newShekelSign;
	}
	
	

	public Order() {
		this.orderID=this.orderID+""+idCounter++;
	}
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Order.idCounter = idCounter;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String CalculateCost() {
		return null;
	}
}
