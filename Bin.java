package booth.assign2.salebin;

import booth.assign1.USMoney;

public class Bin implements BinType {

	// protected data members
	protected String binNumber;
	protected ItemType[] items;
	protected static double maxWeight = 50;
	protected static int counter = 0;
	protected int noOfItems;
	protected double weight;
	protected USMoney totalPrice;

	// Default constructor for Bin
	public Bin() {
		items = new ItemType[10];
		binNumber = "A" + generateBinNumber();
		noOfItems = 0;
		weight = 0;
		totalPrice = new USMoney();
	}

	// Generates bin number by incrementing the static counter
	public static int generateBinNumber() {
		return counter++;
	}

	// adds Item
	public void addItem(ItemType item) {
		if (((item.getWeight() + this.getWeight()) < maxWeight) && (item.isFragile() == false)) {
			items[noOfItems++] = item;
			weight += item.getWeight();
		} else {
			System.out.println("Sorry, your " + ((SaleItem) item).getItemName() + " could not be added at this time.");
		}
	}

	// Getter function for noOfItems
	public int getNoOfItems() {
		return noOfItems;
	}

	// Getter function for weight
	public double getWeight() {
		return weight;
	}

	// Getter for binNumber
	public String getBinNumber() {
		return binNumber;
	}

	// Calculates the total price of the items in the bin
	public USMoney calculatePrice() {
		USMoney price = new USMoney();
		/*
		 * Compiles all of the prices for the Items by incrementing through the
		 * items array
		 */
		for (int i = 0; i < getNoOfItems(); i++) {
			price = price.add(items[i].getPrice());
		}
		// adds $100 for bin cost
		price.addTo(100, 0);
		return price;

	}

	// Returns a string with the specific details of the Bin instance
	public String showDetails() {
		return ("bin #: " + getBinNumber() + "  Weight: " + getWeight() + "  Price: " + calculatePrice().toString());
	}
}
