package booth.assign2.salebin;
import booth.assign1.USMoney;

//Interface declaration for BinType
public interface BinType {
	void addItem(ItemType item);
	USMoney calculatePrice();
	double getWeight();
	int getNoOfItems();
	String showDetails();
}


