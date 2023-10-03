package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
//
//import com.healthmarketscience.jackcess.expr.NumericConfig.Type;

import Enumeration.OrderStatus;
import Model.Customer;
import Model.GlobalProjectID;
import Model.Project;
import Model.ProjectDetailsToShow;
import Model.ProjectItems;
import Model.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProjectsToShowController implements Initializable {

	
	@FXML
	private Button  Settings,GenerateByAI, NewProject, Stock, Projects
			, Email, BackButton;
	private HashSet<Button> Buttons = new HashSet<Button>();
	@FXML
	private AnchorPane screen;

	@FXML
	private TableColumn<Project, String> customerName;

	@FXML
	private Button deleteOrder;

	@FXML
	private ComboBox<String> filter1, filter2;


	@FXML
	private Pane pnlOverview;

	@FXML
	private TableColumn<Project, String> projectCategory;

	@FXML
	private TableColumn<Project, String> projectID;

	@FXML
	private Button removeFilter;

	@FXML
	private Button searchBuuton,projectNotes;

	@FXML
	private TextField searchField1, searchField2;

	@FXML
	private TableColumn<Project, String> customerEmail;

	@FXML
    private TableColumn<Project, Integer> projectPrice;

	
    @FXML
    private TableColumn<Project, String> projectStatus;
    
	@FXML
	private ComboBox<OrderStatus> statusList;

	@FXML
	private TableView<Project> tableView;

	@FXML
	private Button updateStatus;


	
	@FXML
	private ScrollPane pnl;

	private static ProjectDetailsToShow pdts;

	public static ProjectDetailsToShow getPdts() {
		return pdts;
	}

	public static void setPdts(ProjectDetailsToShow pdts) {
		ProjectsToShowController.pdts = pdts;
	}

	@FXML
	void MoveTo(MouseEvent event) throws IOException {

		for (Button b : Buttons) {
			if (b.isPressed()) {

				switch (b.getId()) {

				case "Email": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Email.fxml"));
					Scene scene = new Scene(pane);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Awni Wood Work - Email");
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

				case "Projects": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Projects.fxml"));
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
				
				case "sendEmail": {
					Parent pane = FXMLLoader.load(getClass().getResource("/View/Send.fxml"));
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
	ArrayList<Project> toSend = new ArrayList<>();
	@FXML
	void SearchEmailByLetter(KeyEvent event) {
		toSend.clear();
		searchField1.setOnKeyReleased(keyEvent -> {
			if (filter1.getSelectionModel().getSelectedItem().equals("Customer Email")) {
				
				String searchText = searchField1.getText().toLowerCase();
				ArrayList<Project> toShow = new ArrayList<>();
				ObservableList<Project> custOrders = FXCollections.observableArrayList();
				custOrders.clear();
				for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
					if (c.getEmail().toLowerCase().contains(searchText)) {
						for (Project p : CarpentryLogic.getInstance().getProjects()) {
							if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								Project cp = new Project(p.getCustomerID(),
										p.getProjectID(), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
								
								toShow.add(cp);
								toSend.add(cp);
							}
						}
					}
				}

				custOrders.addAll(Search2(toShow));
				tableView.setItems(custOrders);
			}
			
			else if (filter1.getSelectionModel().getSelectedItem().equals("Customer Name")) {
				String searchText = searchField1.getText().toLowerCase();
				ArrayList<Project> toShow = new ArrayList<>();
				ObservableList<Project> custOrders = FXCollections.observableArrayList();
				custOrders.clear();
				for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
					if (c.getName().toLowerCase().contains(searchText)) {
						for (Project p : CarpentryLogic.getInstance().getProjects()) {
							if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								Project cp = new Project(p.getCustomerID(),
										p.getProjectID(), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
								
								toShow.add(cp);
								toSend.add(cp);

							}
						}
					}
				}

				custOrders.clear();
				
				
				custOrders.addAll(Search2(toShow));
				System.out.println(Search2(toShow));
				tableView.setItems(custOrders);
			}
		
		
			else if (filter1.getSelectionModel().getSelectedItem().equals("Project ID")) {
				String searchText = searchField1.getText();
				ArrayList<Project> toShow = new ArrayList<>();
				ObservableList<Project> custOrders = FXCollections.observableArrayList();
				custOrders.clear();
				for (Project p : CarpentryLogic.getInstance().getProjects()) {
					if(Integer.toString(p.getProjectID()).contains(searchText)) {
						for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
						//if (c.getEmail().toLowerCase().contains(searchText)) {
						//for (Project p : CarpentryLogic.getInstance().getProjects()) {
							if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								Project cp = new Project(p.getCustomerID(),
										p.getProjectID(), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
								
								toShow.add(cp);
								toSend.add(cp);

							}
						}
					}
				}

				custOrders.addAll(Search2(toShow));
				tableView.setItems(custOrders);
			}
		
		
			else 	if (filter1.getSelectionModel().getSelectedItem().equals("Project Category")) {
				String searchText = searchField1.getText();
				ObservableList<Project> toShowOb = FXCollections.observableArrayList();
				
				ArrayList<Project> toShow = new ArrayList<>();
				for (Project p : CarpentryLogic.getInstance().getProjects()) {
					if (p.getProjectCategory().toLowerCase().contains(searchText)) {
						//for(Customer c: CarpentryLogic.getInstance().getCustomers()) {
								// projOrders.add(o);
							//if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
						Project cp = new Project(p.getCustomerID(),
										p.getProjectID(), p.getProjectCategory(), p.getEmail(),p.getStatus(),p.getPrice());
								boolean flag=true;
								for(Project cpts : toShow) {
									if(Integer.toString(cpts.getProjectID()).equals(cp.getProjectID()))
										flag=false;
										
								}
								
								if(flag)
									toShow.add(cp);
								    toSend.add(cp);

							//}
								
						//}
					}
				}
				toShowOb.clear();
				//toShowOb.addAll(toShow);
				toShowOb.addAll(Search2(toShow));
				tableView.setItems(toShowOb);
			}
		});
		
		
	}

	@FXML
	void Search(ActionEvent event) {

	}
	
	ArrayList<Project> Search2(ArrayList<Project> arr) {
		ArrayList<Project> toshow = new ArrayList<>();
		if (filter2.getSelectionModel().getSelectedItem() == null ) {System.out.println(",null");
			return arr;
		}
	
		if (filter2.getSelectionModel().getSelectedItem().equals("Customer Name")) {
			for (Project c : arr) {
				if (c.getCustomerID().toLowerCase().contains(searchField2.getText())) {
					toshow.add(c);

				}
			}
		}
		
		if (filter2.getSelectionModel().getSelectedItem().equals("Customer Email")) {
			for (Project c : arr) {
				if (c.getEmail().toLowerCase().contains(searchField2.getText())) {
					toshow.add(c);

				}
			}
		}
		
		if (filter2.getSelectionModel().getSelectedItem().equals("Project ID")) {
			for (Project p : arr) {
				if (Integer.toString(p.getProjectID()).toLowerCase().contains(searchField2.getText())) {
				//tableView.setItems(null);
					toshow.add(p);

				}

			}
		}

		if (filter2.getSelectionModel().getSelectedItem().equals("Project Category")) {
			for (Project p : arr) {
				if (p.getProjectCategory().toLowerCase().contains(searchField2.getText())) {
					toshow.add(p);

				}
			}
		}

		//searchField2.setText(null);
		
		return toshow;
	}
	
    @FXML
    void SearchByLetter(KeyEvent event) {
    	if(filter2.getSelectionModel().getSelectedItem() != null)
    	{	
    	
    	ObservableList<Project> ObservableList_CP = FXCollections.observableArrayList();
		//ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
    	ObservableList_CP.addAll(Search2(toSend));
//      orders.addAll(arraylistProject);
//      orders.addAll(arraylistProjectItems);
    	
		tableView.setItems(ObservableList_CP);
    	}
    }

	@FXML
	void RemoveFilter(ActionEvent event) {
		ObservableList<Project> ObservableList_CP = FXCollections.observableArrayList();
		ArrayList<Project> arraylistToShow = new ArrayList<>();
		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
				
				if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
					Project cp = new Project(p.getCustomerID(),
							p.getProjectID(), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
					
					arraylistToShow.add(cp);
				}

			}
		}
			
		
		ObservableList_CP.addAll(arraylistToShow);

		tableView.setItems(ObservableList_CP);
		searchField1.setText(null);

	}

	@FXML
	void Delete_Project(ActionEvent event) {

		if (tableView.getSelectionModel().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Please select a project before deleting.",
					"Deleting a project reminder", JOptionPane.WARNING_MESSAGE);
		}

		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			if (Integer.toString(tableView.getSelectionModel().getSelectedItem().getProjectID())
					.equals(Integer.toString(p.getProjectID()))) {
				CarpentryLogic.getInstance().DeleteProject(p);

				for (ProjectItems pi : CarpentryLogic.getInstance().getProjectItems()) {
					if (pi.getProjectID().equals(Integer.toString(p.getProjectID()))) {
						CarpentryLogic.getInstance().DeleteProjectItems(pi);
					}
				}

				for (Section s : CarpentryLogic.getInstance().getSections()) {
					if (s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
						CarpentryLogic.getInstance().DeleteSection(s);
					}
				}
				
//				for(Order o: CarpentryLogic.getInstance().getOrders()) {
//					if(o.getProjectID().equals(Integer.toString(p.getProjectID()))) {
//						CarpentryLogic.getInstance().DeleteOrder(o);
//					}
//				}

			}
		}

		ObservableList<Project> ObservableList_CP = FXCollections.observableArrayList();
		ArrayList<Project> arraylistToShow = new ArrayList<>();
		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			for (Section s : CarpentryLogic.getInstance().getSections()) {
				if (s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
					Project cp = new Project(p.getCustomerID(),
									p.getProjectID(), p.getProjectCategory(), p.getEmail(),p.getStatus(),p.getPrice());
							arraylistToShow.add(cp);
						

				}
			}
		}
		ObservableList_CP.addAll(arraylistToShow);

		tableView.setItems(ObservableList_CP);
	}


	@FXML
	void ShowProjectDetails(ActionEvent event) throws IOException {
		// tableView
		if (tableView.getSelectionModel().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Please select a project before deleting.",
					"Deleting a project reminder", JOptionPane.WARNING_MESSAGE);
		}

		pdts.setCustomerName(tableView.getSelectionModel().getSelectedItem().getCustomerID());
		pdts.setProjectID(Integer.toString(tableView.getSelectionModel().getSelectedItem().getProjectID()));
		pdts.setProjectCategory(tableView.getSelectionModel().getSelectedItem().getProjectCategory());
		pdts.setSection(tableView.getSelectionModel().getSelectedItem().getEmail());
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectDetails.fxml"));
	    Parent root = loader.load();
		
		
		
	    
	    // Get the controller of the second scene
	    String myData = pdts.getProjectID();
	    ProjectDetailsToShowController controller = loader.getController();
	    
	    // Send data
	    
	    
	    controller.setData(myData);

	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.show();
	}

	@FXML
    void Update_Status(ActionEvent event) throws SQLException {
    	if(tableView.getSelectionModel().getSelectedItem()!= null) {System.out.println("if");
    	for(Project p : CarpentryLogic.getInstance().getProjects()) {
    		if(Integer.toString(tableView.getSelectionModel().getSelectedItem().getProjectID()).equals(Integer.toString(p.getProjectID()))) {
    			CarpentryLogic.getInstance().updateProjectStatus(p, statusList.getSelectionModel().getSelectedItem().toString());
    		}
    	}
    	
    	 ObservableList<Project> orders = FXCollections.observableArrayList();
	        ArrayList<Project> arraylistOrders =  new ArrayList<>();
	        for (Project p : CarpentryLogic.getInstance().getProjects()) {
				for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
					
					if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
						Project cp = new Project(p.getCustomerID(),
							p.getProjectID(), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
						
						arraylistOrders.add(cp);
					}

				}
			}
	        orders.addAll(arraylistOrders);
	        
	        tableView.setItems(orders);
	        
    }
    }
	
	 
	@FXML
    void Open_Notes(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectNotes.fxml"));
		
	    Parent root = loader.load();
	    
	    // Get the controller of the second scene
	    NotesController controller = loader.getController();
	    
	    // Send data
	    String myData = Integer.toString(tableView.getSelectionModel().getSelectedItem().getProjectID());
	   
	    controller.setData(myData);
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
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
		
		ObservableList<String> Filter = FXCollections.observableArrayList("Customer Name","Customer Email", "Project ID",
				"Project Category");
		filter1.getItems().addAll(Filter);
		filter2.getItems().addAll(Filter);

		customerName.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		customerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		projectID.setCellValueFactory(new PropertyValueFactory<>("projectID"));
		projectCategory.setCellValueFactory(new PropertyValueFactory<>("projectCategory"));
		projectStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		projectPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		

		ObservableList<Project> ObservableList_CP = FXCollections.observableArrayList();
		ArrayList<Project> arraylistToShow = new ArrayList<>();
		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
				
				if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
					Project cp = new Project(p.getCustomerID(),
							p.getProjectID(), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
					
					arraylistToShow.add(cp);
				}

			}
		}

		ObservableList<OrderStatus> updatecomboBox = FXCollections.observableArrayList(OrderStatus.WaitingProcess,OrderStatus.Canceled,OrderStatus.Delivered,OrderStatus.Finished,OrderStatus.InProgress);
		statusList.getItems().addAll(updatecomboBox);
		
		ObservableList_CP.addAll(arraylistToShow);
//        orders.addAll(arraylistProject);
//        orders.addAll(arraylistProjectItems);

		tableView.setItems(ObservableList_CP);
	}

}
