package cs145.parkingTicket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * Tests various methods within the PoliceOfficer class
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 */

class PoliceOfficerTest {

	/**
	 * This method tests the PoliceOfficer constructor and the accuracy of its parameters through the toString() method. 
	 */
	
	@Test
	void testPoliceOfficerStringInt() {
		PoliceOfficer sgtSmith = new PoliceOfficer("Sgt. Smith", 4352);
		assertEquals("\nPolice Officer Name: Sgt. Smith\nBadge Number: 4352", sgtSmith.toString());
		PoliceOfficer sgtNoah = new PoliceOfficer("Sgt. Noah", 1546);
		assertEquals("\nPolice Officer Name: Sgt. Noah\nBadge Number: 1546", sgtNoah.toString());
	}

	/**
	 * 
	 * This method tests the copy constructor and the accuracy of its parameters through the toString() method. 
	 * 
	 */

	@Test
	void testPoliceOfficerPoliceOfficer() {
		PoliceOfficer detFrank = new PoliceOfficer("Det. Frank", 5674);
		PoliceOfficer outsider = new PoliceOfficer(detFrank);
		PoliceOfficer agKaul = new PoliceOfficer("AG Josh Kaul", 6578);
		PoliceOfficer attyGen = new PoliceOfficer(agKaul);
		assertEquals("\nPolice Officer Name: Det. Frank\nBadge Number: 5674", outsider.toString());
		assertEquals("\nPolice Officer Name: AG Josh Kaul\nBadge Number: 6578", attyGen.toString());
		
		
		
	}
	
	/**
	 * 
	 * This method tests the relationships between the Constructors in classes ParkingMeter, ParkedCar, and PoliceOfficer
	 * when the patrol method is called on PoliceOfficer object. 2 Police officers write up 2 tickets for 2 different cars.
	 * 
	 */

	@Test
	void testpatrol() {
		
		//Camry
		ParkedCar camry = new ParkedCar(2000, "Toyota", "Camry", "Black", "LEM-564");
		ParkingMeter issueTicket = new ParkingMeter(0);
		ParkingMeter noIssueTicket = new ParkingMeter(4);
		PoliceOfficer sgtMe = new PoliceOfficer("Sgt. Me", 7786);
		assertEquals(null, sgtMe.patrol(noIssueTicket, camry)); //Will not issue another ticket
		assertEquals("\n---Illegally Parked Car Info---\nYear: 2000\nMake: Toyota\nModel: Camry\nColor: Black\nLicense: LEM-564\n"
				+ "-----Issuing Officer Info-----\nPolice Officer Name: Sgt. Me\nBadge Number: 7786\nFine Amount: $25", 
				sgtMe.patrol(issueTicket, camry).toString()); //Will Issue ticket
		
		//BMW
		
		ParkedCar bmw = new ParkedCar(2019, "BMW", "M5", "Blue", "SP33D");
		ParkingMeter negative = new ParkingMeter(-3);
		PoliceOfficer sgtBro = new PoliceOfficer("Sgt. Bro", 6969);
		assertEquals(null, sgtBro.patrol(noIssueTicket, bmw)); //Will not issue ticket 
		assertEquals("\n---Illegally Parked Car Info---\nYear: 2019\nMake: BMW\nModel: M5\nColor: Blue\nLicense: SP33D\n"
				+ "-----Issuing Officer Info-----\nPolice Officer Name: Sgt. Bro\nBadge Number: 6969\nFine Amount: $25", 
				sgtBro.patrol(negative, bmw).toString()); //Will issue a ticket
		
	}

}
