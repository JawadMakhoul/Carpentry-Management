package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hands {

	private static int idCounter;
	private int idhands;
	private String handsName;
	private int handsCost;
	
	public Hands(int idhands, String handsName, int handsCost) {
		super();
		this.idhands = idhands;
		this.handsName = handsName;
		this.handsCost = handsCost;
	}
	
	public Hands() {
		super();
		this.idhands = idCounter++;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Hands.idCounter = idCounter;
	}
	public int getIdhands() {
		return idhands;
	}
	public void setIdhands(int idhands) {
		this.idhands = idhands;
	}
	public String getHandsName() {
		return handsName;
	}
	public void setHandsName(String handsName) {
		this.handsName = handsName;
	}
	public int getHandsCost() {
		return handsCost;
	}
	public void setHandsCost(int handsCost) {
		this.handsCost = handsCost;
	}
	
	static {
        // Load the idCounter value from a file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("idCounterHands.txt"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("idCounterHands.txt"));
            writer.write(Integer.toString(idCounter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
