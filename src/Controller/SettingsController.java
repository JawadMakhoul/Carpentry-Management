package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.WoodType;
import Model.Supplier;
import Model.Hands;
import Model.Axles;
import Enumeration.AxleDegree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SettingsController implements Initializable{

	private HashSet<Button> Buttons = new HashSet<Button>();
	
    @FXML
    private CheckBox AutomaticOrderCheckbox;

    @FXML
    private TextField AxleCost;

    @FXML
    private TextField AxleName;

    @FXML
    private Button BackButton,CurrentProjects,GenerateByAI,Inbox,NewProject,Stock,Settings,addAxle,addHand,addSupplierEmail,addWoodType;

    @FXML
    private TextField HandsCost,HandsName,WoodType,WoodTypeCost,supplierEmail;

    @FXML
    void AddButton(MouseEvent event) throws IOException, ClassNotFoundException {

    	for (Button b : Buttons) {
    		if (b.isPressed()) {

    			switch (b.getId()) {
    				
    				case "addWoodType":{
    		
    					WoodType wt = new WoodType();
    					wt.setWoodTypeName(WoodType.getText());
    					wt.setWoodTypeCost(Integer.parseInt(WoodTypeCost.getText()));
    					CarpentryLogic.getInstance().addWoodType(wt);
    	      
    					break;
    				}
    	
    				case "addSupplierEmail": {
    		
    					if(AutomaticOrderCheckbox.isSelected()) {
    						Supplier sp = new Supplier();
    						sp.setSupplierEmail(supplierEmail.getText());
    						sp.setAutoOrder(1);
    						CarpentryLogic.getInstance().addSupplier(sp);
    					}
    					
    					else {
    						Supplier sp = new Supplier();
    						sp.setSupplierEmail(supplierEmail.getText());
    						sp.setAutoOrder(0);
    						CarpentryLogic.getInstance().addSupplier(sp);
    						JOptionPane.showMessageDialog(null, "Automatic orders are disabled", "Box reminder",
    								JOptionPane.WARNING_MESSAGE);
    					}
    		
    					break;
    				}
    	
    				case "addHand":{
    		
    					Hands h = new Hands();
    					h.setHandsName(HandsName.getText());
    					h.setHandsCost(Integer.parseInt(HandsCost.getText()));
    					CarpentryLogic.getInstance().addHands(h);
    		
    					break;
    				}

    				case "addAxle":{
    		
    					Axles a = new Axles();
    					a.setAxleName(AxleName.getText());
    					a.setAxleCost(Integer.parseInt(AxleCost.getText()));
  	      
    					CarpentryLogic.getInstance().addAxle(a);
	
    					break;
    				}
    			}
			}
    	}
    	
    }

    @FXML
    void MoveTo(MouseEvent event) throws IOException {

    	for (Button b : Buttons) {
			if (b.isPressed()) {

				switch (b.getId()) {

				case "Inbox": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Inbox.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Inbox");
					stage.show();
					break;
				}

				case "NewProject": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/NewProject.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Add project");
					stage.show();
					break;
				}
				case "Stock": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Stock.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Stock");
					stage.show();
					break;
				}

				case "CurrentProjects": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/CurrentProjects.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Projects In Progress");
					stage.show();
					break;
				}


				case "GenerateByAI": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/AI.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Generate By Images Ai");
					stage.show();
					break;
				}

				case "BackButton": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work");
					stage.show();
					break;
				}

				case "Settings":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/Settings.fxml"));
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
		Buttons.add(Settings);
		Buttons.add(addAxle);
		Buttons.add(addHand);
		Buttons.add(addSupplierEmail);
		Buttons.add(addWoodType);
		
		
		
	}
    
    

}
