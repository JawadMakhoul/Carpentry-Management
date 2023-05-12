package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import Enumeration.ProjectCategory;
import javafx.scene.control.SingleSelectionModel;

public class Project {
	private static int idCounter;
	private static int projectID;
	private static String customerID;
	private String projectCategory;
	
	public Project(int projectID,String customerID, String projectCategory) {
		super();
		Project.projectID = projectID;
		this.customerID = customerID;
		this.projectCategory = projectCategory;
	}
	public Project() {
		Project.projectID=idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Project.idCounter = idCounter;
	}
	public static int getProjectID() {
		return projectID;
	}
	public int get_ProjectID_nonStatic() {
		int id=Project.projectID;
		return id;
	}
	public static void setProjectID(int projectID) {
		Project.projectID = projectID;
	}
	public static String getCustomerID() {
		return customerID;
	}
	public static void setCustomerID(String customerID) {
		Project.customerID = customerID;
	}

	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterProject.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterProject.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

}
