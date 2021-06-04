/**
 * 
 */
package cs145.lab5;

/**
 * 
 * This class represents the constructor for a StoutSI, inherits fields from the StoutStudent class
 * 
 * @author KamenickNoah
 * @version 03.02.2021
 */

public class StoutSI extends StoutStudent {
	
	private String course;

	/**
	 * 
	 * A getter method that returns the value of the private String course
	 * 
	 * @return the course string value
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * 
	 * Setter method for the private string course
	 * 
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * 
	 * The constructor for the StoutSI object. Inherits id, first/last name, year, and major fields from the StouStudent class
	 * 
	 * 
	 * @param id of of the StoutSI
	 * @param firstName of the StoutSI
	 * @param lastName of the StoutSI
	 * @param year of the StoutSI
	 * @param major of the StoutSI
	 * @param course the course the StoutSI is part of
	 */
	public StoutSI(int id, String firstName, String lastName, level year, String major, String course) {
		super(id, firstName, lastName, year, major);
		this.course = course;
	}

	/**
	 * 
	 * A StoutSI constructor that doesn't overload with a string course param. 
	 * 
	 * @param id of the StoutSI
	 * @param firstName of the StoutSI
	 * @param lastName of the StoutSI
	 * @param year of the StoutSI
	 * @param major of the StoutSI
	 */
	public StoutSI(int id, String firstName, String lastName, level year, String major) {
		super(id, firstName, lastName, year, major);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * A StoutSI constructor that doesn't overload the level enum and major string
	 * @param id of the StoutSI
	 * @param firstName of the StoutSI
	 * @param lastName of the StoutSI
	 */
	public StoutSI(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 * A method that overrides the role abstract method in the StoutStudent parent class.
	 * 
	 * @return a string formatted for the StoutSI
	 */
	
	@Override
	public String role() {
		return super.role() + " and teaches students" + "\nCS-145";
		
	}
	
	
	
}
