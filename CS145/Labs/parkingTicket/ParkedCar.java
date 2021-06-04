/**
 * 
 */
package cs145.parkingTicket;

/**
 * Class representing illegally ParkedCar
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 */
public class ParkedCar {

	private int year; 
	
	private String make;
	
	private String model;
	
	private String color;
	
	private String license;

	/**
	 * 
	 * 
	 * Default constructor for a ParkedCar object
	 * 
	 * 
	 * @param year the year the car was made
	 * @param make the make of the car
	 * @param model the model of the car
	 * @param color the color of the car
	 * @param license the license plate number of the car
	 */
	public ParkedCar(int year, String make, String model, String color, String license)
	{
		this.year = year;
		
		this.make = make;
		
		this.model = model;
		
		this.color = color;
		
		this.license = license;
		
		
	}
	
	/**
	 * 
	 * 
	 * Copy constructor for the ParkedCar object
	 * 
	 * @param car object input for ParkedCar object
	 */
	
	public ParkedCar(ParkedCar car)
	{
		this.year = car.year;
		
		this.make = car.make;
		
		this.model = car.model;
		
		this.color = car.color;
		
		this.license = car.license;
		
		
	}
	
	/**
	 * 
	 * A string with details about a ParkedCar object.
	 * 
	 * @return a formatted string detailing the field values of the illegally parked car (ParkedCar)
	 * 
	 */
	
	
	public String toString()
	{
		
		return "\nYear: " + this.year + "\nMake: " + this.make 
			   + "\nModel: " + this.model + "\nColor: " 
			   + this.color + "\nLicense: " + this.license;
	}
	
	
	
	
	
}
