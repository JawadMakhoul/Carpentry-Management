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
import javafx.scene.chart.PieChart;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StockController implements Initializable{

    @FXML
    private Button ProjectDetails,GenerateByAI,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    private PieChart piechart;
    
    @FXML
    private Button updateWoodQuantity,orderWood;

//    @FXML
//    private ProgressIndicator mdfPercent,melaminePercent,particlePercent,sandwichPercent,solidPercent;

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
    private Text sandwichPercent,solidPercent,mdfPercent,melaminePercent,particlePercent;

    private int countAll=0;
    @FXML
    void UpdateWoodQuantity(MouseEvent event) throws SQLException {
    	
    	switch(woodType.getSelectionModel().getSelectedItem().name()) {
    	
    	case "Sandwich":{
    		boolean flag=true;
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Sandwich")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Sandwich")&& om.getQuantity()==q) {
    						if(flag) {
    							CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    							CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    							showStock();
    		    				OutOfStock();
    							flag=false;
    						}
    					}
    				}
    				
    					
    			}
    		}
    		
    		break;
    	}
    	
    	case "Mdf":{
    		boolean flag=true;
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Mdf")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Mdf")&& om.getQuantity()==q) {
    						if(flag) {
    							CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    							CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    							showStock();
    		    				OutOfStock();
    							flag=false;
    						}
    					}
    				}
    				
    			}
    		}
    		
    		break;
    	}
    	
    	case "Solid_Wood":{
    		boolean flag=true;
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Solid_Wood")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Solid_Wood")&& om.getQuantity()==q) {
    						if(flag) {
    							CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    							CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    							showStock();
    							
    		    				OutOfStock();
    							flag=false;
    						}
    					}
    				}
    				
    			}
    		}
    		
    		break;
    	}

    	case "Melamine":{
    		boolean flag=true;
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Melamine")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Melamine")&& om.getQuantity()==q) {
    						if(flag) {
    							CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    							CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    							showStock();
    		    				OutOfStock();
    							flag=false;
    						}
    					}
    				}
    				
    			}
    		}
    		
    		break;
    	}

    	case "Particleboard":{
    		boolean flag=true;
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals("Particleboard")) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals("Particleboard")&& om.getQuantity()==q) {
    						if(flag) {
    							CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    							CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    							showStock();
    		    				OutOfStock();
    							flag=false;
    						}
    					}
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
	    		
	    		case "GenerateByAI":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/AI.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Generate By Images Ai");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "ProjectDetails":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectDetailsButton.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work");
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
    
    public void OutOfStock() {
    	
    	int sandwichCount=0, mdfCount=0,solidwoodCount=0,melamineCount=0,particleCount=0;
    	for(Stock s: CarpentryLogic.getInstance().getStocks()) {

			if(s.getWoodName().equals("Sandwich"))  {
				sandwichCount=s.getQuantity();
				sandwichPercent.setText(((s.getQuantity()*countAll)/100.0)+"%");
			}
				
			
			if(s.getWoodName().equals("Mdf")) {
				mdfCount=s.getQuantity();
				mdfPercent.setText((s.getQuantity()*countAll/100.0)+"%");
			}
				
				
			if(s.getWoodName().equals("Solid_Wood")) {
				solidwoodCount=s.getQuantity();
				solidPercent.setText((s.getQuantity()*countAll/100.0)+"%");
			}
				
			
			if(s.getWoodName().equals("Melamine")) {
				melamineCount=s.getQuantity();
				melaminePercent.setText((s.getQuantity()*countAll/100.0)+"%");
			}
				
			
			if(s.getWoodName().equals("Particleboard")) {
				particleCount=s.getQuantity();
				particlePercent.setText((s.getQuantity()*countAll/100.0)+"%");
			}
				
				
		}
    	
    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
    			new PieChart.Data("Mdf", mdfCount),
    			new PieChart.Data("Melamine", melamineCount),
    			new PieChart.Data("Particleboard", particleCount),
    			new PieChart.Data("Sandwich", sandwichCount),
    			new PieChart.Data("Solid_Wood", solidwoodCount));
    
    	piechart.setData(pieChartData);
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
		Buttons.add(GenerateByAI);
		Buttons.add(ProjectDetails);
		
		ObservableList<WoodType> woodTypelist = FXCollections.observableArrayList(WoodType.Mdf,WoodType.Melamine,WoodType.Particleboard,WoodType.Sandwich,WoodType.Solid_Wood);
		woodType.getItems().addAll(woodTypelist);
		
		
		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
			countAll=countAll+s.getQuantity();
		}
		OutOfStock();
		showStock();
        
	}
	
	


}
