package Controller;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

import Enumeration.ProjectSection;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.scene.control.ListView;
import javax.mail.search.SearchTerm;

//import com.google.api.client.util.IOUtils;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import Model.Customer;
import Model.Email;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
public class InboxController implements Initializable{

    @FXML
    private Button ProjectDetails,GenerateByAI,refresh,send,replay,NewProject,Stock,CurrentProjects,OrderedMaterials,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
    private ComboBox<String> emails;
    @FXML
	 private TableColumn<Email, String> from;

    public static String replayTo;
	 @FXML
	 private TableColumn<Email, String> subject;

	 public static String subjectTo;
	 
	 @FXML
	 private TableColumn<Email, String> content;
	 @FXML
	 private TableView<Email> tableview;
	 
	 @FXML
	    private TextField toEmailField,subjectField;
	 
	 @FXML
	    private TextArea messageField;
	 
	    

	    private String to_email;
	    
	    @FXML
	    private ImageView trueORfalse,failedToSend2;
	    
	    @FXML
	    private Text text;
	    
	    private boolean flag=false;
	    
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
	    		
	    		case "send":{
	    			
	    			if(flag) { // if flag =true the email is a replay for someone else the destination email is input 
		    			String host = "smtp.office365.com";
		    	        String port = "587";
		    	        String username = "awniwoodwork@hotmail.com";
		    	        String password = "Awnihasanjawad";
		    	        
		    	        // Sender and recipient email addresses
		    	       // String fromEmail = "your_hotmail_email@hotmail.com";
		    	   
		    	        int startIndex = replayTo.indexOf("<");
		    	        int endIndex = replayTo.indexOf(">");
		    	        String toEmail = replayTo.substring(startIndex + 1, endIndex);
		    	        
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
		    	            
		    	            
		    	            emailMessage.setSubject(subjectTo);
		    	            emailMessage.setText(messageField.getText());
		    	            
		    	            // Send email message
		    	            Transport.send(emailMessage);
		    	            Image image = new Image(getClass().getResourceAsStream("/Lib/delivered.png"));
		    	            trueORfalse.setImage(image);
		    	            text.setText("Successfully sent!");
		    	            text.setFill(Color.GREEN);
		    	            messageField.setText(null);
			    	        subjectField.setText(null);
			    	        toEmailField.setText(null);
		    	            
		    	        } catch (MessagingException e) {
		    	        	Image image = new Image(getClass().getResourceAsStream("/Lib/email.png"));
		    	            trueORfalse.setImage(image);
		    	            Image image2 = new Image(getClass().getResourceAsStream("/Lib/remove.png"));
		    	            failedToSend2.setImage(image2);
		    	            text.setText("Failed to send!");
		    	            text.setFill(Color.RED);
		    	        }
		    	        
		    	        
		    	
	    			}
	    			
	    			else {
	    				String host = "smtp.office365.com";
		    	        String port = "587";
		    	        String username = "awniwoodwork@hotmail.com";
		    	        String password = "Awnihasanjawad";
		    	        
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
		    	            
		    	            if(!emails.getSelectionModel().getSelectedItem().equals(null))
		    	            	emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emails.getSelectionModel().getSelectedItem()));
		    	            
		    	            else {
		    	            	emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailField.getText().toString()));
		    	            }
		    	            	emailMessage.setSubject(subjectField.getText());
		    	            emailMessage.setText(messageField.getText());
		    	            
		    	            // Send email message
		    	            Transport.send(emailMessage);
		    	            Image image = new Image(getClass().getResourceAsStream("/Lib/delivered.png"));
		    	            trueORfalse.setImage(image);
		    	            text.setText("Successfully sent!");
		    	            text.setFill(Color.GREEN);
		    	            messageField.setText(null);
			    	        subjectField.setText(null);
			    	        toEmailField.setText(null);
		    	            
		    	        } catch (MessagingException e) {
		    	        	Image image = new Image(getClass().getResourceAsStream("/Lib/email.png"));
		    	            trueORfalse.setImage(image);
		    	            Image image2 = new Image(getClass().getResourceAsStream("/Lib/remove.png"));
		    	            failedToSend2.setImage(image2);
		    	            text.setText("Failed to send!");
		    	            text.setFill(Color.RED);
		    	        }
		    	    }

	        		break;
	    		}
	    		
	    		case "replay":{
	    			
	    			replayTo=tableview.getSelectionModel().getSelectedItem().getFrom();
	    			toEmailField.setText(replayTo);
	    			subjectTo=tableview.getSelectionModel().getSelectedItem().getSubject();
	    			subjectField.setText(subjectTo);
	    			
	    			flag=true;      
	    	    
	        		break;
	    		}
	    		
	    		case "refresh":{
	    			
	    			Properties props = new Properties();
	    			props.setProperty("mail.store.protocol", "imaps");
	    			props.setProperty("mail.imaps.host", "outlook.office365.com");
	    			props.setProperty("mail.imaps.port", "993");
	    			props.setProperty("mail.imaps.ssl.enable", "true");

	    			// create a new session with authentication
	    			Session session = Session.getDefaultInstance(props, new Authenticator() {
	    			    protected PasswordAuthentication getPasswordAuthentication() {
	    			        return new PasswordAuthentication("awniwoodwork@hotmail.com", "Awnihasanjawad");
	    			    }
	    			});

	    			// connect to the email server and open the inbox folder
	    			Store store = session.getStore("imaps");
	    			store.connect();
	    			Folder inbox = store.getFolder("INBOX");
	    			inbox.open(Folder.READ_ONLY);

	    			// Create the table view
	    			ObservableList<Email> emails = FXCollections.observableArrayList();
	    			tableview.setItems(emails);

	    			// Set the columns
	    			from.setCellValueFactory(new PropertyValueFactory<>("From"));
	    			subject.setCellValueFactory(new PropertyValueFactory<>("Subject"));
	    			content.setCellValueFactory(new PropertyValueFactory<>("Content"));
	    			
	    			// Get the messages and add them to the table
	    			Message[] messages = inbox.getMessages();
	    			for (int i = messages.length-1;i>=0;i--) {
	    				Message message = messages[i];
	    			    String from = Arrays.toString(message.getFrom());
	    			    String subject = message.getSubject();
	    			    String content = "";

	    			    Object messageContent = message.getContent();
	    			    if (messageContent instanceof MimeMultipart) {
	    			        // This message has multiple parts, so we need to extract the content of each part
	    			        MimeMultipart multipart = (MimeMultipart) messageContent;
	    			        for (int i1 = 0; i1 < multipart.getCount(); i1++) {
	    			            BodyPart bodyPart = multipart.getBodyPart(i1);
	    			            String contentType = bodyPart.getContentType();
	    			            
	    			            if (contentType.startsWith("text/plain")) {
	    			                // This is a text/plain part, so we can just append its content to the email content
	    			                content += bodyPart.getContent();
	    			            } else if (contentType.startsWith("image/png")) {
	    			                // This is an image/png part, so we can decode the content and append it to the email content
	    			                byte[] imageBytes = IOUtils.toByteArray(bodyPart.getInputStream());
	    			                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	    			                content += "<img src='data:image/png;base64," + base64Image + "' />";
	    			               
	    			            } else {
	    			                // This is not a recognized part type, so we ignore it
	    			            }
	    			        }
	    			    } else {
	    			        // This message has only one part, which is already the content
	    			        content = messageContent.toString();
	    			    }

	    			    Email email = new Email(from, subject, content);
	    			    emails.add(email);
	    			}
	    		

	    			// close the connection and folder
	    			inbox.close(false);
	    			store.close();

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
		Buttons.add(refresh);
		Buttons.add(replay);
		Buttons.add(send);
		Buttons.add(GenerateByAI);
		Buttons.add(ProjectDetails);
		
		
		ArrayList<String> CustEmails = new ArrayList<>();
		for(Customer c : CarpentryLogic.getInstance().getCustomers()) {
			CustEmails.add(c.getEmail());
		}
		
		ObservableList<String> customersEmails = FXCollections.observableArrayList(CustEmails);
		emails.getItems().addAll(customersEmails);
		
		
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		props.setProperty("mail.imaps.host", "outlook.office365.com");
		props.setProperty("mail.imaps.port", "993");
		props.setProperty("mail.imaps.ssl.enable", "true");

		// create a new session with authentication
		Session session = Session.getDefaultInstance(props, new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("awniwoodwork@hotmail.com", "Awnihasanjawad");
		    }
		});

		// connect to the email server and open the inbox folder
		Store store = null;
		try {
			store = session.getStore("imaps");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			store.connect();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Folder inbox = null;
		try {
			inbox = store.getFolder("INBOX");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inbox.open(Folder.READ_ONLY);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create the table view
		ObservableList<Email> emails = FXCollections.observableArrayList();
		tableview.setItems(emails);

		// Set the columns
		from.setCellValueFactory(new PropertyValueFactory<>("From"));
		subject.setCellValueFactory(new PropertyValueFactory<>("Subject"));
		content.setCellValueFactory(new PropertyValueFactory<>("Content"));
		
		// Get the messages and add them to the table
		Message[] messages = null;
		try {
			messages = inbox.getMessages();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = messages.length-1;i>=0;i--) {
			Message message = messages[i];
		    String from = null;
			try {
				from = Arrays.toString(message.getFrom());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String subject = null;
			try {
				subject = message.getSubject();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String content = "";

		    Object messageContent = null;
			try {
				messageContent = message.getContent();
			} catch (IOException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if (messageContent instanceof MimeMultipart) {
		        // This message has multiple parts, so we need to extract the content of each part
		        MimeMultipart multipart = (MimeMultipart) messageContent;
		        try {
					for (int i1 = 0; i1 < multipart.getCount(); i1++) {
					    BodyPart bodyPart = multipart.getBodyPart(i1);
					    String contentType = bodyPart.getContentType();
					    
					    if (contentType.startsWith("text/plain")) {
					        // This is a text/plain part, so we can just append its content to the email content
					        content += bodyPart.getContent();
					    } else if (contentType.startsWith("image/png")) {
					        // This is an image/png part, so we can decode the content and append it to the email content
					        byte[] imageBytes = IOUtils.toByteArray(bodyPart.getInputStream());
					        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					        content += "<img src='data:image/png;base64," + base64Image + "' />";
					       
					    } else {
					        // This is not a recognized part type, so we ignore it
					    }
					}
				} catch (MessagingException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } else {
		        // This message has only one part, which is already the content
		        content = messageContent.toString();
		    }

		    Email email = new Email(from, subject, content);
		    emails.add(email);
		}
	

		// close the connection and folder
		try {
			inbox.close(false);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			store.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



