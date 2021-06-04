/**
 * 
 */
package cs145.billing;
import java.util.ArrayList;
/**
 * Class to generate invoice
 * @author KamenickNoah
 * @version 03.10.2021
 */
public class Invoice {

	private Address billingAddress;
	
	private ArrayList<LineItem> items;
	
	/**
	 * 
	 * Default constructor for the invoice class
	 * 
	 * @param address an input address object
	 */
	
	
	public Invoice(Address address) {
		
		items = new ArrayList<LineItem>();
		this.billingAddress = address;
		
	}
	
	/**
	 * 
	 * This class adds charges
	 * 
	 * 
	 * @param product an input product object
	 * @param quantity an input quantity integer
	 */
	
	public void addCharge(Product product, int quantity) 
	{
		
		LineItem x = new LineItem(product, quantity);
		
		items.add(x);
		
	}
	
	/**
	 * 
	 * A method that returns that gets/calculates the total due from the totals of each item and its respective quantity
	 * 
	 * @return the total due for the purchase
	 */
	
	public double getTotalDue()
	{
		double localTotal = 0;
		
		
		for (int i = 0; i < items.size(); i++)
		{
			
			localTotal += items.get(i).getTotalPrice();
			
		}
		
		return localTotal;

		 
	}
	
	/**
	 * 
	 * Prints the output of the invoice
	 * 
	 * @return a string that represents the output of the invoice
	 * 
	 */
	
	public String toString()
	{
		
		String printedItems = "";
		
		for (int i = 0; i < items.size(); i++)
		{
			
			printedItems += "\n" + items.get(i);
			
			
		}
		
		return "Invoice\n\n" + billingAddress.toString() + "\n\nDescription\tPrice\tQuantity\tTotal" + printedItems + 
				"\n"  + "\nAmount Due" + " $" + getTotalDue();
	}
	
	
}
