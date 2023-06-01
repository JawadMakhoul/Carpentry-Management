package Controller;

import java.io.IOException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UpdateProjectDetailsController implements Initializable{

    @FXML
    private Button ProjectDetails,GenerateByAI,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton,submit,EditCustomer,UpdateProjectDetails;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;
    
    @FXML
    private ComboBox<String> ComboBoxObject;
    
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
    private TableColumn<ProjectDetailsToShowNonStatic, String> projectIDField;

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
    private TableColumn<ProjectDetailsToShowNonStatic, String> handsField;
    @FXML
    private ScrollPane pnl;
    
    @FXML
    private ComboBox<String> customerEmailComboBox;
    
    @FXML
    private ComboBox<String> adddeleteitem;
    
    

    @FXML
    private ComboBox<SectionColor> colorField;


    @FXML
    private ComboBox<handType> handsModelNumber;

    @FXML
    private TextField itemHeightField,itemNameField,itemQuantity,itemWidthField,axleQuantity,handsQuantity;


    @FXML
    private ComboBox<ProjectSection> projectSection;


    @FXML
    private ComboBox<WoodType> woodTypeField;

    @FXML
    private ComboBox<AxleDegree> brzolDegree;

    @FXML
    private CheckBox newSection;

    private ProjectDetailsToShow pdts1;
    @FXML
    void MoveTo(MouseEvent event) throws IOException {
    	
    	for(Button b: Buttons) {
    		if(b.isPressed()) {
    		
    			switch(b.getId()) {
    			
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
    public void ShowProjectDetails() {System.out.println("4564574");
    	ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
        ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
        
        for(Project p : CarpentryLogic.getInstance().getProjects()) {System.out.println("aaa");
        		
        	if(p.getCustomerID().equals(customerEmailComboBox.getSelectionModel().getSelectedItem())) {System.out.println("sss");
        		for(Section s : CarpentryLogic.getInstance().getSections()) {System.out.println("ddd");
        	
       
        
        		if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {System.out.println("ffff");
        			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {System.out.println("ggggg");
        			if(pi.getProjectID().equals(Integer.toString(p.getProjectID())) && (s.getSectionName().equals(pi.getSection()))) {System.out.println("hhhhhhhh");
        				
        					projectIDField.setCellValueFactory(new PropertyValueFactory<>("projectID"));
        					sectionField.setCellValueFactory(new PropertyValueFactory<>("section"));
        					itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        					itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        					itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
        					itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
        					woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
        					quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        					color.setCellValueFactory(new PropertyValueFactory<>("color"));
        					handsField.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
        					
        					String imageSTR = CarpentryLogic.getInstance().GetImage(p);
    						
    							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getModelNumberOfHands(),imageSTR);
    							arraylistToShow.add(pdtsToArray);
    				
    						
    						
        					
        					
        					
                		}
        			}
        			
        		}
        	
        	}// end of section loop
 
        
        }// end of projects loop
        }
        ObservableList_CP.addAll(arraylistToShow);
       
        tableView.setItems(ObservableList_CP);
        System.out.println("345636");
    }
    @FXML
    void showProjects(ActionEvent event) {System.out.println("test");
    	ShowProjectDetails();
    	System.out.println("123123");
    }
    
    @FXML
    void SubmitProjectDetails(ActionEvent event) throws SQLException {

    	if(tableView.getSelectionModel().getSelectedItem()== null) {
			 JOptionPane.showMessageDialog(null, "Please select an item before submiting.", "A project reminder", JOptionPane.WARNING_MESSAGE);
		}
    	else {
    	switch(adddeleteitem.getSelectionModel().getSelectedItem()) {
    	
    	case "Add":{
    		if(itemNameField.getText() !="" && itemHeightField.getText() !="" && itemWidthField.getText() != "" && woodTypeField.getSelectionModel().getSelectedItem() != null
    				 && itemQuantity.getText()!= "" && tableView.getSelectionModel().getSelectedItem()!= null && projectSection.getSelectionModel().getSelectedItem() != null
    				 && colorField.getSelectionModel().getSelectedItem() != null && handsModelNumber.getSelectionModel().getSelectedItem()!= null) {
    			ProjectItems pi = new ProjectItems();
    			pi.setItemName(itemNameField.getText());
    			pi.setHeight(Integer.parseInt(itemHeightField.getText()));
    			pi.setWidth(Integer.parseInt(itemWidthField.getText()));
    			pi.setWoodType(woodTypeField.getSelectionModel().getSelectedItem().toString());
    			pi.setQuantity(Integer.parseInt(itemQuantity.getText()));
    			pi.setProjectID(tableView.getSelectionModel().getSelectedItem().getProjectID());
    			pi.setSection(projectSection.getSelectionModel().getSelectedItem().toString());
    			pi.setColor(colorField.getSelectionModel().getSelectedItem().toString());
    			pi.setModelNumberOfHands(handsModelNumber.getSelectionModel().getSelectedItem().toString());
    			
    			CarpentryLogic.getInstance().addProjectItems(pi);
    			
    			if(newSection.isSelected()) {
    				Section s = new Section();
    		    	try {
    		    	    if (projectSection.getSelectionModel().getSelectedItem() == null) {
    		    	      	 throw new IllegalArgumentException("Please enter all required fields.");
    		    	    }
    		    	 	s.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());
    		    	 	//sec.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());

    		    	}catch (IllegalArgumentException e) {
    		    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		    	    alert.setTitle("Error!");
    		    	    alert.setContentText("Press OK to try again.");
    		    	    alert.setHeaderText(e.getMessage());
    		    	    alert.showAndWait();
    		        }

    		    	s.setProjectID(tableView.getSelectionModel().getSelectedItem().getProjectID());
    		    	try {
    		    	    if (projectSection.getSelectionModel().getSelectedItem() == null || 
    		    	            handsQuantity.getText().equals("")|| 
    		    	            !handsQuantity.getText().matches(".*\\d+.*")
    		    	            || axleQuantity.getText().equals("")|| 
    		    	            !axleQuantity.getText().matches(".*\\d+.*")|| 
    		    	            brzolDegree.getSelectionModel().getSelectedItem()==null
    		    	            )
    		    	            {
    		    	    	 		throw new IllegalArgumentException("Please enter all required fields.");
    		    	            }
    			    	s.setQuantityOFhands(Integer.parseInt(handsQuantity.getText()));
    			    	s.setQuantityOFaxle(Integer.parseInt(axleQuantity.getText()));
    			    	s.setAxleDegree(brzolDegree.getSelectionModel().getSelectedItem().toString());
    			    	CarpentryLogic.getInstance().addSection(s);
    		    	    
    		        	ArrayList<Stock> stock = new ArrayList<Stock>();
    		        	stock= CarpentryLogic.getInstance().getStocks();
    		        	for(Stock s11 : stock) {
    		        		if (s11.getWoodName().equals(woodTypeField.getSelectionModel().getSelectedItem().toString())) {
    		        			s11.setQuantity(s11.getQuantity()-Integer.parseInt(itemQuantity.getText()));
    		        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());
    		        			//ShowProjectDetails();
    		        		}

    		        	}
    		        	
    		        	colorField.setValue(null);
    		        	projectSection.setValue(null);
    		        	brzolDegree.setValue(null);
    		        	handsModelNumber.setValue(null);
    		        	handsQuantity.setText(null);
    		        	axleQuantity.setText(null);
    		        	itemNameField.setText(null);
    		        	itemHeightField.setText(null);
    		        	itemWidthField.setText(null);
    		        	itemQuantity.setText(null);
    		   
    		    	}
    		    	catch (IllegalArgumentException e) {
    		    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		    	    alert.setTitle("Error!");
    		    	    alert.setContentText("Press OK to try again.");
    		    	    alert.setHeaderText(e.getMessage());
    		    	    alert.showAndWait();
    		   	}
    		    	
        			
    			}
    			
    			else if(!newSection.isSelected()) {
    				ProjectItems pi2 = new ProjectItems();
        			pi2.setItemName(itemNameField.getText());
        			pi2.setHeight(Integer.parseInt(itemHeightField.getText()));
        			pi2.setWidth(Integer.parseInt(itemWidthField.getText()));
        			pi2.setWoodType(woodTypeField.getSelectionModel().getSelectedItem().toString());
        			pi2.setQuantity(Integer.parseInt(itemQuantity.getText()));
        			pi2.setProjectID(tableView.getSelectionModel().getSelectedItem().getProjectID());
        			pi2.setSection(tableView.getSelectionModel().getSelectedItem().getSection());
        			pi2.setColor(colorField.getSelectionModel().getSelectedItem().toString());
        			pi2.setModelNumberOfHands(handsModelNumber.getSelectionModel().getSelectedItem().toString());
        			
        			CarpentryLogic.getInstance().addProjectItems(pi2);
        			//ShowProjectDetails();
    			}
    		}
    		break;
    	
    	}
    	case "Edit":{//itemWidthField,axleQuantity,handsQuantity;
    		
    			if(itemNameField.getText()!="") {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemNameField.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateItemName(pi, itemNameField.getText());
    						itemNameField.setText(null);
    					}
    				}
    				
    			}
    			
    			if(itemHeightField.getText()!="") {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemHeightField.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateItemHeight(pi,Integer.parseInt(itemHeightField.getText()));
    						itemHeightField.setText(null);
    					}
    				}
    				
    			}
    			
    			if(itemQuantity.getText()!="") {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemQuantity.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateItemQuantity(pi,Integer.parseInt(itemQuantity.getText()));
    						itemQuantity.setText(null);
    					}
    				}
    				
    			}
    			
    			if(itemWidthField.getText()!="") {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemWidthField.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateItemWidth(pi,Integer.parseInt(itemWidthField.getText()));
    						itemWidthField.setText(null);
    					}
    				}
    				
    			}
    			
    			if(woodTypeField.getSelectionModel().getSelectedItem()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateWoodType(pi, woodTypeField.getSelectionModel().getSelectedItem().toString());
    						//woodTypeField.setSelectionModel(null);
    					}
    				}
    				
    			}
    			
    			if(projectSection.getSelectionModel().getSelectedItem()!=null) {
				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
				
				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
						CarpentryLogic.getInstance().updateItemSection(pi, projectSection.getSelectionModel().getSelectedItem().toString());
						
				}
				for(Section s : CarpentryLogic.getInstance().getSections()) {
					if (s.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID())){
						if(s.getSectionName() ==tableView.getSelectionModel().getSelectedItem().getSection()) {
							CarpentryLogic.getInstance().updateSectionName(s, projectSection.getSelectionModel().toString());
						}
					}
				}
				
			}
    			
    			if(brzolDegree.getSelectionModel().getSelectedItem()!=null) {
    				for(Section s: CarpentryLogic.getInstance().getSections()) {
    					if(s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && s.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID())) {
    						System.out.println(brzolDegree.getSelectionModel().getSelectedItem().toString());
    						CarpentryLogic.getInstance().updateAxleDegree(s, brzolDegree.getSelectionModel().getSelectedItem().toString());
    						//brzolDegree.setSelectionModel(null);
    					}
    				}
    			}
    			
    			if(handsModelNumber.getSelectionModel().getSelectedItem()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateModelOfHands(pi, handsModelNumber.getSelectionModel().getSelectedItem().toString());
    						//handsModelNumber.setSelectionModel(null);
    					}
    				}
    				
    			}
    			
    			
    			if(colorField.getSelectionModel().getSelectedItem()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
    						CarpentryLogic.getInstance().updateItemColor(pi, colorField.getSelectionModel().getSelectedItem().toString());
    						//colorField.setSelectionModel(null);
    					}
    				}
    				
    			}
    			
    			

    			if(axleQuantity.getText()!="") {
    				for(Section s: CarpentryLogic.getInstance().getSections()) {
    					if(s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && s.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID())) {
    						CarpentryLogic.getInstance().updateAxleQuantity(s, Integer.parseInt(axleQuantity.getText()));
    						axleQuantity.setText(null);
    					}
    				}
    			}
    			
    			if(handsQuantity.getText()!="") {
    				for(Section s: CarpentryLogic.getInstance().getSections()) {
    					if(s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && s.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID())) {
    						CarpentryLogic.getInstance().updateHandsQuantity(s, Integer.parseInt(handsQuantity.getText()));
    						handsQuantity.setText(null);
    					}
    				}
    			}
    			
    			//ShowProjectDetails();
    		break;
    	}

    	case "Delete":{
    		
    		switch(ComboBoxObject.getSelectionModel().getSelectedItem()) {
    		
    		case "Project":{
    			DeleteProject();
    			//ShowProjectDetails();
    			break;
    		}
    		
    		case "Item":{
    			DeleteItem();
    			//ShowProjectDetails();
    			break;
    		}
    		
    		case "Section":{
    			DeleteSection();
    			//ShowProjectDetails();
    			break;
    		}
    		
    		}
    		break;
}
    	}
    	}
    }
    
    public void DeleteProject() throws SQLException {
    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
			if(pi.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID())) {
				ArrayList<Stock> stock = new ArrayList<Stock>();
	        	stock= CarpentryLogic.getInstance().getStocks();
	        	for(Stock s11 : stock) {
	        		if (s11.getWoodName().equals(tableView.getSelectionModel().getSelectedItem().getWoodType())) {
	        			s11.setQuantity(s11.getQuantity()+Integer.parseInt(quantity.getText()));
	        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());
	        			CarpentryLogic.getInstance().DeleteProjectItems(pi);
	        		}

	        	}
			}
				
		}
		
		for(Section s : CarpentryLogic.getInstance().getSections()) {
			if(s.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID()))
				CarpentryLogic.getInstance().DeleteSection(s);
											
		}
		
		for(Project p : CarpentryLogic.getInstance().getProjects()) {
			if(Integer.toString(p.getProjectID()).equals(tableView.getSelectionModel().getSelectedItem().getProjectID()))
				CarpentryLogic.getInstance().DeleteProject(p);
											
		}
    }
    
    public void DeleteSection() throws SQLException {
    	
    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
			if(pi.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID()) && pi.getSection().equals(tableView.getSelectionModel().getSelectedItem().getSection())) {
				ArrayList<Stock> stock = new ArrayList<Stock>();
	        	stock= CarpentryLogic.getInstance().getStocks();
	        	for(Stock s11 : stock) {
	        		if (s11.getWoodName().equals(tableView.getSelectionModel().getSelectedItem().getWoodType())) {
	        			s11.setQuantity(s11.getQuantity()+Integer.parseInt(quantity.getText()));
	        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());
	        			CarpentryLogic.getInstance().DeleteProjectItems(pi);
	        		}

	        	}
			}
				
		}
    	
    	for(Section s : CarpentryLogic.getInstance().getSections()) {
			if(s.getProjectID().equals(tableView.getSelectionModel().getSelectedItem().getProjectID()) && s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()))
				CarpentryLogic.getInstance().DeleteSection(s);
											
		}
    }
    
//    public void DeleteItem() throws SQLException {
//    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//			if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//			System.out.println("ssssssssssssssssssssssssssssssssss");
//				ArrayList<Stock> stock = new ArrayList<Stock>();
//	        	stock= CarpentryLogic.getInstance().getStocks();
//    			CarpentryLogic.getInstance().DeleteProjectItems(pi);
//	        	for(Stock s11 : stock) {
//	        		if (s11.getWoodName().equals(tableView.getSelectionModel().getSelectedItem().getWoodType())) {
//	        			s11.setQuantity(s11.getQuantity()+Integer.parseInt(quantity.getText()));
//	        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());
//
//
//	        		}
//
//	        	}
//			}
//				
//		}
//    }
    
    public void DeleteItem() throws SQLException {
    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			if(pi.getItemID()== Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getItemID())) {
			System.out.println(pi.getItemID());
				ArrayList<Stock> stock = new ArrayList<Stock>();
	        	stock= CarpentryLogic.getInstance().getStocks();
    			CarpentryLogic.getInstance().DeleteProjectItems(pi);
	        	for(Stock s11 : stock) {
	        		if (s11.getWoodName().equals(tableView.getSelectionModel().getSelectedItem().getWoodType())) {
	        			s11.setQuantity(s11.getQuantity()+Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getQuantity()));
	        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());


	        		}

	        	}
			}
				
		}
    }
    
    @FXML
    void CheckIfDelete(ActionEvent event) {
    	if(adddeleteitem.getSelectionModel().getSelectedItem().equals("Delete"))
    		ComboBoxObject.setDisable(false);
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
	
		ArrayList<String> emails = new ArrayList<>();
		for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
			emails.add(c.getEmail());
		}
		ObservableList<String> custEmails = FXCollections.observableArrayList(emails);
		customerEmailComboBox.getItems().addAll(custEmails);
		
		
		ObservableList<String> toDo = FXCollections.observableArrayList("Add","Edit","Delete");
		adddeleteitem.getItems().addAll(toDo);
		
		//ProjectDetailsToShow pdts = ProjectItemsController.getPdts();
		ObservableList<ProjectSection> projectSectionList = FXCollections.observableArrayList(ProjectSection.Kitchen,ProjectSection.Room,ProjectSection.LivingRoom,ProjectSection.Bathroom);
		projectSection.getItems().addAll(projectSectionList);
		
		ObservableList<WoodType> woodTypeList = FXCollections.observableArrayList(WoodType.Mdf,WoodType.Melamine,WoodType.Particleboard,WoodType.Sandwich,WoodType.Solid_Wood);
		woodTypeField.getItems().addAll(woodTypeList);
		
		ObservableList<handType> HANDTYPE = FXCollections.observableArrayList(handType.a17,handType.f120,handType.gh32,handType.r452,handType.s125);
		handsModelNumber.getItems().addAll(HANDTYPE);
		
		ObservableList<SectionColor> section_Colors = FXCollections.observableArrayList(SectionColor.Aspen_Tan,SectionColor.Avocado,SectionColor.Beige_Gray,SectionColor.Black_Oak,SectionColor.Black_Walnut,SectionColor.Blueridge_Gray,SectionColor.Brick_Red,SectionColor.Caramel,SectionColor.Cedar_Naturaltone,SectionColor.Cinder,SectionColor.Cinnamon,SectionColor.Clove_Brown,SectionColor.Coffee,SectionColor.Dark_Mahogany,SectionColor.Dark_Oak,SectionColor.Dark_Tahoe,SectionColor.Desert_Sand,SectionColor.Drift_Gray,SectionColor.Ebony,SectionColor.Espresso,SectionColor.Ginger,SectionColor.Light_Mocha,SectionColor.Light_Oak,SectionColor.Mushroom,SectionColor.Naturaltone_Fir,SectionColor.Olive_Brown,SectionColor.Oxford_Brown,SectionColor.Pearl_Gray,SectionColor.Polar_Gray,SectionColor.Redwood,SectionColor.Redwood_Naturaltone,SectionColor.Rosewood,SectionColor.Russet,SectionColor.Sierra,SectionColor.Smoke_Blue,SectionColor.Storm_Gray,SectionColor.Teak,SectionColor.Tobacco,SectionColor.Walnut,SectionColor.Weathered_Barnboard);
		colorField.getItems().addAll(section_Colors);
       
		ObservableList<AxleDegree> axlesDegree = FXCollections.observableArrayList(AxleDegree.Degree_45,AxleDegree.Degree_155,AxleDegree.Degree_180);
		brzolDegree.getItems().addAll(axlesDegree);
	
		ObservableList<String> Object = FXCollections.observableArrayList("Project","Section","Item");
		ComboBoxObject.getItems().addAll(Object);
		ComboBoxObject.setDisable(true);
	}
}
