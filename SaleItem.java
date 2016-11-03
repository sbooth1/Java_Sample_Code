package booth.assign2.salebin;

import booth.assign1.USMoney;

//Class definition for SaleItem, which implements the interface ItemType
public class SaleItem implements ItemType {

	// private data members
	private String itemName;
	private USMoney price;
	private double weight;
	private boolean fragile;

	// Default constructor for SaleItem
	public SaleItem() {
		itemName = null;
		weight = 0;
		fragile = false;
		price = new USMoney();
	}

	// Constructor for SaleItem with arguments
	public SaleItem(String itemName, USMoney price, double weight, boolean fragile) {
		this.itemName = itemName;
		this.price = price;
		this.weight = weight;
		this.fragile = fragile;
	}

	//Getter function for itemName
	public String getItemName(){
		return itemName;
	}
	
	// Getter function for fragile
	public Boolean isFragile() {
		return fragile;
	}

	// Getter function for price
	public USMoney getPrice() {
		return price;
	}

	// Getter function for weight
	public double getWeight() {
		return weight;
	}

	// Returns a String with the details of the Item
	public String getDetails() {
		String details = itemName + ", " + price;
		return details;
	}
}
