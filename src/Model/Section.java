package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Section {
	
	private static int idCounter;
	private int sectionID;
	private String sectionName;
	private String projectID;
	private int quantityOFhands;
	private int quantityOFaxle;
	private String axleDegree;
	private String modelNumberOfHands;

	
	

	public Section(int sectionID,String sectionName,String projectID, int quantityOFhands, int quantityOFaxle, String axleDegree,String modelNumberOfHands ) {
		super();
		this.sectionID=sectionID;
		this.sectionName= sectionName;
		this.projectID = projectID;
		this.quantityOFhands = quantityOFhands;
		this.quantityOFaxle = quantityOFaxle;
		this.axleDegree=axleDegree;
		this.modelNumberOfHands=modelNumberOfHands;
		//ProjectSection = projectSection;
	}
	
	public String getModelNumberOfHands() {
		return modelNumberOfHands;
	}

	public void setModelNumberOfHands(String modelNumberOfHands) {
		this.modelNumberOfHands = modelNumberOfHands;
	}

	public Section() {
		this.sectionID=idCounter++;
	}
	
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Section.idCounter = idCounter;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
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
	public String getAxleDegree() {
		return axleDegree;
	}

	public void setAxleDegree(String axleDegree) {
		this.axleDegree = axleDegree;
	}

	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterSection.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterSection.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
