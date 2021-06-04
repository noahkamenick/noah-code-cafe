package cs145.billing;

/**
 * This class tests the Invoice class
 * 
 * @author Noah Kamenick
 * @version 03.10.2021
 * 
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvoiceTest {
	
	/**
	 * 
	 * This method tests the methods in the Invoice class
	 * 
	 */
	@Test
	void testAll() {

		Product one = new Product("ThisIsProductOne", 5);
		Product two = new Product("ThisProductTwo", 6);
		Address address = new Address("Noah's House", "666 3rd Ave", "Beans", "Montana", "66665");
		Invoice x = new Invoice(address);
		
		x.addCharge(one, 2);
		x.addCharge(two, 3);
		
		assertEquals(28.0, x.getTotalDue());
		
		assertEquals("Invoice\n\nNoah's House\n666 3rd Ave\nBeans, Montana 66665\n\nDescription\tPrice\tQuantity\tTotal\n"
				+ "ThisIsProductOne\t5.0\t2\t\t10.0\nThisProductTwo\t6.0\t3\t\t18.0\n\nAmount Due $28.0", x.toString());
	}

}
