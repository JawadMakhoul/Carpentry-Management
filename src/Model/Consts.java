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
		
		public static final String SQL_SEL_PROJECT_IMAGE = "{call qryGETImage(?)}";
		
		public static final String SQL_INS_CUSTOMER = "{ call qryInsCustomer1(?,?,?,?,?) }";
		public static final String SQL_INS_ORDERS = "{ call qryInsOrder(?,?,?,?,?) }";
		public static final String SQL_INS_PROJECTS = "{ call qryInsProject(?,?,?,?) }";
		public static final String SQL_INS_PROJECTITEMS = "{ call qryInsProjectItems(?,?,?,?,?,?,?,?,?,?) }";
		public static final String SQL_INS_SECTION = "{ call qryInsSection(?,?,?,?,?,?) }";
		public static final String SQL_INS_STOCK = "{ call qryInsStock(?,?,?) }";
		public static final String SQL_INS_ORDEREDMATERIALS = "{ call qryInsOrderedMaterials(?,?,?,?,?) }";
		
		public static final String SQL_DEL_ORDEREDMATERIALS = "{ call qryDelOrderedMaterials(?)}";
		public static final String SQL_DEL_ORDER = "{ call qryDelOrder(?)}";
		public static final String SQL_DEL_PROJECT = "{ call qryDelProject(?)}";
		public static final String SQL_DEL_PROJECTITEMS = "{ call qryDelProjectItems(?)}";
		public static final String SQL_DEL_SECTION = "{ call qryDelSection(?)}";
		
		public static final String SQL_UPD_STOCK = "{ call qryUpdateStockQuantity(?,?,?)}";
		public static final String SQL_UPD_STATUS = "{ call qryUpdateOrderStatus(?,?)}";
		public static final String SQL_UPD_ITEM_COLOR = "{ call qryUpdateItemColor(?,?)}";
		public static final String SQL_UPD_ITEM_HEIGHT = "{ call qryUpdateItemHeight(?,?)}";
		public static final String SQL_UPD_ITEM_NAME = "{ call qryUpdateItemName(?,?)}";
		public static final String SQL_UPD_ITEM_QUANTITY = "{ call qryUpdateItemQuantity(?,?)}";
		public static final String SQL_UPD_ITEM_SECTION = "{ call qryUpdateItemSection(?,?)}";
		public static final String SQL_UPD_ITEM_WIDTH = "{ call qryUpdateItemWidth(?,?)}";
		public static final String SQL_UPD_WOOD_TYPE = "{ call qryUpdateWoodType(?,?)}";
		public static final String SQL_UPD_MODEL_OF_HANDS = "{ call qryUpdateModelOfHands(?,?)}";
		public static final String SQL_UPD_AXLE_DEGREE = "{ call qryUpdateAxleDegree(?,?)}";
		public static final String SQL_UPD_HANDS_QUANTITY = "{ call qryUpdateHandsQuantity(?,?)}";
		public static final String SQL_UPD_AXLE_QUANTITY = "{ call qryUpdateAxleQuantity(?,?)}";
		public static final String SQL_UPD_SECTION_NAME = "{ call qryUpdateSectionName(?,?)}";
		public static final String SQL_UPD_CUSTOMER = "{ call qryUpdateCustomer(?,?,?,?)}";
		
		public static final String SQL_ADD_PROJECTIMAGE = "{call qryAddProjectImage(?,?)}";

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
