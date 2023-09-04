package Controller;

import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class ProjectDetailsToShowController implements Initializable{

	

    @FXML
    private ComboBox<String> ComboBoxObject;


    @FXML
    private ComboBox<String> adddeleteitem;

    @FXML
    private TextField axleQuantity;

    @FXML
    private ComboBox<AxleDegree> brzolDegree;


    @FXML
    private ComboBox<SectionColor> colorField;


    @FXML
    private ComboBox<handType> handsModelNumber;

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
    private ComboBox<ProjectSection> projectSection;


    @FXML
    private Button image,submit,reportButton;

    @FXML
    private ComboBox<WoodType> woodTypeField;
    @FXML
    private Button GenerateByAI,NewProject,Stock,CurrentProjects,Inbox,BackButton;
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
    private TableColumn<ProjectDetailsToShowNonStatic, String> handsField;
    
    @FXML
    private ScrollPane pnl;
    
    @FXML
    private TextField projectCategoryField,projectIDField,customerNameField,phoneNumber;;
    
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
    
    private String data;

    public void setData(String data) {
        this.data = data;
        postInitializeSetup();
        // Maybe update some UI elements here based on the data
    }
    
    private void postInitializeSetup() {
        // Here, use the `data` to populate or modify the UI elements
    	ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
        
        
        ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
    	for(Project p : CarpentryLogic.getInstance().getProjects()) {
        	
        	if(data.equals(Integer.toString(p.getProjectID()))) {
        		
        	
        		for(Section s : CarpentryLogic.getInstance().getSections()) {
        	
        		if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
        			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
        			if(pi.getProjectID().equals(Integer.toString(p.getProjectID())) && pi.getSectionID().equals(Integer.toString(s.getSectionID()))) { 
        				
        					projectCategoryField.setText(p.getProjectCategory());
        					projectIDField.setText(pi.getProjectID());
        					customerNameField.setText(p.getCustomerID());
        					
        					for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
        						
        						if(c.getEmail().equals(p.getEmail()))
        							phoneNumber.setText(c.getPhoneNUMBER());
        					}
        					
        					handsField.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
        					sectionField.setCellValueFactory(new PropertyValueFactory<>("section"));
        					itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        					itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        					itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
        					itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
        					woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
        					quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        					color.setCellValueFactory(new PropertyValueFactory<>("color"));
        					
        					
    							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),pi.getSectionID());
    							
    							arraylistToShow.add(pdtsToArray);
    						
    						
        					
                		}
        			
        			else {
        				projectCategoryField.setText(p.getProjectCategory());
    					projectIDField.setText(Integer.toString(p.getProjectID()));
    					customerNameField.setText(p.getCustomerID());
        			}
        			}
        			
        		}
        	
        	}// end of section loop
        } // end of the if
        
        }// end of projects loop
    	ObservableList_CP.addAll(arraylistToShow);
    	tableView.setItems(ObservableList_CP);
    }
    
	 @FXML
	    void SubmitProjectDetails(ActionEvent event) throws SQLException {

	    	if(tableView.getSelectionModel().getSelectedItem()== null && !newSection.isSelected()) {
				 JOptionPane.showMessageDialog(null, "Please select an item before submiting.", "A project reminder", JOptionPane.WARNING_MESSAGE);
			}
	    	else {
	    	switch(adddeleteitem.getSelectionModel().getSelectedItem()) {
	    	
	    	case "Add":{
	    		if(itemNameField.getText() !="" && itemHeightField.getText() !="" && itemWidthField.getText() != "" && woodTypeField.getSelectionModel().getSelectedItem() != null
	    				 && itemQuantity.getText()!= ""  
	    				 && colorField.getSelectionModel().getSelectedItem() != null && handsModelNumber.getSelectionModel().getSelectedItem()!= null) {
	    			
	    			
	    			if(newSection.isSelected()) {
	    				
	    			ProjectItems pi = new ProjectItems();
	    			pi.setItemName(itemNameField.getText());
	    			pi.setHeight(Integer.parseInt(itemHeightField.getText()));
	    			pi.setWidth(Integer.parseInt(itemWidthField.getText()));
	    			pi.setWoodType(woodTypeField.getSelectionModel().getSelectedItem().toString());
	    			pi.setQuantity(Integer.parseInt(itemQuantity.getText()));
	    			pi.setProjectID(projectIDField.getText().toString());
	    			pi.setSection(projectSection.getSelectionModel().getSelectedItem().toString());
	    			pi.setColor(colorField.getSelectionModel().getSelectedItem().toString());
	    			pi.setHandsmodel(handsModelNumber.getSelectionModel().getSelectedItem().toString());
	    			
	    			CarpentryLogic.getInstance().addProjectItems(pi);
	    			
	    			
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

	    		    	s.setProjectID(projectIDField.getText().toString());
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
	    			    	CarpentryLogic.getInstance().iNSERTItemSectionID(pi, s.getSectionID());
	    			    	pi.setSectionID(Integer.toString(s.getSectionID()));
	    			    	
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
	 		 		
	    				if(tableView.getSelectionModel().getSelectedItem()== null) {
	    					 JOptionPane.showMessageDialog(null, "Please select an item before submiting.", "A project reminder", JOptionPane.WARNING_MESSAGE);
	    				}
	    				else {
	    				ProjectItems pi2 = new ProjectItems();
	        			pi2.setItemName(itemNameField.getText());
	        			pi2.setHeight(Integer.parseInt(itemHeightField.getText()));
	        			pi2.setWidth(Integer.parseInt(itemWidthField.getText()));
	        			pi2.setWoodType(woodTypeField.getSelectionModel().getSelectedItem().toString());
	        			pi2.setQuantity(Integer.parseInt(itemQuantity.getText()));
	        			pi2.setProjectID(projectIDField.getText().toString());
	        			pi2.setSection(tableView.getSelectionModel().getSelectedItem().getSection());
	        			pi2.setColor(colorField.getSelectionModel().getSelectedItem().toString());
	        			pi2.setHandsmodel(handsModelNumber.getSelectionModel().getSelectedItem().toString());
	        			pi2.setSectionID(tableView.getSelectionModel().getSelectedItem().getSectionID());
	        			CarpentryLogic.getInstance().addProjectItems(pi2);
	        			int sID = Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getSectionID());
	        			CarpentryLogic.getInstance().iNSERTItemSectionID(pi2, sID);
	        			colorField.setValue(null);
    		        	projectSection.setValue(null);
    		        	brzolDegree.setValue(null);	
//    		        	handsModelNumber.setPromptText("Hands Model");
//    		        	handsModelNumber.setFocusTraversable(false);
    		        	handsQuantity.setText(null);
    		        	axleQuantity.setText(null);
    		        	itemNameField.setText(null);
    		        	itemHeightField.setText(null);
    		        	itemWidthField.setText(null);
    		        	itemQuantity.setText(null);
	        			ShowProjectDetails();
	    				}
	    			}
	    		}
	    		break;
	    	
	    	}
	    	case "Edit":{
	    		//itemWidthField,axleQuantity,handsQuantity;
	    	  
//	    	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//						if(pi.getColor()!= tableView.getSelectionModel().getSelectedItem().getColor()) {
//							CarpentryLogic.getInstance().updateItemColor(pi, tableView.getSelectionModel().getSelectedItem().getColor());
//						}
//					}
	//
//	    	     }
//	    	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	 				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	 					System.out.println("im section num: " + pi.getItemID());
//	 					System.out.println("my quantity is:" + pi.getQuantity());
////	 					quantity.setOnEditCommit(editEvent  -> {
////							    ProjectDetailsToShowNonStatic q = editEvent.getRowValue();
////							    String newQuantity = editEvent.getNewValue();
////							    q.setQuantity(newQuantity);
////							    System.out.println("Updated Quantity: " + q.getQuantity());
////							});
//	 					
////	 					quantity.setOnEditCommit(editEvent -> {
////	 						TablePosition<ProjectDetailsToShowNonStatic, String> pos = editEvent.getTablePosition();
////	 					    int row = pos.getRow();
////	 					    ProjectDetailsToShowNonStatic item = editEvent.getTableView().getItems().get(row);
////	 					    String newQuantity = editEvent.getNewValue();
////	 					    item.setQuantity(newQuantity);
////	 					    System.out.println("Updated Quantity: " + newQuantity);
////	 					});
	//
//	 					quantity.setOnEditCommit(e -> {
//	 					    String newValue = e.getNewValue();
//	 					    System.out.println(newValue);
//	 					    e.getRowValue().setQuantity(newValue);
//	 					});
	//
	//
//	 					System.out.println("the table quantity is: " + tableView.getSelectionModel().getSelectedItem().getQuantity());
//	 					if( !Integer.toString(pi.getQuantity()).equals( tableView.getSelectionModel().getSelectedItem().getQuantity())) {
//	 				
//	 						CarpentryLogic.getInstance().updateItemQuantity(pi,Integer.parseInt(quantity.getCellData(0)));
//	 						System.out.println("the updated value is"+ tableView.getSelectionModel().getSelectedItem().getQuantity() );
//	 						System.out.println("and in the db "+ pi.getQuantity());
//	 						
//	 				
	//
//	 					
//	 					}
//	 				}
	//
//	     	     }
//	     	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	  				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	  					for(Section s: CarpentryLogic.getInstance().getSections()) {
//	  						if(s.getProjectID() == pi.getProjectID() && s.getSectionName() == pi.getSection() )
//	  					if(!pi.getSection().equals( tableView.getSelectionModel().getSelectedItem().getSection())) {
//	  						CarpentryLogic.getInstance().updateSectionName(s, tableView.getSelectionModel().getSelectedItem().getSection());
//	  					}
//	  				}
//	  				}
//	      	     }
//	     	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	   				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	   					if( !pi.getModelNumberOfHands().equals( tableView.getSelectionModel().getSelectedItem().getModelNumberOFhands())) {
//	   						CarpentryLogic.getInstance().updateModelOfHands(pi, tableView.getSelectionModel().getSelectedItem().getModelNumberOFhands());
//	   					}
//	   				}
	//
//	       	     }
//	    	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    					if(! Integer.toString( pi.getHeight()).equals(( tableView.getSelectionModel().getSelectedItem().getItemHeight()))) {
//	    						CarpentryLogic.getInstance().updateItemHeight(pi,Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getItemHeight()));
//	    					}
//	    				}
	//
//	    	     }
//	    	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	 				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	 					if(! Integer.toString( pi.getWidth()).equals(( tableView.getSelectionModel().getSelectedItem().getItemWidth()))) {
//	 						CarpentryLogic.getInstance().updateItemWidth(pi,Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getItemWidth()));
//	 					}
//	 				}
	//
//	 	     }
//	    	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	  				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	  					if(! pi.getWoodType().equals(( tableView.getSelectionModel().getSelectedItem().getWoodType()))) {
//	  						CarpentryLogic.getInstance().updateWoodType(pi, tableView.getSelectionModel().getSelectedItem().getWoodType());
//	  					}
//	  				}
	//
//	  	     }
//	     	     for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	   				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	   					if(! pi.getItemName().equals(( tableView.getSelectionModel().getSelectedItem().getItemName()))) {
//	   						CarpentryLogic.getInstance().updateItemName(pi, tableView.getSelectionModel().getSelectedItem().getItemName());
//	   					}
//	   				}
	//
//	   	     }  
	    	     
	    	     
	    	     
	    	//}
	    	     
	    	break;
//	    	     
//	    			if(itemNameField.getText()!="") {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemNameField.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateItemName(pi, itemNameField.getText());
//	    						itemNameField.setText(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			if(itemHeightField.getText()!="") {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemHeightField.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateItemHeight(pi,Integer.parseInt(itemHeightField.getText()));
//	    						itemHeightField.setText(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			if(itemQuantity.getText()!="") {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemQuantity.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateItemQuantity(pi,Integer.parseInt(itemQuantity.getText()));
//	    						itemQuantity.setText(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			if(itemWidthField.getText()!="") {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(itemWidthField.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateItemWidth(pi,Integer.parseInt(itemWidthField.getText()));
//	    						itemWidthField.setText(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			if(woodTypeField.getSelectionModel().getSelectedItem()!=null) {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateWoodType(pi, woodTypeField.getSelectionModel().getSelectedItem().toString());
//	    						//woodTypeField.setSelectionModel(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			if(projectSection.getSelectionModel().getSelectedItem()!=null) {
//					//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
//					
//					for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//						if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID()))
//							CarpentryLogic.getInstance().updateItemSection(pi, projectSection.getSelectionModel().getSelectedItem().toString());
//							
//					}
//					for(Section s : CarpentryLogic.getInstance().getSections()) {
//						if (s.getProjectID().equals(projectIDField.getText().toString())){
//							if(s.getSectionName() ==tableView.getSelectionModel().getSelectedItem().getSection()) {
//								CarpentryLogic.getInstance().updateSectionName(s, projectSection.getSelectionModel().toString());
//							}
//						}
//					}
//					
//				}
//	    			
//	    			if(brzolDegree.getSelectionModel().getSelectedItem()!=null) {
//	    				for(Section s: CarpentryLogic.getInstance().getSections()) {
//	    					if(s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && s.getProjectID().equals(projectIDField.getText().toString())) {
//	    						System.out.println(brzolDegree.getSelectionModel().getSelectedItem().toString());
//	    						CarpentryLogic.getInstance().updateAxleDegree(s, brzolDegree.getSelectionModel().getSelectedItem().toString());
//	    						//brzolDegree.setSelectionModel(null);
//	    					}
//	    				}
//	    			}
//	    			
//	    			if(handsModelNumber.getSelectionModel().getSelectedItem()!=null) {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateModelOfHands(pi, handsModelNumber.getSelectionModel().getSelectedItem().toString());
//	    						//handsModelNumber.setSelectionModel(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			
//	    			if(colorField.getSelectionModel().getSelectedItem()!=null) {
//	    				//tableView.getSelectionModel().getSelectedItem().setItemName(axleQuantity.getText());
//	    				
//	    				for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
//	    					if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
//	    						CarpentryLogic.getInstance().updateItemColor(pi, colorField.getSelectionModel().getSelectedItem().toString());
//	    						//colorField.setSelectionModel(null);
//	    					}
//	    				}
//	    				
//	    			}
//	    			
//	    			
	//
//	    			if(axleQuantity.getText()!="") {
//	    				for(Section s: CarpentryLogic.getInstance().getSections()) {
//	    					if(s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && s.getProjectID().equals(projectIDField.getText().toString())) {
//	    						CarpentryLogic.getInstance().updateAxleQuantity(s, Integer.parseInt(axleQuantity.getText()));
//	    						axleQuantity.setText(null);
//	    					}
//	    				}
//	    			}
//	    			
//	    			if(handsQuantity.getText()!="") {
//	    				for(Section s: CarpentryLogic.getInstance().getSections()) {
//	    					if(s.getSectionName().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && s.getProjectID().equals(projectIDField.getText().toString())) {
//	    						CarpentryLogic.getInstance().updateHandsQuantity(s, Integer.parseInt(handsQuantity.getText()));
//	    						handsQuantity.setText(null);
//	    					}
//	    				}
//	    			}
//	    			
//	    			//ShowProjectDetails();
//	    		break;
	    	}

	    	case "Delete":{
	    		
	    		switch(ComboBoxObject.getSelectionModel().getSelectedItem()) {
	    		
	    		case "Project":{
	    			DeleteProject();
	    		ShowProjectDetails();
	    			break;
	    		}
	    		
	    		case "Item":{
	    			DeleteItem();
	    			ShowProjectDetails();
	    			break;
	    		}
	    		
	    		case "Section":{
	    			DeleteSection();
	    			ShowProjectDetails();
	    			break;
	    		}
	    		
	    		}
	    		break;
	}
	    	}
	    	}
	    }
	 
	
		
		@FXML
	    void NewSectionEvent(ActionEvent event) {
			if(newSection.isSelected()) {
			 axleQuantity.setDisable(false);
				handsQuantity.setDisable(false);
				projectSection.setDisable(false);
				brzolDegree.setDisable(false);
			}
			
			else {
				axleQuantity.setDisable(true);
				handsQuantity.setDisable(true);
				projectSection.setDisable(true);
				brzolDegree.setDisable(true);
			}
	    }
	    public void DeleteProject() throws SQLException {
	    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
				if(pi.getProjectID().equals(projectIDField.getText().toString())) {
					System.out.println(pi.getItemID());
					ArrayList<Stock> stock = new ArrayList<Stock>();
		        	stock= CarpentryLogic.getInstance().getStocks();
		        	System.out.println("I sent this: " + pi.getProjectID());
	    			CarpentryLogic.getInstance().DeleteProjectItems(pi);
	    			
	    			for(Stock s11 : stock) {
		        		if (s11.getWoodName().equals(tableView.getSelectionModel().getSelectedItem().getWoodType())) {
		        			s11.setQuantity(s11.getQuantity()+Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getQuantity()));
		        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());


		        		}

		        	}
				}
					
			}
			
			for(Section s : CarpentryLogic.getInstance().getSections()) {
				if(s.getProjectID().equals(projectIDField.getText().toString()))
					CarpentryLogic.getInstance().DeleteSection(s);
												
			}
			
			for(Project p : CarpentryLogic.getInstance().getProjects()) {
				if(Integer.toString(p.getProjectID()).equals(projectIDField.getText().toString()))
					CarpentryLogic.getInstance().DeleteProject(p);
												
			}
	    }
	    
	    public void DeleteSection() throws SQLException {
	    	
	    	String sectionId = tableView.getSelectionModel().getSelectedItem().getSectionID();
	    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
				if(pi.getSection().equals(tableView.getSelectionModel().getSelectedItem().getSection()) && pi.getSectionID().equals(sectionId)) {
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
	    	
	    	for(Section s : CarpentryLogic.getInstance().getSections()) {
				if(sectionId.equals(Integer.toString(s.getSectionID()))) 
					CarpentryLogic.getInstance().DeleteSection(s);
				
					
												
			}
	    }
	    public void DeleteItem() throws SQLException {
	    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
				if(pi.getItemID()== Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getItemID())) {
				
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
	    public void ShowProjectDetails() {

//	      itemID.setCellFactory(TextFieldTableCell.forTableColumn<TableView<ProjectDetailsToShowNonStatic>>());
//	      itemWidth.setCellFactory(TextFieldTableCell.<Project,Integer>());
//	      tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
//	      tableView.setEditable(true);
	    	
	      	ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
	      	ObservableList_CP.clear();
	          ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
	          
	          for(Project p : CarpentryLogic.getInstance().getProjects()) {
	          	//if(p.getCustomerID().equals(customerEmailComboBox.getSelectionModel().getSelectedItem())) {
	          		for(Section s : CarpentryLogic.getInstance().getSections()) {
	          		if(s.getProjectID().equals(projectIDField.getText().toString()) && s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	          			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
	          				
	          			if(pi.getSectionID().equals(Integer.toString(s.getSectionID()))) {
	          			
	          				
	          			projectIDField.setText(pi.getProjectID());
        					
	          			handsField.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
	          					//projectIDField.setCellValueFactory(new PropertyValueFactory<>("projectID"));
	          					sectionField.setCellValueFactory(new PropertyValueFactory<>("section"));
	          					itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
	          					itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
	          					itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
	          					itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
	          					woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
	          					quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	          					color.setCellValueFactory(new PropertyValueFactory<>("color"));
	          					//handsField.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
	          					
	          					//String imageSTR = CarpentryLogic.getInstance().GetImage(p);
	      						
	      							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),pi.getSectionID());
	      							arraylistToShow.add(pdtsToArray);
	      				
	      						
	      						
	          					
	          					
	          					
	                  		}
	          			}
	          			
	          		//}
	          	
	          	}// end of section loop
	   
	          
	          }// end of projects loop
	          }
	          ObservableList_CP.addAll(arraylistToShow);
	         
	          tableView.setItems(ObservableList_CP);

	          
	      }
	    @FXML
	    void CheckIfDelete(ActionEvent event) throws NumberFormatException, SQLException {
	    	
	    	if(adddeleteitem.getSelectionModel().getSelectedItem().equals("Delete")) {
	    	    tableView.setEditable(false);
	    		itemHeightField.setDisable(true);
	    		itemNameField.setDisable(true);
	    		itemQuantity.setDisable(true);
	    		itemWidthField.setDisable(true);
	    		axleQuantity.setDisable(true);
	    		handsQuantity.setDisable(true);
	    		colorField.setDisable(true);
	    		handsModelNumber.setDisable(true);
	    		projectSection.setDisable(true);
	    		woodTypeField.setDisable(true);
	    		brzolDegree.setDisable(true);
	    		newSection.setDisable(true);
	    		ComboBoxObject.setDisable(false);
	    	}
	    	if(adddeleteitem.getSelectionModel().getSelectedItem().equals("Edit")) {
	    		itemHeightField.setDisable(true);
	    		itemNameField.setDisable(true);
	    		itemQuantity.setDisable(true);
	    		itemWidthField.setDisable(true);
	    		axleQuantity.setDisable(true);
	    		handsQuantity.setDisable(true);
	    		colorField.setDisable(true);
	    		handsModelNumber.setDisable(true);
	    		projectSection.setDisable(true);
	    		woodTypeField.setDisable(true);
	    		brzolDegree.setDisable(true);
	    		newSection.setDisable(true);
		    tableView.setEditable(true);
		     quantity.setCellFactory(TextFieldTableCell.forTableColumn());
		     sectionField.setCellFactory(TextFieldTableCell.forTableColumn());
		   //  color.setCellFactory(TextFieldTableCell.forTableColumn());
		     itemHeight.setCellFactory(TextFieldTableCell.forTableColumn());
		     itemName.setCellFactory(TextFieldTableCell.forTableColumn());
		     itemWidth.setCellFactory(TextFieldTableCell.forTableColumn());
		     //woodType.setCellFactory(TextFieldTableCell.forTableColumn());
		     

		     ObservableList<String> woodTypes = FXCollections.observableArrayList(
		    		    "Mdf", "Melamine", "Particleboard", "Sandwich","Solid_Wood"
		    		);
		     woodType.setCellFactory(ComboBoxTableCell.forTableColumn(woodTypes));
		  
	    	
	    	   ObservableList<String> handsField1 = FXCollections.observableArrayList(
	    			   "a17","f120","gh32","r452","s125"
		    		);
		     handsField.setCellFactory(ComboBoxTableCell.forTableColumn(handsField1));
		     
//		     SectionColor.Aspen_Tan,SectionColor.Avocado,SectionColor.Beige_Gray,SectionColor.Black_Oak,SectionColor.Black_Walnut,SectionColor.Blueridge_Gray,SectionColor.Brick_Red,SectionColor.Caramel,SectionColor.Cedar_Naturaltone,SectionColor.Cinder,SectionColor.Cinnamon,SectionColor.Clove_Brown,SectionColor.Coffee,SectionColor.Dark_Mahogany,SectionColor.Dark_Oak,SectionColor.Dark_Tahoe,SectionColor.Desert_Sand,SectionColor.Drift_Gray,SectionColor.Ebony,SectionColor.Espresso,SectionColor.Ginger,SectionColor.Light_Mocha,SectionColor.Light_Oak,SectionColor.Mushroom,SectionColor.Naturaltone_Fir,SectionColor.Olive_Brown,SectionColor.Oxford_Brown,SectionColor.Pearl_Gray,SectionColor.Polar_Gray,SectionColor.Redwood,SectionColor.Redwood_Naturaltone,SectionColor.Rosewood,SectionColor.Russet,SectionColor.Sierra,SectionColor.Smoke_Blue,SectionColor.Storm_Gray,SectionColor.Teak,SectionColor.Tobacco,SectionColor.Walnut,SectionColor.Weathered_Barnboard);
//				colorField.getItems().addAll(section_Colors);
	    	
		     ObservableList<String> colors = FXCollections.observableArrayList(  "Aspen_Tan","Avocado","Beige_Gray","Black_Oak","Black_Walnut","Blueridge_Gray","Brick_Red","Caramel","Cedar_Naturaltone","Cinder","Cinnamon","Clove_Brown","Coffee","Dark_Mahogany","Dark_Oak","Dark_Tahoe","Desert_Sand","Drift_Gray","Ebony","Espresso","Ginger","Light_Mocha","Light_Oak","Mushroom","Naturaltone_Fir","Olive_Brown","Oxford_Brown","Pearl_Gray","Polar_Gray","Redwood","Redwood_Naturaltone","Rosewood","Russet","Sierra","Smoke_Blue","Storm_Gray","Teak","Tobacco","Walnut","Weathered_Barnboard");
			
		     color.setCellFactory(ComboBoxTableCell.forTableColumn(colors));
		    	
		  
	    	}
		     if(adddeleteitem.getSelectionModel().getSelectedItem().equals("Add")) {
		    	    tableView.setEditable(false);
		    	 itemHeightField.setDisable(false);
		 		itemNameField.setDisable(false);
		 		itemQuantity.setDisable(false);
		 		itemWidthField.setDisable(false);
		 		colorField.setDisable(false);
		 		handsModelNumber.setDisable(false);
		 		woodTypeField.setDisable(false);
		 		newSection.setDisable(false);
		     }
		         	
	    }
	    
	    @FXML
	    void callFunction(MouseEvent event) {
	    	for(ProjectItems pi: CarpentryLogic.getInstance().getProjectItems()) {
				if(Integer.toString(pi.getItemID()).equals(tableView.getSelectionModel().getSelectedItem().getItemID())) {
						quantity.setOnEditCommit(e -> {
					    String newValue = e.getNewValue();
					    System.out.println(newValue);
					    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
					    try {
							CarpentryLogic.getInstance().updateItemQuantity(pi,Integer.parseInt(e.getNewValue()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    e.getRowValue().setQuantity(newValue);
					});
						woodType.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateWoodType(pi, newValue);
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setWoodType(newValue);
						});
						color.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateItemColor(pi, newValue);
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setColor(newValue);
						});
						handsField.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateModelOfHands(pi, newValue);
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setModelNumberOFhands(newValue);
						});
						
						
						itemHeight.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateItemHeight(pi,Integer.parseInt(e.getNewValue()));
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setItemHeight(newValue);
						});
						
						itemName.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateItemName(pi,e.getNewValue());
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setItemName(newValue);
						});
						
						itemWidth.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateItemWidth(pi,Integer.parseInt(e.getNewValue()));
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setItemWidth(newValue);
						});
						
					}
					
				

		     }
	    }
	    
	    @FXML
	    void showProjectImage(ActionEvent event) throws IOException {
		 Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectImage.fxml"));
			Scene scene = new Scene(pane);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Awni Wood Work - Project Image");
			stage.show();
	    }
	    
	    @FXML
	    void GetProjectReport(ActionEvent event) {

	    	Document document = new Document();
	        try {
	            PdfWriter.getInstance(document, new FileOutputStream("Project_Report.pdf"));
	            document.open();
	            ObservableList<TableColumn<ProjectDetailsToShowNonStatic, ?>> columns = tableView.getColumns();
	            ObservableList<ProjectDetailsToShowNonStatic> items = tableView.getItems();
	            for (ProjectDetailsToShowNonStatic item : items) {
	                StringBuilder row = new StringBuilder();
	                for (TableColumn<ProjectDetailsToShowNonStatic, ?> column : columns) {
	                    String cellValue = column.getCellData(item).toString();
	                    row.append(cellValue).append(" ");
	                }
	                document.add(new Paragraph(row.toString()));
	            }
	        } catch (DocumentException | FileNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            document.close();
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
			
			ProjectDetailsToShow pdts = CurrentProjectsController.getPdts();
			System.out.println(pdts.getProjectID());
	        
			
			color.setCellValueFactory(new PropertyValueFactory<>("color"));
			itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
			itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
			itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
			itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
			quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
			sectionField.setCellValueFactory(new PropertyValueFactory<>("section"));
			handsField.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
		    
			
			ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
			ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
			for (Project p : CarpentryLogic.getInstance().getProjects()) {
				for (ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
					
					if (Integer.toString(p.getProjectID()).equals(pi.getProjectID())) {
						ProjectDetailsToShowNonStatic cp = new ProjectDetailsToShowNonStatic(p.getCustomerID(),
								Integer.toString(p.getProjectID()), p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName() ,Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),pi.getSectionID());
						
						arraylistToShow.add(cp);
					

					}
				}
			}
			ObservableList_CP.addAll(arraylistToShow);
//	        orders.addAll(arraylistProject);
//	        orders.addAll(arraylistProjectItems);

			tableView.setItems(ObservableList_CP);
	        
			ObservableList<String> Object = FXCollections.observableArrayList("Project","Section","Item");
			ComboBoxObject.getItems().addAll(Object);
			ComboBoxObject.setDisable(true);
			itemHeightField.setDisable(true);
			itemNameField.setDisable(true);
			itemQuantity.setDisable(true);
			itemWidthField.setDisable(true);
			axleQuantity.setDisable(true);
			handsQuantity.setDisable(true);
			colorField.setDisable(true);
			handsModelNumber.setDisable(true);
			projectSection.setDisable(true);
			woodTypeField.setDisable(true);
			brzolDegree.setDisable(true);
			newSection.setDisable(true);
	        
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