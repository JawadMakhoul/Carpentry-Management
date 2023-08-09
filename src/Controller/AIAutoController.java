package Controller;

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
    private Button BackButton,CurrentProjects,Inbox,NewProject,Stock,generate;
    
    @FXML
    private Button image1btn,image2btn,image3btn,image4btn,image5btn,image6btn,image7btn,image8btn,image9btn,image10btn;

    @FXML
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;
    
    private  static ProjectDetailsToShow pdts;


	public static ProjectDetailsToShow getPdts() {
		return pdts;
	}

	public static void setPdts(ProjectDetailsToShow pdts) {
		AIAutoController.pdts = pdts;
	}

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
 
 @FXML
 void UpdateProjectImage(MouseEvent event) throws SQLException, IOException {System.out.println("image buuton");

	 for(Button b : imagebtns) {
		 if(b.isPressed()) {
		 
		 switch(b.getId()) {
		 	case "image1btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_1.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_1.jpg");
		 		break;
		 	}
		 	
		 	case "image2btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_2.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_2.jpg");
		 		break;
		 	}

		 	case "image3btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_3.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_3.jpg");
		 		break;
		 	}

		 	case "image4btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_4.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_4.jpg");
		 		break;
		 	}

		 	case "image5btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_5.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_5.jpg");
		 		break;
		 	}

		 	case "image6btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_6.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_6.jpg");
		 		break;
		 	}

		 	case "image7btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_7.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_7.jpg");
		 		break;
		 	}

		 	case "image8btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_8.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_8.jpg");
		 		break;
		 	}

		 	case "image9btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_9.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_9.jpg");
		 		break;
		 	}

		 	case "image10btn":{
		 		CarpentryLogic.getInstance().addProjectImage(GlobalProjectID.getId(), "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_10.jpg");
		 		ProjectItemsController.getPdts().setImage("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images\\demo_10.jpg");
		 		break;
		 	}
		 	
		 }
		 
		
//		Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectDetails.fxml"));
// 		Scene scene = new Scene(pane);
// 		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
// 		stage.setScene(scene);
// 		stage.setResizable(false);
// 		stage.setTitle("Awni Wood Work - Generate Images By Ai");
// 		stage.show();
 		
// 		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectDetails.fxml"));
//	    Parent root = loader.load();
//	    
//	    // Get the controller of the second scene
//	    String myData = Integer.toString(GlobalProjectID.getId());
//	    ProjectDetailsToShowController controller = loader.getController();
//	    
//	    // Send data
//	    
//	    
//	    controller.setData(myData);
//
//	    Scene scene = new Scene(root);
//	    Stage stage = new Stage();
//	    stage.setScene(scene);
//	    stage.show();
		 
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectDetails.fxml"));
		 Parent root = loader.load();

		 // Get the controller of the second scene
		 String myData = Integer.toString(GlobalProjectID.getId());
		 ProjectDetailsToShowController controller = loader.getController();

		 // Send data
		 controller.setData(myData);

		 // Get the current stage
		 Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

		 // Set new root on the current stage's scene
		 currentStage.getScene().setRoot(root);

	 }
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


}
