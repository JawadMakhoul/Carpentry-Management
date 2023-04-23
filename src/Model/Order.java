package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Controller.CarpentryLogic;
import Enumeration.AxleDegree;
import Enumeration.OrderStatus;

public class Order {

	
	private static int idCounter;
	private String customerID;
	private int orderID;
	private String projectID;
	private String status;
	private char newShekelSign = '\u20AA';
	private int cost;
	
	public Order(int orderID,String customerID, String projectID, String status,int cost) {
		super();
		this.customerID = customerID;
		this.orderID = orderID;
		this.projectID = projectID;
		this.status = status;
		this.cost=cost+newShekelSign;
	}
	
	

	public Order() {
		this.orderID=idCounter++;
	}
	public int getCost() {
		return cost;
	}

	public void setCost(int i) {
		this.cost = i;
	}
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Order.idCounter = idCounter;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 //*********** IMPORTANT************
	 //we have to chane=ge the numbers for a real ones 
	
	public int CalculateCost() {
		 String p_ID= this.projectID,axleDegree;
		 Section s1 = null ;
		 ProjectItems i1 = null;
		 int price = 0;
		 for(Section s : CarpentryLogic.getInstance().getSections()) {
			 		if(s.getProjectID() == p_ID)
			 			s1= s;
		 }
		 switch (s1.getAxleDegree()) {		 
		 case  "Degree_45" :
			 price = price + s1.getQuantityOFaxle()*10;
			 break;
		 case  "Degree_155" :
			 price = price + s1.getQuantityOFaxle()*11;
			 break;
		 case  "Degree_180" :
			 price = price + s1.getQuantityOFaxle()*13;
			 break;
		 }
		 for(ProjectItems  i : CarpentryLogic.getInstance().getProjectItems()) {
			 if (i.getProjectID() == p_ID) {
				 i1= i;
			 }
		 }
			 switch (i1.getWoodType()) {
			 
			 case  "Sandwich" :
				 price = price + i1.getQuantity()*10;
				 break;
			 case  "Mdf" :
				 price = price + i1.getQuantity()*11;
				 break;
			 case  "Solid_Wood" :
				 price = price + i1.getQuantity()*12;
				 break;
			 case  "Melamine" :
				 price = price + i1.getQuantity()*14;
				 break;
			 case  "Particleboard" :
				 price = price + i1.getQuantity()*15;
				 break;
		 }
			 switch (i1.getModelNumberOfHands()) {

			 case  "s125" :
				 price = price + s1.getQuantityOFhands()*10;
				 break;
			 case  "f120" :
				 price = price + s1.getQuantityOFhands()*11;
				 break;
			 case  "r452" :
				 price = price + s1.getQuantityOFhands()*12;
				 break;
			 case  "gh32" :
				 price = price + s1.getQuantityOFhands()*14;
				 break;
			 case  "a17" :
				 price = price + s1.getQuantityOFhands()*15;
				 break;
		 }
		
		 
		return price;
	}
	
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterOrder.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterOrder.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
