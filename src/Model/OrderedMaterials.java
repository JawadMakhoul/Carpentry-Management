package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class OrderedMaterials {

	private static int idCounter;
	private int OrderMaterialsID;
	private int stockID;
	private String woodName;
	private int quantity;
	private String status;
	
	public OrderedMaterials(int OrderMaterialsID,int stockID, String woodName, int quantity,String status) {
		super();
		this.OrderMaterialsID=OrderMaterialsID;
		this.stockID = stockID;
		this.woodName = woodName;
		this.quantity = quantity;
		this.status=status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderedMaterials() {
		this.OrderMaterialsID=idCounter++;
	}
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public String getWoodName() {
		return woodName;
	}
	public void setWoodName(String woodName) {
		this.woodName = woodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterOrderedMaterials.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterOrderedMaterials.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		OrderedMaterials.idCounter = idCounter;
	}

	public int getOrderMaterialsID() {
		return OrderMaterialsID;
	}

	public void setOrderMaterialsID(int orderMaterialsID) {
		OrderMaterialsID = orderMaterialsID;
	}
	
	
}
