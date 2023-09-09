package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Enumeration.ProjectCategory;
import Model.Customer;
import Model.GlobalProjectID;
import Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewProjectController implements Initializable {

	private String projectID;
	@FXML
	private Button GenerateByAI, projectItems, NewProject, Stock,
			CurrentProjects, Inbox, BackButton;
	private HashSet<Button> Buttons = new HashSet<Button>();

	ArrayList<String> emailsarray = new ArrayList<>();
	
	@FXML
	private TextField CustomerName, address, email, phoneNumber;

	@FXML
	private ComboBox<ProjectCategory> projectCategory;

	@FXML
	private AnchorPane screen;

	@FXML
	private ComboBox<String> customersemails;

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	@FXML
	void MoveTo(MouseEvent event) throws IOException, ClassNotFoundException {

		for (Button b : Buttons) {
			if (b.isPressed()) {

				switch (b.getId()) {

				case "Inbox": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Inbox.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Inbox");
					stage.show();
					break;
				}

				case "NewProject": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/NewProject.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Add project");
					stage.show();
					break;
				}
				case "Stock": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Stock.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Stock");
					stage.show();
					break;
				}

				case "CurrentProjects": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/CurrentProjects.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Projects In Progress");
					stage.show();
					break;
				}

				case "GenerateByAI": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/AI.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Generate By Images Ai");
					stage.show();
					break;
				}

				case "BackButton": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work");
					stage.show();
					break;
				}

				case "projectItems": {
					boolean flag = true;
					if (projectCategory.getSelectionModel().getSelectedItem() == null) {
//						try {
//							final Alert alert = new Alert(Alert.AlertType.INFORMATION);
//							alert.setTitle("Error!");
//							alert.setContentText("Press OK to try again.");
//							alert.setHeaderText("please enter the missing value.");
//							alert.showAndWait();
//						} catch (Error e) {
//							e.printStackTrace();
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
					}

					else if (!CustomerName.getText().equals("") && !phoneNumber.getText().equals("")
							&& !address.getText().equals("") && !email.getText().equals("")
							&& projectCategory.getSelectionModel().getSelectedItem() != null
							&& customersemails.getSelectionModel().getSelectedItem() == null) { // Creating new customer
																	
						for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
							if (c.getEmail().equals(email.getText())) {
								JOptionPane.showMessageDialog(null, "this email is already exists.", "Email reminder",
										JOptionPane.WARNING_MESSAGE);
								flag = false;
							}
						}
					}
					
						if (customersemails.getSelectionModel().getSelectedItem() != null && projectCategory.getSelectionModel().getSelectedItem() != null) {
							
							for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
								
								if (c.getEmail() .equals(customersemails.getSelectionModel().getSelectedItem().toString())) {
									
									CustomerName.setText(c.getName());
									phoneNumber.setText(c.getPhoneNUMBER());
									address.setText(c.getAddress());
									email.setText(c.getEmail());
									Project p = new Project();
									GlobalProjectID.setCustomerName(CustomerName.getText());
									GlobalProjectID.setId(p.getProjectID());
									// String ip = c.getName();
									p.setCustomerID(c.getName());
									if (projectCategory.getSelectionModel().getSelectedItem() != null) {
										p.setProjectCategory(
												projectCategory.getSelectionModel().getSelectedItem().toString());
									}
									p.setEmail(c.getEmail());
									p.setCost(p.CalculateCost());
									p.setPrice(0);
									CarpentryLogic.getInstance().addProject(p);
									FXMLLoader loader = new FXMLLoader(
											getClass().getResource("/View/ProjectItems.fxml"));
									Parent pane = loader.load();
									Scene scene = new Scene(pane);
									Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
									stage.setScene(scene);
									stage.setTitle("Awni Wood Work - Project Items");
									stage.show();

								}
							}
							flag=false;
						}
						
					
						if (customersemails.getSelectionModel().getSelectedItem() == null) {
							if (!CustomerName.getText().equals("") && !phoneNumber.getText().equals("")
									&& !address.getText().equals("") && !email.getText().equals("")
									&& projectCategory.getSelectionModel().getSelectedItem() != null) { // Creating
																										// new
																										// customer
																										// and new
																										// project

								Customer c = new Customer();
								if (CustomerName.getText().matches(".*\\d+.*")) {
									// c.setName(CustomerName.getText());
									try {
										final Alert alert = new Alert(Alert.AlertType.INFORMATION);
										alert.setTitle("Error!");
										alert.setContentText("Press OK to try again.");
										alert.setHeaderText("Sorry the customer name shouldn`t include numbers.");
										alert.showAndWait();
									} catch (Error e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
								} else {
									c.setName(CustomerName.getText());
									// System.out.println(c.getName());
									GlobalProjectID.setCustomerName(CustomerName.getText());
									// System.out.println(GlobalProjectID.getCustomerName());
									//try {
										if(phoneNumber.getText().matches("^05\\d{8}$")) {
											int num = Integer.parseInt((phoneNumber.getText()));
											c.setPhoneNUMBER(phoneNumber.getText());
											c.setAddress(address.getText());
											if (email.getText().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
												c.setEmail(email.getText());
												CarpentryLogic.getInstance().addCustomer(c);

												Project p = new Project();
												GlobalProjectID.setId(p.getProjectID());
												// String ip = c.getName();
												p.setCustomerID(c.getName());
												if (projectCategory.getSelectionModel().getSelectedItem() != null) {
													p.setProjectCategory(projectCategory.getSelectionModel()
															.getSelectedItem().toString());
												}
												p.setEmail(c.getEmail());
												p.setStatus(Enumeration.OrderStatus.WaitingProcess.toString());
												p.setCost(p.CalculateCost());
												p.setPrice(0);
												CarpentryLogic.getInstance().addProject(p);

												FXMLLoader loader = new FXMLLoader(
														getClass().getResource("/View/ProjectItems.fxml"));
												Parent pane = loader.load();
												Scene scene = new Scene(pane);
												Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
												stage.setScene(scene);
												stage.setTitle("Awni Wood Work - Project Items");
												stage.show();
											} else {
												try {
													final Alert alert = new Alert(Alert.AlertType.INFORMATION);
													alert.setTitle("Error!");
													alert.setContentText("Press OK to try again.");
													alert.setHeaderText("please enter a valid Email.");
													alert.showAndWait();
												} catch (Error e) {
													e.printStackTrace();
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										}
										
										else {
											try {
												final Alert alert = new Alert(Alert.AlertType.INFORMATION);
												alert.setTitle("Error!");
												alert.setContentText("Press OK to try again.");
												alert.setHeaderText("Sorry the customer phone number not valid!.");
												alert.showAndWait();
											} catch (Error e) {
												e.printStackTrace();
											} catch (Exception e) {
												e.printStackTrace();
											}
										
										
										}
//									} catch (NumberFormatException e) {
//										try {
//											final Alert alert = new Alert(Alert.AlertType.INFORMATION);
//											alert.setTitle("Error!");
//											alert.setContentText("Press OK to try again.");
//											alert.setHeaderText("Sorry the costumer phone sholdn`t include letters.");
//											alert.showAndWait();
//										} catch (Error e1) {
//											e1.printStackTrace();
//										} catch (Exception e1) {
//											e1.printStackTrace();
//										}
//									}
									
									
								}

								// Integer i = p.getProjectID();
								// setProjectID(i.toString());
							}
						
							flag=false;
						}
					 else if(flag){
								try {
									final Alert alert = new Alert(Alert.AlertType.INFORMATION);
									alert.setTitle("Error!");
									alert.setContentText("Press OK to try again.");
									alert.setHeaderText("please enter the missing value.");
									alert.showAndWait();
								} catch (Error e) {
									e.printStackTrace();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						
						break;
						}
				}
					
				
			}
		}

	}

	@FXML
	void ShowCsutomer(ActionEvent event) {
		if (customersemails.getSelectionModel().getSelectedItem() != null) {
			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
				if (c.getEmail() .equals(customersemails.getSelectionModel().getSelectedItem().toString())) {
					CustomerName.setText(c.getName());
					phoneNumber.setText(c.getPhoneNUMBER());
					address.setText(c.getAddress());
					email.setText(c.getEmail());

				}
			}
		}

	}

	@FXML
    void update_customerDetails(ActionEvent event) throws SQLException {

		if (!customersemails.getSelectionModel().getSelectedItem().equals(null)) {
			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
				if (c.getEmail().equals(customersemails.getSelectionModel().getSelectedItem())) {
//    			c.setName(CustomerName.getText());
//    			c.setPhoneNUMBER(phoneNumber.getText());
//    			c.setAddress(address.getText());
					String custname, custaddress, custphone, custemail;
					if (!CustomerName.getText().equals(null))
						custname = CustomerName.getText();
					else
						custname = c.getName();

					if (!address.getText().equals(null))
						custaddress = address.getText();
					else
						custaddress = c.getAddress();

					if (!phoneNumber.getText().equals(null))
						custphone = phoneNumber.getText();
					else
						custphone = c.getPhoneNUMBER();

					if (!email.getText().equals(null)) {
						custemail = email.getText();
						
						for(Project p : CarpentryLogic.getInstance().getProjects()) {
							if(p.getCustomerID().equals(c.getEmail()))
								CarpentryLogic.getInstance().updateCustomerEmailInProject(p, custemail);
						}
					}
					else
						custemail = c.getEmail();
					
					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Update!");
					alert.setContentText("Customer details updated succesfully!");
					alert.setHeaderText("Updated!");
					alert.showAndWait();
					CarpentryLogic.getInstance().updateCustomer(c, custname, custaddress, custphone, custemail);
					

					CustomersEmails();
				}
			}
		}

		else
			JOptionPane.showMessageDialog(null, "Please select email from the list.", "Email Reminder",
					JOptionPane.WARNING_MESSAGE);
    }
	
	public void CustomersEmails() {
		emailsarray.clear();
		customersemails.getItems().clear();
		for (Customer c : CarpentryLogic.getInstance().getCustomers()) {

			emailsarray.add(c.getEmail());
		}

		ObservableList<String> custEmails = FXCollections.observableArrayList(emailsarray);
		customersemails.getItems().addAll(custEmails);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
// TODO Auto-generated method stub
		
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(projectItems);
		Buttons.add(GenerateByAI);

		ObservableList<ProjectCategory> projectType = FXCollections.observableArrayList(ProjectCategory.Home,
				ProjectCategory.Office, ProjectCategory.Institution);
		projectCategory.getItems().addAll(projectType);

		ArrayList<String> emails = new ArrayList<>();
		for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
			emails.add(c.getEmail());
		}
		ObservableList<String> custEmails = FXCollections.observableArrayList(emails);
		customersemails.getItems().addAll(custEmails);

	}

}
