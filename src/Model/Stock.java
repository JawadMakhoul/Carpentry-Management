package Model;

public class Stock {

	private String woodName;
	private int quantity;
	public Stock(String woodName, int quantity) {
		super();
		this.woodName = woodName;
		this.quantity = quantity;
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
	
	
}
