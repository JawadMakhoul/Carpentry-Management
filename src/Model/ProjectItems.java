package Model;

import Enumeration.ProjectSection;
import Enumeration.WoodType;

public class ProjectItems {
	
	private String ItemName;
	private int height;
	private int width;
	private String woodType;
	private int quantity;
	private int projectID;
	private String section;
	private String color;
	private String modelNumberOfHands;

	public ProjectItems(String itemName, int height, int width, String woodType, int quantity, int projectID,
			String section, String color, String modelNumberOfHands) {
		super();
		ItemName = itemName;
		this.height = height;
		this.width = width;
		this.woodType = woodType;
		this.quantity = quantity;
		this.projectID = projectID;
		this.section = section;
		this.color = color;
		this.modelNumberOfHands = modelNumberOfHands;
	}

	
	public ProjectItems(int projectID) {
		super();
		this.projectID = projectID;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelNumberHands() {
		return modelNumberOfHands;
	}
	public void setModelNumberHands(String modelNumberHands) {
		this.modelNumberOfHands = modelNumberHands;
	}
	
	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getModelNumberOfHands() {
		return modelNumberOfHands;
	}

	public void setModelNumberOfHands(String modelNumberOfHands) {
		this.modelNumberOfHands = modelNumberOfHands;
	}
	
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	

}
