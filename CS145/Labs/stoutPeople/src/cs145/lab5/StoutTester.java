/**
 * 
 */
package cs145.lab5;

import java.util.Arrays;

/**
 * 
 * A test method used to test the relationship and workings of various child/parent classes.
 * 
 * @author KamenickNoah
 * @version 03.02.2021
 */
public class StoutTester extends StoutPerson {
	
	/**
	 * 
	 * Constructor for the StoutTester class
	 * 
	 * @param id the id integer
	 * @param firstName the firstName string
	 * @param lastName the lastName string
	 */

	public StoutTester(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Main method that creates objects from the various Child classes of Superclass StoutPerson
	 * 
	 */
	public static void main(String[] args) {
		
		
		StoutPerson[] person = new StoutPerson[6]; 
		
		person[0] = new StoutFaculty(1256, "Scott", "Turner", "Associate Professor");
		person[1] = new StoutFaculty(615, "Diane", "Christie", "Professor");
		person[2] = new StoutFaculty(1073, "Terry", "Mason", "Professor");
		person[3] = new StoutStudent(123, "Noah", "Kamenick", StoutStudent.level.sophomore ,"CNIT");
		person[4] = new StoutStudent(134, "John", "Smith");
		person[5] = new StoutSI(1232, "Andrew", "Nelson", StoutStudent.level.junior, "Computer Science");
	
		Arrays.sort(person);
		
		
		for(int i = 0; i < person.length; i++) {
			
			System.out.println(person[i].toString());
		}
		
	}
	
	/**
	 * 
	 * Necessary abstract method to override from the StoutPerson class
	 * 
	 * @return a string returned from the role() method.
	 * 
	 */

	@Override
	public String role() {
		// TODO Auto-generated method stub
		return null;
	}

}
