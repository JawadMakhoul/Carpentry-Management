package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Enumeration.ProjectSection;
import Enumeration.WoodType;

public class ProjectItems {
	
	private static int idCounter;
	
	private int itemID;
	private String ItemName;
	private int height;
	private int width;
	private String woodType;
	private int quantity;
	private String projectID;
	private String section;
	private String color;
	private String handsmodel;
	private String sectionID;
	

	public ProjectItems(int itemID,String ItemName, int height, int width, String woodType, int quantity, String projectID,
			String section, String color,String handsmodel,String sectionid) {
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
		this.handsmodel=handsmodel;
		this.sectionID=sectionid;
	}

	public String getSectionID() {
		return sectionID;
	}

	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}

	public String getHandsmodel() {
		return handsmodel;
	}

	public void setHandsmodel(String handsmodel) {
		this.handsmodel = handsmodel;
	}

	public ProjectItems() {
		this.itemID=idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		ProjectItems.idCounter = idCounter;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
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
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterProjectItems.txt"));
            idCounter = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException e) {
            // If the file doesn't exist or can't be read, start the counter at 1
            idCounter = 1;
        }
    }
	
	public static void saveIdCounter() {
        // Save the idCounter value to a file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterProjectItems.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
