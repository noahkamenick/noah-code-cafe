package cs145.billing;

public class LineItem {
	/**
	 * Local Variables
	 */
	
	private int quantity;
	private Product product;
	
	/**
	 * Constructor
	 */
	public LineItem(Product product, int quantity) {
		this.quantity = quantity;
		this.product = product;
	}
	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}
	public String toString() {
		return product.getDescription() + "\t" + product.getPrice() + "\t" + quantity + "\t" + "\t" + getTotalPrice();
	}
	//Comment
}
