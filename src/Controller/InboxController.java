package Controller;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
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
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private Button sendEmail,replay,refresh,NewProject,Stock,CurrentProjects,ColorsCatalog,OrderedMaterials,FinancialManaging,OrdersCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

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
	    		
	    		case "replay":{
	    			
	    			replayTo=tableview.getSelectionModel().getSelectedItem().getFrom();
	    			subjectTo=tableview.getSelectionModel().getSelectedItem().getSubject();
	    			
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/ReplayTo.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work");
	        		stage.show();
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
	    			for (Message message : messages) {
	    			    String from = Arrays.toString(message.getFrom());
	    			    String subject = message.getSubject();
	    			    String content = "";

	    			    Object messageContent = message.getContent();
	    			    if (messageContent instanceof MimeMultipart) {
	    			        // This message has multiple parts, so we need to extract the content of each part
	    			        MimeMultipart multipart = (MimeMultipart) messageContent;
	    			        for (int i = 0; i < multipart.getCount(); i++) {
	    			            BodyPart bodyPart = multipart.getBodyPart(i);
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

	    			    }


	    			break;
    	}
    		}}
    
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Buttons.add(OrdersCatalog);
		Buttons.add(FinancialManaging);
		Buttons.add(OrderedMaterials);
		Buttons.add(ColorsCatalog);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(refresh);
		Buttons.add(replay);
		Buttons.add(sendEmail);
	}


}
