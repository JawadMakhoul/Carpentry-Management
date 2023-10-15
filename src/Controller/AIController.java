package Controller;
import java.io.*;
import java.sql.SQLException;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.application.Platform;

import java.util.*;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enumeration.ProjectSection;
import Model.Project;
import Model.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AIController implements Initializable{

	private HashSet<Button> Buttons = new HashSet<Button>();
	private HashSet<Button> imagebtns = new HashSet<Button>();
    @FXML
    private Button Settings,GenerateByAI,BackButton,Projects,Email,NewProject,Stock,generate;
    
    @FXML
    private Button image1btn,image2btn,image3btn,image4btn,image5btn,image6btn,image7btn,image8btn,image9btn,image10btn;

    @FXML
    private ComboBox<String> projectSection;
    
    @FXML
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10, loading;

    @FXML
    private TextArea textInput;
    
    @FXML
    private ComboBox<Integer> projectID;

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
    void GenerateImages(MouseEvent event) throws IOException, InterruptedException, SQLException {
    	
    	Image loadingImage = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\737.gif");
        loading.setImage(loadingImage);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Process p = null;
                try {
                    ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jawad\\AppData\\Local\\Microsoft\\WindowsApps\\python.exe","C:\\Users\\jawad\\git\\Awni-wood-work\\src\\AI\\GenerateImages.py", textInput.getText());
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

                    p.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> {
                    try {
                    	
                    	loading.setImage(null);
                    	
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

                        Image i6 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");
                        image6.setImage(i6);

                        Image i7 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");
                        image7.setImage(i7);

                        Image i8 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");
                        image8.setImage(i8);

                        Image i9 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");
                        image9.setImage(i9);

                        Image i10 = new Image("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");
                        image10.setImage(i10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                return null;
            }
        };

        new Thread(task).start(); // Start the task in a new thread
    }

 
 @FXML
 void UpdateProjectImage(MouseEvent event) throws SQLException {

	 File oldFile = null;
	 for(Button b : imagebtns) {
		 if(b.isPressed()) {
		 
		 switch(b.getId()) {
		 	case "image1btn":{
		 		
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  // Replace with your old filename's path
	 	         
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
	 	        
		 		
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
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
		 		
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
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
		 		
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
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
	 	        
		 		
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
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
	 	       
		 		break;
		 	}

		 	case "image6btn":{
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  // Replace with your old filename's path
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
	 	        
		 		
		 		break;
		 	}

		 	case "image7btn":{
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  // Replace with your old filename's path
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
		 		
		 		break;
		 	}

		 	case "image8btn":{
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  // Replace with your old filename's path
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
	 	        
		 		
		 		break;
		 	}

		 	case "image9btn":{
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  // Replace with your old filename's path
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete10 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  
	 	        fileToDelete10.delete();
		 		
		 		break;
		 	}

		 	case "image10btn":{
		 		 oldFile = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_10.jpg");  // Replace with your old filename's path
	 	        
	 	       File fileToDelete1 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_1.jpg");  
	 	        fileToDelete1.delete();
	 	        
	 	       File fileToDelete2 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_2.jpg");  
	 	        fileToDelete2.delete();
	 	        
	 	       File fileToDelete3 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_3.jpg");  
	 	        fileToDelete3.delete();
	 	        
	 	       File fileToDelete4 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_4.jpg");  
	 	        fileToDelete4.delete();
	 	        
	 	       File fileToDelete5 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_5.jpg");  
	 	        fileToDelete5.delete();
	 	        
	 	       File fileToDelete6 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_6.jpg");  
	 	        fileToDelete6.delete();
	 	        
	 	       File fileToDelete7 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_7.jpg");  
	 	        fileToDelete7.delete();
	 	        
	 	       File fileToDelete8 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_8.jpg");  
	 	        fileToDelete8.delete();
	 	        
	 	       File fileToDelete9 = new File("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\demo_9.jpg");  
	 	        fileToDelete9.delete();
	 	        
		 		
		 		break;
		 	}
		 }
		 
		 if(projectSection.getSelectionModel().getSelectedItem().equals("Kitchen")) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\Kitchen_ProjectID"+projectID.getSelectionModel().getSelectedItem().toString()+".jpg";
	 			File newFile = new File(path);  
	 	        oldFile.renameTo(newFile);
	 	        
		 		CarpentryLogic.getInstance().addProjectImage1(Integer.parseInt(projectID.getSelectionModel().getSelectedItem().toString()), path);
		 		JOptionPane.showMessageDialog(null, "Image added to the project.", "Adding image", JOptionPane.INFORMATION_MESSAGE);
	 		}
	 		
	 		else if(projectSection.getSelectionModel().getSelectedItem().equals("Room")) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\Room_ProjectID"+projectID.getSelectionModel().getSelectedItem().toString()+".jpg";
	 			File newFile = new File(path);
	 			oldFile.renameTo(newFile);
	 			
	 			CarpentryLogic.getInstance().addProjectImage2(Integer.parseInt(projectID.getSelectionModel().getSelectedItem().toString()), path);
		 		JOptionPane.showMessageDialog(null, "Image added to the project.", "Adding image", JOptionPane.INFORMATION_MESSAGE);
	 		}
	 		
	 		else if(projectSection.getSelectionModel().getSelectedItem().equals("LivingRoom")) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\LivingRoom_ProjectID"+projectID.getSelectionModel().getSelectedItem().toString()+".jpg";
	 			File newFile = new File(path);
	 			oldFile.renameTo(newFile);
	 			
	 			CarpentryLogic.getInstance().addProjectImage3(Integer.parseInt(projectID.getSelectionModel().getSelectedItem().toString()), path);
		 		JOptionPane.showMessageDialog(null, "Image added to the project.", "Adding image", JOptionPane.INFORMATION_MESSAGE);
	 		}
	 		
	 		else if(projectSection.getSelectionModel().getSelectedItem().equals("Bathroom")) {
	 			String path = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\Bathroom_ProjectID"+projectID.getSelectionModel().getSelectedItem().toString()+".jpg";
	 			File newFile = new File(path);
	 			oldFile.renameTo(newFile);
	 			
	 			CarpentryLogic.getInstance().addProjectImage4(Integer.parseInt(projectID.getSelectionModel().getSelectedItem().toString()), path);JOptionPane.showMessageDialog(null, "Image added to the project.", "Adding image", JOptionPane.INFORMATION_MESSAGE);
	 		}
	 }
	 }
 }
 
 
 @FXML
 void FillProjectSectionsComboBox(ActionEvent event) {
	 projectSection.getItems().clear();
	 
	 for(Section s : CarpentryLogic.getInstance().getSections()) {
		 if(Integer.toString(projectID.getSelectionModel().getSelectedItem()).equals(s.getProjectID())) {
			 projectSection.getItems().add(s.getSectionName());
		 }
	 }
	 projectSection.setPrefWidth(Control.USE_COMPUTED_SIZE);
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
