package Model;

import java.time.LocalDate;

import Enumeration.ProjectCategory;

public class Project {
	
	private int ID=1;
	private LocalDate date;
	private Customer customer;
	private ProjectCategory projectCategory;
	public Project(LocalDate date, Customer customer, ProjectCategory projectCategory) {
		super();
		ID = ID++;
		this.date = date;
		this.customer = customer;
		this.projectCategory = projectCategory;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}
	
	
	

}
