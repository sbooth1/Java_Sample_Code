package booth.assign2.salebin;

import booth.assign1.USMoney;

//Interface declaration for ItemType
public interface ItemType {
	Boolean isFragile();

	USMoney getPrice();

	double getWeight();

	String getDetails();
}
