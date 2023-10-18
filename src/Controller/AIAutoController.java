package Controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import Model.GlobalProjectID;
import Model.ProjectDetailsToShow;
import Model.ProjectDetailsToShowNonStatic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.Image;
public class AIAutoController implements Initializable{

	private HashSet<Button> Buttons = new HashSet<Button>();
	private HashSet<Button> imagebtns = new HashSet<Button>();
    @FXML
    private Button Settings,BackButton,Projects,Email,NewProject,Stock,generate;
    
    @FXML
    private Button image1btn,image2btn,image3btn,image4btn,image5btn;

    @FXML
    private ImageView image1,image2,image3,image4,image5;
    
    private  static ProjectDetailsToShow pdts;


	public static ProjectDetailsToShow getPdts() {
		return pdts;
	}

	public static void setPdts(ProjectDetailsToShow pdts) {
		AIAutoController.pdts = pdts;
	}

	private int data;
	private String projectid;
    public void setData(int data ,String projectid) {
        this.data = data;
        this.projectid=projectid;
        // Maybe update some UI elements here based on the data
    }
    
    public void setData(int data) {
    	this.data=data;
    }
    
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
 
 @FXML
 void UpdateProjectImage(MouseEvent event) throws SQLException, IOException {

	 File oldFile = null;
	 for(Button b : imagebtns) {
		 if(b.isPressed()) {
		 
		 switch(b.getId()) {
		 	case "image1btn":{
	 	        
		 	    oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg"); 
		 		
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        

		 		
		 		break;
		 	}
		 	
		 	case "image2btn":{
		 		
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  // Replace with your old filename's path
	 	        
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();

	 	       
		 		break;
		 	}

		 	case "image3btn":{
		 		
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  // Replace with your old filename's path
	 	        
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();

	 	       
		 		break;
		 	}

		 	case "image4btn":{
		 		
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  // Replace with your old filename's path
	 	        
		 		
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();

	 	       
		 		break;
		 	}

		 	case "image5btn":{
		 		
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  // Replace with your old filename's path
	 	        
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       
		 		break;
		 	}
		 	
		 	
		 }
		 
		 if(data==1) {    
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\Kitchen_ProjectID"+projectid+".jpg";
	 	        File newFile = new File(path);  

	 	        oldFile.renameTo(newFile); 
	 			CarpentryLogic.getInstance().addProjectImage1(Integer.parseInt(projectid), path);
	 			ProjectItemsController.getPdts().setImage1(path);
	 		}
	 		
	 		else if(data==2) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\Room_ProjectID"+projectid+".jpg";
	 			File newFile = new File(path);  

	 	        oldFile.renameTo(newFile);
	 			CarpentryLogic.getInstance().addProjectImage2(Integer.parseInt(projectid), path);
	 			ProjectItemsController.getPdts().setImage2(path);
	 		}
	 		
	 		else if(data==3) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\LivingRoom_ProjectID"+projectid+".jpg";
	 			File newFile = new File(path);  

	 	        oldFile.renameTo(newFile);
	 			CarpentryLogic.getInstance().addProjectImage3(Integer.parseInt(projectid), path);
	 			ProjectItemsController.getPdts().setImage3(path);
	 		}
	 		
	 		else if(data==4) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\Bathroom_ProjectID"+projectid+".jpg";
	 			File newFile = new File(path);  

	 	        oldFile.renameTo(newFile);
	 			CarpentryLogic.getInstance().addProjectImage4(Integer.parseInt(projectid), path);
	 			ProjectItemsController.getPdts().setImage4(path);
	 		}
		// Get the current stage using the event source
		 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		 // Close the current stage
		 currentStage.close();

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectCost.fxml"));
 	    Parent root = loader.load();
 		ProjectCostController controller = loader.getController();
 	    
 	    // Send data
 	    
 	   
 	    controller.setData(Integer.parseInt(projectid));

 	    Scene scene = new Scene(root);
 	    Stage stage3 = new Stage();
 	    stage3.setScene(scene);
 	    stage3.show();
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
	Buttons.add(Settings);
	
	imagebtns.add(image1btn);
	imagebtns.add(image2btn);
	imagebtns.add(image3btn);
	imagebtns.add(image4btn);
	imagebtns.add(image5btn);
	
	Image i1 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");
	 image1.setImage(i1);
   
	 Image i2 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");
	 image2.setImage(i2);
	 
	 Image i3 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");
	 image3.setImage(i3);
	
	 Image i4 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");
	 image4.setImage(i4);
   
	 Image i5 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");
	 image5.setImage(i5);
	 

}


}
