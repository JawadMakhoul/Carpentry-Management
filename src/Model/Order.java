package Model;

import Enumeration.OrderStatus;

public class Order {

	private int personID;
	private int orderID=0;
	private int projectID;
	private String status;
	public Order(int personID, int orderID, int projectID, String status) {
		super();
		this.personID = personID;
		this.orderID = orderID;
		this.projectID = projectID;
		this.status = status;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
