package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			             Statement stmt = con.createStatement()) {

			            String sql = "SELECT * FROM customer";
			            ResultSet rs = stmt.executeQuery(sql);

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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
		             Statement stmt = con.createStatement()) {

		            String sql = "SELECT * FROM ordertbl";
		            ResultSet rs = stmt.executeQuery(sql);
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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
		             Statement stmt = con.createStatement()) {

		            String sql = "SELECT * FROM project";
		            ResultSet rs = stmt.executeQuery(sql);
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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
		             Statement stmt = con.createStatement()) {

		            String sql = "SELECT * FROM projectitems";
		            ResultSet rs = stmt.executeQuery(sql);
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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
		             Statement stmt = con.createStatement()) {

		            String sql = "SELECT * FROM section";
		            ResultSet rs = stmt.executeQuery(sql);
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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
		             Statement stmt = con.createStatement()) {

		            String sql = "SELECT * FROM stock";
		            ResultSet rs = stmt.executeQuery(sql);
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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
		             Statement stmt = con.createStatement()) {

		            String sql = "SELECT * FROM orderedmaterials";
		            ResultSet rs = stmt.executeQuery(sql);
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


		
		public  boolean addCustomer(Customer c) throws ClassNotFoundException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into customer values(?, ?, ?, ?, ?)")){ 

					// int i = 1;
					stmt.setInt(1, c.getID()); // can't be null
					stmt.setString(2, c.getName());
					stmt.setString(3, c.getPhoneNUMBER());
					stmt.setString(4, c.getAddress());
					stmt.setString(5, c.getEmail());
					

					stmt.executeUpdate();
					return true;
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return false;
		}

		public  boolean addOrder(Order o) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into ordertbl values(?, ?, ?, ?, ?)")){ 
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
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into project values(?, ?, ?, ?)")){ 

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into orderedmaterials values(?, ?, ?, ?, ?)")){ 

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into projectitems values(?)")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into projectitems values(?,?, ?, ?, ?, ?, ?, ?, ?, ?)")){

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
					stmt.setString(10, pi.getHandsmodel());
					
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into section values(?, ?, ?, ?, ?, ?)")){

					// int i = 1;
					stmt.setInt(1, s.getSectionID()); // can't be null
					stmt.setString(2, s.getSectionName());
					stmt.setString(3, s.getProjectID());
					stmt.setInt(4, s.getQuantityOFhands());
					stmt.setInt(5, s.getQuantityOFaxle());
					stmt.setString(6, s.getAxleDegree());
					
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into stock values(?, ?, ?)")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE stock SET quantity = ? WHERE woodName=? AND stockID=?;")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET image = ? WHERE ProjectID=?;"
							)){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE * FROM OrderedMaterials WHERE OrderedMaterialsID=?];")){
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE ordertbl SET status = ? WHERE OrderID=?;")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET color = ? WHERE itemID=?;")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE section SET quantityOfAxle = ? WHERE sectionID=?;")){


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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE section SET sectinoName = ? WHERE sectionID=?")){


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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE section SET quantityOfHands = ? WHERE sectionID=?")){


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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET height = ? WHERE itemID=?")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET itemName = ? WHERE itemID=?")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET quantity =? WHERE itemID=?")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET section = ? WHERE itemID=?")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET width = ? WHERE itemID=?")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET woodType = ? WHERE itemID=?")){

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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE section SET axleDegree = ? WHERE sectionID=?")){


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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE section SET handsModel = ? WHERE sectionID=? AND projectID=?")){

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
		
		public boolean updateCustomer(Customer c,String name,String address,String phone, String email) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE customer SET name = ?, phoneNum = ?, adress = ? , Email=? WHERE ID=?")){


		        // set the parameter values for the prepared statement
				System.out.println("test1");
				
		        stmt.setString(1, name);
		        stmt.setString(2, phone);
		        stmt.setString(3, address);
		        stmt.setString(4, email);
		        stmt.setInt(5, c.getID());
		        // execute the prepared statement
		        stmt.executeUpdate();System.out.println("test2");
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE * FROM ordertbl WHERE OrderID = ?")){
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE * FROM project WHERE ProjectID = ?")){
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE * FROM projectitems WHERE itemID = ?")){
					
					
					stmt.setString(1, Integer.toString(pi.getItemID())); 
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE * FROM section WHERE sectionID = ?")){
					
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
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("SELECT Image FROM project WHERE ProjectID = ?")){
					
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

