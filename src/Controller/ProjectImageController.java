package Controller;

import java.io.IOException;
import javafx.scene.image.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enumeration.AxleDegree;
import Enumeration.OrderStatus;
import Enumeration.ProjectSection;
import Enumeration.SectionColor;
import Enumeration.WoodType;
import Enumeration.handType;
import Model.CurrentProjectsToShow;
import Model.Customer;
import Model.GlobalProjectID;
import Model.Order;
import Model.Project;
import Model.ProjectDetailsToShow;
import Model.ProjectDetailsToShowNonStatic;
import Model.ProjectItems;
import Model.Section;
import Model.Stock;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ProjectImageController implements Initializable{

	@FXML
    private Button GenerateByAI,NewProject,Stock,CurrentProjects,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
	 

	    @FXML
	    private TextField customerNameField;

	    @FXML
	    private TextField phoneNumber;

	    @FXML
	    private TextField projectCategoryField;

	    @FXML
	    private TextField projectIDField;

	    @FXML
	    private ImageView projectimage;

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
    
   
	 
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			Buttons.add(CurrentProjects);
			Buttons.add(Stock);
			Buttons.add(NewProject);
			Buttons.add(Inbox);
			Buttons.add(BackButton);
			Buttons.add(GenerateByAI);
			
			ProjectDetailsToShow pdts = ProjectItemsController.getPdts();
	       
	        ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
	        ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
	        
	        for(Project p : CarpentryLogic.getInstance().getProjects()) {
	        	
	        	if(pdts.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	        		
	        	
	        		for(Section s : CarpentryLogic.getInstance().getSections()) {
	        	
	        		if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	        			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
	        			if(pi.getProjectID().equals(Integer.toString(p.getProjectID())) && pi.getSectionID().equals(Integer.toString(s.getSectionID()))) { 
	        				
	        					projectCategoryField.setText(p.getProjectCategory());
	        					projectIDField.setText(pi.getProjectID());
	        					customerNameField.setText(p.getCustomerID());
	        					String imageSTR = CarpentryLogic.getInstance().GetImage(p);
	    						if(imageSTR==null) {
	    							//Image i = new Image("");
	    							projectimage.setImage(null);
	    							
	    						}
	    						
	    						else {
	    							Image i = new Image(imageSTR);
	    							projectimage.setImage(i);
	    							
	    						}
	        					for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
	        						
	        						if(c.getEmail().equals(p.getEmail()))
	        							phoneNumber.setText(c.getPhoneNUMBER());
	        					}
	        					
	        					
	        					
	    						
	        					
	                		}
	        			
	        			
	        			}
	        			
	        		}
	        	
	        	}// end of section loop
	        } // end of the if
	        
	        }// end of projects loop
	       
		}

}