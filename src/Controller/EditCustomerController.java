package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enumeration.ProjectCategory;
import Model.Customer;
import Model.GlobalProjectID;
import Model.Project;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditCustomerController implements Initializable{

private String projectID;
    @FXML
    private Button EditCustomer,UpdateProjectDetails,ProjectDetails,GenerateByAI,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
   
    @FXML
    private TextField CustomerName,address,email,phoneNumber;

    @FXML
    private ComboBox<ProjectCategory> projectCategory;

    @FXML
    private AnchorPane screen;

    @FXML
    private ComboBox<String> customersemails;
    public String getProjectID() {
    	return projectID;
    }

    public void setProjectID(String projectID) {
    	this.projectID = projectID;
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
   
    }}}
    }
   
    

    @FXML
    void ShowCsutomer(ActionEvent event) {
    	 if(customersemails.getSelectionModel().getSelectedItem()!= null) {
    		   for(Customer c : CarpentryLogic.getInstance().getCustomers()) 
    		   {
    			   if(c.getEmail() == customersemails.getSelectionModel().getSelectedItem().toString()) {
    				   CustomerName.setText(c.getName());
    				   phoneNumber.setText(c.getPhoneNUMBER());
    				   address.setText(c.getAddress());
    				  
    				   
    			   }
    		   }
    	   }
    }
    
    @FXML
    void UpdateCustomer(ActionEvent event) throws SQLException {
    	
    	if(!customersemails.getSelectionModel().getSelectedItem().equals(null)) {
    	for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
    		if(c.getEmail().equals(customersemails.getSelectionModel().getSelectedItem().toString())) {
//    			c.setName(CustomerName.getText());
//    			c.setPhoneNUMBER(phoneNumber.getText());
//    			c.setAddress(address.getText());
    			CarpentryLogic.getInstance().updateCustomer(c, CustomerName.getText(), address.getText(), phoneNumber.getText());
    		}
    	}}
    	
    	else 
    		JOptionPane.showMessageDialog(null, "Please select email from the list.", "Email Reminder", JOptionPane.WARNING_MESSAGE);
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
	//Buttons.add(projectItems);
	Buttons.add(GenerateByAI);
	Buttons.add(ProjectDetails);
	Buttons.add(EditCustomer);
	Buttons.add(UpdateProjectDetails);
	
	ArrayList<String> emails = new ArrayList<>();
	for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
		emails.add(c.getEmail());
	}
	ObservableList<String> custEmails = FXCollections.observableArrayList(emails);
	customersemails.getItems().addAll(custEmails);
}


}
