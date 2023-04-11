package Model;

public class Section {
	
	private String sectionName;
	private int projectID;
	private int quantityOFhands;
	private int quantityOFaxle;
	private String ProjectSection;

	
	
	public Section(String sectionName,int projectID, int quantityOFhands, int quantityOFaxle, String projectSection) {
		super();
		this.sectionName= sectionName;
		this.projectID = projectID;
		this.quantityOFhands = quantityOFhands;
		this.quantityOFaxle = quantityOFaxle;
		ProjectSection = projectSection;
	}
	
	
	public String getProjectSection() {
		return ProjectSection;
	}


	public void setProjectSection(String projectSection) {
		ProjectSection = projectSection;
	}


	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
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
}
