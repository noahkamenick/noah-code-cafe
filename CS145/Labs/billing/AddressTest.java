package cs145.billing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddressStringInt() {
		Address address = new Address("Bob ", "1234", " Townsville ", "WI ", "12345");
		assertEquals("Bob" + "\n" + "1234" + "\n" + "Townsville, WI 12345",address.toString());
	}

	@Test
	void testToString() {
		Address address = new Address("Bob ", "1234", " Townsville ", "WI ", "12345");
		assertEquals("Bob" + "\n" + "1234" + "\n" + "Townsville, WI 12345",address.toString());
	}

}
