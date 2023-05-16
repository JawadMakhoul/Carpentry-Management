package Model;

public class GlobalProjectID {
	
	private static int id=0;
	private static String CustomerName="";

	public static String getCustomerName() {
		return CustomerName;
	}

	public static void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		GlobalProjectID.id = id;
	}
	

}
