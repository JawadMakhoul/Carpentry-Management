package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Controller.CarpentryLogic;
import Enumeration.AxleDegree;
import Enumeration.OrderStatus;
import javafx.scene.control.TableColumn;

public class Order {

	
	private static int idCounter;
	private String customerName;
	private int orderID;
	private String projectID;
	private String status;
	private char newShekelSign = '\u20AA';
	private int cost;
	
	public Order(int orderID,String customerName, String projectID, String status,int cost) {
		super();
		this.customerName = customerName;
		this.orderID = orderID;
		this.projectID = projectID;
		this.status = status;
		this.cost=cost;
		//+newShekelSign;
	}


	public Order() {
		this.orderID=idCounter++;
	}
	public Order(TableColumn<Order, String> customerName, TableColumn<Order, String> projectID2,
			TableColumn<Order, String> projectStatus, TableColumn<Order, Integer> cost2) {
		// TODO Auto-generated constructor stub
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
		 String p_ID= this.projectID;
		 boolean flag=true;
		 int price = 0;
		 
		 for(Section s : CarpentryLogic.getInstance().getSections()) {
			 		if(s.getProjectID().equals(p_ID)) {flag=true;
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
