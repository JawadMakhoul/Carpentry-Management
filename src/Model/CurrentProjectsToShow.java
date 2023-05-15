package Model;

public class CurrentProjectsToShow {
	
	private String customerName;
	private String ProjectID;
	private String projectCategory;
	private String itemID;
	private String itemName;
	private String itemHeight;
	private String itemWidth;
	private String woodType;
	private String quantity;
	private String section;
	private String color;
	private String modelNumberOFhands;
	
	public CurrentProjectsToShow(String customerName, String projectID, String projectCategory, String itemID,
			String itemName, String itemHeight, String itemWidth, String woodType, String quantity, String section,
			String color, String modelNumberOFhands) {
		super();
		this.customerName = customerName;
		ProjectID = projectID;
		this.projectCategory = projectCategory;
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemHeight = itemHeight;
		this.itemWidth = itemWidth;
		this.woodType = woodType;
		this.quantity = quantity;
		this.section = section;
		this.color = color;
		this.modelNumberOFhands = modelNumberOFhands;
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
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}
	public String getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}
	public String getWoodType() {
		return woodType;
	}
	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelNumberOFhands() {
		return modelNumberOFhands;
	}
	public void setModelNumberOFhands(String modelNumberOFhands) {
		this.modelNumberOFhands = modelNumberOFhands;
	}
	
	
	

}
