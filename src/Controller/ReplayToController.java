package Controller;

import java.awt.Font;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.scene.control.ListView;
import javax.mail.search.SearchTerm;

//import com.google.api.client.util.IOUtils;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReplayToController implements Initializable{

    @FXML
    private Button sendEmail,send,NewProject,Stock,CurrentProjects,ColorsCatalog,OrderedMaterials,FinancialManaging,ProjectsCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    private TextArea messageField;

    @FXML
    private TextField subjectField,toEmailField;
    
	private String to_email,subject;
	
	@FXML
    private Text text;
	
	@FXML
    private ImageView trueORfalse,failedToSend2;
	
    @FXML
    void MoveTo(MouseEvent event) throws IOException, MessagingException {
    	
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
	    		
	    		case "ColorsCatalog":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ColorsCatalog.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Colors Catalog");
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
	    		
	    		case "FinancialManaging":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/FinancialManaging.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Financial Managing");
	        		stage.show();
	        		break;
	    		}
	    		
	    		case "ProjectsCatalog":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectsCatalog.fxml"));
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
	    		
	    		case "send":{
	    			
	    			String host = "smtp.office365.com";
	    	        String port = "587";
	    	        String username = "awniwoodwork@hotmail.com";
	    	        String password = "Awnihasanjawad";
	    	        
	    	        // Sender and recipient email addresses
	    	       // String fromEmail = "your_hotmail_email@hotmail.com";
	    	   
	    	        int startIndex = to_email.indexOf("<");
	    	        int endIndex = to_email.indexOf(">");
	    	        String toEmail = to_email.substring(startIndex + 1, endIndex);
	    	        
	    	       // String subject = result1.substring(startIndex1 + 1, endIndex1);
	    	    
	    	       // String message = "This is a test email sent from a Hotmail account.";
	    	        
	    	        // SMTP server properties
	    	        Properties props = new Properties();
	    	        props.put("mail.smtp.auth", "true");
	    	        props.put("mail.smtp.starttls.enable", "true");
	    	        props.put("mail.smtp.host", host);
	    	        props.put("mail.smtp.port", port);
	    	        
	    	        // Create a session with SMTP server
	    	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	    	            protected PasswordAuthentication getPasswordAuthentication() {
	    	                return new PasswordAuthentication(username, password);
	    	            }
	    	        });
	    	        
	    	        try {
	    	            // Create email message
	    	            Message emailMessage = new MimeMessage(session);
	    	            emailMessage.setFrom(new InternetAddress(username));
	    	            
	    	           
	    	            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
	    	            
	    	            
	    	            emailMessage.setSubject(subject);
	    	            emailMessage.setText(messageField.getText());
	    	            
	    	            // Send email message
	    	            Transport.send(emailMessage);
	    	            Image image = new Image(getClass().getResourceAsStream("/Lib/delivered.png"));
	    	            trueORfalse.setImage(image);
	    	            text.setText("Successfully sent!");
	    	            text.setFill(Color.GREEN);
	    	            
	    	        } catch (MessagingException e) {
	    	        	Image image = new Image(getClass().getResourceAsStream("/Lib/email.png"));
	    	            trueORfalse.setImage(image);
	    	            Image image2 = new Image(getClass().getResourceAsStream("/Lib/remove.png"));
	    	            failedToSend2.setImage(image2);
	    	            text.setText("Failed to send!");
	    	            text.setFill(Color.RED);
	    	        }
	    	    }
    	}
    			}
    		}
    	
    
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(ProjectsCatalog);
		Buttons.add(FinancialManaging);
		Buttons.add(OrderedMaterials);
		Buttons.add(ColorsCatalog);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(send);
		Buttons.add(sendEmail);
		
		to_email = InboxController.replayTo;
		subject = InboxController.subjectTo;
		toEmailField.setText(to_email.toString());
		subjectField.setText(subject.toString());
	}


}
