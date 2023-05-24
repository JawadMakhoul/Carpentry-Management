package Controller;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import Enumeration.WoodType;
import Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.Image;
public class AIController implements Initializable{

	private HashSet<Button> Buttons = new HashSet<Button>();
	private HashSet<Button> imagebtns = new HashSet<Button>();
    @FXML
    private Button GenerateByAI,BackButton,CurrentProjects,Inbox,NewProject,OrderedMaterials,OrdersCatalog,Stock,generate;
    
    @FXML
    private Button image1btn,image2btn,image3btn,image4btn,image5btn,image6btn,image7btn,image8btn,image9btn,image10btn;

    @FXML
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;

    @FXML
    private TextArea textInput;
    
    @FXML
    private ComboBox<Integer> projectID;

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
	    		
	    		
    		}
    	}
    		
    	}
    	
    }

 @FXML
 void GenerateImages(MouseEvent event) throws IOException, InterruptedException, SQLException {
	 Process p = null;
	 try {
		 
		 
		    ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\demo.py", textInput.getText());
		    p = pb.start();

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
	            System.err.println("Error: " + error);
	        }
		} catch (IOException e) {
		    e.printStackTrace();
		}

	     
	 p.waitFor();

	 
	 Image i1 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_1.jpg");
	 image1.setImage(i1);
    
	 Image i2 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_2.jpg");
	 image2.setImage(i2);
	 
	 Image i3 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_3.jpg");
	 image3.setImage(i3);
	
	 Image i4 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_4.jpg");
	 image4.setImage(i4);
    
	 Image i5 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_5.jpg");
	 image5.setImage(i5);
	 
	 Image i6 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_6.jpg");
	 image6.setImage(i6);
    
	 Image i7 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_7.jpg");
	 image7.setImage(i7);
	 
	 Image i8 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_8.jpg");
	 image8.setImage(i8);
    
	 Image i9 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_9.jpg");
	 image9.setImage(i9);
	 
	 Image i10 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_10.jpg");
	 image10.setImage(i10);
	 
	 
 }
 
 @FXML
 void UpdateProjectImage(MouseEvent event) throws SQLException {

	 for(Button b : imagebtns) {
		 if(b.isPressed()) {
		 
		 switch(b.getId()) {
		 	case "image1btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_1.jpg");
		 		break;
		 	}
		 	
		 	case "image2btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_2.jpg");
		 		break;
		 	}

		 	case "image3btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_3.jpg");
		 		break;
		 	}

		 	case "image4btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_4.jpg");
		 		break;
		 	}

		 	case "image5btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_5.jpg");
		 		break;
		 	}

		 	case "image6btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_6.jpg");
		 		break;
		 	}

		 	case "image7btn":{
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_7.jpg");
		 		break;
		 	}

		 	case "image8btn":{
		System.out.println("8");
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_8.jpg");
		 		break;
		 	}

		 	case "image9btn":{
		 		System.out.println("9");
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_9.jpg");
		 		break;
		 	}

		 	case "image10btn":{
		 		System.out.println("10");
		 		CarpentryLogic.getInstance().addProjectImage(projectID.getSelectionModel().getSelectedItem(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_10.jpg");
		 		break;
		 	}
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
	Buttons.add(GenerateByAI);
	
	imagebtns.add(image1btn);
	imagebtns.add(image2btn);
	imagebtns.add(image3btn);
	imagebtns.add(image4btn);
	imagebtns.add(image5btn);
	imagebtns.add(image6btn);
	imagebtns.add(image7btn);
	imagebtns.add(image8btn);
	imagebtns.add(image9btn);
	imagebtns.add(image10btn);
	
	ArrayList<Integer> IDs = new ArrayList<>();
	for(Project p : CarpentryLogic.getInstance().getProjects()) {
		IDs.add(p.getProjectID());
	}
	ObservableList<Integer> projectIDs = FXCollections.observableArrayList(IDs);
	projectID.getItems().addAll(projectIDs);
	
}


}
