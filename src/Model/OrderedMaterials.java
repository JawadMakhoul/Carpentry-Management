package Model;

import java.util.Date;

public class OrderedMaterials {

	private String stockID;
	private String woodName;
	private int quantity;
	//private Date expectedArrivalDate;
	public OrderedMaterials(String stockID, String woodName, int quantity) {
		super();
		this.stockID = stockID;
		this.woodName = woodName;
		this.quantity = quantity;
		//this.expectedArrivalDate = new Date();
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
//	public Date getExpectedArrivalDate() {
//		return expectedArrivalDate;
//	}
//	public void setExpectedArrivalDate(Date expectedArrivalDate) {
//		this.expectedArrivalDate = expectedArrivalDate;
//	}
	
	
}
