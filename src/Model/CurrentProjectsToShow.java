package Model;

public class CurrentProjectsToShow {
	
	private String customerName;
	private String ProjectID;
	private String projectCategory;
	private String customerEmail;
	
	public CurrentProjectsToShow(String customerName, String projectID, String projectCategory, String customerEmail) {
		super();
		this.customerName = customerName;
		ProjectID = projectID;
		this.projectCategory = projectCategory;
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
}
