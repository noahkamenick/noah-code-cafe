/**
 * 
 */
package cs145.billing;

/**
 * This class creates a product object
 * @author KamenickNoah
 * @version 03.04.2021
 */

public class Product {
	private String description;
	private double price;
	
	/**
	 * 
	 * This creates a product object using a description string and a price double
	 * 
	 */
	public Product(String desc, double price) {
		this.description = desc;
		this.price = price;
	}
	/**
	 * Getter method for string description
	 * @return the description of the product
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Getter method for double price
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}
}
