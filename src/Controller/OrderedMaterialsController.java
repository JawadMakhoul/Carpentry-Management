package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import Enumeration.WoodType;
import Model.Order;
import Model.OrderedMaterials;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrderedMaterialsController implements Initializable{

    @FXML
    private Button orderWood,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;
    
    @FXML
    private ComboBox<WoodType> woodType;
    
    @FXML
    private TableColumn<OrderedMaterials, String> orderStatus;

    @FXML
    private TableColumn<OrderedMaterials, String> productName;

    @FXML
    private TableColumn<OrderedMaterials, Integer> quantity;
    @FXML
    private TableView<OrderedMaterials> tableView;
    
    @FXML
    private TextField quantityOFWood;

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
	    		
	    		
    		}
    	}
    		
    	}
    	
    }

    @FXML
    void order_Wood(MouseEvent event) {

    	switch(woodType.getSelectionModel().getSelectedItem().name()) {
    	
    		case "Sandwich":{
    		
    			for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    				if(s.getWoodName().equals("Sandwich")) {
    				
    					int q = Integer.parseInt(quantityOFWood.getText());
    					OrderedMaterials om = new OrderedMaterials();
    					om.setStockID(s.getStockID());
    					om.setWoodName("Sandwich");
    					om.setQuantity(q);
    					CarpentryLogic.getInstance().addOrderedMaterials(om);
    				}
    			}
    			showOrderedMATERIALS();
    			break;
    		}
    	
    		case "Mdf":{
    		
    			for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    				if(s.getWoodName().equals("Mdf")) {
    				
    					int q = Integer.parseInt(quantityOFWood.getText());
    					OrderedMaterials om = new OrderedMaterials();
    					om.setStockID(s.getStockID());
    					om.setWoodName("Mdf");
    					om.setQuantity(q);
    					CarpentryLogic.getInstance().addOrderedMaterials(om);
    				}
    			}
    			showOrderedMATERIALS();
    			break;
    		}
    	
    		case "Solid_Wood":{
    		
    			for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    				if(s.getWoodName().equals("Solid_Wood")) {
    				
    					int q = Integer.parseInt(quantityOFWood.getText());
    					OrderedMaterials om = new OrderedMaterials();
    					om.setStockID(s.getStockID());
    					om.setWoodName("Solid_Wood");
    					om.setQuantity(q);
    					CarpentryLogic.getInstance().addOrderedMaterials(om);
    				}
    			}
    			showOrderedMATERIALS();
    			break;
    		}

    		case "Melamine":{
	
    			for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
		
    				if(s.getWoodName().equals("Melamine")) {
			
    					int q = Integer.parseInt(quantityOFWood.getText());
    					OrderedMaterials om = new OrderedMaterials();
    					om.setStockID(s.getStockID());
    					om.setWoodName("Melamine");
    					om.setQuantity(q);
    					CarpentryLogic.getInstance().addOrderedMaterials(om);
    				}
    			}
    			showOrderedMATERIALS();
    			break;
    		}

    		case "Particleboard":{
	
    			for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
		
    				if(s.getWoodName().equals("Particleboard")) {
			
    					int q = Integer.parseInt(quantityOFWood.getText());
    					OrderedMaterials om = new OrderedMaterials();
    					om.setStockID(s.getStockID());
    					om.setWoodName("Particleboard");
    					om.setQuantity(q);
    					CarpentryLogic.getInstance().addOrderedMaterials(om);
    				}
    			}
    			showOrderedMATERIALS();
    			break;
    		}
  
    	}
    	
    }
    
    public void showOrderedMATERIALS() {
    	productName.setCellValueFactory(new PropertyValueFactory<>("woodName"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		orderStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
     

        // Get the data and add it to the table
        ObservableList<OrderedMaterials> orderedmaterials = FXCollections.observableArrayList();
        ArrayList<OrderedMaterials> arraylistOrders = CarpentryLogic.getInstance().getOrderedMaterials();
        orderedmaterials.addAll(arraylistOrders);
        
        tableView.setItems(orderedmaterials);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		// TODO Auto-generated method stub
		Buttons.add(OrdersCatalog);
		Buttons.add(OrderedMaterials);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		
		
		ObservableList<WoodType> woodTypelist = FXCollections.observableArrayList(WoodType.Mdf,WoodType.Melamine,WoodType.Particleboard,WoodType.Sandwich,WoodType.Solid_Wood);
		woodType.getItems().addAll(woodTypelist);
		
		showOrderedMATERIALS();
	}


}
