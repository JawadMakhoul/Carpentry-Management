package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.HashMap;
import java.util.Map;

import Model.Customer;
import Model.OrderedMaterials;
import Model.Stock;
import Model.WoodType;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class StockController implements Initializable{

    @FXML
    private Button Settings,GenerateByAI,NewProject,Stock,CurrentProjects,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    private PieChart piechart;
    
    @FXML
    private Button updateWoodQuantity,orderWood;

    @FXML
    private ComboBox<Model.WoodType> woodType;

    @FXML
    private TextField quantityOFWood;

    @FXML
    private TableView<Stock> tableview;

    @FXML
    private TableColumn<Stock, Integer> quantityColumn;
   
    @FXML
    private TableColumn<Stock, String> woodTypeColumn;
    
    @FXML
    private TableColumn<OrderedMaterials, String> orderStatus;

    @FXML
    private TableColumn<OrderedMaterials, String> productName;

    @FXML
    private TableColumn<OrderedMaterials, Integer> quantity;
    @FXML
    private TableView<OrderedMaterials> tableView;

    @FXML
    private Text sandwichPercent,solidPercent,mdfPercent,melaminePercent,particlePercent;

    private int countAll=0;
    
    public final String ACCOUNT_SID = "AC43db627bb9804649fe0427f34f843041";
    public final String AUTH_TOKEN = "34b98819ff46d22d86d1161cb6af3131";
    
    @FXML
    void UpdateWoodQuantity(MouseEvent event) throws SQLException {
    	if(woodType.getSelectionModel().getSelectedItem()!= null) {
    	
    		boolean flag=true;
    		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    			if(s.getWoodName().equals(woodType.getSelectionModel().getSelectedItem().toString())) {
    				int q = Integer.parseInt(quantityOFWood.getText());
    				
    				for(OrderedMaterials om: CarpentryLogic.getInstance().getOrderedMaterials()) {
    					if(om.getWoodName().equals(woodType.getSelectionModel().getSelectedItem().toString())&& om.getQuantity()==q) {
    						if(flag) {
    							CarpentryLogic.getInstance().DeleteOrderedMaterials(om);
    							CarpentryLogic.getInstance().updateStockQuantity(s, s.getQuantity()+q);
    							showStock();
    							showOrderedMATERIALS();
    							OutOfStock();
    							flag=false;
    						}
    					}
    					
    					
    				}
    				
    				if(flag) {
						JOptionPane.showMessageDialog(null, "Please create an order of wood before updating the stock!", "Alert",
								JOptionPane.WARNING_MESSAGE);
					}
    				
    					
    			}
    		}
    	
    	
    	}
    	}

    

    @FXML
    void order_Wood(MouseEvent event) {
    	if(woodType.getSelectionModel().getSelectedItem()!= null) {

    		
    			for(Model.Stock s: CarpentryLogic.getInstance().getStocks()) {
    			
    				if(s.getWoodName().equals(woodType.getSelectionModel().getSelectedItem().toString())) {
    				
    					int q = Integer.parseInt(quantityOFWood.getText());
    					OrderedMaterials om = new OrderedMaterials();
    					om.setStockID(s.getStockID());
    					om.setWoodName(s.getWoodName());
    					om.setQuantity(q);
    					CarpentryLogic.getInstance().addOrderedMaterials(om);
    				}
    			}
    			showOrderedMATERIALS();
    			
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
	    		
	    		case "Settings":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/Settings.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Settings");
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
    	
    	HashMap<String,Integer> StockMap = new HashMap<>();
    	for(Stock s: CarpentryLogic.getInstance().getStocks()) {
    		StockMap.put(s.getWoodName(), s.getQuantity());	
		}
    	
    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    	
    	for(HashMap.Entry<String, Integer> entry : StockMap.entrySet()) {
    		pieChartData.add(new PieChart.Data(entry.getKey(),entry.getValue()));
    	}
    	
    
    	piechart.setData(pieChartData);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(GenerateByAI);
		Buttons.add(Settings);
		
		
		ArrayList<WoodType> woodTypeNames = new ArrayList<>();
		for (WoodType c : CarpentryLogic.getInstance().getWoodType()) {
			woodTypeNames.add(c);
		}
		ObservableList<WoodType> woodtype = FXCollections.observableArrayList(woodTypeNames);
		woodType.getItems().addAll(woodtype);
		
		String name="";
		boolean flag=false,New_WoodType=false;
		for(WoodType wt : CarpentryLogic.getInstance().getWoodType()) {
			for(Stock s : CarpentryLogic.getInstance().getStocks()) {
				if(wt.getWoodTypeName().equals(s.getWoodName())) {
					flag=true;
				}
			}
			
			if(!flag) {
				name = wt.getWoodTypeName();
				New_WoodType=true;
			}
			
			if(New_WoodType) {
				Stock newS = new Stock();
				newS.setWoodName(name);
				newS.setQuantity(0);
				CarpentryLogic.getInstance().addStock(newS);
				
			}
			flag=false;
		}
		
		
		
		for(Stock s: CarpentryLogic.getInstance().getStocks()) {
			countAll=countAll+s.getQuantity();
		}
		showOrderedMATERIALS();
		showStock();
		OutOfStock();
	}
    
	


}
