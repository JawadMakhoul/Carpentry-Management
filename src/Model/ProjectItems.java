package Model;

import Enumeration.ProjectSection;

public class ProjectItems {
	
	private int projectID;
	private ProjectSection section;
	private String color;
	private String modelNumberHands;
	private int quantityOFhands;
	private int quantityOFaxle;
	public ProjectItems(int projectID, ProjectSection section, String color, String modelNumberHands,
			int quantityOFhands, int quantityOFaxle) {
		super();
		this.projectID = projectID;
		this.section = section;
		this.color = color;
		this.modelNumberHands = modelNumberHands;
		this.quantityOFhands = quantityOFhands;
		this.quantityOFaxle = quantityOFaxle;
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
		return modelNumberHands;
	}
	public void setModelNumberHands(String modelNumberHands) {
		this.modelNumberHands = modelNumberHands;
	}
	public int getQuantityOFhands() {
		return quantityOFhands;
	}
	public void setQuantityOFhands(int quantityOFhands) {
		this.quantityOFhands = quantityOFhands;
	}
	public int getQuantityOFaxle() {
		return quantityOFaxle;
	}
	public void setQuantityOFaxle(int quantityOFaxle) {
		this.quantityOFaxle = quantityOFaxle;
	}

	
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public ProjectSection getSection() {
		return section;
	}
	public void setSection(ProjectSection section) {
		this.section = section;
	}
	

}
