package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Consts;
import Model.Customer;
import Model.Order;
import Model.Project;
import Model.ProjectItems;
import Model.Section;
import Model.Stock;

public class CarpentryLogic {

	

		private static CarpentryLogic _instance;

		private CarpentryLogic() {
		}

		public static CarpentryLogic getInstance() {
			if (_instance == null)
				_instance = new CarpentryLogic();
			return _instance;
		}

		public  ArrayList<Customer> getCustomers() {

			ArrayList<Customer> results = new ArrayList<Customer>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

				String Name = Consts.CONN_STR;
				System.out.println(Name);
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CUSTOMERS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Customer(rs.getInt(i++),rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<Order> getOrders() {

			ArrayList<Order> results = new ArrayList<Order>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

				String Name = Consts.CONN_STR;
				System.out.println(Name);
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_ORDERS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Order(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++), rs.getString(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<Project> getProjects() {

			ArrayList<Project> results = new ArrayList<Project>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

				String Name = Consts.CONN_STR;
				System.out.println(Name);
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PROJECTS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Project( rs.getInt(i++), rs.getString(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<ProjectItems> getProjectItems() {

			ArrayList<ProjectItems> results = new ArrayList<ProjectItems>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

				String Name = Consts.CONN_STR;
				System.out.println(Name);
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PROJECTITEMS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new ProjectItems(rs.getString(i++),rs.getInt(i++),rs.getInt(i++), rs.getString(i++),rs.getInt(i++),rs.getInt(i++),
								rs.getString(i++), rs.getString(i++), rs.getString(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<Section> getSections() {

			ArrayList<Section> results = new ArrayList<Section>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_SECTION);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Section(rs.getString(i++), rs.getInt(i++),rs.getInt(i++),rs.getInt(i++), rs.getString(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<Stock> getStocks() {

			ArrayList<Stock> results = new ArrayList<Stock>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_STOCK);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Stock(rs.getString(i++), rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		

		
		public  boolean addCustomer(Customer c) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_CUSTOMER)) {

					// int i = 1;
					stmt.setInt(1, c.getID()); // can't be null
					stmt.setString(2, c.getName());
					stmt.setString(3, c.getPhoneNUMBER());
					stmt.setString(4, c.getAddress());
					stmt.setString(5, c.getEmail());
					

					stmt.executeUpdate();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}

		public  boolean addOrder(int personID, int orderID, int projectID, String status) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_ORDERS)) {
					// int i = 1;
					stmt.setInt(1, personID); // can't be null
					stmt.setInt(2, orderID);
					stmt.setInt(3, projectID);
					stmt.setString(4, status);

					stmt.executeUpdate();
					
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}

		public  boolean addProject( int customerID, String projectCategory) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_PROJECTS)) {

					// int i = 1;
					
					stmt.setInt(2,customerID);
					stmt.setString(3, projectCategory); // can't be null

					

					stmt.executeUpdate();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public  boolean addProjectItemsByProjectID(int projectID) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_PROJECTITEMS)) {

					// int i = 1;
//					stmt.setString(1, null); // can't be null
//					stmt.setInt(2, null);
//					stmt.setInt(3, null);
//					stmt.setString(4, null);
//					stmt.setInt(5, null);
					stmt.setInt(6, projectID);
//					stmt.setString(7, null);
//					stmt.setString(8, null);
//					stmt.setString(9, null);
					
					
					stmt.executeUpdate();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		public  boolean addProjectItems(String itemName, int height, int width, String woodType, int quantity, int projectID,
				String section, String color, String modelNumberOfHands) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_PROJECTITEMS)) {

					// int i = 1;
					stmt.setString(1, itemName); // can't be null
					stmt.setInt(2, height);
					stmt.setInt(3, width);
					stmt.setString(4, woodType);
					stmt.setInt(5, quantity);
					stmt.setInt(6, projectID);
					stmt.setString(7, section);
					stmt.setString(8, color);
					stmt.setString(9, modelNumberOfHands);
					
					
					stmt.executeUpdate();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public  boolean addSection(String sectionName,int projectID, int quantityOFhands, int quantityOFaxle, String projectSection) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SECTION)) {

					// int i = 1;
					stmt.setString(1, sectionName); // can't be null
					stmt.setInt(2, projectID);
					stmt.setInt(3, quantityOFhands);
					stmt.setInt(4, quantityOFaxle);
					stmt.setString(5, projectSection);
					
					
					
					stmt.executeUpdate();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public  boolean addStock(String woodName, int quantity) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_STOCK)) {

					// int i = 1;
					stmt.setString(1, woodName); // can't be null
					stmt.setInt(2, quantity);
					
					
					
					
					stmt.executeUpdate();
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return false;
		}
	}


