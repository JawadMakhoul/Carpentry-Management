package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Axles;
import Model.Customer;
import Model.Hands;
import Model.Project;
import Model.ProjectItems;
import Model.Section;
import Model.Stock;
import Model.Supplier;
import Model.WoodType;

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

		public  ArrayList<Axles> getAxles() {

			ArrayList<Axles> results = new ArrayList<Axles>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			             Statement stmt = con.createStatement()) {

			            String sql = "SELECT * FROM axles";
			            ResultSet rs = stmt.executeQuery(sql);

			            while (rs.next()) {
						int i = 1;
						results.add(new Axles(rs.getInt(i++),rs.getString(i++),rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		
		public  ArrayList<Hands> getHands() {

			ArrayList<Hands> results = new ArrayList<Hands>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			             Statement stmt = con.createStatement()) {

			            String sql = "SELECT * FROM hands";
			            ResultSet rs = stmt.executeQuery(sql);

			            while (rs.next()) {
						int i = 1;
						results.add(new Hands(rs.getInt(i++),rs.getString(i++),rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		
		public  ArrayList<Supplier> getSupplier() {

			ArrayList<Supplier> results = new ArrayList<Supplier>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			             Statement stmt = con.createStatement()) {

			            String sql = "SELECT * FROM supplier";
			            ResultSet rs = stmt.executeQuery(sql);

			            while (rs.next()) {
						int i = 1;
						results.add(new Supplier(rs.getInt(i++),rs.getString(i++),rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}

		public  ArrayList<WoodType> getWoodType() {

			ArrayList<WoodType> results = new ArrayList<WoodType>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			             Statement stmt = con.createStatement()) {

			            String sql = "SELECT * FROM woodtype";
			            ResultSet rs = stmt.executeQuery(sql);

			            while (rs.next()) {
						int i = 1;
						results.add(new WoodType(rs.getInt(i++),rs.getString(i++),rs.getInt(i++),rs.getInt(i++)));
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
						results.add(new Project(rs.getInt(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++)));
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
						results.add(new ProjectItems(rs.getInt(i++),rs.getString(i++),rs.getInt(i++),rs.getInt(i++),rs.getInt(i++), rs.getString(i++),rs.getInt(i++),rs.getString(i++),
								rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++)));
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
						results.add(new Stock(rs.getInt(i++),rs.getString(i++), rs.getInt(i++)));
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
						results.add(new Model.OrderedMaterials(rs.getInt(i++),rs.getInt(i++),rs.getString(i++), rs.getInt(i++),rs.getString(i++)));
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

		public  boolean addAxle(Axles c) throws ClassNotFoundException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into axles values(?, ?, ?)")){ 

					// int i = 1;
					stmt.setInt(1, c.getAxlesID()); // can't be null
					stmt.setString(2, c.getAxleName());
					stmt.setInt(3, c.getAxleCost());
					

					stmt.executeUpdate();
					return true;
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return false;
		}
		
		public  boolean addHands(Hands c) throws ClassNotFoundException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into hands values(?, ?, ?)")){ 

					// int i = 1;
					stmt.setInt(1, c.getIdhands()); // can't be null
					stmt.setString(2, c.getHandsName());
					stmt.setInt(3, c.getHandsCost());
					

					stmt.executeUpdate();
					return true;
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return false;
		}
		
		public  boolean addSupplier(Supplier c) throws ClassNotFoundException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into supplier values(?,  ?,?)")){ 

					// int i = 1;
					stmt.setInt(1, c.getIdsupplier()); // can't be null
					stmt.setString(2, c.getSupplierEmail());
					stmt.setInt(3, c.getAutoOrder());

					stmt.executeUpdate();
					return true;
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return false;
		}
		
		public  boolean addWoodType(WoodType c) throws ClassNotFoundException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into woodtype values(?, ?, ?,?)")){ 

					// int i = 1;
					stmt.setInt(1, c.getIdWoodType()); // can't be null
					stmt.setString(2, c.getWoodTypeName());
					stmt.setInt(3, c.getWoodTypeCost());
					stmt.setInt(4, c.getNeedToBePainted());

					stmt.executeUpdate();
					return true;
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return false;
		}

		public  boolean addProject(Project p) {
			try {Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into project values(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)")){ 

					// int i = 1;
					stmt.setInt(1, p.getProjectID());
					stmt.setString(2, p.getCustomerID());
					stmt.setString(3, p.getProjectCategory()); // can't be null
					stmt.setString(4, null);
					stmt.setString(5, null);
					stmt.setString(6, null);
					stmt.setString(7, null);
					stmt.setString(8, p.getEmail());
					stmt.setString(9, p.getStatus());
					stmt.setInt(10, p.getCost());
					stmt.setString(11, p.getNotes());
					stmt.setInt(12, p.getPrice());
					stmt.setDate(13, p.getDate());
					stmt.setString(14, p.getPhoneNumber());
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
					stmt.setInt(2, om.getStockID());
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
		
		public  boolean addProjectItems(ProjectItems pi) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("Insert into projectitems values(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)")){

					// int i = 1;
					stmt.setInt(1, pi.getItemID()); // can't be null
					stmt.setString(2, pi.getItemName());
					stmt.setInt(3, pi.getHeight());
					stmt.setInt(4, pi.getWidth());
					stmt.setInt(5, pi.getDepth());
					stmt.setString(6, pi.getWoodType());
					stmt.setInt(7, pi.getQuantity());
					stmt.setString(8, pi.getProjectID());
					stmt.setString(9, pi.getSection());
					stmt.setString(10, pi.getColor());
					stmt.setString(11, pi.getHandsmodel());
					stmt.setString(12, pi.getSectionID());
					
					
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
					stmt.setInt(1, s.getStockID()); // can't be null
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
				stmt.setInt(3,s.getStockID());
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
		
		public boolean updateProjectCost(Project p,int cost) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET cost = ? WHERE ProjectID=? ;")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, p.getProjectID());
		        stmt.setInt(1, cost);
		        
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
		
		public boolean updateProjectPrice(Project p,int price) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET price = ? WHERE ProjectID=? ;")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, p.getProjectID());
		        stmt.setInt(1, price);
		        
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
		
		public boolean addProjectImage1(int p, String image) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET image1 = ? WHERE ProjectID=?;"
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
		
		public boolean addProjectImage2(int p, String image) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET image2 = ? WHERE ProjectID=?;"
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
		
		public boolean addProjectImage3(int p, String image) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET image3 = ? WHERE ProjectID=?;"
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
		
		public boolean addProjectImage4(int p, String image) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET image4 = ? WHERE ProjectID=?;"
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
					CallableStatement stmt = con.prepareCall("DELETE FROM OrderedMaterials WHERE OrderedMaterialsID=?;")){
					
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
		
		public  boolean DeleteWoodType(WoodType wt) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE FROM woodtype WHERE idWoodType=?;")){
					
					stmt.setInt(1, wt.getIdWoodType());
					
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
		
		public  boolean DeleteAxle(Axles a) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE FROM axles WHERE axlesID=?;")){
					
					stmt.setInt(1, a.getAxlesID());
					
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
		
		public  boolean DeleteHands(Hands h) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE FROM hands WHERE idhands=?;")){
					
					stmt.setInt(1, h.getIdhands());
					
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
		public  boolean DeleteSupplier(Supplier s) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE FROM supplier WHERE idsupplier=?;")){
					
					stmt.setInt(1, s.getIdsupplier());
					
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
		
		public boolean updateProjectStatus(Project p,String orderStatus) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET status = ? WHERE ProjectID=?;")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, p.getProjectID());
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
		
		public boolean updateProjectNotes(Project p,String notes) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET notes = ? WHERE ProjectID=?;")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, p.getProjectID());
		        stmt.setString(1, notes);
		        
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
		
		public boolean updateItemDepth(ProjectItems pi,int depth) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET depth = ? WHERE itemID=?")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
		        stmt.setInt(1, depth);
		        
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
		
		public boolean updateItemSectionID(ProjectItems pi,int s) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE projectitems SET sectionID = ? WHERE itemID=?;")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, pi.getItemID());
				
		        stmt.setString(1, Integer.toString(s));
		        
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
		
		public boolean updateCustomerEmailInProject(Project p,String email) throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET Email = ? WHERE ProjectID=? ")){

		        // set the parameter values for the prepared statement
				
				stmt.setInt(2, p.getProjectID());
		        stmt.setString(1, email);
		        
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
				
				
		        stmt.setString(1, name);
		        stmt.setString(2, phone);
		        stmt.setString(3, address);
		        stmt.setString(4, email);
		        stmt.setInt(5, c.getID());
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
		
		
		
		public  boolean DeleteProject(Project p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("DELETE  FROM project WHERE ProjectID = ?")){
					
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
		
		public  boolean DeleteSectionImage1(Project p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET Image1 = NULL WHERE ProjectID=?")){
					
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
		
		public  boolean DeleteSectionImage2(Project p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET Image2 = NULL WHERE ProjectID=?")){
					
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
		
		public  boolean DeleteSectionImage3(Project p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET Image3 = NULL WHERE ProjectID=?")){
					
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
		
		public  boolean DeleteSectionImage4(Project p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("UPDATE project SET Image4 = NULL WHERE ProjectID=?")){
					
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
					CallableStatement stmt = con.prepareCall("DELETE  FROM projectitems WHERE itemID = ?")){
					
					
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
					CallableStatement stmt = con.prepareCall("DELETE  FROM section WHERE sectionID = ?")){
					
					stmt.setString(1, Integer.toString(s.getSectionID()));
					
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
		
		public  String GetImage1(Project p) {
			
			String result = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("SELECT Image1 FROM project WHERE ProjectID = ?")){
					
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

public  String GetImage2(Project p) {
			
			String result = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
			           //  Statement stmt = con.createStatement()
					CallableStatement stmt = con.prepareCall("SELECT Image2 FROM project WHERE ProjectID = ?")){
					
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

public  String GetImage3(Project p) {
	
	String result = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
	           //  Statement stmt = con.createStatement()
			CallableStatement stmt = con.prepareCall("SELECT Image3 FROM project WHERE ProjectID = ?")){
			
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

public  String GetImage4(Project p) {
	
	String result = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpentrydatabase","root","AwniWoodWork");
	           //  Statement stmt = con.createStatement()
			CallableStatement stmt = con.prepareCall("SELECT Image4 FROM project WHERE ProjectID = ?")){
			
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

