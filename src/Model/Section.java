package Model;

public class Section {
	
	private static int idCounter=1;
	private String sectionID="Section_";
	private String sectionName;
	private String projectID;
	private int quantityOFhands;
	private int quantityOFaxle;
	//private String ProjectSection;

	
	
	public Section(String sectionID,String sectionName,String projectID, int quantityOFhands, int quantityOFaxle) {
		super();
		this.sectionID=sectionID;
		this.sectionName= sectionName;
		this.projectID = projectID;
		this.quantityOFhands = quantityOFhands;
		this.quantityOFaxle = quantityOFaxle;
		//ProjectSection = projectSection;
	}
	
	public Section() {
		this.sectionID=this.sectionID+""+idCounter++;
	}
	
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Section.idCounter = idCounter;
	}

	public String getSectionID() {
		return sectionID;
	}

	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

//	public String getProjectSection() {
//		return ProjectSection;
//	}
//
//
//	public void setProjectSection(String projectSection) {
//		ProjectSection = projectSection;
//	}


	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
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
