package Model;

import java.sql.Date;
import java.time.LocalDate;

import Enumeration.ProjectCategory;

public class Project {
	private static int idCounter=1;
	private String projectID="Project_";
	private String customerID;
	private String projectCategory;
	
	public Project(String projectID,String customerID, String projectCategory) {
		super();
		this.projectID = projectID;
		this.customerID = customerID;
		this.projectCategory = projectCategory;
	}
	public Project() {
		this.projectID=this.projectID+""+idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Project.idCounter = idCounter;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	
	
	

}
