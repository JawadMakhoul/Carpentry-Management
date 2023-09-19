package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Controller.ProjectItemsController;
import Model.Customer;
import Model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;

public class SuppliersController implements Initializable{

    @FXML
    private ComboBox<String> suppliersComboBox;
    
    @FXML
    private Button supplierEmail;

    private String data1,data2;
    public void setData(String data1,String data2) {
        this.data1 = data1;
        this.data2 = data2;
        // Do whatever you need with this data, e.g., update a label or text area.
    }
   
    @FXML
    void GetSupplierEmail(ActionEvent event) {
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

	        String toEmail = suppliersComboBox.getSelectionModel().getSelectedItem().toString();



            Message emailMessage = new MimeMessage(session);

            emailMessage.setFrom(new InternetAddress(username));

            

            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            emailMessage.setSubject("New order");

            emailMessage.setText("I want to order " +data2 + " " + data1);

            

            // Send email message

            Transport.send(emailMessage);

            Image image = new Image(getClass().getResourceAsStream("/Lib/delivered.png"));

            //trueORfalse.setImage(image);

     

         

            

        } catch (MessagingException e) {
//
//        	Image image = new Image(getClass().getResourceAsStream("/Lib/email.png"));
//
//            trueORfalse.setImage(image);
//
//            Image image2 = new Image(getClass().getResourceAsStream("/Lib/remove.png"));
//
//            failedToSend2.setImage(image2);

          

        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ArrayList<String> suppliers = new ArrayList<>();
		for (Supplier c : CarpentryLogic.getInstance().getSupplier()) {
			if(c.getAutoOrder()==1)
				suppliers.add(c.getSupplierEmail());
		}
		ObservableList<String> suppEmails = FXCollections.observableArrayList(suppliers);
		suppliersComboBox.getItems().addAll(suppEmails);
	}

}
