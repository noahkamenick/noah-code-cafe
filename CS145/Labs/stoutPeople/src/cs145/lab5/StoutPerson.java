/**
 * 
 */
package cs145.lab5;

/**
 * A class that represents a StoutPerson
 * 
 * @author KamenickNoah
 * @version 03.01.2021
 */
public abstract class StoutPerson implements Comparable<StoutPerson> {

	private int id;
	
	private String firstName;
	
	private String lastName;

	/**
	 * Getter Method for a StoutPerson's firstName field
	 * 
	 * @return the firstName of a StoutPerson
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for a StoutPerson's firstName field
	 * 
	 * @param firstName the firstName to set for a StoutPerson
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter Method for a StoutPersons LastName field
	 * @return the lastName of a StoutPerson
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter Method for a StoutPerson's LastName Field
	 * 
	 * @param lastName the lastName to set of a StoutPerson
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter Method for the ID of a StoutPerson
	 * 
	 * @return the id of a StoutPerson
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * Constructor for the StoutPerson Class. Takes in an id int, firstName and lastName strings.
	 * 
	 * @param id an ID of a StoutPerson
	 * @param firstName of a StoutPerson
	 * @param lastName of a StoutPerson
	 */
	public StoutPerson(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * An abstract method named role().
	 * 
	 * @return returns a formatted string
	 */
	
	public abstract String role();
	
	/**
	 * 
	 * An overridden toString method from the object class that formats the information of child classes. 
	 * 
	 * @return a formatted string based on the input from child classes
	 * 
	 */
	
	public String toString() {
		
		return this.lastName + ", " + this.firstName + "\nID: " + this.id + "\n" + this.role() + "\n";
		
		
	}
	
	/**
	 * 
	 * A method that compares the lastName of the calling object and the object that is inputted into the parameters.
	 * 
	 * @return a compareTo return integer
	 */
	
	public int compareTo(StoutPerson other)
	{
		
		return this.lastName.compareTo(other.lastName);
	
	
	}

	
	
	
}
