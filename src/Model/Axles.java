package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Axles {

	private static int idCounter;
	private int axlesID;
	private String axleName;
	private int axleCost;
	public Axles(int axlesID, String axleName, int axleCost) {
		super();
		this.axlesID = axlesID;
		this.axleName = axleName;
		this.axleCost = axleCost;
	}
	
	public Axles() {
		super();
		this.axlesID = idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Axles.idCounter = idCounter;
	}
	public int getAxlesID() {
		return axlesID;
	}
	public void setAxlesID(int axlesID) {
		this.axlesID = axlesID;
	}
	public String getAxleName() {
		return axleName;
	}
	public void setAxleName(String axleName) {
		this.axleName = axleName;
	}
	public int getAxleCost() {
		return axleCost;
	}
	public void setAxleCost(int axleCost) {
		this.axleCost = axleCost;
	} 
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterAxles.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterAxles.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
