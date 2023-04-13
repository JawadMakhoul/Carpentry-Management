package Model;

public class Customer {
	
	
    private static int idCounter=1;
    private  int personID;
	private String name;
	private String phoneNUMBER;
	private String address;
	private String email;
	
	
	public Customer(int personID,String name, String phoneNUMBER, String address, String email) {
		super();
		
		this.personID=personID;
		this.name = name;
		this.phoneNUMBER = phoneNUMBER;
		this.address = address;
		this.email = email;
	}
	
	public Customer() {
		
		
		this.personID=idCounter++;
		
	}
	public  int getID() {
		return personID;
	}
	
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Customer.idCounter = idCounter;
	}
	public  void setID(int personID) {
		this.personID = personID;
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
