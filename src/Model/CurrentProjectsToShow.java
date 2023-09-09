package Model;

public class CurrentProjectsToShow {
	
	private String customerName;
	private String ProjectID;
	private String projectCategory;
	private String customerEmail;
	private String status;
	private int price;
	
	public CurrentProjectsToShow(String customerName, String projectID, String projectCategory, String customerEmail
			, String status, int price) {
		super();
		this.customerName = customerName;
		ProjectID = projectID;
		this.projectCategory = projectCategory;
		this.customerEmail = customerEmail;
		this.status=status;
		this.price=price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
