package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.WoodType;
import Model.Supplier;
import Model.Hands;
import Model.Axles;
import Enumeration.AxleDegree;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SettingsController implements Initializable{

	private HashSet<Button> Buttons = new HashSet<Button>();
	
	@FXML
    private ComboBox<Axles> brzolDegree;
	@FXML
    private ComboBox<Hands> handsModelNumber;
	@FXML
    private ComboBox<Supplier> suppliers;

    @FXML
    private ComboBox<WoodType> woodType;
    @FXML
    private CheckBox AutomaticOrderCheckbox,needAPaint;

    @FXML
    private TextField AxleCost;

    @FXML
    private TextField AxleName;

    @FXML
    private Button BackButton,Projects,GenerateByAI,Email,NewProject,Stock,Settings,addAxle,addHand,addSupplierEmail,addWoodType;

    @FXML
    private TextField HandsCost,HandsName,WoodType,WoodTypeCost,supplierEmail;
    
    @FXML
    private Button deleteAxle,deleteHand,deleteSupplier,deleteWoodType;

    @FXML
    void AddORDeleteButton(MouseEvent event) throws IOException, ClassNotFoundException {

    	for (Button b : Buttons) {
    		if (b.isPressed()) {

    			switch (b.getId()) {
    				
    				case "addWoodType":{
    		
    					WoodType wt = new WoodType();
    					wt.setWoodTypeName(WoodType.getText());
    					wt.setWoodTypeCost(Integer.parseInt(WoodTypeCost.getText()));
    					if(needAPaint.isSelected())
    						wt.setNeedToBePainted(1);
    					else wt.setNeedToBePainted(0);
    					
    					CarpentryLogic.getInstance().addWoodType(wt);
    	      
    					JOptionPane.showMessageDialog(null, "WoodType added successfully.", "Alert",
								JOptionPane.INFORMATION_MESSAGE);
    					break;
    				}
    				
    				case "deleteWoodType":{
    		    		
    					for(WoodType wt :  CarpentryLogic.getInstance().getWoodType()) {
    						if(wt.getWoodTypeName().equals(woodType.getSelectionModel().getSelectedItem().toString())) {
    							CarpentryLogic.getInstance().DeleteWoodType(wt);   
    							JOptionPane.showMessageDialog(null, "WoodType deleted successfully.", "Alert",
        								JOptionPane.INFORMATION_MESSAGE);
    							}
    					}
    					
    	      
    					break;
    				}
    	
    				case "addSupplierEmail": {
    		
    					if(AutomaticOrderCheckbox.isSelected()) {
    						Supplier sp = new Supplier();
    						sp.setSupplierEmail(supplierEmail.getText());
    						sp.setAutoOrder(1);
    						CarpentryLogic.getInstance().addSupplier(sp);
    						
    						JOptionPane.showMessageDialog(null, "Supplier added successfully.", "Alert",
    								JOptionPane.INFORMATION_MESSAGE);
    					}
    					
    					else {
    						Supplier sp = new Supplier();
    						sp.setSupplierEmail(supplierEmail.getText());
    						sp.setAutoOrder(0);
    						CarpentryLogic.getInstance().addSupplier(sp);
    						JOptionPane.showMessageDialog(null, "Supplier added successfully, Automatic orders are disabled", "Alert",
    								JOptionPane.INFORMATION_MESSAGE);
    					}
    		
    					break;
    				}
    				
    				case "deleteSupplier":{
    		    		
    					for(Supplier s :  CarpentryLogic.getInstance().getSupplier()) {
    						if(s.getSupplierEmail().equals(suppliers.getSelectionModel().getSelectedItem().toString())) {
    							CarpentryLogic.getInstance().DeleteSupplier(s);						
    							JOptionPane.showMessageDialog(null, "Supplier deleted successfully.", "Alert",
        								JOptionPane.INFORMATION_MESSAGE);
    							}
    					}
    					
    	      
    					break;
    				}
    	
    				case "addHand":{
    		
    					Hands h = new Hands();
    					h.setHandsName(HandsName.getText());
    					h.setHandsCost(Integer.parseInt(HandsCost.getText()));
    					CarpentryLogic.getInstance().addHands(h);
    					JOptionPane.showMessageDialog(null, "Hand added successfully.", "Alert",
								JOptionPane.INFORMATION_MESSAGE);
    					break;
    				}

    				case "deleteHand":{
    		    		
    					for(Hands h :  CarpentryLogic.getInstance().getHands()) {
    						if(h.getHandsName().equals(handsModelNumber.getSelectionModel().getSelectedItem().toString())) {
    							CarpentryLogic.getInstance().DeleteHands(h);						
    							JOptionPane.showMessageDialog(null, "Hand deleted successfully.", "Alert",
        								JOptionPane.INFORMATION_MESSAGE);
    							}
    					}
    					
    	      
    					break;
    				}

    				case "addAxle":{
    		
    					Axles a = new Axles();
    					a.setAxleName(AxleName.getText());
    					a.setAxleCost(Integer.parseInt(AxleCost.getText()));
  	      
    					CarpentryLogic.getInstance().addAxle(a);
    					JOptionPane.showMessageDialog(null, "Axle added successfully.", "Alert",
								JOptionPane.INFORMATION_MESSAGE);
    					break;
    				}
    				
    				case "deleteAxle":{
    		    		
    					for(Axles a :  CarpentryLogic.getInstance().getAxles()) {
    						if(a.getAxleName().equals(brzolDegree.getSelectionModel().getSelectedItem().toString())) {
    							CarpentryLogic.getInstance().DeleteAxle(a);						
    							JOptionPane.showMessageDialog(null, "Axle deleted successfully.", "Alert",
        								JOptionPane.INFORMATION_MESSAGE);}
    					}
    					
    	      
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

				case "Email": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Email.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Email");
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

				case "Projects": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Projects.fxml"));
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
		Buttons.add(Projects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Email);
		Buttons.add(BackButton);
		Buttons.add(GenerateByAI);
		Buttons.add(Settings);
		Buttons.add(addAxle);
		Buttons.add(addHand);
		Buttons.add(addSupplierEmail);
		Buttons.add(addWoodType);
		Buttons.add(deleteAxle);
		Buttons.add(deleteHand);
		Buttons.add(deleteSupplier);
		Buttons.add(deleteWoodType);
		
		ArrayList<WoodType> woodTypeArrayList = new ArrayList<>();
		for (WoodType c : CarpentryLogic.getInstance().getWoodType()) {
			woodTypeArrayList.add(c);
		}
		
		ObservableList<WoodType> woodTypeList = FXCollections.observableArrayList(woodTypeArrayList);
		woodType.getItems().addAll(woodTypeList);
		
		ArrayList<Hands> HandsArrayList = new ArrayList<>();
		for (Hands h : CarpentryLogic.getInstance().getHands()) {
			HandsArrayList.add(h);
		}
		
		ObservableList<Hands> HANDTYPE = FXCollections.observableArrayList(HandsArrayList);
		handsModelNumber.getItems().addAll(HANDTYPE);
		
		ArrayList<Axles> AxlesArrayList = new ArrayList<>();
		for (Axles a : CarpentryLogic.getInstance().getAxles()) {
			AxlesArrayList.add(a);
		}
		ObservableList<Axles> axlesDegree = FXCollections.observableArrayList(AxlesArrayList);
		brzolDegree.getItems().addAll(axlesDegree);
		
		ArrayList<Supplier> SuppliersArrayList = new ArrayList<>();
		for (Supplier s : CarpentryLogic.getInstance().getSupplier()) {
			SuppliersArrayList.add(s);
		}
		ObservableList<Supplier> supplierslist = FXCollections.observableArrayList(SuppliersArrayList);
		suppliers.getItems().addAll(supplierslist);
	}
    
    

}
