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
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_ORDERS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Order(rs.getInt(i++),rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getInt(i++)));
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
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PROJECTS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Project(rs.getInt(i++),rs.getString(i++), rs.getString(i++)));
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
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_PROJECTITEMS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new ProjectItems(rs.getInt(i++),rs.getString(i++),rs.getInt(i++),rs.getInt(i++), rs.getString(i++),rs.getInt(i++),rs.getString(i++),
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
						results.add(new Section(rs.getInt(i++), rs.getString(i++),rs.getString(i++),rs.getInt(i++),rs.getInt(i++),rs.getString(i++)));
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
						results.add(new Stock(rs.getString(i++),rs.getString(i++), rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<Model.OrderedMaterials> getOrderedMaterials() {

			ArrayList<Model.OrderedMaterials> results = new ArrayList<Model.OrderedMaterials>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_ORDEREDMATERIALS);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Model.OrderedMaterials(rs.getInt(i++),rs.getString(i++),rs.getString(i++), rs.getInt(i++),rs.getString(i++)));
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

		public  boolean addOrder(Order o) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_ORDERS)) {
					// int i = 1;
					stmt.setInt(1, o.getOrderID()); // can't be null
					stmt.setString(2, o.getCustomerName());
					stmt.setString(3, o.getProjectID());
					stmt.setString(4, o.getStatus());
					stmt.setInt(5, o.getCost());
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

		public  boolean addProject(Project p) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_PROJECTS)) {

					// int i = 1;
					stmt.setInt(1, p.getProjectID());
					stmt.setString(2, p.getCustomerID());
					stmt.setString(3, p.getProjectCategory()); // can't be null
					stmt.setString(4, null);
					

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
		
		public  boolean addOrderedMaterials(Model.OrderedMaterials om) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_ORDEREDMATERIALS)) {

					// int i = 1;
					stmt.setInt(1, om.getOrderMaterialsID());
					stmt.setString(2, om.getStockID());
					stmt.setString(3, om.getWoodName());
					stmt.setInt(4, om.getQuantity()); // can't be null
					stmt.setString(5, "On_The_Way");
					

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
		public  boolean addProjectItems(ProjectItems pi) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_PROJECTITEMS)) {

					// int i = 1;
					stmt.setInt(1, pi.getItemID()); // can't be null
					stmt.setString(2, pi.getItemName());
					stmt.setInt(3, pi.getHeight());
					stmt.setInt(4, pi.getWidth());
					stmt.setString(5, pi.getWoodType());
					stmt.setInt(6, pi.getQuantity());
					stmt.setString(7, pi.getProjectID());
					stmt.setString(8, pi.getSection());
					stmt.setString(9, pi.getColor());
					stmt.setString(10, pi.getModelNumberOfHands());
					
					
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
		
		public  boolean addSection(Section s) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SECTION)) {

					// int i = 1;
					stmt.setInt(1, s.getSectionID()); // can't be null
					stmt.setString(2, s.getSectionName());
					stmt.setString(3, s.getProjectID());
					stmt.setInt(4, s.getQuantityOFhands());
					stmt.setInt(5, s.getQuantityOFaxle());
					stmt.setString(6, s.getAxleDegree());
					//stmt.setString(6, s.getProjectSection());
					
					
					
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
		
		public  boolean addStock(Stock s) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_STOCK)) {

					// int i = 1;
					stmt.setString(1, s.getStockID()); // can't be null
					stmt.setString(2, s.getWoodName());
					stmt.setInt(3, s.getQuantity());
					
					
					
					
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
		
		public boolean updateStockQuantity(Stock s,int newQuantity) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_STOCK)) {

		        // set the parameter values for the prepared statement
				stmt.setString(3,s.getStockID());
				stmt.setString(2, s.getWoodName());
		        stmt.setInt(1, newQuantity);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean addProjectImage(int p, String image) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_ADD_PROJECTIMAGE)) {

		        // set the parameter values for the prepared statement
				
				stmt.setString(1, image);
		        stmt.setInt(2, p);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public  boolean DeleteOrderedMaterials(Model.OrderedMaterials om) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_ORDEREDMATERIALS)) {
					
					stmt.setInt(1, om.getOrderMaterialsID());
					
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
		
		public boolean updateProjectStatus(Order o,String orderStatus) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_STATUS)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, o.getOrderID());
		        stmt.setString(1, orderStatus);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateItemColor(ProjectItems pi,String color) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_COLOR)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setString(1, color);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateAxleQuantity(Section s,int q) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_AXLE_QUANTITY)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, s.getSectionID());
		        stmt.setInt(1, q);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateSectionName(Section s,String name) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_SECTION_NAME)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, s.getSectionID());
		        stmt.setString(1, name);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateHandsQuantity(Section s,int q) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_HANDS_QUANTITY)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, s.getSectionID());
		        stmt.setInt(1, q);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateItemHeight(ProjectItems pi,int height) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_HEIGHT)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setInt(1, height);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateItemName(ProjectItems pi,String name) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_NAME)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setString(1, name);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateItemQuantity(ProjectItems pi,int q) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_QUANTITY)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setInt(1, q);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateItemSection(ProjectItems pi,String s) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_SECTION)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setString(1, s);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateItemWidth(ProjectItems pi,int width) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_WIDTH)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setInt(1, width);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateWoodType(ProjectItems pi,String woodType) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_WOOD_TYPE)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setString(1, woodType);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateAxleDegree(Section s,String degree) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_AXLE_DEGREE)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, s.getSectionID());
		        stmt.setString(1, degree);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateModelOfHands(ProjectItems pi,String handsmodel) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_MODEL_OF_HANDS)) {

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setString(1, handsmodel);
		        
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public boolean updateCustomer(Customer c,String name,String address,String phone) throws SQLException {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_CUSTOMER)) {

		        // set the parameter values for the prepared statement
				
				
		        stmt.setString(1, name);
		        stmt.setString(2, phone);
		        stmt.setString(3, address);
		        stmt.setInt(4, c.getID());
		        // execute the prepared statement
		        stmt.executeUpdate();
		        return true;
		        // check if any rows were updated
		        
		}
				} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;

	}
		
		public  boolean DeleteOrder(Order o) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_ORDER)) {
					
					stmt.setInt(1, o.getOrderID());
					
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
		
		public  boolean DeleteProject(Project p) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_PROJECT)) {
					
					stmt.setInt(1, p.getProjectID());
					
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
		
		public  boolean DeleteProjectItems(ProjectItems pi) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_PROJECTITEMS)) {
					
					stmt.setString(1, pi.getProjectID());
					
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
		
		public  boolean DeleteSection(Section s) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_SECTION)) {
					
					stmt.setString(1, s.getProjectID());
					
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
		
		public  String GetImage(Project p) {
			
			String result = null;
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_SEL_PROJECT_IMAGE)) {
					
					stmt.setInt(1, p.getProjectID());
					
					 ResultSet rs = stmt.executeQuery();
			            
			            // If the ResultSet has a result, assign it to the 'result' variable
			            if (rs.next()) {
			                result = rs.getString(1); // Adjust this if your image is not the first column in the ResultSet
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			    return result;
		}

}

