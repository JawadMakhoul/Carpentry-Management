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
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String status;
	private int cost;
	private int price;
	private Date date;
	private String notes;
	private String phoneNumber;

	public Project(int projectID,String customerID, String projectCategory,String image1,String image2,String image3,String image4,String email, String status, int cost, int price, String notes,Date date,String phoneNumber) {
		super();
		this.projectID = projectID;
		this.customerID = customerID;
		this.projectCategory = projectCategory;
		this.email=email;
		this.image1="";
		this.image2="";
		this.image3="";
		this.image4="";
		this.status=status;
		this.cost=cost;
		this.notes=notes;
		this.price=price;
		this.date = date;	
		this.phoneNumber=phoneNumber;
		}
	
	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public Project(String customerID,int projectID, String projectCategory ,String email, String status, int price) {
		super();
		this.projectID = projectID;
		this.customerID = customerID;
		this.projectCategory = projectCategory;
		this.email=email;
		this.status=status;
		this.price=price;
		}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate() {
		this.date = Date.valueOf(LocalDate.now());
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

		String axles= "", handsmodel= "",woodType= "";

		int axlesQuantity=0,handsQuantity=0,woodQuantity=0,cost = 0;

		int axlesCost=0, handsCost=0, woodCost=0;

		int axlesPrice=0, handsprice=0, woodprice=0;

		

		for(Section s :CarpentryLogic.getInstance().getSections()) {

			if(s.getProjectID().equals(Integer.toString( this.projectID))){

				axles=s.getAxleDegree();

				axlesQuantity=s.getQuantityOFaxle();

				handsQuantity = s.getQuantityOFhands();

			

				for(Axles a: CarpentryLogic.getInstance().getAxles()) {

					if(a.getAxleName().equals(axles)) {

						axlesPrice = a.getAxleCost();

					}

				}

				for(ProjectItems i : CarpentryLogic.getInstance().getProjectItems() ) {

					if(i.getProjectID().equals(Integer.toString( this.projectID)) && Integer.toString(s.getSectionID()).equals(i.getSectionID())) {

						handsmodel = i.getHandsmodel();

						woodType = i.getWoodType();

						woodQuantity += i.getQuantity();

						for(Hands h : CarpentryLogic.getInstance().getHands() ) {

							if(h.getHandsName().equals(handsmodel)) {

								handsprice = h.getHandsCost();

								handsCost = handsprice * handsQuantity; 

							}

							

						}

						for(WoodType h :CarpentryLogic.getInstance().getWoodType() ) {

							if(h.getWoodTypeName().equals(woodType)) {

								woodprice = h.getWoodTypeCost();

							}

						}

						

						

					}

				}

				axlesCost = axlesPrice * axlesQuantity;

				woodCost = woodprice * woodQuantity ; 

				cost = cost + axlesCost + handsCost + woodCost;

			}

		}

		return cost;

		

	}
	
	public int CalculateSuggestedPrice() {

		String Wood= "" ;

		int quantity=0;

		boolean flag = false;

		int suggested;

		int hight=0, width=0;

		for(ProjectItems i : CarpentryLogic.getInstance().getProjectItems() ) {

			if(i.getProjectID().equals(Integer.toString( this.projectID))) {

				Wood = i.getWoodType();

				quantity = i.getQuantity();

				hight = i.getHeight();

				width = i.getWidth();

			}

		}

		for(WoodType h :CarpentryLogic.getInstance().getWoodType() ) {

			if(h.getWoodTypeName().equals(Wood)) {

			if(h.getNeedToBePainted() == 1) {

				flag = true;

			}

		}

		}

		suggested = CalculateCost();

		if (flag == true) {

			suggested += ((hight*width)/100) * 200;

		}

		suggested += (quantity/4)*750;

		

	return suggested;

	}


	

}
