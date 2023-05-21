package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enumeration.OrderStatus;
import Model.CurrentProjectsToShow;
import Model.Customer;
import Model.Order;
import Model.Project;
import Model.ProjectItems;
import Model.Section;
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
import javafx.scene.control.ComboBox;
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

public class CurrentProjectsController implements Initializable{

    @FXML
    private Button NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;
    
    @FXML
    private TableColumn<CurrentProjectsToShow, String> color;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> customerName;

    @FXML
    private Button deleteOrder;

    @FXML
    private ComboBox<String> filter;

    @FXML
    private TableColumn<CurrentProjectsToShow, Integer> itemHeight;

    @FXML
    private TableColumn<CurrentProjectsToShow, Integer> itemID;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> itemName;

    @FXML
    private TableColumn<CurrentProjectsToShow, Integer> itemWidth;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> modelNumberOfHands;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> projectCategory;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> projectID;

    @FXML
    private TableColumn<CurrentProjectsToShow, Integer> quantity;

    @FXML
    private Button removeFilter;

    @FXML
    private Button searchBuuton;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> section;

    @FXML
    private ComboBox<OrderStatus> statusList;

    @FXML
    private TableView<CurrentProjectsToShow> tableView;

    @FXML
    private Button updateStatus;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> woodType;
    
    @FXML
    private ScrollPane pnl;

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
	    		
	    		case "OrdersCatalog":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/OrdersCatalog.fxml"));
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
    	
    	if(filter.getSelectionModel().getSelectedItem().equals("Customer Name")) {
    		for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
    			if(searchField.getText().equals(c.getName())) {
    				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
    				ObservableList<CurrentProjectsToShow> custOrders = FXCollections.observableArrayList();
    				for(Project p : CarpentryLogic.getInstance().getProjects()) {
    					if(p.getCustomerID().equals(searchField.getText())) {
    						//custOrders.add(p);
	    				
    						for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    							if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
    								//custOrders.add(pi);
    								CurrentProjectsToShow cpts = new  CurrentProjectsToShow(c.getName(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
    								toShow.add(cpts);
    							}
    						}
    					}
    	    		}
    	    	
    				custOrders.addAll(toShow);
    				tableView.setItems(custOrders);
    			}	
    		}
    	}
    	
    	
    	 
    	if(filter.getSelectionModel().getSelectedItem().equals("Project ID")) {
    		for(Project p : CarpentryLogic.getInstance().getProjects()) {
    			if(searchField.getText().equals(Integer.toString(p.getProjectID()))) {
    				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
    				ObservableList<CurrentProjectsToShow> toShowOb = FXCollections.observableArrayList();
    				for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
    					if(pi.getProjectID().equals(searchField.getText())) {
    						//projOrders.add(o);
    						CurrentProjectsToShow cpts = new  CurrentProjectsToShow(p.getCustomerID(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
							toShow.add(cpts);
    				}
    				
    			}
    				toShowOb.addAll(toShow);
    				tableView.setItems(toShowOb);
    		}
    	}
    	}
    	
    	if(filter.getSelectionModel().getSelectedItem().equals("Project Category")) {
    		ObservableList<CurrentProjectsToShow> toShowOb = FXCollections.observableArrayList();
    		for(Project p : CarpentryLogic.getInstance().getProjects()) {
    			if(searchField.getText().equals(p.getProjectCategory())) {
    				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
    				
    				for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
    					if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
    						//projOrders.add(o);
    						CurrentProjectsToShow cpts = new  CurrentProjectsToShow(p.getCustomerID(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
							toShow.add(cpts);
    				}
    					
    			}
    				
    				toShowOb.addAll(toShow);
    		}
    	}tableView.setItems(toShowOb);
    	}
    	
    	if(filter.getSelectionModel().getSelectedItem().equals("Item Name")) {
    		ObservableList<CurrentProjectsToShow> toShowOb = FXCollections.observableArrayList();
    		for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
    			if(searchField.getText().equals(pi.getItemName())) {
    				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
    				
    				for(Project p : CarpentryLogic.getInstance().getProjects()) {
    					if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
    						//projOrders.add(o);
    						CurrentProjectsToShow cpts = new  CurrentProjectsToShow(p.getCustomerID(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
							toShow.add(cpts);
    				}
    					
    			}
    				
    				toShowOb.addAll(toShow);
    		}
    	}tableView.setItems(toShowOb);
    	}
    	
    }

    @FXML
    void RemoveFilter(ActionEvent event) {
    	ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
        ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
        for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
        	for(Project p : CarpentryLogic.getInstance().getProjects()) {
        		if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
        			CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
        			arraylistToShow.add(cp);
        		}
        	}
        
        }
        ObservableList_CP.addAll(arraylistToShow);
        
        tableView.setItems(ObservableList_CP);
        searchField.setText(null);
    	
    }
    
    @FXML
    void Delete_Project(ActionEvent event) {
    
    	
	    	for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    		if(tableView.getSelectionModel().getSelectedItem().getProjectID().equals(Integer.toString(p.getProjectID()))) {
	    			CarpentryLogic.getInstance().DeleteProject(p);
	    			
	    			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
	    				if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	    					CarpentryLogic.getInstance().DeleteProjectItems(pi);
	    				}
	    			}
	    			
	    			for(Section s : CarpentryLogic.getInstance().getSections()) {
	    				if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	    					CarpentryLogic.getInstance().DeleteSection(s);
	    				}
	    			}
	    			
	    		}
	    	}
	    	
	    	ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
	        ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
	        for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
	        	for(Project p : CarpentryLogic.getInstance().getProjects()) {
	        		if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	        			CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
	        			arraylistToShow.add(cp);
	        		}
	        	}
	        
	        }
	        ObservableList_CP.addAll(arraylistToShow);
	        
	        tableView.setItems(ObservableList_CP);
        }
    
    
    @FXML
    void Delete_Order(ActionEvent event) {
    	
    	for(Order o : CarpentryLogic.getInstance().getOrders()) {
//    		if(o.getOrderID()==tableView.getSelectionModel().getSelectedItem().getOrderID()) {
//    			CarpentryLogic.getInstance().DeleteOrder(o);
//    		}
    	}
    	 ObservableList<Order> orders = FXCollections.observableArrayList();
	        ArrayList<Order> arraylistOrders = CarpentryLogic.getInstance().getOrders();
	        orders.addAll(arraylistOrders);
	        
	       // tableView.setItems(orders);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(OrdersCatalog);
		Buttons.add(OrderedMaterials);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		
		ObservableList<String> Filter = FXCollections.observableArrayList("Customer Name","Project ID","Project Category","Item Name");
		filter.getItems().addAll(Filter);
		
		customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        projectID.setCellValueFactory(new PropertyValueFactory<>("projectID"));
        projectCategory.setCellValueFactory(new PropertyValueFactory<>("projectCategory"));
        itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
        itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
        woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        section.setCellValueFactory(new PropertyValueFactory<>("section"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        modelNumberOfHands.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
        
        ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
        ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
        for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
        	for(Project p : CarpentryLogic.getInstance().getProjects()) {
        		if(pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
        			CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),Integer.toString(p.getProjectID()),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands());
        			arraylistToShow.add(cp);
        		}
        	}
        
        }
        
        //arraylistOrder = CarpentryLogic.getInstance().getProjects();
        //ArrayList<?>  arraylistOrder = CarpentryLogic.getInstance().getProjectItems();
        ObservableList_CP.addAll(arraylistToShow);
//        orders.addAll(arraylistProject);
//        orders.addAll(arraylistProjectItems);
        
        tableView.setItems(ObservableList_CP);
	}


}
