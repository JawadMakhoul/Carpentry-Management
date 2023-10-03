package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WoodType {

	@Override
	public String toString() {
		return ""+WoodTypeName;
	}

	private static int idCounter;
	private int idWoodType;
	private String WoodTypeName;
	private int WoodTypeCost;
	private int needToBePainted;
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		WoodType.idCounter = idCounter;
	}
	public int getIdWoodType() {
		return idWoodType;
	}
	public void setIdWoodType(int idWoodType) {
		this.idWoodType = idWoodType;
	}
	public String getWoodTypeName() {
		return WoodTypeName;
	}
	public void setWoodTypeName(String woodTypeName) {
		WoodTypeName = woodTypeName;
	}
	public int getWoodTypeCost() {
		return WoodTypeCost;
	}
	public void setWoodTypeCost(int woodTypeCost) {
		WoodTypeCost = woodTypeCost;
	} 
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterWoodType.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterWoodType.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public int getNeedToBePainted() {
		return needToBePainted;
	}
	public void setNeedToBePainted(int needToBePainted) {
		this.needToBePainted = needToBePainted;
	}
	public WoodType(int idWoodType, String woodTypeName, int woodTypeCost, int needToBePainted) {
		super();
		this.idWoodType = idWoodType;
		this.WoodTypeName = woodTypeName;
		this.WoodTypeCost = woodTypeCost;
		this.needToBePainted=needToBePainted;
	}
	
	public WoodType() {
		super();
		this.idWoodType = idCounter++;
	}
}
