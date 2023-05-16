package Controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test implements Initializable{
	//@FXML
   // private Button sendEmail,NewProject,Stock,CurrentProjects,ColorsCatalog,OrderedMaterials,FinancialManaging,ProjectsCatalog,Inbox,BackButton;
    private HashSet<Button> Buttons = new HashSet<Button>();
    @FXML
    private Button BackButton;

    @FXML
    private Button ColorsCatalog;

    @FXML
    private Button CurrentProjects;

    @FXML
    private Button FinancialManaging;

    @FXML
    private Button Inbox;

    @FXML
    private Button NewProject;

    @FXML
    private Button OrderedMaterials;

    @FXML
    private Button ProjectsCatalog;

    @FXML
    private Button Stock;

    @FXML
    private Button sendEmail;

    @FXML
    private WebView web;
    
    @FXML
    private TextField textfield;
    
    private WebEngine webengine;

    @FXML
    void MoveTo(MouseEvent event) {

    }

    public void loadPAGE() {
    	webengine.load("https://platform.openai.com/docs/api-reference/introduction");
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
		Buttons.add(sendEmail);
		
//		webengine = web.getEngine();
//		loadPAGE();
		
		URL url = null;
		try {
			url = new URL("https://labs.openai.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // replace with the actual API URL
	    HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    conn.setRequestProperty("Authorization", "Bearer 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"); // replace YOUR_API_KEY with your actual API key
	    conn.setRequestProperty("Content-Type", "application/json");

	    // If you need to send a request body, get the output stream and write to it here.

	    BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String inputLine;
	    StringBuilder content = new StringBuilder();
	    try {
			while ((inputLine = in.readLine()) != null) {
			  content.append(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Clean up
	    try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    conn.disconnect();

	    System.out.println("Response content: " + content.toString());
	}

}
