package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.ResourceBundle;

import Model.Customer;
import Model.Email;
import Model.Order;
import Model.Project;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProjectsCatalogController implements Initializable{

    @FXML
    private Button searchBuuton,sendEmail,NewProject,Stock,CurrentProjects,ColorsCatalog,OrderedMaterials,FinancialManaging,ProjectsCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    private Label totalDelivered,totalInProgress,totalProjects,totalWaiting,totalCanceled,totalFinished;

    @FXML
    private Pane pnlOverview;
    
    @FXML
    private TableColumn<Order, Integer> cost;

    @FXML
    private TableColumn<Order, String> customerName;

    @FXML
    private TableColumn<Order, String> projectID;

    @FXML
    private TableColumn<Order, String> projectStatus;
    
    @FXML
    private TableView<Order> tableView;
    
    @FXML
    private TextField searchField;

    @FXML
    void MoveTo(MouseEvent event) throws IOException {
    	
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
    void Search(ActionEvent event) {
    	
    	tableView.setItems(null);
    	
    	for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
    		if(searchField.getText().equals(c.getName())) {
    	    	ObservableList<Order> custOrders = FXCollections.observableArrayList();
    	    	for(Order o: CarpentryLogic.getInstance().getOrders()) {
    	    		if(o.getCustomerName().equals(searchField.getText())) {System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvv");
    	    				custOrders.add(o);
    	    			}
    	    		}
    	    	tableView.setItems(custOrders);
    		}	
    	}
    	
    	for(Project p : CarpentryLogic.getInstance().getProjects()) {
    		if(searchField.getText().equals(Integer.toString(p.getProjectID()))) {System.out.println("testtttttttttttttttttttttt");
    			ObservableList<Order> projOrders = FXCollections.observableArrayList();
    			for(Order o : CarpentryLogic.getInstance().getOrders()) {
    				if(o.getProjectID().equals(searchField.getText())) {
    					projOrders.add(o);
    				}
    			}
    	    	tableView.setItems(projOrders);
    		}
    	}
    	
    	ObservableList<Order> statOrders = FXCollections.observableArrayList();
    	for(Order o : CarpentryLogic.getInstance().getOrders()) {
    		if(searchField.getText().equals(o.getStatus())) {
    			
    			statOrders.add(o);
    		}
    		tableView.setItems(statOrders);
    	}
    	
    	ObservableList<Order> costOrders = FXCollections.observableArrayList();
    	for(Order o : CarpentryLogic.getInstance().getOrders()) {
    		if(Integer.parseInt(searchField.getText())== o.getCost()) {
    			
    			costOrders.add(o);
    		}
    		tableView.setItems(costOrders);
    	}
    	
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
		Buttons.add(sendEmail);
		
		int countProjects=0;
		for(Project p: CarpentryLogic.getInstance().getProjects()) 
			countProjects++;
		totalProjects.setText(Integer.toString(countProjects));
		
		int countDelivered=0;
		for(Order o: CarpentryLogic.getInstance().getOrders()) {
			if(o.getStatus().equals("Delivered")) {
				for(Project p : CarpentryLogic.getInstance().getProjects()) {
					if(Integer.toString(p.getProjectID())==o.getProjectID()) {
						countDelivered++;
						
					}
				}
			}
				
		}
		totalDelivered.setText(Integer.toString(countDelivered));
		
		int countInProgress=0;
		for(Order o: CarpentryLogic.getInstance().getOrders()) {
			if(o.getStatus().equals("InProgress")) {
				for(Project p : CarpentryLogic.getInstance().getProjects()) {
					if(Integer.toString(p.getProjectID())==o.getProjectID()) {
						countInProgress++;
						
					}
				}
			}
				
		}
		totalInProgress.setText(Integer.toString(countInProgress));
		
		int countWaiting=0;
		for(Order o: CarpentryLogic.getInstance().getOrders()) {
			if(o.getStatus().equals("WaitingProcess")) {
				countWaiting++;
			}
				
		}
		totalWaiting.setText(Integer.toString(countWaiting));
		
		int countFinished=0;
		for(Order o: CarpentryLogic.getInstance().getOrders()) {
			if(o.getStatus().equals("Finished")) {
				countFinished++;
			}
				
		}
		totalFinished.setText(Integer.toString(countFinished));
		
		int countCanceled=0;
		for(Order o: CarpentryLogic.getInstance().getOrders()) {
			if(o.getStatus().equals("Canceled")) {
				countCanceled++;
			}
				
		}
		totalCanceled.setText(Integer.toString(countCanceled));
		
		customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
	        projectID.setCellValueFactory(new PropertyValueFactory<>("projectID"));
	        projectStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
	        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

	        // Get the data and add it to the table
	        ObservableList<Order> orders = FXCollections.observableArrayList();
	        ArrayList<Order> arraylistOrders = CarpentryLogic.getInstance().getOrders();
	        orders.addAll(arraylistOrders);
	        
	        tableView.setItems(orders);
	}


}
