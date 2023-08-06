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
import Model.ProjectDetailsToShowNonStatic;
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
import javafx.scene.control.CheckBox;
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
    private ComboBox<?> ComboBoxObject;


    @FXML
    private ComboBox<?> adddeleteitem;

    @FXML
    private TextField axleQuantity;

    @FXML
    private ComboBox<?> brzolDegree;


    @FXML
    private ComboBox<?> colorField;


    @FXML
    private ComboBox<?> handsModelNumber;

    @FXML
    private TextField handsQuantity;


    @FXML
    private TextField itemHeightField;


    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemQuantity;

    

    @FXML
    private TextField itemWidthField;

    @FXML
    private CheckBox newSection;

   

    @FXML
    private ComboBox<?> projectSection;


    @FXML
    private Button submit;

    @FXML
    private ComboBox<?> woodTypeField;
    @FXML
    private Button EditCustomer,UpdateProjectDetails,ProjectDetails,GenerateByAI,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;
    
    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> color;

    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> itemHeight;

    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> itemID;

    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> itemName;

    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> itemWidth;

    @FXML
    private Pane pnlOverview;

    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> quantity;


    @FXML
    private TableView<ProjectDetailsToShowNonStatic> tableView;

    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> woodType;
    
    @FXML
    private TableColumn<ProjectDetailsToShowNonStatic, String> sectionField;
    
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
	    		
	    		case "EditCustomer":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/EditCustomer.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "UpdateProjectDetails":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/UpdateProjectDetails.fxml"));
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
    void CheckIfDelete(ActionEvent event) {

    }


    @FXML
    void SubmitProjectDetails(ActionEvent event) {

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
		Buttons.add(EditCustomer);
		Buttons.add(UpdateProjectDetails);
		
		ProjectDetailsToShow pdts = ProjectItemsController.getPdts();
       
        ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
        ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
        
        for(Project p : CarpentryLogic.getInstance().getProjects()) {
        	
        	if(pdts.getProjectID().equals(Integer.toString(p.getProjectID()))) {
        		
        	
        		for(Section s : CarpentryLogic.getInstance().getSections()) {
        	
        		if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
        			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
        			if(pi.getProjectID().equals(Integer.toString(p.getProjectID())) && (s.getSectionName().equals(pi.getSection()))) {
        				
        					projectCategoryField.setText(p.getProjectCategory());
        					projectIDField.setText(pi.getProjectID());
        					customerNameField.setText(p.getCustomerID());
        					handsField.setText(pi.getHandsmodel());
        					sectionField.setCellValueFactory(new PropertyValueFactory<>("section"));
        					itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        					itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        					itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
        					itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
        					woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
        					quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        					color.setCellValueFactory(new PropertyValueFactory<>("color"));
        					
        					String imageSTR = CarpentryLogic.getInstance().GetImage(p);
    						if(imageSTR==null) {
    							//Image i = new Image("");
    							projectImage.setImage(null);
    							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),imageSTR);
    							arraylistToShow.add(pdtsToArray);
    						}
    						
    						else {
    							Image i = new Image(imageSTR);
    							projectImage.setImage(i);
    							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),imageSTR);
    							arraylistToShow.add(pdtsToArray);
    						}
        					
        					
        					
                		}
        			}
        			
        		}
        	
        	}// end of section loop
        } // end of the if
        
        }// end of projects loop
        ObservableList_CP.addAll(arraylistToShow);
       
        tableView.setItems(ObservableList_CP);
        
        
	}


}
