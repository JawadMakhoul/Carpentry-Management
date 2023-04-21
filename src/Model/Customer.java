package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class Customer {
	
	
    private static int idCounter;
    private int personID;
	private String name;
	private String phoneNUMBER;
	private String address;
	private String email;
	
	 static {
	        // Load the idCounter value from a file
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader("idCounterCustomer.txt"));
	            idCounter = Integer.parseInt(reader.readLine());
	            reader.close();
	        } catch (IOException e) {
	            // If the file doesn't exist or can't be read, start the counter at 1
	            idCounter = 1;
	        }
	    }
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

	public static void saveIdCounter() {
        // Save the idCounter value to a file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterCustomer.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
