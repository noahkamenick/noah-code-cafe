package cs145.parkingTicket;

/**
 * Reports the year, make, model, color, and license number of the illegally parked car.
 * Report the amount of the fine, which is $25
 * Reports the name and badge number of the police officer issuing the ticket.
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 */
public class ParkingTicket {

	private PoliceOfficer officer;
	
	private ParkedCar car;
	
	private final int FINE = 25;
	
	/**
	 * 
	 * ParkingTicket copy constructor
	 * 
	 * @param car sets inputted car object from parameters into privately declared car object within the ParkingTicket class
	 * @param officer sets inputted officer object from parameters to privately declared officer object within class
	 */
	
	public ParkingTicket(ParkedCar car, PoliceOfficer officer)
	{
		this.car = car;
		this.officer = officer;
		
	}
	/**
	 * 
	 * String method that returns a clean string
	 * 
	 * @return nicely formatted parking ticket
	 */
	
	
	public String toString()
	{

		return "\n---Illegally Parked Car Info---" + car.toString() + "\n-----Issuing Officer Info-----" + officer.toString() + "\nFine Amount: $" + FINE;
	}

}
