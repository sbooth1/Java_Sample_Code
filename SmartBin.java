package booth.assign2.salebin;

import booth.assign1.USMoney;

//Class definition for SmartBin, which is inherited from Bin
public class SmartBin extends Bin {
	// private member vairable
	private String label;

	// Default Constructor
	public SmartBin() {
		/*
		 * Since generateBinNumber is already called in the Bin constructor,
		 * counter has already been incremented and a new bin number has taken
		 * its place. So we can use (counter - 1) as the binNumber in the
		 * SmartBin constructor so that it doesn't get incremented twice.
		 */
		binNumber = "SM" + (counter - 1);
		label = null;
		noOfItems = 0;
		weight = 0;
		totalPrice = new USMoney();
	}

	// Setter function for label
	public void setLabel(String label) {
		this.label = label;
	}

	// Getter function for label
	public String getLabel() {
		return label;
	}

	@Override
	// Function to add items to SmartBin, overrides functionality from Bin
	public void addItem(ItemType item) {
		// Checks to make sure maxWeight has not been exceeded
		if ((item.getWeight() + weight) < maxWeight) {
			items[noOfItems++] = item;
			weight += item.getWeight();
			if (item.isFragile()) {
				label = "Fragile - Handle with Care";
			}
		} else {
			// If the max weight is exceeded, the user is notified.
			System.out.print("Sorry, your " + ((SaleItem) item).getItemName() + " could not be added at this time. ");
			// Tells the user the remaining weight before maxWeight is reached
			System.out.println("Try again adding an item less than " + (maxWeight - weight) + " pounds.");
		}
	}

	@Override
	// Overrides the calculatePrice function from the Bin class
	public USMoney calculatePrice() {
		USMoney price = new USMoney();
		// Computes the total price by iterating through the items array
		for (int i = 0; i < getNoOfItems(); i++) {
			price = price.add(items[i].getPrice());
			// adds $10 for each fragile item
			if (items[i].isFragile()) {
				price.addTo(10, 0);
			}
		}
		// adds $100 for the bin cost
		price.addTo(100, 0);
		return price;
	}

	@Override
	// Overrides the showDetails function of the Bin class
	public String showDetails() {
		// returns details for the SmartBin instance
		return ("label: " + getLabel() + "  bin #: " + getBinNumber() + "  Weight: " + getWeight() + " Price: "
				+ calculatePrice().toString());
	}
}
