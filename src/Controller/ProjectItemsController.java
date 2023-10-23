package Controller;



import Model.Stock ;
import Model.Supplier;
import Model.GlobalProjectID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import java.util.ArrayList;


import Enumeration.AxleDegree;
import Enumeration.OrderStatus;
import Enumeration.ProjectCategory;
import Enumeration.SectionColor;
import Enumeration.handType;
import Model.Hands;
import Model.Axles;
import Model.Supplier;
import Model.Project;
import Model.ProjectDetailsToShow;
import Model.ProjectDetailsToShowNonStatic;
import Model.Section;
import Model.ProjectItems;
import Model.Customer;
import Model.WoodType;
import Model.OrderedMaterials;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.Properties;
public class ProjectItemsController implements Initializable{
	
	@FXML
    private Button Settings,GenerateByAI,ShowProjectDetails,BackButton,Projects,Email,NewProject,Stock,addItem,addSection,finish;
	
	private HashSet<Button> Buttons = new HashSet<Button>();
    
	 @FXML
	    private TextArea notes;
    @FXML
    private TextField suggestedPrice,orderStatus,ItemName,handsQuantity,axleQuantity,height,quantity,width,depth,CUSTOMERID,ORDERID,PROJECTID;

    @FXML
    private ComboBox<String> projectSection;
    
    @FXML
    private ComboBox<Hands> handsModelNumber;

    @FXML
    private ComboBox<Stock> woodType;
    
    @FXML
    private ImageView loading;
    
    @FXML
    private ComboBox<Axles> brzolDegree;
    
    @FXML
    private ComboBox<SectionColor> color;
    
    private String toAI="";
    private Section sec = new Section();
    private ProjectItems pi = new ProjectItems();
    
    private boolean sectionPressed = false;
    private int saveProjectID;
    
    private ArrayList<ProjectItems> PI_Array = new ArrayList<ProjectItems>();
    private  static ProjectDetailsToShow pdts;

	public static ProjectDetailsToShow getPdts() {
		return pdts;
	}

	public static void setPdts(ProjectDetailsToShow pdts) {
		ProjectItemsController.pdts = pdts;
	}
    
    @FXML
    void MoveTo(MouseEvent event) throws IOException {
    	// send to the order constructor String status by convert the enum to string
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

    
    
    
    @FXML
    void AddAnotherItem(MouseEvent event) throws IOException {

    	ProjectItems pi2 = new ProjectItems();

    	try {
    	    if (projectSection.getSelectionModel().getSelectedItem() == null ||
    	            ItemName.getText().isEmpty() ||
    	            height.getText().isEmpty() ||
    	            width.getText().isEmpty() || depth.getText().isEmpty() ||
    	            woodType.getSelectionModel().getSelectedItem() == null ||
    	            quantity.getText().isEmpty() ||
    	            color.getValue() == null || handsModelNumber.getSelectionModel().getSelectedItem() == null) 
    	            {

    	        throw new IllegalArgumentException("Please enter all required fields.");
    	    }
    	    pi2.setSection(projectSection.getSelectionModel().getSelectedItem().toString());
    	    pi2.setItemName(ItemName.getText());
    	    pi2.setHeight(Integer.parseInt(height.getText()));
    	    pi2.setWidth(Integer.parseInt(width.getText()));
    	    pi2.setDepth(Integer.parseInt(depth.getText()));
    	    pi2.setWoodType(woodType.getSelectionModel().getSelectedItem().toString());
    	    pi2.setQuantity(Integer.parseInt(quantity.getText()));
    	    
    	    boolean flagSupp=false;
    	    for(Supplier sp : CarpentryLogic.getInstance().getSupplier()) {
    	    	if(sp.getAutoOrder()==1)
    	    		flagSupp=true;
    	    }
    	    
    	    if(flagSupp) {
    	    	
    	    
    	    for(Stock s1: CarpentryLogic.getInstance().getStocks()) {
    	    	
    	    	if(s1.getWoodName().equals(pi2.getWoodType()) && pi2.getQuantity()> s1.getQuantity()) {
    	    		
    	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Supplier.fxml"));
    		    	
    		    	Parent pane = loader.load();
    		    	// Set the data on the controller
    		    	SuppliersController controller = loader.getController();
    		    	
    		    	
    		    	controller.setData(quantity.getText(),woodType.getSelectionModel().getSelectedItem().toString());  // Replace 'Your String Data Here' with the actual data you want to send
    		    	
    		    	
    		    	
    		    	// Create the scene and show it in a new stage
    		    	Scene scene = new Scene(pane);
    		    	Stage newStage = new Stage();  // Create a new stage for the new scene
    		    	newStage.setScene(scene);
    		    	newStage.setResizable(false);
    		    	newStage.setTitle("Awni Wood Work - Project Image");
    		    	newStage.show();
    	    
    	}
    	    	
    	    }}
    	    
    	    else {

	    		final Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	    alert.setTitle("Attention!");
	    	    alert.setContentText("Not enough wood in stock.");
	    	    //alert.setHeaderText(e.getMessage());
	    	    alert.showAndWait();
    	    }
    	    pi2.setColor(color.getValue().toString());
    	    pi2.setHandsmodel(handsModelNumber.getSelectionModel().getSelectedItem().toString());
    	    
    		Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            GlobalProjectID gpid = (GlobalProjectID) stage.getUserData();
            Integer i = gpid.getId();
        	String s = i.toString();
        	pi2.setProjectID(s);
        	saveProjectID=i;
        	
        	
        	CarpentryLogic.getInstance().addProjectItems(pi2);
        	PI_Array.add(pi2);
        	sectionPressed=true;
        	ItemName.setText(null);
        	height.setText(null);
        	width.setText(null);
        	depth.setText(null);
        	pdts.setSection(pi2.getSection());
        	
    	    // Rest of the code when all fields are valid
    	} catch (IllegalArgumentException e) {
    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setTitle("Error!");
    	    alert.setContentText("Press OK to try again.");
    	    alert.setHeaderText(e.getMessage());
    	    alert.showAndWait();
    	}
    }

    @FXML
    void AddSection(MouseEvent event) throws NumberFormatException, SQLException, IOException {
    	
    	if(sectionPressed) {
    	Section s = new Section();
    	try {
    	    if (projectSection.getSelectionModel().getSelectedItem() == null) {
    	      	 throw new IllegalArgumentException("Please enter all required fields.");
    	    }
    	 	s.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());
    	 	sec.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());

    	}catch (IllegalArgumentException e) {
    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setTitle("Error!");
    	    alert.setContentText("Press OK to try again.");
    	    alert.setHeaderText(e.getMessage());
    	    alert.showAndWait();
        }

    	//s.setSectionName(projectSection.getSelectionModel().getSelectedItem().toString());
    	Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        GlobalProjectID gpid = (GlobalProjectID) stage.getUserData();
        Integer i = gpid.getId();
    	String s3 = i.toString();
    	s.setProjectID(s3);
    	try {
    	    if (projectSection.getSelectionModel().getSelectedItem() == null || 
    	            handsQuantity.getText().equals("")|| 
    	            !handsQuantity.getText().matches(".*\\d+.*")
    	            || axleQuantity.getText().equals("")|| 
    	            !axleQuantity.getText().matches(".*\\d+.*")|| 
    	            brzolDegree.getSelectionModel().getSelectedItem()==null
    	|| handsModelNumber.getSelectionModel().getSelectedItem() == null)
    	            {
    	    	 		throw new IllegalArgumentException("Please enter all required fields.");
    	            }
	    	s.setQuantityOFhands(Integer.parseInt(handsQuantity.getText()));
	    	s.setQuantityOFaxle(Integer.parseInt(axleQuantity.getText()));
	    	s.setAxleDegree(brzolDegree.getSelectionModel().getSelectedItem().toString());
	    	
	    	CarpentryLogic.getInstance().addSection(s);
    	    
	    	for(ProjectItems piIndex : PI_Array) {
	    		if(Integer.toString(saveProjectID).equals(piIndex.getProjectID()))
	    			CarpentryLogic.getInstance().updateItemSectionID(piIndex, s.getSectionID());
	    	}
	    	
    	    switch(color.getSelectionModel().getSelectedItem().toString()) { // To send to the AI
    	  
    	    	case "Weathered_Barnboard","Pearl_Gray","Desert_Sand","Drift_Gray","Beige_Gray","Mushroom","Blueridge_Gray","Light_Oak","Smoke_Blue","Aspen_Tan":{
    	    		
    	    		pi.setColor("Beige");
    	    		break;
    	    	}
    	    	
    	    	case "Brick_Red","Sierra","Russet","Rosewood","Clove_Brown","Teak","Tobacco","Redwood","Dark_Mahogany","Walnut","Oxford_Brown":{
    	    		
    	    		pi.setColor("Brown");
    	    		break;
    	    	}
    	    	
    	    	case "Naturaltone_Fir","Redwood_Naturaltone","Cinnamon","Caramel","Cedar_Naturaltone":{
    	    		
    	    		pi.setColor("Camel");
    	    		break;
    	    	}
    	    	
    	    	case "Light_Mocha","Ginger","Avocado","Coffee","Espresso","Olive_Brown","Dark_Oak","Dark_Tahoe","Black_Walnut":{
    	    		
    	    		pi.setColor("Lite brown");
    	    		break;
    	    	}
    	    	
    	    	case "Black_Oak","Ebony","Cinder":{
    	    		
    	    		pi.setColor("Black");
    	    		break;
    	    	}
    	    	
    	    	case "Polar_Gray","Storm_Gray":{
    	    		
    	    		pi.setColor("Lite blue");
    	    		break;
    	    	}
    	    }
        	ArrayList<Stock> stock = new ArrayList<Stock>();
        	stock= CarpentryLogic.getInstance().getStocks();
        	for(Stock s11 : stock) {
        		if (s11.getWoodName().equals(woodType.getSelectionModel().getSelectedItem().toString())) {
        			s11.setQuantity(s11.getQuantity()-Integer.parseInt(quantity.getText()));
        			CarpentryLogic.getInstance().updateStockQuantity(s11, s11.getQuantity());
        		}

        	}
        	
        	color.setValue(null);
        	projectSection.setValue(null);
        	brzolDegree.setValue(null);
        	handsModelNumber.setValue(null);
        	handsQuantity.setText(null);
        	axleQuantity.setText(null);
        	ItemName.setText(null);
        	height.setText(null);
        	width.setText(null);
        	depth.setText(null);
        	quantity.setText(null);
                
    	}
    	catch (IllegalArgumentException e) {
    	    final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setTitle("Error!");
    	    alert.setContentText("Press OK to try again.");
    	    alert.setHeaderText(e.getMessage());
    	    alert.showAndWait();
   	}

    	
	    Image loadingImage = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\737.gif");
        loading.setImage(loadingImage);

        
        for(ProjectItems pi : PI_Array) {
        	toAI+= pi.getItemName()+", ";
        }
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Process p = null;
                try {
                	
                	if(sec.getSectionName().equals("Room")) {
                		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : "+pi.getColor()+"Bedroom that includes "+ toAI);
                        p = pb.start();
                	}
                	
                	if(sec.getSectionName().equals("Kitchen")) {
                		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : "+ pi.getColor()+"Kitchen that includes "+ toAI);
                        p = pb.start();
                	}
                	
                	if(sec.getSectionName().equals("LivingRoom")) {
                		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project : "+ pi.getColor()+"LivingRoom that includes "+ toAI );
                        p = pb.start();
                	}
                	
                	if(sec.getSectionName().equals("Bathroom")) {
                		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py",  "Carpentry Project :"+ pi.getColor()+" Bathroom that includes "+ toAI);
                        p = pb.start();
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
                    	    
                    	    AIAutoController controller = loader.getController();
                    	    
                    	    // Send data
                    	    
                    	   
                    	    controller.setData(myData,s.getProjectID());

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

        new Thread(task).start(); // Start the task in a new thread
    	}
    	
    	else {
    		JOptionPane.showMessageDialog(null, "Please add the items first .", "Items Reminder", JOptionPane.WARNING_MESSAGE);
    	}
    	PI_Array.clear();
    	}
    
    
   
    
    @FXML
    void Finish(MouseEvent event) throws IOException, InterruptedException, SQLException {
        
    	
    		
    		for(Project p1 : CarpentryLogic.getInstance().getProjects()) {
    			if(p1.getProjectID()==saveProjectID) {
    				if(notes.getText().equals(null))
    					CarpentryLogic.getInstance().updateProjectNotes(p1, "Null");
    				
    				else CarpentryLogic.getInstance().updateProjectNotes(p1, notes.getText());
//    				p1.setPrice(Integer.parseInt(price.getText()));
//    				CarpentryLogic.getInstance().updateProjectPrice(p1, p1.getPrice());
    			}
    		}
            
                                
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectDetails.fxml"));
                        	    Parent root = loader.load();
                        	    
                        	    // Get the controller of the second scene
                        	    String myData = Integer.toString(GlobalProjectID.getId());
                        	    ProjectDetailsToShowController controller = loader.getController();
                        	    
                        	    // Send data
                        	    
                        	    
                        	    controller.setData(myData);

                        	    Scene scene = new Scene(root);
                        	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        	    stage.setScene(scene);
                        	    stage.show();
                            
    	}
    //}

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Buttons.add(Projects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Email);
		Buttons.add(BackButton);
		Buttons.add(finish);
		Buttons.add(GenerateByAI);
		Buttons.add(Settings);
		
		ObservableList<String> projectSectionList = FXCollections.observableArrayList("Kitchen","Room","LivingRoom","Bathroom");
		projectSection.getItems().addAll(projectSectionList);
		
		ArrayList<Stock> stockArrayList = new ArrayList<>();
		for (Stock c : CarpentryLogic.getInstance().getStocks()) {
			stockArrayList.add(c);
		}
		
		ObservableList<Stock> woodTypeList = FXCollections.observableArrayList(stockArrayList);
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
		
		
		
		
		
		ObservableList<SectionColor> section_Colors = FXCollections.observableArrayList(SectionColor.Aspen_Tan,SectionColor.Avocado,SectionColor.Beige_Gray,SectionColor.Black_Oak,SectionColor.Black_Walnut,SectionColor.Blueridge_Gray,SectionColor.Brick_Red,SectionColor.Caramel,SectionColor.Cedar_Naturaltone,SectionColor.Cinder,SectionColor.Cinnamon,SectionColor.Clove_Brown,SectionColor.Coffee,SectionColor.Dark_Mahogany,SectionColor.Dark_Oak,SectionColor.Dark_Tahoe,SectionColor.Desert_Sand,SectionColor.Drift_Gray,SectionColor.Ebony,SectionColor.Espresso,SectionColor.Ginger,SectionColor.Light_Mocha,SectionColor.Light_Oak,SectionColor.Mushroom,SectionColor.Naturaltone_Fir,SectionColor.Olive_Brown,SectionColor.Oxford_Brown,SectionColor.Pearl_Gray,SectionColor.Polar_Gray,SectionColor.Redwood,SectionColor.Redwood_Naturaltone,SectionColor.Rosewood,SectionColor.Russet,SectionColor.Sierra,SectionColor.Smoke_Blue,SectionColor.Storm_Gray,SectionColor.Teak,SectionColor.Tobacco,SectionColor.Walnut,SectionColor.Weathered_Barnboard);
		color.getItems().addAll(section_Colors);
	}
	
}
