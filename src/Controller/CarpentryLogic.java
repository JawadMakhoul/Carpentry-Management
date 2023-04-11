package Controller;

import java.sql.Connection;
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
						results.add(new Customer(rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++)));
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
						results.add(new Project(rs.getDate(i++), rs.getInt(i++), rs.getString(i++)));
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

		

		
		public  boolean addCustomer(String flightNum, Date departureDate, Date landingDate, String status, String srcAirport,
				String destAirport, String tailNum, String p1, String p2) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_FLIGHT)) {

					// int i = 1;
					stmt.setString(1, flightNum); // can't be null

					if (departureDate != null) {
						stmt.setDate(2, (java.sql.Date) departureDate);
					} else {
						stmt.setNull(2, java.sql.Types.DATE);
					}
					if (landingDate != null) {
						stmt.setDate(3, new java.sql.Date(landingDate.getTime()));
					} else {
						stmt.setNull(3, java.sql.Types.DATE);
					}
					if (status != null) {
						stmt.setString(4, status);
					} else {
						stmt.setNull(4, java.sql.Types.VARCHAR);
					}
					if (srcAirport != null) {
						stmt.setString(5, srcAirport);
					} else {
						stmt.setNull(5, java.sql.Types.VARCHAR);
					}
					if (destAirport != null) {
						stmt.setString(6, destAirport);
					} else {
						stmt.setNull(6, java.sql.Types.VARCHAR);
					}
					if (tailNum != null) {
						stmt.setString(7, tailNum);
					} else {
						stmt.setNull(7, java.sql.Types.VARCHAR);
					}
					if (p1 != null) {
						stmt.setString(8, p1);
					} else {
						stmt.setNull(8, java.sql.Types.VARCHAR);
					}

					if (p2 != null) {
						stmt.setString(9, p2);
					} else {
						stmt.setNull(9, java.sql.Types.VARCHAR);
					}

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

		public  boolean addAirAttendantsInFlight(String id, String flightNum) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_AIRATTENDANTINFLIGHT)) {
					// int i = 1;
					stmt.setString(1, id); // can't be null

					if (flightNum != null) {
						
						stmt.setString(2, flightNum);
						
					} else {
						stmt.setNull(2, java.sql.Types.VARCHAR);
					}

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

		public  boolean addShift(String shiftId, String startTime, String endTime) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SHIFT)) {

					// int i = 1;
					stmt.setString(1, shiftId); // can't be null

					if (startTime != null) {
						
						stmt.setString(2, startTime);
					} else {
						stmt.setNull(2, java.sql.Types.VARCHAR);
					}

					if (endTime != null) {
						
						stmt.setString(3, endTime);
					} else {
						stmt.setNull(3, java.sql.Types.VARCHAR);
					}

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
		
		public  boolean addGroundInShift(String AttendantId, String shiftNum, String role) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_GroundInShift)) {

					// int i = 1;
					stmt.setString(1, AttendantId); // can't be null

					if (shiftNum != null) {
						
						stmt.setString(2, shiftNum);
					} else {
						stmt.setNull(2, java.sql.Types.VARCHAR);
					}

					if (role != null) {
						
						stmt.setString(3, role);
					} else {
						stmt.setNull(3, java.sql.Types.VARCHAR);
					}

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

}
