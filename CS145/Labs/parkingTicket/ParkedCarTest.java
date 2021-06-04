package cs145.parkingTicket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Tests various methods within the ParkedCar class
 * 
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 */

class ParkedCarTest {

	/**
	 * 
	 * This method tests the ParkedCar Parameter/Object 
	 * relationship through the formatting of the toString method.
	 * 
	 */
	
	@Test
	void testParkedCarIntStringStringStringString() {
		ParkedCar corollaCoaster = new ParkedCar(1997, "Toyota", "Corolla", "Black", "AAN-123");
		assertEquals("\nYear: 1997\nMake: Toyota\nModel: Corolla\nColor: Black\nLicense: AAN-123", corollaCoaster.toString());
		ParkedCar chevy = new ParkedCar(2010, "Chevy", "Impala", "Black", "AAN-1234");
		assertEquals("\nYear: 2010\nMake: Chevy\nModel: Impala\nColor: Black\nLicense: AAN-1234", chevy.toString());
		
	}
	
	/**
	 * This method tests the ParkedCar copy constructor and verifies the relations between
	 * the constructor and other objects of the same constructor name with the toString method.
	 */

	@Test
	void testParkedCarParkedCar() {
		ParkedCar sienna = new ParkedCar(2010, "Toyota", "Sienna", "Black", "GHG-444");
		ParkedCar toyota = new ParkedCar(sienna);
		ParkedCar amg = new ParkedCar(2019, "Mercedes-Benz", "AMG", "Gray", "SPEED");
		ParkedCar mercedes = new ParkedCar(amg);
		assertEquals("\nYear: 2010\nMake: Toyota\nModel: Sienna\nColor: Black\nLicense: GHG-444", toyota.toString());
		assertEquals("\nYear: 2019\nMake: Mercedes-Benz\nModel: AMG\nColor: Gray\nLicense: SPEED", mercedes.toString());
	}

}
