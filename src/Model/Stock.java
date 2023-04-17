package Model;

public class Stock {

	private static int idCounter=1;
	private String stockID="Stock_";
	private String woodName;
	private int quantity;
	public Stock(String stockID,String woodName, int quantity) {
		super();
		this.stockID=stockID;
		this.woodName = woodName;
		this.quantity = quantity;
	}
	
	public Stock()
	{
		this.stockID=this.stockID+""+idCounter++;
	}
	
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Stock.idCounter = idCounter;
	}

	public String getStockID() {
		return stockID;
	}

	public void setStockID(String stockID) {
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
	
	
}
