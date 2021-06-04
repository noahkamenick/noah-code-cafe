package cs145.parkingTicket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Tests Method(s) within the ParkingTicket class
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 */


class ParkingTicketTest {
	
	/**
	 * 
	 * This method tests logic and relationships within the ParkingTicket copy constructor between
	 * the ParkedCar, PoliceOfficer, and ParkingTicket classes.
	 * 
	 */
	
	@Test
	void testParkingTicket() {
		
		//Toyota
		
		ParkedCar car = new ParkedCar(1998, "Toyota", "Corolla", "Red", "BPA-555");
		PoliceOfficer sgtJoe = new PoliceOfficer("Sgt. Joe", 3947);
		ParkingTicket tix = new ParkingTicket(car, sgtJoe);
		assertEquals("\n---Illegally Parked Car Info---\n"
				+ "Year: 1998\nMake: Toyota\nModel: Corolla\nColor: Red\nLicense: BPA-555\n"
				+ "-----Issuing Officer Info-----\n"
				+ "Police Officer Name: Sgt. Joe\nBadge Number: 3947\nFine Amount: $25", tix.toString());
		
		//Ford
		
		ParkedCar ford = new ParkedCar(2019, "Ford", "Mustang", "Orange", "SP33DY");
		PoliceOfficer sgtGee = new PoliceOfficer("Sgt. Gee", 1923); 
		ParkingTicket ticket = new ParkingTicket(ford, sgtGee);
		assertEquals("\n---Illegally Parked Car Info---\n"
				+ "Year: 2019\nMake: Ford\nModel: Mustang\nColor: Orange\nLicense: SP33DY\n"
				+ "-----Issuing Officer Info-----\n"
				+ "Police Officer Name: Sgt. Gee\nBadge Number: 1923\nFine Amount: $25", ticket.toString());

	}
}