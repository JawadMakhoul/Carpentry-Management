package Model;

public class Person {
	
	private String name;
	private String phoneNUMBER;
	private String address;
	private String email;
	
	
	public Person(String name, String phoneNUMBER, String address, String email) {
		super();
		this.name = name;
		this.phoneNUMBER = phoneNUMBER;
		this.address = address;
		this.email = email;
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
