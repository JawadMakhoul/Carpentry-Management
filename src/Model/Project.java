package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import Controller.CarpentryLogic;
import Enumeration.ProjectCategory;
import javafx.scene.control.SingleSelectionModel;

public class Project {
	private static int idCounter;
	private int projectID;
	private String customerID;
	private String projectCategory;
	private String email;
	private String image;
	private String status;
	private int cost;
	private String notes;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Project(int projectID,String customerID, String projectCategory,String image,String email, String status, int cost, String notes) {
		super();
		this.projectID = projectID;
		this.customerID = customerID;
		this.projectCategory = projectCategory;
		this.email=email;
		this.image="";
		this.status=status;
		this.cost=cost;
		this.notes=notes;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Project() {
		this.projectID=idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Project.idCounter = idCounter;
	}
	public  int getProjectID() {
		return projectID;
	}
//	public int get_ProjectID_nonStatic() {
//		int id=Project.projectID;
//		return id;
//	}
	public  void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public  String getCustomerID() {
		return customerID;
	}
	public  void setCustomerID(String customerID) {
		this.customerID = customerID;
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
	
	public int CalculateCost() {
		 int p_ID= this.projectID;
		 boolean flag=true;
		 int price = 0;
		 
		 for(Section s : CarpentryLogic.getInstance().getSections()) {
			 		if(s.getProjectID().equals(Integer.toString(p_ID))) {flag=true;
			 			switch (s.getAxleDegree()) {		 
			 			
			 			 case  "Degree_45" :{
			 				 price = price + s.getQuantityOFaxle()*10;
			 				 System.out.println("45/ "+price);
			 				 break;}
			 			 case  "Degree_155" :{
			 				 price = price + s.getQuantityOFaxle()*11;
			 				System.out.println("155/ "+price);
			 				 break;}
			 			 case  "Degree_180" :{
			 				 price = price + s.getQuantityOFaxle()*13;
			 				System.out.println("180/ "+price);
			 				 break;}
			 			 }
			 		
			 		
			 		
				 		for(ProjectItems  i : CarpentryLogic.getInstance().getProjectItems()) {
							 if (i.getSection()==s.getSectionName()) {
									 switch (i.getWoodType()) {
									 
									 	case  "Sandwich" :
									 	{
									 		price = price + i.getQuantity()*125;
									 		System.out.println("Sandwich "+price);
									 		break;
									 	}
									 	
									 	case  "Mdf" :
									 	{
									 		price = price + i.getQuantity()*170;
									 		System.out.println("Mdf "+price);
									 		break;
									 	}
									 	
									 	case  "Solid_Wood" :
									 	{
									 		price = price + i.getQuantity()*110;
									 		System.out.println("Solid "+price);
									 		break;
									 	}
									 	
									 	case  "Melamine" :
									 	{
									 		price = price + i.getQuantity()*115;
									 		System.out.println("melamine "+price);
									 		break;
										}
									 
									 	case  "Particleboard" :
									 	{
									 		price = price + i.getQuantity()*80;
									 		System.out.println("Particleboard "+price);
									 		break;
									 	}
								 } // end of switch
									 if(flag) {
										 
										 switch (i.getHandsmodel()) {
		
										 	case  "s125" :
										 	{
										 		price = price + s.getQuantityOFhands()*10;
										 		System.out.println("s125 "+price);
										 		flag=false;
										 		break;
										 	}
										 	
										 	case  "f120" :
										 	{
										 		price = price + s.getQuantityOFhands()*11;
										 		System.out.println("f120 "+price);
										 		flag=false;
										 		break;
										 	}
										 	
										 	case  "r452" :
										 	{
										 		price = price + s.getQuantityOFhands()*12;
										 		System.out.println("r452 "+price);
										 		flag=false;
										 		break;
										 	}
									 
										 	case  "gh32" :
										 	{
										 		price = price + s.getQuantityOFhands()*14;
										 		System.out.println("gh32 "+price);
										 		flag=false;
										 		break;
										 	}
									 
										 	case  "a17" :
										 	{
										 		price = price + s.getQuantityOFhands()*15;
										 		System.out.println("a17 "+price);
										 		flag=false;
										 		break;
										 	}
									 
									 
										 }// end of switch
									 } // end of if flag
							 } // end of is id ==
						 } // end of projectitems for loop
			 			
			 		}
			 	}
		 //this.cost=price;
		return price;
	}
	

}
