package cs145.parkingTicket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests various methods within the ParkingMeter class
 * 
 * @author KamenickNoah
 * @version 2021.02.22
 */


class ParkingMeterTest {

	/**
	 * 
	 * This method tests the default constructor using a setTime setter 
	 * 
	 */
	
	@Test
	void testParkingMeter() {
		ParkingMeter noTicket = new ParkingMeter(2);
		ParkingMeter ticket = new ParkingMeter(0);
		assertEquals(2, noTicket.getTime(), 0.00001);
		assertEquals(0, ticket.getTime(), 0.00001);
	}

	/**
	 * 
	 * 
	 * This method tests if the getTime method is functioning properly
	 * 
	 */
	
	@Test
	void testGetTime() {
		ParkingMeter noTicketTwo = new ParkingMeter(5);
		ParkingMeter ticketTwo = new ParkingMeter(-1);
		assertEquals(5, noTicketTwo.getTime(), 0.00001);
		assertEquals(-1, ticketTwo.getTime(), 0.00001);
	}

	/**
	 * 
	 * This method tests if the setTime method is operating correctly 
	 * 
	 */
	
	@Test
	void testSetTime() {
		ParkingMeter noTicketThree = new ParkingMeter(6);
		ParkingMeter ticketThree = new ParkingMeter(-2);
		assertEquals(6, noTicketThree.getTime(), 0.00001);
		assertEquals(-2, ticketThree.getTime(), 0.00001);
	}

}
