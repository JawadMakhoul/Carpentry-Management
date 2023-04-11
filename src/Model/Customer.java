package Model;

public class Customer {
	
	private static int personID=0;
	private String name;
	private String phoneNUMBER;
	private String address;
	private String email;
	
	
	public Customer(String name, String phoneNUMBER, String address, String email) {
		super();
		Customer.personID=personID++;
		this.name = name;
		this.phoneNUMBER = phoneNUMBER;
		this.address = address;
		this.email = email;
	}
	public static int getID() {
		return personID;
	}
	public static void setID(int iD) {
		personID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNUMBER() {
		return phoneNUMBER;
	}
	public void setPhoneNUMBER(String phoneNUMBER) {
		this.phoneNUMBER = phoneNUMBER;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
