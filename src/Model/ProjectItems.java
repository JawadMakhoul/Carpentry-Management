package Model;

import Enumeration.ProjectSection;
import Enumeration.WoodType;

public class ProjectItems {
	
	private static int idCounter=1;
	
	private String itemID="Item_";
	private String ItemName;
	private int height;
	private int width;
	private String woodType;
	private int quantity;
	private String projectID;
	private String section;
	private String color;
	private String modelNumberOfHands;

	public ProjectItems(String itemID,String ItemName, int height, int width, String woodType, int quantity, String projectID,
			String section, String color, String modelNumberOfHands) {
		super();
		this.itemID=itemID;
		this.ItemName = ItemName;
		this.height = height;
		this.width = width;
		this.woodType = woodType;
		this.quantity = quantity;
		this.projectID = projectID;
		this.section = section;
		this.color = color;
		this.modelNumberOfHands = modelNumberOfHands;
	}

	public ProjectItems() {
		this.itemID=this.itemID+""+idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		ProjectItems.idCounter = idCounter;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public ProjectItems(String projectID) {
		super();
		this.projectID = projectID;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	

}
