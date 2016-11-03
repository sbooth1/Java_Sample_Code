/*
* 
* Steven Booth -- W1084292
* Assignment #1
* 
* 
* USMoney Tester: Implementation to test the functionality of the methods
* within USMoney. Tests cases such as blank constructor, cent overload
* in the setCents method, adding instances of the class, using the 
* constructor with arguments, as well as all setters and getters.  
* 
* 
*/

package booth.assign1;

public class USMoneyTester {

	// main function to be used for testing USMoney object
	public static void main(String[] args) {
		// Tester
		// Should output $0.00
		USMoney amt1 = new USMoney();
		System.out.println(amt1);

		// Should output "$2.50"
		amt1.setCents(250);
		System.out.println(amt1);

		// Should output "$10.50"
		amt1.setDollars(10);
		System.out.println(amt1);

		// Should output "50"
		System.out.println(amt1.getCents());

		// Should output "$13.40\n $13.40\n"
		USMoney amt2 = amt1.add(new USMoney(2, 90));
		System.out.println(amt1);
		System.out.println(amt2);

		// Should output "$26.80"
		amt2.addTo(amt1.getDollars(), amt1.getCents());
		System.out.println(amt2);

		// Tests final constructor (Should output "$3.50")
		USMoney amt3 = new USMoney(3.50);
		System.out.println(amt3);

	}
}
