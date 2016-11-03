/*
	 * 
	 * Steven Booth -- W1084292
	 * 10/28/16
	 * 
	 * 
	 * USMoney: An object class that holds the dollar and cent values
	 * as private members. Includes implementation of functional currency
	 * modification methods such as adding and setting dollar and cent 
	 * values. 
	 * 
	 *  
	 */

package booth.assign1;

public class USMoney {

	// Private member variables
	private int dollars;
	private int cents;

	// "No arg" Constructor
	public USMoney() {
		dollars = 0;
		cents = 0;
	}

	// Constructor with one argument
	public USMoney(double amt) {
		cents = (int) ((100 * amt) % 100); // casts the fractional part to an
											// int
		dollars = (int) amt; // casts to int to get whole part
	}

	// Constructor with two arguments
	public USMoney(int d, int c) {
		this.cents = c % 100;
		this.dollars = (d + (c / 100));
	}

	// Functionality to add dollar and cent values to invoked object
	public void addTo(int d, int c) {
		this.cents += c % 100;
		this.dollars += (d + (c / 100));
	}

	// Functionality to add object parameter and invoked object
	public USMoney add(USMoney money) {
		int c = money.cents + this.cents;
		int d = money.dollars + this.dollars;
		USMoney tmp = new USMoney(d, c);
		return tmp;
	}

	// Converts USMoney instance into String representation
	public String toString() {
		String strep; // String representation variable
		// checks to see if cents are at zero
		if (this.cents == 0) {
			strep = ("$" + this.dollars + "." + this.cents + "0"); // adds extra
																	// zero
		} else
			strep = ("$" + this.dollars + "." + this.cents);
		// returns String representation
		return strep;
	}

	// Returns dollar value
	public int getDollars() {
		return dollars;
	}

	// Sets dollars value
	public void setDollars(int dollars) {
		this.dollars = dollars;
	}

	// Returns cents value
	public int getCents() {
		return cents;
	}

	// Sets cents value
	public void setCents(int c) {
		// sets the new cents (before check)
		this.cents = c % 100;
		// checks if cents is more than 100
		if (c > 99) {
			this.dollars = c / 100;
		}
	}
}
