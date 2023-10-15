package Controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.BaseColor;
import Enumeration.AxleDegree;
import Enumeration.ProjectSection;
import Enumeration.SectionColor;
import Enumeration.handType;
import Model.Customer;
import Model.Hands;
import Model.Axles;
import Model.WoodType;
import Model.Project;
import Model.ProjectDetailsToShow;
import Model.ProjectDetailsToShowNonStatic;
import Model.ProjectItems;
import Model.Section;
import Model.Stock;
import Model.BackgroundColorEvent;
import Model.BackgroundColorEvent2;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ProjectDetailsToShowController implements Initializable{

	

    @FXML
    private ComboBox<String> ComboBoxObject;

    @FXML
    private ComboBox<Integer> month;
    @FXML
    private Button reportByMonth;
    @FXML
    private ComboBox<String> adddeleteitem;

    @FXML
    private TextField axleQuantity;

    @FXML
    private ComboBox<Axles> brzolDegree;

    @FXML
    private TextField ProjectPrice;
    @FXML
    private ComboBox<SectionColor> colorField;


    @FXML
    private ComboBox<Hands> handsModelNumber;

    @FXML
    private TextField handsQuantity;


    @FXML
    private TextField itemHeightField;


    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemQuantity;

    

    @FXML
    private TextField itemWidthField,itemDepthField;

    @FXML
    private CheckBox newSection;

    @FXML
    private ImageView loading;

    @FXML
    private ComboBox<ProjectSection> projectSection;


    @FXML
    private Button image,submit,reportButton;

    @FXML
    private ComboBox<WoodType> woodTypeField;
    @FXML
    private Button Settings,GenerateByAI,NewProject,Stock,Projects,Email,BackButton;
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
    private TableColumn<ProjectDetailsToShowNonStatic, String> itemWidth,itemDepth;

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
    private TextField projectCategoryField,projectIDField,customerNameField,phoneNumber;
    
    @FXML
    private ImageView projectImage;


	@FXML
    void MoveTo(MouseEvent event) throws IOException {
    	
    	for(Button b: Buttons) {
    		if(b.isPressed()) {
    		
    			switch(b.getId()) {
    		
    			case "Email":{
    				Parent pane = FXMLLoader.load(getClass().getResource("/View/Email.fxml"));
    				Scene scene = new Scene(pane);
    				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    				stage.setScene(scene);
    				stage.setResizable(false);
    				stage.setTitle("Awni Wood Work - Email");
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
	    		
	    		case "Projects":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/Projects.fxml"));
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
        					ProjectPrice.setText(Integer.toString(p.getPrice()));
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
        					itemDepth.setCellValueFactory(new PropertyValueFactory<>("itemDepth"));
        					woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
        					quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        					color.setCellValueFactory(new PropertyValueFactory<>("color"));
        					
        					
    							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),pi.getSectionID(),Integer.toString(pi.getDepth()));
    							
    							arraylistToShow.add(pdtsToArray);
    						
    						
        					
                		}
        			
        			else {
        				projectCategoryField.setText(p.getProjectCategory());
    					projectIDField.setText(Integer.toString(p.getProjectID()));
    					customerNameField.setText(p.getCustomerID());
    					ProjectPrice.setText(Integer.toString(p.getPrice()));
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
	    void SubmitProjectDetails(ActionEvent event) throws SQLException, IOException {

	    	if(tableView.getSelectionModel().getSelectedItem()== null && !newSection.isSelected()) {
				 JOptionPane.showMessageDialog(null, "Please select an item before submiting.", "A project reminder", JOptionPane.WARNING_MESSAGE);
			}
	    	else {
	    	switch(adddeleteitem.getSelectionModel().getSelectedItem()) {
	    	
	    	case "Add":{
	    		if(itemNameField.getText() !="" && itemHeightField.getText() !="" && itemWidthField.getText() != "" && itemDepthField.getText() !="" && woodTypeField.getSelectionModel().getSelectedItem() != null
	    				 && itemQuantity.getText()!= ""  
	    				 && colorField.getSelectionModel().getSelectedItem() != null && handsModelNumber.getSelectionModel().getSelectedItem()!= null) {
	    			
	    			
	    			if(newSection.isSelected()) {
	    				
	    			ProjectItems pi = new ProjectItems();
	    			pi.setItemName(itemNameField.getText());
	    			pi.setHeight(Integer.parseInt(itemHeightField.getText()));
	    			pi.setWidth(Integer.parseInt(itemWidthField.getText()));
	    			pi.setDepth(Integer.parseInt(itemDepthField.getText()));
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
	    			    	CarpentryLogic.getInstance().updateItemSectionID(pi, s.getSectionID());
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
	    		        	javafx.scene.image.Image loadingImage = new  javafx.scene.image.Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\737.gif");
	    		        	loading.setImage(loadingImage);

	    		            Task<Void> task = new Task<Void>() {
	    		                @Override
	    		                protected Void call() throws Exception {
	    		                    Process p = null;
	    		                    try {
	    		                    	
	    		                    	if(projectSection.getSelectionModel().getSelectedItem().toString().equals("Room")) {
	    		                    		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : Full bedroom that includes bed and desk, closet with a mirror in" + pi.getColor());
	    		                            p = pb.start();
	    		                    	}
	    		                    	
	    		                    	else if(projectSection.getSelectionModel().getSelectedItem().toString().equals("Kitchen")) {
	    		                    		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : Kitchen that includes island in" + pi.getColor());
	    		                            p = pb.start();
	    		                    	}
	    		                    	
	    		                    	else if(projectSection.getSelectionModel().getSelectedItem().toString().equals("LivingRoom")) {
	    		                    		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : LivingRoom that includes TV furniture and a salon table in" + pi.getColor());
	    		                            p = pb.start();
	    		                    	}
	    		                    	
	    		                    	else if(projectSection.getSelectionModel().getSelectedItem().toString().equals("Bathroom")) {
	    		                    		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : Bathroom that includes sink cabinets with a mirror in" + pi.getColor());
	    		                            p = pb.start();
	    		                    	}
	    		                    		

	    		                        // Read output
	    		                        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    		                        String output;
	    		                        while ((output = in.readLine()) != null) {
	    		                            System.out.println(output);
	    		                        }

	    		                        // Read any errors from the attempted command
	    		                        BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	    		                        String error;
	    		                        while ((error = err.readLine()) != null) {
	    		                            System.err.println(error);
	    		                        }

	    		                        p.waitFor();
	    		                    } catch (IOException e) {
	    		                        e.printStackTrace();
	    		                    }

	    		                    Platform.runLater(() -> {
	    		                        try {
	    		                            loading.setImage(null);  // Set loading image to null

	    		                            // Open new Scene
	    		                            try {
	    		                            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AI_Auto.fxml"));
	    		                        	    Parent root = loader.load();
	    		                        	    int myData=0;
	    		                        	    // Get the controller of the second scene
	    		                        	    switch(s.getSectionName()) {
	    		                        	    
	    		                        	    case "Kitchen":{
	    		                        	    	myData = 1;
	    		                        	    	break;
	    		                        	    }
	    		                        	    
	    		                        	    case "Room":{
	    		                        	    	myData = 2;
	    		                        	    	break;
	    		                        	    }
	    		                        	    
	    		                        	    case "LivingRoom":{
	    		                        	    	myData = 3;
	    		                        	    	break;
	    		                        	    }
	    		                        	    
	    		                        	    case "Bathroom":{
	    		                        	    	myData = 4;
	    		                        	    	break;
	    		                        	    }
	    		                        	    }
	    		                        	    //String myData = Integer.toString(GlobalProjectID.getId());
	    		                        	    AIAutoController controller = loader.getController();
	    		                        	    
	    		                        	    // Send data
	    		                        	    
	    		                        	    
	    		                        	    controller.setData(myData,projectIDField.getText().toString());

	    		                        	    Scene scene = new Scene(root);
	    		                        	    Stage stage3 = new Stage();
	    		                        	    stage3.setScene(scene);
	    		                        	    stage3.show();
	    		                                
	    		                                
	    		                            } catch (IOException e) {
	    		                                e.printStackTrace();
	    		                            }

	    		                            // Do the same for other ImageViews...
	    		                        } catch (Exception e) {
	    		                            e.printStackTrace();
	    		                        }
	    		                    });

	    		                    return null;
	    		                }
	    		            };

	    		            new Thread(task).start();
	    		            
	    		        	colorField.setValue(null);
	    		        	//projectSection.setValue(null);
	    		        	brzolDegree.setValue(null);
	    		        	handsModelNumber.setValue(null);
	    		        	handsQuantity.setText(null);
	    		        	axleQuantity.setText(null);
	    		        	itemNameField.setText(null);
	    		        	itemHeightField.setText(null);
	    		        	itemWidthField.setText(null);
	    		        	itemDepthField.setText(null);
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
	        			pi2.setDepth(Integer.parseInt(itemDepthField.getText()));
	        			pi2.setWoodType(woodTypeField.getSelectionModel().getSelectedItem().toString());
	        			pi2.setQuantity(Integer.parseInt(itemQuantity.getText()));
	        			pi2.setProjectID(projectIDField.getText().toString());
	        			pi2.setSection(tableView.getSelectionModel().getSelectedItem().getSection());
	        			pi2.setColor(colorField.getSelectionModel().getSelectedItem().toString());
	        			pi2.setHandsmodel(handsModelNumber.getSelectionModel().getSelectedItem().toString());
	        			pi2.setSectionID(tableView.getSelectionModel().getSelectedItem().getSectionID());
	        			CarpentryLogic.getInstance().addProjectItems(pi2);
	        			int sID = Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getSectionID());
	        			CarpentryLogic.getInstance().updateItemSectionID(pi2, sID);
	        			colorField.setValue(null);
    		        	projectSection.setValue(null);
    		        	brzolDegree.setValue(null);	
    		        	handsQuantity.setText(null);
    		        	axleQuantity.setText(null);
    		        	itemNameField.setText(null);
    		        	itemHeightField.setText(null);
    		        	itemWidthField.setText(null);
    		        	itemDepthField.setText(null);
    		        	itemQuantity.setText(null);
	        			ShowProjectDetails();
	    				}
	    			}
	    		}
	
	    		for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    			if(Integer.toString(p.getProjectID()).equals(projectIDField.getText())) {
	    				ProjectPrice.setText(Integer.toString(p.getPrice()));
	    			}
	    		}
	    		
	    		break;
	    	
	    	}
	    	case "Edit":{
	    	     
	    	break;
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
	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectCost.fxml"));
	    	 	    Parent root = loader.load();
	    	 		ProjectCostController controller = loader.getController();
	    	 	    
	    	 	    // Send data
	    	 	    
	    	 	   
	    	 	    controller.setData(Integer.parseInt(projectIDField.getText()));

	    	 	    Scene scene = new Scene(root);
	    	 	    Stage stage3 = new Stage();
	    	 	    stage3.setScene(scene);
	    	 	    stage3.show();
	    			break;
	    		}
	    		
	    		case "Section":{
	    			DeleteSection();
	    			ShowProjectDetails();
	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectCost.fxml"));
	    	 	    Parent root = loader.load();
	    	 		ProjectCostController controller = loader.getController();
	    	 	    
	    	 	    // Send data
	    	 	    
	    	 	   
	    	 	    controller.setData(Integer.parseInt(projectIDField.getText()));

	    	 	    Scene scene = new Scene(root);
	    	 	    Stage stage3 = new Stage();
	    	 	    stage3.setScene(scene);
	    	 	    stage3.show();
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
	    	String sectionName="",sectionProjectID="";
	    	for(Section s : CarpentryLogic.getInstance().getSections()) {
				if(sectionId.equals(Integer.toString(s.getSectionID()))) {
					 sectionName = s.getSectionName();
					 sectionProjectID= s.getProjectID();
					CarpentryLogic.getInstance().DeleteSection(s);
				}
												
			}
	    	
	    	for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    		if(Integer.toString(p.getProjectID()).equals(sectionProjectID)) {
	    			if(sectionName.equals("Kitchen")) {
	    				CarpentryLogic.getInstance().DeleteSectionImage1(p);
	    			}
	    			
	    			else if(sectionName.equals("Room")) {
	    				CarpentryLogic.getInstance().DeleteSectionImage2(p);
	    			}
	    			
	    			else if(sectionName.equals("LivingRoom")) {
	    				CarpentryLogic.getInstance().DeleteSectionImage3(p);
	    			}
	    			
	    			else if(sectionName.equals("Bathroom")) {
	    				CarpentryLogic.getInstance().DeleteSectionImage4(p);
	    			}
	    			
	    		}
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
	    	
	      	ObservableList<ProjectDetailsToShowNonStatic> ObservableList_CP = FXCollections.observableArrayList();
	      	ObservableList_CP.clear();
	          ArrayList<ProjectDetailsToShowNonStatic> arraylistToShow = new ArrayList<>();
	          
	          for(Project p : CarpentryLogic.getInstance().getProjects()) {
	          		for(Section s : CarpentryLogic.getInstance().getSections()) {
	          		if(s.getProjectID().equals(projectIDField.getText().toString()) && s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
	          			for(ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
	          				
	          			if(pi.getSectionID().equals(Integer.toString(s.getSectionID()))) {
	          			
	          				
	          			projectIDField.setText(pi.getProjectID());
	          			ProjectPrice.setText(Integer.toString(p.getPrice()));
	          			handsField.setCellValueFactory(new PropertyValueFactory<>("modelNumberOFhands"));
	          					//projectIDField.setCellValueFactory(new PropertyValueFactory<>("projectID"));
	          					sectionField.setCellValueFactory(new PropertyValueFactory<>("section"));
	          					itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
	          					itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
	          					itemHeight.setCellValueFactory(new PropertyValueFactory<>("itemHeight"));
	          					itemWidth.setCellValueFactory(new PropertyValueFactory<>("itemWidth"));
	          					itemDepth.setCellValueFactory(new PropertyValueFactory<>("itemDepth"));
	          					woodType.setCellValueFactory(new PropertyValueFactory<>("woodType"));
	          					quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	          					color.setCellValueFactory(new PropertyValueFactory<>("color"));
	      							ProjectDetailsToShowNonStatic pdtsToArray = new ProjectDetailsToShowNonStatic(p.getCustomerID(),pi.getProjectID(),p.getProjectCategory(),Integer.toString(pi.getItemID()),pi.getItemName(),Integer.toString(pi.getHeight()),Integer.toString(pi.getWidth()),pi.getWoodType(),Integer.toString(pi.getQuantity()),pi.getSection(),pi.getColor(),pi.getHandsmodel(),pi.getSectionID(),Integer.toString(pi.getDepth()));
	      							arraylistToShow.add(pdtsToArray);
	      				
	                  		}
	          			}
	          	
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
	    		itemDepthField.setDisable(true);
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
	    		itemDepthField.setDisable(true);
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
		     itemHeight.setCellFactory(TextFieldTableCell.forTableColumn());
		     itemName.setCellFactory(TextFieldTableCell.forTableColumn());
		     itemWidth.setCellFactory(TextFieldTableCell.forTableColumn());
		     itemDepth.setCellFactory(TextFieldTableCell.forTableColumn());
		     
		     ObservableList<String> woodTypes = FXCollections.observableArrayList(
		    		    "Mdf", "Melamine", "Particleboard", "Sandwich","Solid_Wood"
		    		);
		     woodType.setCellFactory(ComboBoxTableCell.forTableColumn(woodTypes));
		  
	    	
	    	   ObservableList<String> handsField1 = FXCollections.observableArrayList(
	    			   "a17","f120","gh32","r452","s125"
		    		);
		     handsField.setCellFactory(ComboBoxTableCell.forTableColumn(handsField1));
		     ObservableList<String> colors = FXCollections.observableArrayList(  "Aspen_Tan","Avocado","Beige_Gray","Black_Oak","Black_Walnut","Blueridge_Gray","Brick_Red","Caramel","Cedar_Naturaltone","Cinder","Cinnamon","Clove_Brown","Coffee","Dark_Mahogany","Dark_Oak","Dark_Tahoe","Desert_Sand","Drift_Gray","Ebony","Espresso","Ginger","Light_Mocha","Light_Oak","Mushroom","Naturaltone_Fir","Olive_Brown","Oxford_Brown","Pearl_Gray","Polar_Gray","Redwood","Redwood_Naturaltone","Rosewood","Russet","Sierra","Smoke_Blue","Storm_Gray","Teak","Tobacco","Walnut","Weathered_Barnboard");
			
		     color.setCellFactory(ComboBoxTableCell.forTableColumn(colors));
		    	
		  
	    	}
		     if(adddeleteitem.getSelectionModel().getSelectedItem().equals("Add")) {
		    	    tableView.setEditable(false);
		    	 itemHeightField.setDisable(false);
		 		itemNameField.setDisable(false);
		 		itemQuantity.setDisable(false);
		 		itemWidthField.setDisable(false);
		 		itemDepthField.setDisable(false);
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
						
						itemDepth.setOnEditCommit(e -> {
						    String newValue = e.getNewValue();
						    System.out.println(newValue);
						    //if( !Integer.toString(pi.getQuantity()).equals(e.getNewValue())) {
						    try {
								CarpentryLogic.getInstance().updateItemDepth(pi,Integer.parseInt(e.getNewValue()));
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						    e.getRowValue().setItemDepth(newValue);
						});
						
					}
					
				

		     }
	    	}
	    
	    private PdfPCell getCenterAlignedCell(String content, Font font) {
	        PdfPCell cell = new PdfPCell(new Phrase(content, font));
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        return cell;
	    }

	    
	    @FXML
	    void GetProjectReportByMonth(ActionEvent event) {



	    	Document document = new Document();

	    	String desktopPath="";

	    	PdfWriter writer = null;

	    	try {

	    	    desktopPath = System.getProperty("user.home") + "/Downloads/Project_Report.pdf";

	    	    writer= PdfWriter.getInstance(document, new FileOutputStream(desktopPath));

	    	    writer.setPageEvent(new BackgroundColorEvent2());

	    	    document.open();

	    	    ArrayList <Project> projectsList = new ArrayList<>();

	    	  
	    	    

	    	    for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    	    	if(Integer.toString(p.getDate().getMonth()+1).equals(month.getSelectionModel().getSelectedItem().toString()))  {
	    	    		
	    	    		projectsList.add(p);
	    	    	}

	    	    }

	    	    // 1. Bold center title "Project Report"

	    	    Font titleFont = new Font(Font.FontFamily.HELVETICA, 32, Font.BOLD);

	    	    Paragraph title = new Paragraph("Project Report", titleFont);

	    	    title.setAlignment(Element.ALIGN_CENTER);

	    	    title.setSpacingAfter(10);

	    	    document.add(title);



	    	    // 2. The date the report was created

	    	    String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

	    	    Paragraph dateParagraph = new Paragraph("Report Date: " + currentDate);

	    	    dateParagraph.setSpacingAfter(10);

	    	    document.add(dateParagraph);



	    	    

	    	    // The rest of your table generation code...

	    	    PdfPTable table = new PdfPTable(8);

	    	    table.setWidthPercentage(108);

	    	    Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

	    	    PdfPCell headerCell1 = new PdfPCell(new Phrase("Project ID", boldFont));
    	        headerCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell1);
	    	    
    	        PdfPCell headerCell2 = new PdfPCell(new Phrase("Customer Name", boldFont));
    	        headerCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell2);
    	        
    	        PdfPCell headerCell3 = new PdfPCell(new Phrase("Project Category", boldFont));
    	        headerCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell3);
    	        
    	        
    	        PdfPCell headerCell5 = new PdfPCell(new Phrase("Project Status", boldFont));
    	        headerCell5.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell5);
    	        
    	        PdfPCell headerCell6 = new PdfPCell(new Phrase("Project Cost", boldFont));
    	        headerCell6.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell6);
    	        
    	        PdfPCell headerCell7 = new PdfPCell(new Phrase("Project Price", boldFont));
    	        headerCell7.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell7);
    	        
    	        PdfPCell headerCell8 = new PdfPCell(new Phrase("Project Date", boldFont));
    	        headerCell8.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell8);
    	        
    	        PdfPCell headerCell9 = new PdfPCell(new Phrase("Phone Number", boldFont));
    	        headerCell9.setHorizontalAlignment(Element.ALIGN_CENTER);
    	        table.addCell(headerCell9);
    	        
    	        for (Project project : projectsList) {
    	            table.addCell(getCenterAlignedCell(Integer.toString(project.getProjectID()), boldFont));
    	            table.addCell(getCenterAlignedCell(project.getCustomerID(), boldFont));
    	            table.addCell(getCenterAlignedCell(project.getProjectCategory(), boldFont));
    	            table.addCell(getCenterAlignedCell(project.getStatus(), boldFont));
    	            table.addCell(getCenterAlignedCell(Integer.toString(project.getCost()), boldFont));
    	            table.addCell(getCenterAlignedCell(Integer.toString(project.getPrice()), boldFont));
    	            table.addCell(getCenterAlignedCell(project.getDate().toString(), boldFont));
    	            table.addCell(getCenterAlignedCell(project.getPhoneNumber(), boldFont));
    	        }

    	        
    	        document.add(table);


    	        int totalCost=0, totalPrice=0, revenue=0;

        	    for(Project p : projectsList) {

        	    	totalCost+=p.getCost();

        	    	totalPrice=p.getPrice();

        	    }

        	    revenue= totalPrice-totalCost;

        	    

        	    Paragraph monthRevenueParagraph = new Paragraph("Month revenue: " + revenue);

        	    monthRevenueParagraph.setSpacingAfter(20);  // Add some spacing after this before the table

        	    document.add(monthRevenueParagraph);
	    	} catch (DocumentException | FileNotFoundException e) {

	    	    e.printStackTrace();

	    	} finally {

	    	    document.close();

	    	    try {

	    	        if (Desktop.isDesktopSupported()) {

	    	            Desktop.getDesktop().open(new File(desktopPath));

	    	        }

	    	    } catch (IOException e) {

	    	        e.printStackTrace();

	    	    }



	    	}



	    

	}
	    @FXML
	    void showProjectImage(ActionEvent event) throws IOException {
	    	
	    	// Load the FXML and get the controller
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectImage.fxml"));
	    	
	    	Parent pane = loader.load();
	    	// Set the data on the controller
	    	ProjectImageController controller = loader.getController();
	    	
	    	for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    		if(Integer.toString(p.getProjectID()).equals(projectIDField.getText())) {
	    			String image1,image2,image3,image4;
	    			String imagePath1,imagePath2,imagePath3,imagePath4;
	    			image1=CarpentryLogic.getInstance().GetImage1(p);
	    			image2=CarpentryLogic.getInstance().GetImage2(p);
	    			image3=CarpentryLogic.getInstance().GetImage3(p);
	    			image4=CarpentryLogic.getInstance().GetImage4(p);
	    			if(image1==null)
	    				 imagePath1="";
	    			else imagePath1=image1;
	    			
	    			if(image2==null)
	    				 imagePath2="";
	    			else imagePath2=image2;
	    			
	    			if(image3==null)
	    				 imagePath3="";
	    			else imagePath3=image3;
	    			
	    			if(image4==null)
	    				 imagePath4="";
	    			else imagePath4=image4;
	    			
	    			controller.setData(imagePath1,imagePath2,imagePath3,imagePath4);  // Replace 'Your String Data Here' with the actual data you want to send
	    	    	
	    		}
	    	}
	    	
	    	// Create the scene and show it in a new stage
	    	Scene scene = new Scene(pane);
	    	Stage newStage = new Stage();  // Create a new stage for the new scene
	    	newStage.setScene(scene);
	    	newStage.setResizable(false);
	    	newStage.setTitle("Awni Wood Work - Project Image");
	    	newStage.show();

	    }
	    
	    @FXML
	    void GetProjectReport(ActionEvent event) throws MalformedURLException, IOException {

	    	Document document = new Document();
	    	String desktopPath="";
	    	PdfWriter writer = null;
	    	try {
	    	    desktopPath = System.getProperty("user.home") + "/Downloads/Project_Details_Report.pdf";
	    	    writer= PdfWriter.getInstance(document, new FileOutputStream(desktopPath));
	    	    writer.setPageEvent(new BackgroundColorEvent());
	    	    document.open();

	    	    ProjectDetailsToShow pdts = ProjectsToShowController.getPdts();
	    	    String projectID="";
	    	    
	    	    for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    	    	if(Integer.toString(p.getProjectID()).equals(pdts.getProjectID())) {
	    	    		projectID=pdts.getProjectID();
	    	    	}
	    	    }
	    	    // 1. Bold center title "Project Report"
	    	    Font titleFont = new Font(Font.FontFamily.HELVETICA, 32, Font.BOLD);
	    	    Paragraph title = new Paragraph("Project Details Report", titleFont);
	    	    title.setAlignment(Element.ALIGN_CENTER);
	    	    title.setSpacingAfter(10);
	    	    document.add(title);

	    	    // 2. The date the report was created
	    	    String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	    	    Paragraph dateParagraph = new Paragraph("Report Date: " + currentDate);
	    	    dateParagraph.setSpacingAfter(10);
	    	    document.add(dateParagraph);

	    	    // 3. Customer name
	    	    String customerName="";
	    	    String customerPhoneNumber="";
	    	    String projectCost="";
	    	    Date projectDate = null;
	    	    String projectStatus="";
	    	    String customerAddress="";
	    	    String customerEmail="";
	    	    String projectCategory="";
	    	    String projectNotes="";
	    	    String image1Path="",image2Path="",image3Path="",image4Path="";
	    	    
	    	    for(Project p : CarpentryLogic.getInstance().getProjects()) {
	    	    	for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
	    	    		if(p.getCustomerID().equals(c.getName()) && Integer.toString(p.getProjectID()).equals(projectID)) {
	    	    			customerName=c.getName();
	    	    			customerPhoneNumber=c.getPhoneNUMBER();
	    	    			projectCost=Integer.toString(p.getPrice());
	    	    			projectDate=p.getDate();
	    	    			projectStatus=p.getStatus();
	    	    			customerAddress=c.getAddress();
	    	    			customerEmail=c.getEmail();
	    	    			projectCategory=p.getProjectCategory();
	    	    			projectNotes=p.getNotes();
	    	    		}
	    	    	}
	    	    }
	    	    
	    	    Paragraph customerNameParagraph = new Paragraph("Customer Name: " + customerName);
	    	    document.add(customerNameParagraph);

	    	    // 4. Customer phone number
	    	    
	    	    Paragraph customerPhoneParagraph = new Paragraph("Customer Phone Number: " + customerPhoneNumber);
	    	    document.add(customerPhoneParagraph);

	    	 // Customer address
	    	    Paragraph customerAddressParagraph = new Paragraph("Customer Address: " + customerAddress);
	    	    document.add(customerAddressParagraph);

	    	    // Customer email
	    	    Paragraph customerEmailParagraph = new Paragraph("Customer Email: " + customerEmail);
	    	    customerEmailParagraph.setSpacingAfter(10);
	    	    document.add(customerEmailParagraph);
	    	    
	    	    Paragraph projectIDParagraph = new Paragraph("Project ID: " + projectID);
	    	    document.add(projectIDParagraph);
	    	    
	    	    Paragraph projectCostParagraph = new Paragraph("Project Cost: " + projectCost);
	    	    document.add(projectCostParagraph);
	    	    
	    	    // 6. Project date
	    	    Paragraph projectDateParagraph = new Paragraph("Project Date: " + projectDate);
	    	    document.add(projectDateParagraph);

	    	    // 7. Project status
	    	    Paragraph projectStatusParagraph = new Paragraph("Project Status: " + projectStatus);
	    	  //  projectStatusParagraph.setSpacingAfter(20);  // Add some spacing after this before the table
	    	    document.add(projectStatusParagraph);
	    	    
	    	    // Project category
	    	    
	    	    Paragraph projectCategoryParagraph = new Paragraph("Project Category: " + projectCategory);
	    	    document.add(projectCategoryParagraph);

	    	    // Project notes
	    	  
	    	    Paragraph projectNotesParagraph = new Paragraph("Project Notes: " + projectNotes);
	    	    projectNotesParagraph.setSpacingAfter(20);  // Add some spacing after this before the table
	    	    document.add(projectNotesParagraph);


	    	    for(Project p : CarpentryLogic.getInstance().getProjects()) {
		    		if(Integer.toString(p.getProjectID()).equals(projectIDField.getText())) {
		    			 image1Path=CarpentryLogic.getInstance().GetImage1(p);
		    			 image2Path=CarpentryLogic.getInstance().GetImage2(p);
		    			 image3Path=CarpentryLogic.getInstance().GetImage3(p);
		    			 image4Path=CarpentryLogic.getInstance().GetImage4(p);
		    		}
		    	}
	    	    PdfPTable table = new PdfPTable(tableView.getColumns().size());
	    	    table.setWidthPercentage(100);
	    	    ObservableList<TableColumn<ProjectDetailsToShowNonStatic, ?>> columns = tableView.getColumns();
	    	    Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	    	    for (TableColumn<ProjectDetailsToShowNonStatic, ?> column : columns) {
	    	        String headerValue = column.getText();
	    	        PdfPCell headerCell = new PdfPCell(new Phrase(headerValue, boldFont));
	    	        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	        table.addCell(headerCell);
	    	    }
	    	    ObservableList<ProjectDetailsToShowNonStatic> items = tableView.getItems();
	    	    for (ProjectDetailsToShowNonStatic item : items) {
	    	        for (TableColumn<ProjectDetailsToShowNonStatic, ?> column : columns) {
	    	            String cellValue = column.getCellData(item).toString();
	    	            PdfPCell cell = new PdfPCell(new Phrase(cellValue));
	    	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	            table.addCell(cell);
	    	        }
	    	    }
	    	    document.add(table);
	    	    
	    	    try {
	    	    	
	    	    	if (image1Path != null) {
	    	            // Create an Image instance for image1
	    	    		com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(image1Path);
	    	            image1.setAbsolutePosition(45, 235); // x and y position
	    	            image1.scaleToFit(500, 500); // width and height

	    	            // Add a new page
	    	            document.newPage();

	    	            // Add a title or any other content before the image
	    	            Paragraph image1title = new Paragraph("Kitchen Image", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
	    	            image1title.setAlignment(Element.ALIGN_CENTER);
	    	            document.add(image1title);

	    	            // Add some spacing after the title if needed
	    	            document.add(new Paragraph("\n"));

	    	            // Add the image to the document
	    	            document.add(image1);
	    	        }
	    	    	
	    	    	if (image2Path != null) {
	    	            // Create an Image instance for image1
	    	    		com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance(image2Path);
	    	            image2.setAbsolutePosition(45, 235); // x and y position
	    	            image2.scaleToFit(500, 500); // width and height

	    	            // Add a new page
	    	            document.newPage();

	    	            // Add a title or any other content before the image
	    	            Paragraph image2title = new Paragraph("Room Image", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
	    	            image2title.setAlignment(Element.ALIGN_CENTER);
	    	            document.add(image2title);

	    	            // Add some spacing after the title if needed
	    	            document.add(new Paragraph("\n"));

	    	            // Add the image to the document
	    	            document.add(image2);
	    	        }
	    	    	
	    	    	if (image3Path != null) {
	    	            // Create an Image instance for image1
	    	    		com.itextpdf.text.Image image3 = com.itextpdf.text.Image.getInstance(image3Path);
	    	            image3.setAbsolutePosition(45, 235); // x and y position
	    	            image3.scaleToFit(500, 500); // width and height

	    	            // Add a new page
	    	            document.newPage();

	    	            // Add a title or any other content before the image
	    	            Paragraph image3title = new Paragraph("Livingroom Image", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
	    	            image3title.setAlignment(Element.ALIGN_CENTER);
	    	            document.add(image3title);

	    	            // Add some spacing after the title if needed
	    	            document.add(new Paragraph("\n"));

	    	            // Add the image to the document
	    	            document.add(image3);
	    	        }
	    	    	
	    	    	if (image4Path != null) {
	    	            // Create an Image instance for image1
	    	    		com.itextpdf.text.Image image4 = com.itextpdf.text.Image.getInstance(image4Path);
	    	            image4.setAbsolutePosition(45, 235); // x and y position
	    	            image4.scaleToFit(500, 500); // width and height

	    	            // Add a new page
	    	            document.newPage();

	    	            // Add a title or any other content before the image
	    	            Paragraph image4title = new Paragraph("Bathroom Image", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
	    	            image4title.setAlignment(Element.ALIGN_CENTER);
	    	            document.add(image4title);

	    	            // Add some spacing after the title if needed
	    	            document.add(new Paragraph("\n"));

	    	            // Add the image to the document
	    	            document.add(image4);
	    	        }
	    	        
	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	    }
	    	    // The rest of your table generation code...
	    	    
	    	} catch (DocumentException | FileNotFoundException e) {
	    	    e.printStackTrace();
	    	} finally {
	    	    document.close();
	    	    try {
	    	        if (Desktop.isDesktopSupported()) {
	    	            Desktop.getDesktop().open(new File(desktopPath));
	    	        }
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
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
	        
			ObservableList<String> Object = FXCollections.observableArrayList("Project","Section","Item");
			ComboBoxObject.getItems().addAll(Object);
			ComboBoxObject.setDisable(true);
			itemHeightField.setDisable(true);
			itemNameField.setDisable(true);
			itemQuantity.setDisable(true);
			itemWidthField.setDisable(true);
			itemDepthField.setDisable(true);
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
			
			ArrayList<WoodType> woodTypeArrayList = new ArrayList<>();
			for (WoodType c : CarpentryLogic.getInstance().getWoodType()) {
				woodTypeArrayList.add(c);
			}
			
			ObservableList<WoodType> woodTypeList = FXCollections.observableArrayList(woodTypeArrayList);
			woodTypeField.getItems().addAll(woodTypeList);
			
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
			
			
			ObservableList<Integer> months = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
			month.getItems().addAll(months);
			
			ObservableList<SectionColor> section_Colors = FXCollections.observableArrayList(SectionColor.Aspen_Tan,SectionColor.Avocado,SectionColor.Beige_Gray,SectionColor.Black_Oak,SectionColor.Black_Walnut,SectionColor.Blueridge_Gray,SectionColor.Brick_Red,SectionColor.Caramel,SectionColor.Cedar_Naturaltone,SectionColor.Cinder,SectionColor.Cinnamon,SectionColor.Clove_Brown,SectionColor.Coffee,SectionColor.Dark_Mahogany,SectionColor.Dark_Oak,SectionColor.Dark_Tahoe,SectionColor.Desert_Sand,SectionColor.Drift_Gray,SectionColor.Ebony,SectionColor.Espresso,SectionColor.Ginger,SectionColor.Light_Mocha,SectionColor.Light_Oak,SectionColor.Mushroom,SectionColor.Naturaltone_Fir,SectionColor.Olive_Brown,SectionColor.Oxford_Brown,SectionColor.Pearl_Gray,SectionColor.Polar_Gray,SectionColor.Redwood,SectionColor.Redwood_Naturaltone,SectionColor.Rosewood,SectionColor.Russet,SectionColor.Sierra,SectionColor.Smoke_Blue,SectionColor.Storm_Gray,SectionColor.Teak,SectionColor.Tobacco,SectionColor.Walnut,SectionColor.Weathered_Barnboard);
			colorField.getItems().addAll(section_Colors);
	       
		}

}