package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import Enumeration.AxleDegree;
import Enumeration.OrderStatus;
import Enumeration.ProjectCategory;
import Enumeration.ProjectSection;
import Enumeration.WoodType;
//import Model.Customer;
import Model.Project;
import Model.Section;
import Model.ProjectItems;
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
    private Button ShowProjectDetails,BackButton,ColorsCatalog,CurrentProjects,FinancialManaging,Inbox,MaterialsToOrder,NewProject,OrderedMaterials,ProjectsCatalog,Stock,addItem,addSection,finish;
	private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private ColorPicker color;

    @FXML
    private TextField orderStatus,ItemName,handsModelNumber,handsQuantity,axleQuantity,height,quantity,width,CUSTOMERID,ORDERID,PROJECTID,orderCost;

    @FXML
    private ComboBox<ProjectSection> projectSection;

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
	    		
	    		case "MaterialsToOrder":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/MaterialsToOrder.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Order Materials");
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
	    		
	    		case "finish":{
	    			Section s = new Section();
	    	    	s.setSectionName(projectSection.getSelectionModel().toString());
	    	    	Node node = (Node) event.getSource();
	    	        Stage stage = (Stage) node.getScene().getWindow();
	    	        Project p = (Project) stage.getUserData();
	    	        Integer i = p.getProjectID();
	    	    	String s4 = i.toString();
	    	       
	    	    	s.setProjectID(s4);
	    	    	s.setQuantityOFhands(Integer.parseInt(handsQuantity.getText()));
	    	    	s.setQuantityOFaxle(Integer.parseInt(axleQuantity.getText()));
	    	    	//s.setProjectSection(projectSection.getSelectionModel().toString());
	    	    	
	    	    	ProjectItems pi = new ProjectItems();
	    	    	pi.setItemName(ItemName.getText());
	    	    	pi.setHeight(Integer.parseInt(height.getText()));
	    	    	pi.setWidth(Integer.parseInt(width.getText()));
	    	    	pi.setWoodType(woodType.getSelectionModel().toString());
	    	    	pi.setQuantity(Integer.parseInt(quantity.getText()));
	    	    	pi.setProjectID(s4);
	    	    	pi.setSection(projectSection.getSelectionModel().toString());
	    	    	pi.setColor(color.getValue().toString());
	    	    	pi.setModelNumberOfHands(handsModelNumber.getText());
	    	    	
	    	    	CarpentryLogic.getInstance().addProjectItems(pi);
	    	    	
	    	    	CarpentryLogic.getInstance().addSection(s);
	    	    	
//	    	    	Order o = new Order();
//	    	    	Node node2 = (Node) event.getSource();
//	    	        Stage stage2 = (Stage) node2.getScene().getWindow();
//	    	        Project p2 = (Project) stage2.getUserData();
//	    	        String customerID = p2.getCustomerID();
//	    	    	o.setCustomerID(customerID); CUSTOMERID.setText(o.getCustomerID());
//	    	    	o.setProjectID(projectid); PROJECTID.setText(o.getProjectID());
//	    	    	o.setStatus(Enumeration.OrderStatus.WaitingProcess.toString()); orderStatus.setText(Enumeration.OrderStatus.WaitingProcess.toString());
//	    	    	o.setCost(o.CalculateCost()); orderCost.setText(o.getCost());// write function in order class to calculate the cost of the order////////////////////////////////////////////////////////////////////////////////////////////////////////
//	    			
	    	    	
	    	    	Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage1.setScene(scene);
	        		stage1.setResizable(false);
	        		stage1.setTitle("Awni Wood Work");
	        		stage1.show();
	        		break;
	        		
	    		}	
	    	
	    		case "ShowProjectDetails":{
	    			
	    	    	Order o = new Order();
	    	    	Node node2 = (Node) event.getSource();
	    	        Stage stage2 = (Stage) node2.getScene().getWindow();
	    	        Project p2 = (Project) stage2.getUserData();
	    	        String customerID = p2.getCustomerID();
	    	    	o.setCustomerID(customerID); 
	    	    	//Integer i1 = o.getCustomerID();
	    	    	String s1 = o.getCustomerID();
	    	    	CUSTOMERID.setText(s1);
	    	    	Integer p2id = p2.getProjectID();
	    	    	o.setProjectID(p2id.toString()); 
	    	    	//Integer i2 = o.getProjectID();
	    	    	String s2 = o.getProjectID();
	    	    	PROJECTID.setText(s2);
	    	    	o.setStatus(Enumeration.OrderStatus.WaitingProcess.toString()); orderStatus.setText(Enumeration.OrderStatus.WaitingProcess.toString());
	    	    	o.setCost(o.CalculateCost()); orderCost.setText(o.getCost());// write function in order class to calculate the cost of the order////////////////////////////////////////////////////////////////////////////////////////////////////////
	    			
	    	    	CarpentryLogic.getInstance().addOrder(o);
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
    	pi.setWoodType(woodType.getSelectionModel().toString());
    	pi.setQuantity(Integer.parseInt(quantity.getText()));
    	Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Project p = (Project) stage.getUserData();
        
        Integer i = p.getProjectID();
    	String s = i.toString();
        
    	pi.setProjectID(s);
    	pi.setSection(projectSection.getSelectionModel().toString());
    	pi.setColor(color.getValue().toString());
    	pi.setModelNumberOfHands(handsModelNumber.getText());
    	
    	CarpentryLogic.getInstance().addProjectItems(pi);
    	
    	ItemName.setText(null);
    	height.setText(null);
    	width.setText(null);
    	woodType.setSelectionModel(null);
    	quantity.setText(null);
    	color.setValue(null);
    	handsModelNumber.setText(null);
    	
    }

    @FXML
    void AddSection(MouseEvent event) {
    	Section s = new Section();
    	s.setSectionName(projectSection.getSelectionModel().toString());
    	Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Project p = (Project) stage.getUserData();
        Integer i = p.getProjectID();
    	String s3 = i.toString();
        
    	s.setProjectID(s3);
    	s.setQuantityOFhands(Integer.parseInt(handsQuantity.getText()));
    	s.setQuantityOFaxle(Integer.parseInt(axleQuantity.getText()));
    	//s.setProjectSection(projectSection.getSelectionModel().toString());
    	
    	CarpentryLogic.getInstance().addSection(s);
    	
    	projectSection.setSelectionModel(null);
    	handsQuantity.setText(null);
    	axleQuantity.setText(null);
    	//projectSection.setSelectionModel(null);
    	
    	ItemName.setText(null);
    	height.setText(null);
    	width.setText(null);
    	woodType.setSelectionModel(null);
    	quantity.setText(null);
    	color.setValue(null);
    	handsModelNumber.setText(null);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(ProjectsCatalog);
		Buttons.add(FinancialManaging);
		Buttons.add(OrderedMaterials);
		Buttons.add(ColorsCatalog);
		Buttons.add(MaterialsToOrder);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(ShowProjectDetails);
//		Buttons.add(addItem);
//		Buttons.add(addSection);
		Buttons.add(finish);
		
		ObservableList<ProjectSection> projectSectionList = FXCollections.observableArrayList(ProjectSection.Kitchen,ProjectSection.Room,ProjectSection.LivingRoom,ProjectSection.Bathroom,ProjectSection.Closet,ProjectSection.Table,ProjectSection.Bed,ProjectSection.Other);
		projectSection.getItems().addAll(projectSectionList);
		
		ObservableList<WoodType> woodTypeList = FXCollections.observableArrayList(WoodType.Mdf,WoodType.Melamine,WoodType.Particleboard,WoodType.Sandwich,WoodType.Solid_Wood);
		woodType.getItems().addAll(woodTypeList);
		
		ObservableList<AxleDegree> axlesDegree = FXCollections.observableArrayList(AxleDegree.Degree_45,AxleDegree.Degree_155,AxleDegree.Degree_180);
		brzolDegree.getItems().addAll(axlesDegree);
	}
	
}
