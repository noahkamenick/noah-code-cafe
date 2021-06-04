/**
 * 
 */
package cs145.lab5;

/**
 * 
 * This class specifies the fields and methods for StoutStudent, extends fields and methods from StoutPerson
 * 
 * @author KamenickNoah
 * @version 03.02.2021
 */
public class StoutStudent extends StoutPerson {

	
	/**
	 * 
	 * A enum representing the level in school of the StoutStudent
	 * 
	 */
	
	
	public enum level {
		

		freshman, sophomore, junior, senior;
	  
	    
	}
	
	private level year;
	
	private String major;
	
	/**
	 * 
	 * Student constructor
	 * 
	 * @param id the id input of the StoutStudent object
	 * @param firstName the firstName string input of the StoutStudent object
	 * @param lastName the lastName string input of the StoutStudent object
	 * @param year the year level input from the level enumeration, representing the students' year in college in the StoutStudent object
	 * @param major the major string input of the StoutStudent object
	 */
	public StoutStudent(int id, String firstName, String lastName, level year, String major) {
		super(id, firstName, lastName);
		this.year = year;
		this.major = major;
	}

	/**
	 * 
	 * Getter method for the year enum field
	 * 
	 * @return the year 
	 */
	public level getYear() {
		return year;
	}

	/**
	 * Setter method for the year emum field
	 * 
	 * @param year the year to set
	 */
	public void setYear(level year) {
		this.year = year;
	}

	/**
	 * 
	 * Getter method for the major string field
	 * 
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * 
	 * Setter method for the major string field
	 * 
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * 
	 * Constructor for a StoutStudent object with inherited methods from the StoutPerson super class. Represents an undeclared, freshman student. 
	 * 
	 * @param id the id of the undeclared, freshman StoutStudent
	 * @param firstName the firstName field of the undeclared, freshman StoutStudent. 
	 * @param lastName the lastName field of the undecalred, freshman StoutStudent. 
	 */
	public StoutStudent(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		year = level.freshman;
		major = "Undeclared";
	}

	/**
	 * 
	 * A method that overrides the role abstract method in the StoutPerson super class.
	 * 
	 * @return a string formatted for the StoutStudent
	 */
	
	@Override
	public String role() {
		// TODO Auto-generated method stub
		return this.major + " " + this.year + " takes classes";	
	}

}
