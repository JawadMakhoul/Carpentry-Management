package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Supplier {

	private static int idCounter;
	private int idsupplier;
	private String supplierEmail;
	private int autoOrder;
	public int getAutoOrder() {
		return autoOrder;
	}
	public void setAutoOrder(int autoOrder) {
		this.autoOrder = autoOrder;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Supplier.idCounter = idCounter;
	}
	public int getIdsupplier() {
		return idsupplier;
	}
	public void setIdsupplier(int idsupplier) {
		this.idsupplier = idsupplier;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public Supplier(int idsupplier, String supplierEmail,int autoOrder) {
		super();
		this.idsupplier = idsupplier;
		this.supplierEmail = supplierEmail;
		this.autoOrder=autoOrder;
	}
	
	public Supplier() {
		super();
		this.idsupplier = idCounter++;
	}
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterSupplierEmail.txt"));
            idCounter = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException e) {
            // If the file doesn't exist or can't be read, start the counter at 1
            idCounter = 1;
        }
    }
	
	public static void saveIdCounter() {
        // Save the idCounter value to a file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterSupplierEmail.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
