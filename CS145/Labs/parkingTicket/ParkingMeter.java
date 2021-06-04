	/**
 * 
 */
package cs145.parkingTicket;

/**
 * Needs to know the number of minutes of parking time remaining.
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 *
 */
public class ParkingMeter {

	private int time; 
	
	/**
	 * 
	 * Default Constructor for the ParkingMeter class
	 * 
	 * @param time is the passed integer time variable
	 */
	
	public ParkingMeter(int time)
	{
		this.setTime(time);
		
	}
	
	/**
	 * 
	 * Returns (gets) the value of the time variable 
	 * 
	 * @return a private integer variable representing time
	 */
	
	public int getTime() {

		return time;
		
	}
	
	/**
	 * 
	 * Sets/Mutates the private time variable
	 * 
	 * @param time is the passed integer variable
	 * 
	 */
	
	public void setTime(int time)
	{
		
		this.time = time;
		
	}
	
	
	
	
	

}
