package Controller;
import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.Image;
public class AIController implements Initializable{

	private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private Button BackButton,CurrentProjects,Inbox,NewProject,OrderedMaterials,OrdersCatalog,Stock,generate;

    @FXML
    private ImageView image1,image2,image3;

    @FXML
    private TextArea textInput;

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
 void GenerateImages(MouseEvent event) throws IOException {
	 try {
		    ProcessBuilder pb = new ProcessBuilder("python","C:\\Users\\jawad\\OneDrive\\Desktop\\AI\\demo.py",textInput.getText().toString());
		    Process p = pb.start();

		    // Capture standard output from Python script
		    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String output;
		    while ((output = in.readLine()) != null) {
		        System.out.println(output);
		    }

		    // Capture error output from Python script
		    BufferedReader inError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		    while ((output = inError.readLine()) != null) {
		        System.err.println(output);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}

	 Image i1 = new Image(getClass().getResourceAsStream("/Lib/demo_0.jpg"));
	 image1.setImage(i1);
	 //Path filePath1 = Paths.get("/Lib/demo_0.jpg");
     
	 Image i2 = new Image(getClass().getResourceAsStream("/Lib/demo_1.jpg"));
	 image2.setImage(i2);
	 //Path filePath2 = Paths.get("/Lib/demo_1.jpg");
	 Image i3 = new Image(getClass().getResourceAsStream("/Lib/demo_2.jpg"));
	 image3.setImage(i3);
	/// Path filePath3 = Paths.get("/Lib/demo_2.jpg");
	// Files.delete(filePath1);
	// Files.delete(filePath2);
	// Files.delete(filePath3);
	 
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
}


}
