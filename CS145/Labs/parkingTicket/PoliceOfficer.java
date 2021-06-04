/**
 * 
 */
package cs145.parkingTicket;

/**
 * Know's the car’s make, model, color, license number.
 * 
 * To examine a ParkingMeter object and determine the meter’s time has expired. If the meter’s time has 
 * expired, to issue a parking ticket (generate a ParkingTicket object) listing the ParkedCar object’s information, 
 * the officer’s information, and the fine amount. If the meter’s time has not expired, no ticket is issued.
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 *
 */
public class PoliceOfficer {

	private String name;
	
	private int badgeNumber;
	
	
	/**
	 * 
	 * Default PoliceOfficer Constructor that details information about the Ticket-issuing Police Officer. 
	 * 
	 * @param name the name of the officer issuing the parking ticket
	 * @param badge the badge number correspondent to the issuing police officer
	 */
	
	
	public PoliceOfficer(String name, int badge)
	{
		this.name = name;
		
		this.badgeNumber = badge;
		
	}
	
	/**
	 * 
	 * A copy constructor for the PoliceOfficer constructor 
	 * 
	 * @param officer a PoliceOfficer object input
	 */
	
	
	public PoliceOfficer(PoliceOfficer officer)
	{
		this.name = officer.name;
		
		this.badgeNumber = officer.badgeNumber;
		
	}
	
	/**
	 * 
	 * A string object to concatenate the information about the ticket-issuing police officer
	 * 
	 * @return a string detailing the police officers name and badge number. 
	 */
	
	public String toString()
	{
		return "\nPolice Officer Name: " + this.name + "\nBadge Number: " + this.badgeNumber; 
	}
	
	/**
	 * 
	 * This method checks whether a Police officer should give a car a parking ticket based
	 * on the time on the parking meter. If so, the method utilizes data from respective 
	 * classes.
	 * 
	 * 
	 * @param meter a parking meter object input
	 * @param car a parked car object input
	 * @return a written parking ticket
	 */
	
	public ParkingTicket patrol(ParkingMeter meter, ParkedCar car)
	{
		if(meter.getTime() <= 0)
		{
			
			PoliceOfficer other = new PoliceOfficer(name, badgeNumber);
			ParkingTicket issued = new ParkingTicket(car, other);
			return issued;
			
			
		}
		
		else {
			
			//ParkingTicket issued = new ParkingTicket(null, null);
			return null;
		}
		
		
		
		
				
	}
	
	
	
	

}
