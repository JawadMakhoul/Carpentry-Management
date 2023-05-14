package Model;

import java.net.URLDecoder;

public final class Consts {
	

		private Consts() {
			throw new AssertionError();
		}

		protected static final String DB_FILEPATH = getDBPath();
		public static final String CONN_STR = "jdbc:ucanaccess://" + getDBPath() + ";COLUMNORDER=DISPLAY";
		public static final String SQL_SEL_CUSTOMERS = "SELECT * FROM Customer";
		public static final String SQL_SEL_ORDERS = "SELECT * FROM OrderTbl";
		public static final String SQL_SEL_PROJECTS = "SELECT * FROM Project";
		public static final String SQL_SEL_PROJECTITEMS = "SELECT * FROM ProjectItems";
		public static final String SQL_SEL_SECTION = "SELECT * FROM Section";
		public static final String SQL_SEL_STOCK = "SELECT * FROM Stock";
		public static final String SQL_SEL_ORDEREDMATERIALS = "SELECT * FROM OrderedMaterials";
		
		public static final String SQL_INS_CUSTOMER = "{ call qryInsCustomer1(?,?,?,?,?) }";
		public static final String SQL_INS_ORDERS = "{ call qryInsOrder(?,?,?,?,?) }";
		public static final String SQL_INS_PROJECTS = "{ call qryInsProject(?,?,?) }";
		public static final String SQL_INS_PROJECTITEMS = "{ call qryInsProjectItems(?,?,?,?,?,?,?,?,?,?) }";
		public static final String SQL_INS_SECTION = "{ call qryInsSection(?,?,?,?,?,?) }";
		public static final String SQL_INS_STOCK = "{ call qryInsStock(?,?,?) }";
		public static final String SQL_INS_ORDEREDMATERIALS = "{ call qryInsOrderedMaterials(?,?,?,?,?) }";
		
		public static final String SQL_DEL_ORDEREDMATERIALS = "{ call qryDelOrderedMaterials(?)}";
		public static final String SQL_DEL_ORDER = "{ call qryDelOrder(?)}";
		
		public static final String SQL_UPD_STOCK = "{ call qryUpdateStockQuantity(?,?,?)}";
		public static final String SQL_UPD_STATUS = "{ call qryUpdateOrderStatus(?,?)}";

		private static String getDBPath() {
			try {
				String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
				String decoded = URLDecoder.decode(path, "UTF-8");
				 //System.out.println(decoded); //- Can help to check the returned path
				if (decoded.contains(".jar")) {
					decoded = decoded.substring(0, decoded.lastIndexOf('/'));
					return decoded + "/DataBase.accdb";
				} else {
					decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
					//System.out.println(decoded);System.out.println(decoded + "src/Model/DataBase.accdb");
					return decoded + "src/Model/DataBase.accdb";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
