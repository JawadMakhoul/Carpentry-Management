package Controller;



import Model.Stock ;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.ArrayList;


import Enumeration.AxleDegree;
import Enumeration.OrderStatus;
import Enumeration.ProjectCategory;
import Enumeration.ProjectSection;
import Enumeration.WoodType;
import Enumeration.handType;
//import Model.Customer;
import Model.Project;
import Model.Section;
import Model.ProjectItems;
import Model.Customer;
import Model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProjectItemsController implements Initializable{
	
	@FXML
    private Button sendEmail,ShowProjectDetails,BackButton,ColorsCatalog,CurrentProjects,FinancialManaging,Inbox,NewProject,OrderedMaterials,ProjectsCatalog,Stock,addItem,addSection,finish;
	private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private ColorPicker color;

    @FXML
    private TextField orderStatus,ItemName,handsQuantity,axleQuantity,height,quantity,width,CUSTOMERID,ORDERID,PROJECTID,orderCost;

    @FXML
    private ComboBox<ProjectSection> projectSection;
    
    @FXML
    private ComboBox<handType> handsModelNumber;

    @FXML
    private ComboBox<WoodType> woodType;
    
    @FXML
    private ComboBox<AxleDegree> brzolDegree;
    
    @FXML
    void MoveTo(MouseEvent event) throws IOException {
    	// send to the order constructor String status by convert the enum to string
    	for(Button b: Buttons) {
    		
    		if(b.isPressed()) {
    		
    			switch(b.getId()) {
    		
    			case "Inbox":{
    				Parent pane = FXMLLoader.load(getClass().getResource("/View/Inbox.fxml"));
    				Scene scene = new Scene(pane);
    				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    				stage.setScene(scene);
    				stage.setResizable(false);
    				stage.setTitle("Awni Wood Work - Inbox");
    				stage.show();
    				break;
    			}
    		
	    		case "NewProject":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/NewProject.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Add project");
	        		stage.show();
	        		break;
	    		}	
	    		case "Stock":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/Stock.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Stock");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "CurrentProjects":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/CurrentProjects.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Projects In Progress");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "ColorsCatalog":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ColorsCatalog.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Colors Catalog");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "OrderedMaterials":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/OrderedMaterials.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Ordered Materials");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "FinancialManaging":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/FinancialManaging.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Financial Managing");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "ProjectsCatalog":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectsCatalog.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Projects Catalog");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "BackButton":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work");
	        		stage.show();
	        		break;
	    		}	
	    		
	    		case "sendEmail":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/Send.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work");
	        		stage.show();
	        		break;
	    		}
    		}
    	}
    		
    	}
    	
    }

    
    
    
    @FXML
    void AddAnotherItem(MouseEvent event) {

    	ProjectItems pi = new ProjectItems();
    	pi.setItemName(ItemName.getText());
    	pi.setHeight(Integer.parseInt(height.getText()));
    	pi.setWidth(Integer.parseInt(width.getText()));
    	pi.setWoodType(woodType.getSelectionModel().getSelectedItem().toString());
    	pi.setQuantity(Integer.parseInt(quantity.getText()));
    	pi.setSection(projectSection.getSelectionModel().getSelectedItem().toString());
    	pi.setColor(color.getValue().toString());
    	pi.setModelNumberOfHands(handsModelNumber.getSelectionModel().getSelectedItem().toString());
    	Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Project p = (Project) stage.getUserData();
        Integer i = p.getProjectID();
    	String s = i.toString();
    	pi.setProjectID(s);
    	
    	CarpentryLogic.getInstance().addProjectItems(pi);
    	
    	ItemName.setText(null);
    	height.setText(null);
    	width.setText(null);
    	quantity.setText(null);
    	
    }

    @FXML
    void AddSection(MouseEvent event) throws NumberFormatException, SQLException {
    	Section s = new Section();
    	s.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());
    	Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Project p = (Project) stage.getUserData();
        Integer i = p.getProjectID();
    	String s3 = i.toString();
    	s.setProjectID(s3);
    	s.setQuantityOFhands(Integer.parseInt(handsQuantity.getText()));
    	s.setQuantityOFaxle(Integer.parseInt(axleQuantity.getText()));
    	s.setAxleDegree(brzolDegree.getSelectionModel().getSelectedItem().toString());
    	CarpentryLogic.getInstance().addSection(s);
    	
    	ProjectItems pi = new ProjectItems();
    	pi.setItemName(ItemName.getText());
    	pi.setHeight(Integer.parseInt(height.getText()));
    	pi.setWidth(Integer.parseInt(width.getText()));
    	pi.setWoodType(woodType.getSelectionModel().getSelectedItem().toString());
    	pi.setQuantity(Integer.parseInt(quantity.getText()));
    	ArrayList<Stock> stock = new ArrayList<Stock>();
    	stock= CarpentryLogic.getInstance().getStocks();
    	for(Stock s1 : stock) {
    		if (s1.getWoodName().equals(woodType.getSelectionModel().getSelectedItem().toString())) {
    			s1.setQuantity(s1.getQuantity()-Integer.parseInt(quantity.getText()));
    			CarpentryLogic.getInstance().updateStockQuantity(s1, s1.getQuantity());
    		}

    	}
    	pi.setSection(projectSection.getSelectionModel().getSelectedItem().toString());
    	pi.setColor(color.getValue().toString());
    	pi.setModelNumberOfHands(handsModelNumber.getSelectionModel().getSelectedItem().toString());
    	pi.setProjectID(s3);
    	
    	CarpentryLogic.getInstance().addProjectItems(pi);
    	
    	color.setValue(null);
    	handsQuantity.setText(null);
    	axleQuantity.setText(null);
    	ItemName.setText(null);
    	height.setText(null);
    	width.setText(null);
    	quantity.setText(null);
    }
    
    @FXML
    void ShowProjectDetails(MouseEvent event) {
    	Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Project p = (Project) stage.getUserData();
    	String customerName=null;
    	for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
			if(Integer.toString(c.getID()).equals(p.getCustomerID())){
				customerName = c.getName();
			}
		}
    	Order o = new Order();
    	o.setCustomerName(customerName);
    	String s1 = o.getCustomerName();
    	CUSTOMERID.setText(s1);
    	Integer p2id = p.getProjectID();
    	o.setProjectID(p2id.toString());
    	String s2 = o.getProjectID();
    	PROJECTID.setText(s2);
    	Integer oid = o.getOrderID();
    	String soid = oid.toString();
    	ORDERID.setText(soid);
    	o.setStatus(Enumeration.OrderStatus.WaitingProcess.toString()); 
    	orderStatus.setText(Enumeration.OrderStatus.WaitingProcess.toString());
    	Integer cost = o.CalculateCost();
    	String scost = cost.toString(); 
    	orderCost.setText(scost);
    	CarpentryLogic.getInstance().addOrder(o);
    	
    }
    
    @FXML
    void Finish(MouseEvent event) throws IOException {
    	// Add Section
//    	Section s = new Section();
//    	s.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());
//    	Node node = (Node) event.getSource();
//        Stage stage = (Stage) node.getScene().getWindow();
//        Project p = (Project) stage.getUserData();
//        Integer i = p.getProjectID();
//    	String s3 = i.toString();
//    	s.setProjectID(s3);
//    	s.setQuantityOFhands(Integer.parseInt(handsQuantity.getText()));
//    	s.setQuantityOFaxle(Integer.parseInt(axleQuantity.getText()));
//    	s.setAxleDegree(brzolDegree.getSelectionModel().getSelectedItem().toString());
//    	CarpentryLogic.getInstance().addSection(s);
//    	
//    	ProjectItems pi = new ProjectItems();
//    	pi.setItemName(ItemName.getText());
//    	pi.setHeight(Integer.parseInt(height.getText()));
//    	pi.setWidth(Integer.parseInt(width.getText()));
//    	pi.setWoodType(woodType.getSelectionModel().getSelectedItem().toString());
//    	pi.setQuantity(Integer.parseInt(quantity.getText()));
//    	ArrayList<Stock> stock1 = new ArrayList<Stock>();
//    	stock1= CarpentryLogic.getInstance().getStocks();
//    	for(Stock s1 : stock1) {
//    		if (s1.getWoodName() == woodType.getSelectionModel().getSelectedItem().toString()) {
//    			s1.setQuantity(s1.getQuantity()-Integer.parseInt(quantity.getText()));
//    		}
//
//    	}
//    	pi.setSection(projectSection.getSelectionModel().getSelectedItem().toString());
//    	pi.setColor(color.getValue().toString());
//    	pi.setModelNumberOfHands(handsModelNumber.getSelectionModel().getSelectedItem().toString());
//    	pi.setProjectID(s3);
//    	CarpentryLogic.getInstance().addProjectItems(pi);

//    	String customerID = p.getCustomerID();
//    	Order o = new Order();
//    	o.setCustomerID(customerID);
//    	Integer p2id = p.getProjectID();
//    	o.setProjectID(p2id.toString());
//    	o.setStatus(Enumeration.OrderStatus.WaitingProcess.toString()); 
//    	o.setCost(o.CalculateCost()); 
//    	CarpentryLogic.getInstance().addOrder(o);

    	Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage12 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage12.setScene(scene);
		stage12.setResizable(false);
		stage12.setTitle("Awni Wood Work");
		stage12.show();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(ProjectsCatalog);
		Buttons.add(FinancialManaging);
		Buttons.add(OrderedMaterials);
		Buttons.add(ColorsCatalog);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(ShowProjectDetails);
		Buttons.add(finish);
		Buttons.add(sendEmail);
		
		ObservableList<ProjectSection> projectSectionList = FXCollections.observableArrayList(ProjectSection.Kitchen,ProjectSection.Room,ProjectSection.LivingRoom,ProjectSection.Bathroom,ProjectSection.Closet,ProjectSection.Table,ProjectSection.Bed,ProjectSection.Other);
		projectSection.getItems().addAll(projectSectionList);
		
		ObservableList<WoodType> woodTypeList = FXCollections.observableArrayList(WoodType.Mdf,WoodType.Melamine,WoodType.Particleboard,WoodType.Sandwich,WoodType.Solid_Wood);
		woodType.getItems().addAll(woodTypeList);
		
		ObservableList<AxleDegree> axlesDegree = FXCollections.observableArrayList(AxleDegree.Degree_45,AxleDegree.Degree_155,AxleDegree.Degree_180);
		brzolDegree.getItems().addAll(axlesDegree);
		
		ObservableList<handType> HANDTYPE = FXCollections.observableArrayList(handType.a17,handType.f120,handType.gh32,handType.r452,handType.s125);
		handsModelNumber.getItems().addAll(HANDTYPE);
	}
	
}
