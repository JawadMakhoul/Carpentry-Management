package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Store;

import Model.Email;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

public class InboxController implements Initializable{

    @FXML
    private Button refresh,NewProject,Stock,CurrentProjects,MaterialsToOrder,ColorsCatalog,OrderedMaterials,FinancialManaging,ProjectsCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private AnchorPane screen;

    @FXML
	 private TableColumn<Email, String> from;

	 @FXML
	 private TableColumn<Email, String> subject;

	 @FXML
	 private TableColumn<Email, String> content;
	 @FXML
	 private TableView<Email> tableview;
	 
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
	    		
	    		case "MaterialsToOrder":{
	    			Parent pane = FXMLLoader.load(getClass().getResource("/View/MaterialsToOrder.fxml"));
	        		Scene scene = new Scene(pane);
	        		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        		stage.setScene(scene);
	        		stage.setResizable(false);
	        		stage.setTitle("Awni Wood Work - Order Materials");
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
	    		
	    		case "refresh":{
	    			System.out.println("test");
	    			
//	    			ObservableList<Email> data = FXCollections.observableArrayList(
//	    			        new Email("jawad", "makhoul","test"),
//	    			        new Email("hasan", "masalha","test"),
//	    			        new Email("alo", "marhaba","test"));
//	    			
//	    			
//	    			tableview.setItems(data);
	    			try {String mailStoreType = "pop3";
	    				
	    				//create properties field
	    				Properties prop = new Properties();
	    				
	    				prop.put ("mail.pop3.host", "pop.gmail.com");
	    				prop.put ("mail.pop3.port","995") ;
	    				prop.put ("mail.pop3.starttis.enable","true");
	    				Session emailsession = Session.getDefaultInstance(prop);
	    				Store store = emailsession.getStore("pop3s");System.out.println("test9999999999999999999999999");
	    				System.out.println(store.toString());
	    				
	    				store.connect("pop.gmail.com", "jawad.makhoul9@gmail.com", "jawad1499makhoulmaker");System.out.println("test10000101010101010101010");
	    				//folder object for open inbox
	    				Folder emailFolder = store.getFolder("Inbox");System.out.println("test***********************************");
	    				emailFolder.open(Folder.READ_ONLY);System.out.println("test////////////////////////////////");
	    				//get the messages
	    				Message messages[] = emailFolder.getMessages();System.out.println("test+++++++++++++++++++++++++++++++++++");
	    				int i = ((messages.length) -1);System.out.println("test.......................................");
	    				
	    				Message message = messages[i];
	    				System.out.println("test33333333333333333333333333333333");
	    				System.out.println ("Email Number"+(1+1));
	    				System.out.println ("Subject:" + message. getSubject () ) ;
	    				System. out.println ("From:"+ message.getFrom () [0]);
//	    				from.setText(message.getFrom() [0]);
//	    				System.out.println("testttttt");
//		    			from.setCellValueFactory(new PropertyValueFactory<>("From"));
//		    			subject.setCellValueFactory(new PropertyValueFactory<>("Subject"));
//		    			content.setCellValueFactory(new PropertyValueFactory<>("Content"));
	    				//close the store and folder objects emailfolder.close (true);
	    				emailFolder.close(true);
	    				store.close();
	    				
	    			} catch (NoSuchProviderException e) {
	    				}
	    			
	    			catch (MessagingException e) {
	    					} 
	    			catch (Exception e){
	    					
	    				}
	    			
//	    			private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
//	    			private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//	    			private static final String user = "me";
//	    			static Gmail service = null;
//	    			private static File filePath = new File(System.getProperty("user.dir") + "/credentials.json");
//
//	    			public static void main(String[] args) throws IOException, GeneralSecurityException {
//
//	    				getGmailService();
//	    				
//	    				getMailBody("Google");
//
//	    			}
//
//	    			public static void getMailBody(String searchString) throws IOException {
//
//	    				// Access Gmail inbox
//
//	    				Gmail.Users.Messages.List request = service.users().messages().list(user).setQ(searchString);
//
//	    				ListMessagesResponse messagesResponse = request.execute();
//	    				request.setPageToken(messagesResponse.getNextPageToken());
//
//	    				// Get ID of the email you are looking for
//	    				String messageId = messagesResponse.getMessages().get(0).getId();
//
//	    				Message message = service.users().messages().get(user, messageId).execute();
//
//	    				// Print email body
//
//	    				String emailBody = StringUtils
//	    						.newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()));
//
//	    				System.out.println("Email body : " + emailBody);
//
//	    			}
//
//	    			public static Gmail getGmailService() throws IOException, GeneralSecurityException {
//
//	    				InputStream in = new FileInputStream(filePath); // Read credentials.json
//	    				GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//	    				// Credential builder
//
//	    				Credential authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
//	    						.setJsonFactory(JSON_FACTORY)
//	    						.setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
//	    								clientSecrets.getDetails().getClientSecret().toString())
//	    						.build().setAccessToken(getAccessToken()).setRefreshToken(
//	    								"YOUR_REFRESH_TOKEN");//Replace this
//
//	    				// Create Gmail service
//	    				final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//	    				service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize)
//	    						.setApplicationName(GmailAPI.APPLICATION_NAME).build();
//
//	    				return service;
//	    			}
//
//	    			private static String getAccessToken() {
//
//	    				try {
//	    					Map<String, Object> params = new LinkedHashMap<>();
//	    					params.put("grant_type", "refresh_token");
//	    					params.put("client_id", "YOUR_CLIENT_ID"); //Replace this
//	    					params.put("client_secret", "YOUR_CLIENT_SECRET"); //Replace this
//	    					params.put("refresh_token",
//	    							"YOUR_REFRESH_TOKEN"); //Replace this
//
//	    					StringBuilder postData = new StringBuilder();
//	    					for (Map.Entry<String, Object> param : params.entrySet()) {
//	    						if (postData.length() != 0) {
//	    							postData.append('&');
//	    						}
//	    						postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//	    						postData.append('=');
//	    						postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//	    					}
//	    					byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//	    					URL url = new URL("https://accounts.google.com/o/oauth2/token");
//	    					HttpURLConnection con = (HttpURLConnection) url.openConnection();
//	    					con.setDoOutput(true);
//	    					con.setUseCaches(false);
//	    					con.setRequestMethod("POST");
//	    					con.getOutputStream().write(postDataBytes);
//
//	    					BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	    					StringBuffer buffer = new StringBuffer();
//	    					for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//	    						buffer.append(line);
//	    					}
//
//	    					JSONObject json = new JSONObject(buffer.toString());
//	    					String accessToken = json.getString("access_token");
//	    					return accessToken;
//	    				} catch (Exception ex) {
//	    					ex.printStackTrace();
//	    				}
//	    				return null;
//	    			}
	    			break;
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
		Buttons.add(MaterialsToOrder);
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(refresh);
	}


}
