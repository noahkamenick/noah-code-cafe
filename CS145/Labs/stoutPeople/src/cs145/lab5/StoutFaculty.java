/**
 * 
 */
package cs145.lab5;

/**
 * 
 * This class specifies the fields and methods for StoutFaculty, extends fields and methods from StoutPerson
 * 
 * 
 * @author KamenickNoah
 * @version 03.02.2021
 */
public class StoutFaculty extends StoutPerson {

	private String position;
	
	
	/**
	 * Getter method for the position field of the StoutFaculty object
	 * 
	 * @return the position of the StoutFaculty object
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Setter method for the the position field of the StoutFaculty object
	 * 
	 * @param position the position of the StoutFaculty object to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Constructor that inherits the id, firstName, and lastName fields from the super class. Overloads with a position string parameter, sets the position to the field position string.
	 * 
	 * @param id the ID of the StoutFaculty object
	 * @param firstName the firstName input of the StoutFaculty object
	 * @param lastName the lastName input of the StoutFaculty object
	 * @param position the position of the StoutFaculty Object
	 */
	public StoutFaculty(int id, String firstName, String lastName, String position) {
		super(id, firstName, lastName);
		this.position = position;
	}

	/**
	 * 
	 * Constructor that inherits the id, firstName, and lastName fields and inputs the int ID, String firstName, and String lastName parameters of the StoutFaculty constructor. 
	 * 
	 * @param id the ID of the StoutFaculty object
	 * @param firstName the firstName input of the StoutFaculty object
	 * @param lastName the lastName input of the StoutFaculty object
	 */
	public StoutFaculty(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		position = "Instructor";
	}
	
	/**
	 * 
	 * A method that overrides the role abstract method in the StoutPerson super class.
	 * 
	 * @return a string formatted for the StoutFaculty classi
	 */
	@Override
	public String role() {
		// TODO Auto-generated method stub
		
		return this.position + " teaches students";
		
	}
		
	

}
