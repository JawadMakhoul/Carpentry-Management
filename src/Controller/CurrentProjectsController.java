package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.healthmarketscience.jackcess.expr.NumericConfig.Type;

import Enumeration.OrderStatus;
import Model.CurrentProjectsToShow;
import Model.Customer;
import Model.GlobalProjectID;
import Model.Order;
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

public class CurrentProjectsController implements Initializable {

	
	@FXML
	private Button  Settings,GenerateByAI, NewProject, Stock, CurrentProjects
			, Inbox, BackButton;
	private HashSet<Button> Buttons = new HashSet<Button>();
	@FXML
	private AnchorPane screen;

	@FXML
	private TableColumn<CurrentProjectsToShow, String> customerName;

	@FXML
	private Button deleteOrder;

	@FXML
	private ComboBox<String> filter1, filter2;


	@FXML
	private Pane pnlOverview;

	@FXML
	private TableColumn<CurrentProjectsToShow, String> projectCategory;

	@FXML
	private TableColumn<CurrentProjectsToShow, String> projectID;

	@FXML
	private Button removeFilter;

	@FXML
	private Button searchBuuton,projectNotes;

	@FXML
	private TextField searchField1, searchField2;

	@FXML
	private TableColumn<CurrentProjectsToShow, String> customerEmail;

	@FXML
    private TableColumn<CurrentProjectsToShow, Integer> projectPrice;

	
    @FXML
    private TableColumn<CurrentProjectsToShow, String> projectStatus;
    
	@FXML
	private ComboBox<OrderStatus> statusList;

	@FXML
	private TableView<CurrentProjectsToShow> tableView;

	@FXML
	private Button updateStatus;


	
	@FXML
	private ScrollPane pnl;

	private static ProjectDetailsToShow pdts;

	public static ProjectDetailsToShow getPdts() {
		return pdts;
	}

	public static void setPdts(ProjectDetailsToShow pdts) {
		CurrentProjectsController.pdts = pdts;
	}

	@FXML
	void MoveTo(MouseEvent event) throws IOException {

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
	ArrayList<CurrentProjectsToShow> toSend = new ArrayList<>();
	@FXML
	void SearchEmailByLetter(KeyEvent event) {
		toSend.clear();
		searchField1.setOnKeyReleased(keyEvent -> {
			if (filter1.getSelectionModel().getSelectedItem().equals("Customer Email")) {
				
				String searchText = searchField1.getText().toLowerCase();
				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
				ObservableList<CurrentProjectsToShow> custOrders = FXCollections.observableArrayList();
				custOrders.clear();
				for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
					if (c.getEmail().toLowerCase().contains(searchText)) {
						for (Project p : CarpentryLogic.getInstance().getProjects()) {
							if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
										Integer.toString(p.getProjectID()), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
								
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
				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
				ObservableList<CurrentProjectsToShow> custOrders = FXCollections.observableArrayList();
				custOrders.clear();
				for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
					if (c.getName().toLowerCase().contains(searchText)) {
						for (Project p : CarpentryLogic.getInstance().getProjects()) {
							if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
										Integer.toString(p.getProjectID()), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
								
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
				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
				ObservableList<CurrentProjectsToShow> custOrders = FXCollections.observableArrayList();
				custOrders.clear();
				for (Project p : CarpentryLogic.getInstance().getProjects()) {
					if(Integer.toString(p.getProjectID()).contains(searchText)) {
						for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
						//if (c.getEmail().toLowerCase().contains(searchText)) {
						//for (Project p : CarpentryLogic.getInstance().getProjects()) {
							if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
										Integer.toString(p.getProjectID()), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
								
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
				ObservableList<CurrentProjectsToShow> toShowOb = FXCollections.observableArrayList();
				
				ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
				for (Project p : CarpentryLogic.getInstance().getProjects()) {
					if (p.getProjectCategory().toLowerCase().contains(searchText)) {
						//for(Customer c: CarpentryLogic.getInstance().getCustomers()) {
								// projOrders.add(o);
							//if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
								CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
										Integer.toString(p.getProjectID()), p.getProjectCategory(), p.getEmail(),p.getStatus(),p.getPrice());
								boolean flag=true;
								for(CurrentProjectsToShow cpts : toShow) {
									if(cpts.getProjectID().equals(cp.getProjectID()))
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

//		if (filter1.getSelectionModel().getSelectedItem().equals("Customer Email")) {
//			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
//				if (searchField1.getText().equals(c.getName())) {
//					ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
//					ObservableList<CurrentProjectsToShow> custOrders = FXCollections.observableArrayList();
//					for (Project p : CarpentryLogic.getInstance().getProjects()) {
//						if (p.getCustomerID().equals(searchField1.getText())) {
//							// custOrders.add(p);
//
//							for (Section s : CarpentryLogic.getInstance().getSections()) {
//									if(s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
//									// custOrders.add(pi);
//									CurrentProjectsToShow cpts = new CurrentProjectsToShow(c.getName(),
//											Integer.toString(p.getProjectID()), p.getProjectCategory(), s.getSectionName());
//									toShow.add(cpts);
//									}
//							}
//
//						}
//					}
//
//					custOrders.addAll(Search2(toShow));
//					tableView.setItems(custOrders);
//				}
//			}
//		}
//
//		if (filter1.getSelectionModel().getSelectedItem().equals("Project ID")) {
//			for (Project p : CarpentryLogic.getInstance().getProjects()) {
//				if (searchField1.getText().equals(Integer.toString(p.getProjectID()))) {
//					ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
//					ObservableList<CurrentProjectsToShow> toShowOb = FXCollections.observableArrayList();
//					for (Section s : CarpentryLogic.getInstance().getSections()) {
//						if (s.getProjectID().equals(searchField1.getText())) {
//							// projOrders.add(o);
//							CurrentProjectsToShow cpts = new CurrentProjectsToShow(p.getCustomerID(),
//									Integer.toString(p.getProjectID()), p.getProjectCategory(), s.getSectionName());
//							toShow.add(cpts);
//						}
//
//					}
//					toShowOb.addAll(Search2(toShow));
//					tableView.setItems(toShowOb);
//				}
//			}
//		}
//
//		if (filter1.getSelectionModel().getSelectedItem().equals("Project Category")) {
//			ObservableList<CurrentProjectsToShow> toShowOb = FXCollections.observableArrayList();
//			for (Project p : CarpentryLogic.getInstance().getProjects()) {
//				if (searchField1.getText().equals(p.getProjectCategory())) {
//					ArrayList<CurrentProjectsToShow> toShow = new ArrayList<>();
//
//					for (Section s : CarpentryLogic.getInstance().getSections()) {
//						if (s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
//							// projOrders.add(o);
//							CurrentProjectsToShow cpts = new CurrentProjectsToShow(p.getCustomerID(),
//									Integer.toString(p.getProjectID()), p.getProjectCategory(),s.getSectionName());
//							toShow.add(cpts);
//						}
//
//					}
//
//					toShowOb.addAll(toShow);
//				}
//			}
//			tableView.setItems(toShowOb);
//		}

	}
	// ********************************************************************************************************

	ArrayList<CurrentProjectsToShow> Search2(ArrayList<CurrentProjectsToShow> arr) {
		ArrayList<CurrentProjectsToShow> toshow = new ArrayList<>();
		if (filter2.getSelectionModel().getSelectedItem() == null ) {System.out.println(",null");
			return arr;
		}
	
		if (filter2.getSelectionModel().getSelectedItem().equals("Customer Name")) {
			for (CurrentProjectsToShow c : arr) {
				if (c.getCustomerName().toLowerCase().contains(searchField2.getText())) {
					toshow.add(c);

				}
			}
		}
		
		if (filter2.getSelectionModel().getSelectedItem().equals("Customer Email")) {
			for (CurrentProjectsToShow c : arr) {
				if (c.getCustomerEmail().toLowerCase().contains(searchField2.getText())) {
					toshow.add(c);

				}
			}
		}
		
		if (filter2.getSelectionModel().getSelectedItem().equals("Project ID")) {
			for (CurrentProjectsToShow p : arr) {
				if (p.getProjectID().toLowerCase().contains(searchField2.getText())) {
				//tableView.setItems(null);
					toshow.add(p);

				}

			}
		}

		if (filter2.getSelectionModel().getSelectedItem().equals("Project Category")) {
			for (CurrentProjectsToShow p : arr) {
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
    	{	System.out.println("the seccound one is not null");
    	
    	ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
		//ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
    	ObservableList_CP.addAll(Search2(toSend));
//      orders.addAll(arraylistProject);
//      orders.addAll(arraylistProjectItems);
    	
		tableView.setItems(ObservableList_CP);
    	}
    }

	@FXML
	void RemoveFilter(ActionEvent event) {
		ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
		ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
				
				if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
					CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
							Integer.toString(p.getProjectID()), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
					
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
			if (tableView.getSelectionModel().getSelectedItem().getProjectID()
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

		ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
		ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			for (Section s : CarpentryLogic.getInstance().getSections()) {
				if (s.getProjectID().equals(Integer.toString(p.getProjectID()))) {
							CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
									Integer.toString(p.getProjectID()), p.getProjectCategory(), p.getEmail(),p.getStatus(),p.getPrice());
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

		pdts.setCustomerName(tableView.getSelectionModel().getSelectedItem().getCustomerName());
		System.out.println(pdts.getCustomerName());
		pdts.setProjectID(tableView.getSelectionModel().getSelectedItem().getProjectID());
		System.out.println(pdts.getProjectID());
		pdts.setProjectCategory(tableView.getSelectionModel().getSelectedItem().getProjectCategory());
		System.out.println(pdts.getProjectCategory());
		pdts.setSection(tableView.getSelectionModel().getSelectedItem().getCustomerEmail());
		//System.out.println(pdts.getCustomerName());
		// pdts.setModelNumberOFhands(tableView.getSelectionModel().getSelectedItem().getModelNumberOFhands());
		
		
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
    		if(tableView.getSelectionModel().getSelectedItem().getProjectID().equals(Integer.toString(p.getProjectID()))) {System.out.println("update status");
    			CarpentryLogic.getInstance().updateProjectStatus(p, statusList.getSelectionModel().getSelectedItem().toString());
    		}
    	}
    	
    	 ObservableList<CurrentProjectsToShow> orders = FXCollections.observableArrayList();
	        ArrayList<CurrentProjectsToShow> arraylistOrders =  new ArrayList<>();
	        for (Project p : CarpentryLogic.getInstance().getProjects()) {
				for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
					
					if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
						CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
								Integer.toString(p.getProjectID()), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
						
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
//		Parent pane = FXMLLoader.load(getClass().getResource("/View/ProjectNotes.fxml"));
//		Scene scene = new Scene(pane);
//		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		stage.setScene(scene);
//		stage.setResizable(false);
//		stage.setTitle("Awni Wood Work - Project Notes");
//		stage.show();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ProjectNotes.fxml"));
		
	    Parent root = loader.load();
	    
	    // Get the controller of the second scene
	    NotesController controller = loader.getController();
	    
	    // Send data
	    String myData = tableView.getSelectionModel().getSelectedItem().getProjectID();
	   
	    controller.setData(myData);
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Buttons.add(CurrentProjects);
		Buttons.add(Stock);
		Buttons.add(NewProject);
		Buttons.add(Inbox);
		Buttons.add(BackButton);
		Buttons.add(GenerateByAI);
		Buttons.add(Settings);
		
		ObservableList<String> Filter = FXCollections.observableArrayList("Customer Name","Customer Email", "Project ID",
				"Project Category");
		filter1.getItems().addAll(Filter);
		filter2.getItems().addAll(Filter);

		customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
		customerEmail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
		projectID.setCellValueFactory(new PropertyValueFactory<>("projectID"));
		projectCategory.setCellValueFactory(new PropertyValueFactory<>("projectCategory"));
		projectStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		projectPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		

		ObservableList<CurrentProjectsToShow> ObservableList_CP = FXCollections.observableArrayList();
		ArrayList<CurrentProjectsToShow> arraylistToShow = new ArrayList<>();
		for (Project p : CarpentryLogic.getInstance().getProjects()) {
			for (Customer c : CarpentryLogic.getInstance().getCustomers()) {
				
				if (c.getName().equals(p.getCustomerID()) && c.getEmail().equals(p.getEmail())) {
					CurrentProjectsToShow cp = new CurrentProjectsToShow(p.getCustomerID(),
							Integer.toString(p.getProjectID()), p.getProjectCategory(), c.getEmail(),p.getStatus(),p.getPrice());
					
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
