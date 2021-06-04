package cs145.billing;

public class Address {
	/**
	 * Local Variables
	 */
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	/**
	 * Address Constructor
	 * @param name String name 
	 * @param street String street
	 * @param city String city
	 * @param state String state
	 * @param zip String zip
	 */
	public Address(String name, String street, String city, String state, String zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
	}
	/**
	 * toString Return
	 * returns name + street + city + state + zip
	 */
	public String toString() {
		return name + "\n" + street + "\n" + city + ", " + state + " " + zip;
	}

}
