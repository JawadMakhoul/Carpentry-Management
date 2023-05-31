package Controller;

import java.io.IOException;
import java.net.URL;
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

public class NewProjectController implements Initializable{

private String projectID;
    @FXML
    private Button EditCustomer,UpdateProjectDetails,ProjectDetails,GenerateByAI,projectItems,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
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
    case "projectItems":{
    	boolean flag=true;
    	if( projectCategory.getSelectionModel().getSelectedItem()== null) {
			 JOptionPane.showMessageDialog(null, "Please select a catagory before submiting.", "A catagory reminder", JOptionPane.WARNING_MESSAGE);
		}
    	
    	else if(!CustomerName.getText().equals("") && !phoneNumber.getText().equals("") && !address.getText().equals("") && !email.getText().equals("") && projectCategory.getSelectionModel().getSelectedItem()!= null && customersemails.getSelectionModel().getSelectedItem()== null ) { // Creating new customer and new project    
    		    for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
    		    	if(c.getEmail().equals(email.getText())) {
    		    		JOptionPane.showMessageDialog(null, "this email is already exists.", "Email reminder", JOptionPane.WARNING_MESSAGE);
    		    		flag=false;
    		    	}
    		    }
    		    
    		    if(flag) {
    		    	if(customersemails.getSelectionModel().getSelectedItem()!= null) {
    		    		   for(Customer c : CarpentryLogic.getInstance().getCustomers()) 
    		    		   {
    		    			   if(c.getEmail() == customersemails.getSelectionModel().getSelectedItem().toString()) {
    		    				   CustomerName.setText(c.getName());
    		    				   phoneNumber.setText(c.getPhoneNUMBER());
    		    				   address.setText(c.getAddress());
    		    				   email.setText(c.getEmail());
    		    				   Project p = new Project();
    		    				    GlobalProjectID.setId(p.getProjectID());
    		    				    //String ip = c.getName();
    		    				    p.setCustomerID(c.getEmail());
    		    				    if(projectCategory.getSelectionModel().getSelectedItem() != null) {
    		    				    p.setProjectCategory(projectCategory.getSelectionModel().getSelectedItem().toString());
    		    				    }
    		    				    CarpentryLogic.getInstance().addProject(p);
    		    				    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectItems.fxml"));
    		    				    Parent pane = loader.load();
    		    				    Scene scene = new Scene(pane);
    		    				    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		    				    stage.setScene(scene);
    		    				    stage.setTitle("Awni Wood Work - Project Items");
    		    				    stage.show();
    		    				    
    		    				   
    		    			   }
    		    		   }
    		    	   }
    		    	   if(customersemails.getSelectionModel().getSelectedItem()== null ){
    		    	    if(!CustomerName.getText().equals("") && !phoneNumber.getText().equals("") && !address.getText().equals("") && !email.getText().equals("") && projectCategory.getSelectionModel().getSelectedItem()!= null   ) { // Creating new customer and new project    
    		    	    
    		    	   
    		    	    Customer c = new Customer();
    		    	    if(CustomerName.getText().matches(".*\\d+.*")) {
    		    	    //c.setName(CustomerName.getText());
    		    	    try {
    		    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		    	    alert.setTitle("Error!");
    		    	    alert.setContentText("Press OK to try again.");
    		    	    alert.setHeaderText("Sorry the costumer name sholdn`t include numbers.");
    		    	    alert.showAndWait();
    		    	    } catch (Error e) {
    		    	    e.printStackTrace();
    		    	    } catch (Exception e) {
    		    	    e.printStackTrace();
    		    	    }
    		    	    } else {
    		    	    c.setName(CustomerName.getText());
    		    	    //System.out.println(c.getName());
    		    	    GlobalProjectID.setCustomerName(CustomerName.getText());
    		    	    //System.out.println(GlobalProjectID.getCustomerName());
    		    	    try {
    		    	   
    		    	       int num = Integer.parseInt((phoneNumber.getText()));
    		    	    c.setPhoneNUMBER(phoneNumber.getText());
    		    	   
    		    	   
    		    	    c.setAddress(address.getText());
    		    	    if (email.getText().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"))
    		    	    {
    		    	    c.setEmail(email.getText());
    		    	    CarpentryLogic.getInstance().addCustomer(c);
    		    	   
    		    	    Project p = new Project();
    		    	    GlobalProjectID.setId(p.getProjectID());
    		    	    //String ip = c.getName();
    		    	    p.setCustomerID(c.getEmail());
    		    	    if(projectCategory.getSelectionModel().getSelectedItem() != null) {
    		    	    p.setProjectCategory(projectCategory.getSelectionModel().getSelectedItem().toString());
    		    	    }
    		    	    CarpentryLogic.getInstance().addProject(p);
    		    	    
    		    	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectItems.fxml"));
    		    	    Parent pane = loader.load();
    		    	    Scene scene = new Scene(pane);
    		    	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		    	    stage.setScene(scene);
    		    	    stage.setTitle("Awni Wood Work - Project Items");
    		    	    stage.show();
    		    	    }else {
    		    	    try {
    		    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		    	    alert.setTitle("Error!");
    		    	    alert.setContentText("Press OK to try again.");
    		    	    alert.setHeaderText("please enter a valid Email.");
    		    	    alert.showAndWait();
    		    	    } catch (Error e) {
    		    	    e.printStackTrace();
    		    	    } catch (Exception e) {
    		    	    e.printStackTrace();
    		    	    }
    		    	    }
    		    	    } catch (NumberFormatException e) {
    		    	    try {
    		    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		    	    alert.setTitle("Error!");
    		    	    alert.setContentText("Press OK to try again.");
    		    	    alert.setHeaderText("Sorry the costumer phone sholdn`t include letters.");
    		    	    alert.showAndWait();
    		    	    } catch (Error e1) {
    		    	    e1.printStackTrace();
    		    	    } catch (Exception e1) {
    		    	    e1.printStackTrace();
    		    	    }    
    		    	    }
    		    	    }
    		    	   
    		    	    //Integer i = p.getProjectID();
    		    	    //setProjectID(i.toString());
    		    	    }else {
    		    	    try {
    		    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		    	    alert.setTitle("Error!");
    		    	    alert.setContentText("Press OK to try again.");
    		    	    alert.setHeaderText("please enter the missing value.");
    		    	    alert.showAndWait();
    		    	    } catch (Error e) {
    		    	    e.printStackTrace();
    		    	    } catch (Exception e) {
    		    	    e.printStackTrace();
    		    	    }
    		    	    }
    		    	   }
    		    }
    		  
    	 } 
    	 else {
   if(customersemails.getSelectionModel().getSelectedItem()!= null) {
	   for(Customer c : CarpentryLogic.getInstance().getCustomers()) 
	   {
		   if(c.getEmail() == customersemails.getSelectionModel().getSelectedItem().toString()) {
			   CustomerName.setText(c.getName());
			   phoneNumber.setText(c.getPhoneNUMBER());
			   address.setText(c.getAddress());
			   email.setText(c.getEmail());
			   Project p = new Project();
			    GlobalProjectID.setId(p.getProjectID());
			    //String ip = c.getName();
			    p.setCustomerID(c.getEmail());
			    if(projectCategory.getSelectionModel().getSelectedItem() != null) {
			    p.setProjectCategory(projectCategory.getSelectionModel().getSelectedItem().toString());
			    }
			    CarpentryLogic.getInstance().addProject(p);
			    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectItems.fxml"));
			    Parent pane = loader.load();
			    Scene scene = new Scene(pane);
			    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			    stage.setScene(scene);
			    stage.setTitle("Awni Wood Work - Project Items");
			    stage.show();
			    
			   
		   }
	   }
   }
   if(customersemails.getSelectionModel().getSelectedItem()== null ){
    if(!CustomerName.getText().equals("") && !phoneNumber.getText().equals("") && !address.getText().equals("") && !email.getText().equals("") && projectCategory.getSelectionModel().getSelectedItem()!= null   ) { // Creating new customer and new project    
    
   
    Customer c = new Customer();
    if(CustomerName.getText().matches(".*\\d+.*")) {
    //c.setName(CustomerName.getText());
    try {
    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Error!");
    alert.setContentText("Press OK to try again.");
    alert.setHeaderText("Sorry the costumer name sholdn`t include numbers.");
    alert.showAndWait();
    } catch (Error e) {
    e.printStackTrace();
    } catch (Exception e) {
    e.printStackTrace();
    }
    } else {
    c.setName(CustomerName.getText());
    //System.out.println(c.getName());
    GlobalProjectID.setCustomerName(CustomerName.getText());
    //System.out.println(GlobalProjectID.getCustomerName());
    try {
   
       int num = Integer.parseInt((phoneNumber.getText()));
    c.setPhoneNUMBER(phoneNumber.getText());
   
   
    c.setAddress(address.getText());
    if (email.getText().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"))
    {
    c.setEmail(email.getText());
    CarpentryLogic.getInstance().addCustomer(c);
   
    Project p = new Project();
    GlobalProjectID.setId(p.getProjectID());
    //String ip = c.getName();
    p.setCustomerID(c.getEmail());
    if(projectCategory.getSelectionModel().getSelectedItem() != null) {
    p.setProjectCategory(projectCategory.getSelectionModel().getSelectedItem().toString());
    }
    CarpentryLogic.getInstance().addProject(p);
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectItems.fxml"));
    Parent pane = loader.load();
    Scene scene = new Scene(pane);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.setTitle("Awni Wood Work - Project Items");
    stage.show();
    }else {
    try {
    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Error!");
    alert.setContentText("Press OK to try again.");
    alert.setHeaderText("please enter a valid Email.");
    alert.showAndWait();
    } catch (Error e) {
    e.printStackTrace();
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
    } catch (NumberFormatException e) {
    try {
    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Error!");
    alert.setContentText("Press OK to try again.");
    alert.setHeaderText("Sorry the costumer phone sholdn`t include letters.");
    alert.showAndWait();
    } catch (Error e1) {
    e1.printStackTrace();
    } catch (Exception e1) {
    e1.printStackTrace();
    }    
    }
    }
   
    //Integer i = p.getProjectID();
    //setProjectID(i.toString());
    }else {
    try {
    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Error!");
    alert.setContentText("Press OK to try again.");
    alert.setHeaderText("please enter the missing value.");
    alert.showAndWait();
    } catch (Error e) {
    e.printStackTrace();
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
   }
    	 }
    
    }
    break;
    }
    }}
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
    				   email.setText(c.getEmail());
    				   
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
	Buttons.add(projectItems);
	Buttons.add(GenerateByAI);
	Buttons.add(ProjectDetails);
	Buttons.add(EditCustomer);
	Buttons.add(UpdateProjectDetails);
	
	ObservableList<ProjectCategory> projectType = FXCollections.observableArrayList(ProjectCategory.Home,ProjectCategory.Office,ProjectCategory.Institution);
	projectCategory.getItems().addAll(projectType);
	
	ArrayList<String> emails = new ArrayList<>();
	for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
		emails.add(c.getEmail());
	}
	ObservableList<String> custEmails = FXCollections.observableArrayList(emails);
	customersemails.getItems().addAll(custEmails);
	
	
}


}
