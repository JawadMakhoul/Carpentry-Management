package Controller;

import java.io.IOException;
import javafx.scene.image.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enumeration.OrderStatus;
import Model.CurrentProjectsToShow;
import Model.Customer;
import Model.GlobalProjectID;
import Model.Order;
import Model.Project;
import Model.ProjectDetailsToShow;
import Model.ProjectItems;
import Model.Section;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ProjectDetailsToShowController implements Initializable{

    @FXML
    private Button ProjectDetails,GenerateByAI,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;
    
    @FXML
    private TableColumn<ProjectDetailsToShow, String> color;

    @FXML
    private TableColumn<ProjectDetailsToShow, String> itemHeight;

    @FXML
    private TableColumn<ProjectDetailsToShow, String> itemID;

    @FXML
    private TableColumn<ProjectDetailsToShow, String> itemName;

    @FXML
    private TableColumn<ProjectDetailsToShow, String> itemWidth;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<ProjectDetailsToShow, String> quantity;


    @FXML
    private TableView<ProjectDetailsToShow> tableView;

    @FXML
    private TableColumn<ProjectDetailsToShow, String> woodType;
    
    @FXML
    private TableColumn<ProjectDetailsToShow, String> sectionField;
    
    @FXML
    private ScrollPane pnl;
    
    @FXML
    private TextField projectCategoryField,projectIDField,customerNameField,handsField;
    
    @FXML
    private ImageView projectImage;

    private ProjectDetailsToShow pdts1;
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
	
        ProjectDetailsToShow pdts = ProjectItemsController.getPdts();
        ObservableList<ProjectDetailsToShow> ObservableList_CP = FXCollections.observableArrayList();
        ArrayList<ProjectDetailsToShow> arraylistToShow = new ArrayList<>();
        for(Project p : CarpentryLogic.getInstance().getProjects()) {
        			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
        			if((pi.getProjectID().equals(Integer.toString(p.getProjectID())))&& (pdts.getProjectID().equals(pi.getProjectID()))) {
        				System.out.println(pi.getProjectID());
        				
        					
        					
        					//sectionField.setText(pdts.getSection());
        					projectCategoryField.setText(p.getProjectCategory());
        					projectIDField.setText(pi.getProjectID());
        					customerNameField.setText(p.getCustomerID());
        					handsField.setText(pi.getModelNumberOfHands());
        					sectionField.setCellValueFactory(cellData -> new ReadOnlyStringWrapper (pi.getSection()));
        					itemID.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(pi.getItemID())));
        					itemName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(pi.getItemName()));
        					itemHeight.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(pi.getHeight())));
        					itemWidth.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(pi.getWidth())));
        					woodType.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(pi.getWoodType()));
        					quantity.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(pi.getQuantity())));
        					color.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(pi.getColor()));
        					
        					ProjectDetailsToShow pdtsToArray = null;
        					pdtsToArray.setColor(pi.getColor());
        					pdtsToArray.setCustomerName(p.getCustomerID());
        					pdtsToArray.setItemHeight(Integer.toString(pi.getHeight()));
        					pdtsToArray.setItemID(Integer.toString(pi.getItemID()));
        					pdtsToArray.setItemName(pi.getItemName());
        					pdtsToArray.setItemWidth(Integer.toString(pi.getWidth()));
        					pdtsToArray.setModelNumberOFhands(pi.getModelNumberOfHands());
        					pdtsToArray.setProjectCategory(p.getProjectCategory());
        					pdtsToArray.setProjectID(pi.getProjectID());
        					pdtsToArray.setQuantity(Integer.toString(pi.getQuantity()));
        					pdtsToArray.setSection(pi.getSection());
        					pdtsToArray.setWoodType(pi.getWoodType());
        					arraylistToShow.add(pdtsToArray);
                		}
        			}
        			
        }
        ObservableList_CP.addAll(arraylistToShow);
        
        tableView.setItems(ObservableList_CP);
        
        Image i = new Image(pdts.getImage());
        projectImage.setImage(i);
	}


}
