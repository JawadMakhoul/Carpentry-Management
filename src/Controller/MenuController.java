package Controller;

import javafx.scene.Scene;
import java.util.HashSet;
import java.util.ResourceBundle;

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable{

    @FXML
    private Button NewProject,Stock,CurrentProjects,MaterialsToOrder,ColorsCatalog,OrderedMaterials,FinancialManaging,ProjectsCatalog;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    void MoveTo(ActionEvent event) throws IOException {
    	
    	for(Button b: Buttons) {
    		switch(b.getId()) {
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
    		
    		case "MaterialsToOrder":{
    			Parent pane = FXMLLoader.load(getClass().getResource("/View/MaterialsToOrder.fxml"));
        		Scene scene = new Scene(pane);
        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        		stage.setScene(scene);
        		stage.setResizable(false);
        		stage.setTitle("Awni Wood Work - Order Materials");
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
    		
    		case "FinancialManaging":{System.out.println("financew");
    			Parent pane = FXMLLoader.load(getClass().getResource("/View/FinancialManaging.fxml"));
        		Scene scene = new Scene(pane);
        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        		stage.setScene(scene);
        		stage.setResizable(false);
        		stage.setTitle("Awni Wood Work - Financial Managing");
        		stage.show();
        		break;
    		}
    		
    		case "ProjectsCatalog":{
    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectsCatalog.fxml"));
        		Scene scene = new Scene(pane);
        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        		stage.setScene(scene);
        		stage.setResizable(false);
        		stage.setTitle("Awni Wood Work - Projects Catalog");
        		stage.show();
        		break;
    		}
    		}
    	}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(ProjectsCatalog);
		Buttons.add(FinancialManaging);
		Buttons.add(OrderedMaterials);
		Buttons.add(ColorsCatalog);
		Buttons.add(MaterialsToOrder);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
	}


}