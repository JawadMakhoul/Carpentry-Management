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
    private Button ProjectDetails,GenerateByAI,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton,submit;
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
    private ImageView loading;

    @FXML
    private ComboBox<SectionColor> colorField;


    @FXML
    private ComboBox<handType> handsModelNumber;

    @FXML
    private TextField itemHeightField,itemNameField,itemQuantity,itemWidthField,axleQuantity,handsQuantity;


    @FXML
    private ComboBox<ProjectSection> projectSection;

    @FXML
    private Button showProjects;

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
    
    public void ShowProjectDetails() {
    	ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
        ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
        
        for(Project p : CarpentryLogic.getInstance().getProjects()) {
        		
        	if(p.getCustomerID().equals(customerEmailComboBox.getSelectionModel().getSelectedItem())) {
        		for(Section s : CarpentryLogic.getInstance().getSections()) {
        	
       
        
        		if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
        			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
        			if(pi.getProjectID().equals(Integer.toString(p.getProjectID())) && (s.getSectionName().equals(pi.getSection()))) {
        				
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
        ObservableList_CP.addAll(arraylistToShow);
       
        tableView.setItems(ObservableList_CP);
        }
    }
    @FXML
    void showProjects(ActionEvent event) {
    	ShowProjectDetails();
    }
    
    @FXML
    void SubmitProjectDetails(ActionEvent event) throws SQLException {

    	if(tableView.getSelectionModel().getSelectedItem()== null) {
			 JOptionPane.showMessageDialog(null, "Please select an item before submiting.", "A project reminder", JOptionPane.WARNING_MESSAGE);
		}
    	
    	switch(adddeleteitem.getSelectionModel().getSelectedItem()) {
    	
    	case "Add":{
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
    		        			ShowProjectDetails();
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
        			ShowProjectDetails();
    			}
    			
    		break;
    	}
    	
    	case "Edit":{//itemWidthField,axleQuantity,handsQuantity;
    		
    			if(itemNameField.getText()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemNameField.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
    						CarpentryLogic.getInstance().updateItemName(pi, itemNameField.getText());
    				}
    				
    			}
    			
    			if(itemHeightField.getText()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemHeightField.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
    						CarpentryLogic.getInstance().updateItemHeight(pi,Integer.parseInt(itemHeightField.getText()));
    				}
    				
    			}
    			
    			if(itemQuantity.getText()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemQuantity.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
    						CarpentryLogic.getInstance().updateItemQuantity(pi,Integer.parseInt(itemQuantity.getText()));
    				}
    				
    			}
    			
    			if(itemWidthField.getText()!=null) {
    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemWidthField.getText());
    				
    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
    						CarpentryLogic.getInstance().updateItemWidth(pi,Integer.parseInt(itemWidthField.getText()));
    				}
    				
    			}
    			
//    			if(axleQuantity.getText()!=null) {
//    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
//    				
//    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
//    						//CarpentryLogic.getInstance()
//    				}
//    				
//    			}
//    			
//    			if(handsQuantity.getText()!=null) {
//    				//tableView.getSelectionModel().getSelectedItem().setItemName(handsQuantity.getText());
//    				
//    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
//    						//CarpentryLogic.getInstance().updateItemHeight(pi,Integer.parseInt(itemHeightField.getText()));
//    				}
//    				
//    			}
    			ShowProjectDetails();
    		break;
    	}

    	case "Delete":{
    		
    		for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
					CarpentryLogic.getInstance().DeleteProjectItems(pi);
			}
    		
    		
	
    		break;
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
	

	}
}
