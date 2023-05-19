package Controller;

import java.io.IOException;
import Model.OrderedMaterials;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;

import Enumeration.ProjectCategory;
import Enumeration.WoodType;
import Model.Consts;
import Model.Stock;
import Controller.CarpentryLogic;
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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StockController implements Initializable{

    @FXML
    private Button sendEmail,NewProject,Stock,CurrentProjects,ColorsCatalog,OrderedMaterials,FinancialManaging,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    private Button updateWoodQuantity,orderWood;

    @FXML
    private ProgressIndicator mdfPercent,melaminePercent,particlePercent,sandwichPercent,solidPercent;

    @FXML
    private ComboBox<WoodType> woodType;

    @FXML
    private TextField quantityOFWood;

    @FXML
    private TableView<Stock> tableview;

    @FXML
    private TableColumn<Stock, Integer> quantityColumn;
   
    @FXML
    private TableColumn<Stock, String> woodTypeColumn;
    @FXML
    private ImageView mdfImage,melamineImage,particleImage,sandwichImage,solidImage;

    @FXML
    void UpdateWoodQuantity(MouseEvent event) throws SQLException {
    	
    	switch(woodType.getSelectionModel().getSelectedItem().name()) {
    	
    	case "Sandwich":{
    		
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Sandwich")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    				showStock();
    				sandwichPercent.setProgress((s.getQuantity()+q)/100.0);
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Sandwich"))
    						CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    				}
    				
    			}
    		}
    		
    		break;
    	}
    	
    	case "Mdf":{
    		
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Mdf")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    				showStock();
    				mdfPercent.setProgress((s.getQuantity()+q)/100.0);
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Mdf"))
    						CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    				}
    				
    			}
    		}
    		
    		break;
    	}
    	
    	case "Solid_Wood":{
    		
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Solid_Wood")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    				showStock();
    				solidPercent.setProgress((s.getQuantity()+q)/100.0);
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Solid_Wood"))
    						CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    				}
    				
    			}
    		}
    		
    		break;
    	}

    	case "Melamine":{
	
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Melamine")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    				showStock();
    				melaminePercent.setProgress((s.getQuantity()+q)/100.0);
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Melamine"))
    						CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    				}
    				
    			}
    		}
    		
    		break;
    	}

    	case "Particleboard":{
	
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Particleboard")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    				showStock();
    				particlePercent.setProgress((s.getQuantity()+q)/100.0);
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Particleboard"))
    						CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    				}
    				
    			}
    		}
    		
    		break;

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
	
    			break;
    		}
  
    	}
    	
    }
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

    public void showStock() {
    	
    	ObservableList<Stock> stocks = FXCollections.observableArrayList();
		tableview.setItems(stocks);

		// Set up cell value factories for each column
		woodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("woodName"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		// Loop over the stocks and add them to the table
		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
		    stocks.add(s);
		}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(OrdersCatalog);
		Buttons.add(FinancialManaging);
		Buttons.add(OrderedMaterials);
		Buttons.add(ColorsCatalog);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(sendEmail);
		
		ObservableList<WoodType> woodTypelist = FXCollections.observableArrayList(WoodType.Mdf,WoodType.Melamine,WoodType.Particleboard,WoodType.Sandwich,WoodType.Solid_Wood);
		woodType.getItems().addAll(woodTypelist);
		
		for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
			
			if(s.getWoodName().equals("Sandwich"))  {
				if((s.getQuantity()/100.0)<0) {
					Image image = new Image(getClass().getResourceAsStream("/Lib/out-of-stockk.png"));
					sandwichImage.setImage(image);
				}
				sandwichPercent.setProgress(s.getQuantity()/100.0);
			}
				
			
			if(s.getWoodName().equals("Mdf")) {
				if((s.getQuantity()/100.0)<0) {
					Image image = new Image(getClass().getResourceAsStream("/Lib/out-of-stockk.png"));
					mdfImage.setImage(image);
				}
				mdfPercent.setProgress(s.getQuantity()/100.0);
			}
				
				
			if(s.getWoodName().equals("Solid_Wood")) {
				if((s.getQuantity()/100.0)<0) {
					Image image = new Image(getClass().getResourceAsStream("/Lib/out-of-stockk.png"));
					solidImage.setImage(image);
				}
				solidPercent.setProgress(s.getQuantity()/100.0);
			}
				
			
			if(s.getWoodName().equals("Melamine")) {
				if((s.getQuantity()/100.0)<0) {
					Image image = new Image(getClass().getResourceAsStream("/Lib/out-of-stockk.png"));
					melamineImage.setImage(image);
				}
				melaminePercent.setProgress(s.getQuantity()/100.0);
			}
				
			
			if(s.getWoodName().equals("Particleboard")) {
				if((s.getQuantity()/100.0)<0) {
					Image image = new Image(getClass().getResourceAsStream("/Lib/out-of-stockk.png"));
					particleImage.setImage(image);
				}
				particlePercent.setProgress(s.getQuantity()/100.0);
			}
				
				
		}
		showStock();
        
	}
	
	


}
