package Model;

public class ProjectDetailsToShow {
	
	private static String customerName;
	private static String ProjectID;
	private static String projectCategory;
	private static String section;
	private static String image;
	public static String getImage() {
		return image;
	}
	public static void setImage(String image) {
		ProjectDetailsToShow.image = image;
	}
	public static String getCustomerName() {
		return customerName;
	}
	public static void setCustomerName(String customerName) {
		ProjectDetailsToShow.customerName = customerName;
	}
	public static String getProjectID() {
		return ProjectID;
	}
	public static void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public static String getProjectCategory() {
		return projectCategory;
	}
	public static void setProjectCategory(String projectCategory) {
		ProjectDetailsToShow.projectCategory = projectCategory;
	}
	public static String getSection() {
		return section;
	}
	public static void setSection(String section) {
		ProjectDetailsToShow.section = section;
	}
	
}
