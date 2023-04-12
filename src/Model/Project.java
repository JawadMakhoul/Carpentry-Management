package Model;

import java.sql.Date;
import java.time.LocalDate;

import Enumeration.ProjectCategory;

public class Project {
	
	private static int ID=1;
	private int customerID;
	private String projectCategory;
	public Project(int customerID, String projectCategory) {
		super();
		ID = ID++;
		this.customerID = customerID;
		this.projectCategory = projectCategory;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getCustomer() {
		return customerID;
	}
	public void setCustomer(int customerID) {
		this.customerID = customerID;
	}
	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	
	
	

}
